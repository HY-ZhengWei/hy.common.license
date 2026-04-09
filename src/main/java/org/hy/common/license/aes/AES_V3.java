package org.hy.common.license.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.hy.common.ExpireMap;
import org.hy.common.StringHelp;
import org.hy.common.license.base64.Base64Factory;





/**
 * AES加解密版本3：用于解决Android手机与Java服务AES版本1加密结果不一样的问题。
 * 
 * 改进点：初始向量是非固定的
 *
 * @author      ZhengWei(HY)
 * @createDate  2026-04-09
 * @version     v1.0
 */
public final class AES_V3 implements IAES
{
    
    private static final String $AES_Cipher   = "AES/CBC/PKCS5Padding";
    
    /** 过期时长（单位：秒） */
    private static final Long   $ExpireSecond = 60 * 10L;
    
    
    
    private Cipher                    cipherEncrypt;
    
    /** 初始向量对应的解密类 */
    private ExpireMap<String ,Cipher> cipherDecryptMap;
    
    /** 初始向量 */
    private String                    iv;
    
    /** 私钥 */
    private String                    privateKey;
    
    /** 密钥等级 */
    private int                       passwordLevel;
    
    
    
    /**
     * 构造器
     *
     * @author      ZhengWei(HY)
     * @createDate  2026-04-09
     * @version     v1.0
     *
     * @param i_PrivateKey  私钥
     */
    public AES_V3(String i_PrivateKey)
    {
        this(i_PrivateKey ,16);
    }
    
    
    
    /**
     * 构造器
     *
     * @author      ZhengWei(HY)
     * @createDate  2026-04-09
     * @version     v1.0
     *
     * @param i_PrivateKey     私钥
     * @param i_PasswordLevel  密钥等级。可选值为：16/24/32
     */
    public AES_V3(String i_PrivateKey ,int i_PasswordLevel)
    {
        this.cipherDecryptMap = new ExpireMap<String ,Cipher>();
        this.iv               = StringHelp.random(16 ,true ,true);
        this.privateKey       = i_PrivateKey;
        this.passwordLevel    = i_PasswordLevel;
        
        try
        {
            String v_PrivateKey = StringHelp.rpad(i_PrivateKey ,i_PasswordLevel ," ");
            
            IvParameterSpec v_ParamSpec = new IvParameterSpec(this.iv.getBytes());  // 初始向量
            SecretKeySpec   v_KeySpec   = new SecretKeySpec(v_PrivateKey.substring(0 ,i_PasswordLevel).getBytes(), $AES_Name);
            
            this.cipherEncrypt     = Cipher.getInstance($AES_Cipher);
            Cipher v_CipherDecrypt = Cipher.getInstance($AES_Cipher);
            
            this.cipherEncrypt.init(Cipher.ENCRYPT_MODE ,v_KeySpec ,v_ParamSpec);
            v_CipherDecrypt   .init(Cipher.DECRYPT_MODE ,v_KeySpec ,v_ParamSpec);
            
            this.cipherDecryptMap.put(this.iv ,v_CipherDecrypt);  // 自身原本的永不过期
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    
    
    /**
     * 加密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2026-04-09
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    @Override
    public String encrypt(String i_Content)
    {
        try
        {
            byte [] v_Byte_AES = this.cipherEncrypt.doFinal(i_Content.getBytes($CharsetName));
            
            return this.iv + new String(Base64Factory.getIntance().encode(v_Byte_AES) ,"UTF-8");
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
     * @author      ZhengWei(HY)
     * @createDate  2026-04-09
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    @Override
    public String decrypt(String i_Content)
    {
        try
        {
            String v_IV            = i_Content.substring(0 ,16);
            Cipher v_CipherDecrypt = this.cipherDecryptMap.get(v_IV);
            if ( v_CipherDecrypt == null )
            {
                IvParameterSpec v_ParamSpec = new IvParameterSpec(v_IV.getBytes());  // 初始向量
                SecretKeySpec   v_KeySpec   = new SecretKeySpec(this.privateKey.substring(0 ,this.passwordLevel).getBytes(), $AES_Name);
                
                v_CipherDecrypt = Cipher.getInstance($AES_Cipher);
                v_CipherDecrypt.init(Cipher.DECRYPT_MODE ,v_KeySpec ,v_ParamSpec);
                
                this.cipherDecryptMap.put(v_IV ,v_CipherDecrypt ,$ExpireSecond);
            }
            
            byte [] v_ByteContent = Base64Factory.getIntance().decode(i_Content.substring(16));
            byte [] v_ByteDecode  = v_CipherDecrypt.doFinal(v_ByteContent);
            
            return new String(v_ByteDecode, $CharsetName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
