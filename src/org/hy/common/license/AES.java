package org.hy.common.license;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;





/**
 * 高级加密标准（Advanced Encryption Standard），是一种区块加密标准。
 * 这个标准用来替代原先的DES，已经被多方分析且广为全世界所使用。
 * 
 * 那么为什么原来的DES会被取代呢?
 * 原因就在于其使用56位密钥，比较容易被破解。
 * 而AES可以使用128、192、和256位密钥，并且用128位分组加密和解密数据，相对来说安全很多。
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-04-26
 * @version     v1.0
 */
public class AES
{

    private static String $CHARSETNAME = "UTF-8";
    
    private static String $ALGORITHM   = "AES";
    
    private SecretKey key;
    
    
    
    public AES(String i_PrivateKey)
    {
        this(i_PrivateKey ,128);
    }
    
    
    
    
    public AES(String i_PrivateKey ,int i_PasswordSize)
    {
        try
        {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance($ALGORITHM);
            // 2.根据ecnodeRules规则初始化密钥生成器
            // 生成一个X位的随机源,根据传入的字节数组
            keygen.init(i_PasswordSize ,new SecureRandom(i_PrivateKey.getBytes()));
            // 3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte [] raw = original_key.getEncoded();
            // 5.根据字节数组生成AES密钥
            this.key = new SecretKeySpec(raw ,$ALGORITHM);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    
    
    /**
     * 加密 
     * 
     * 1.构造密钥生成器 
     * 2.根据ecnodeRules规则初始化密钥生成器 
     * 3.产生密钥 
     * 4.创建和初始化密码器 
     * 5.内容加密 
     * 6.返回字符串
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-04-26
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public String encrypt(String i_Content)
    {
        try
        {
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance($ALGORITHM);
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE ,this.key);
            // 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] byte_encode = i_Content.getBytes($CHARSETNAME);
            // 9.根据密码器的初始化方式--加密：将数据加密
            byte [] byte_AES = cipher.doFinal(byte_encode);
            // 10.将加密后的数据转换为字符串
            // 这里用Base64Encoder中会找不到包
            // 解决办法：
            // 在项目的Build path中先移除JRE System Library，再添加库JRE System
            // Library，重新编译后就一切正常了。
            String AES_encode = new String(new BASE64Encoder().encode(byte_AES));
            // 11.将字符串返回
            return AES_encode;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }



    /**
     * 解密
     * 
     * 1.同加密1-4步 
     * 2.将加密后的字符串反成byte[]数组 
     * 3.将加密内容解密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-04-26
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public String decrypt(String i_Content)
    {
        try
        {
            Cipher cipher = Cipher.getInstance($ALGORITHM);
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE ,this.key);
            // 8.将加密并编码后的内容解码成字节数组
            byte [] byte_content = new BASE64Decoder().decodeBuffer(i_Content);
            // 解密
            byte [] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode ,$CHARSETNAME);
            return AES_decode;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
}
