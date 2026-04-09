package org.hy.common.license.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.hy.common.StringHelp;
import org.hy.common.license.base64.Base64Factory;





/**
 * AES加解密版本2：用于解决Android手机与Java服务AES版本1加密结果不一样的问题。
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-09-16
 * @version     v1.0
 */
public final class AES_V2 implements IAES
{
    
    private static final String $AES_Cipher = "AES/CBC/PKCS5Padding";
    
    private static final String $Key        = "1234567890ABCDEF";
    
    
    
    private Cipher cipherEncrypt;
    
    private Cipher cipherDecrypt;
    
    
    
    /**
     * 构造器
     *
     * @author      ZhengWei(HY)
     * @createDate  2020-09-16
     * @version     v1.0
     *
     * @param i_PrivateKey  私钥
     */
    public AES_V2(String i_PrivateKey)
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
     * @param i_PrivateKey      私钥
     * @param i_PasswordLevel  密钥等级。可选值为：16/24/32
     */
    public AES_V2(String i_PrivateKey ,int i_PasswordLevel)
    {
        try
        {
            String v_PrivateKey = StringHelp.rpad(i_PrivateKey ,i_PasswordLevel ," ");
            
            IvParameterSpec v_ParamSpec = new IvParameterSpec($Key.getBytes());  // 初始向量
            SecretKeySpec   v_KeySpec   = new SecretKeySpec(v_PrivateKey.substring(0 ,i_PasswordLevel).getBytes(), $AES_Name);
            
            this.cipherEncrypt = Cipher.getInstance($AES_Cipher);
            this.cipherDecrypt = Cipher.getInstance($AES_Cipher);
            
            this.cipherEncrypt.init(Cipher.ENCRYPT_MODE, v_KeySpec, v_ParamSpec);
            this.cipherDecrypt.init(Cipher.DECRYPT_MODE, v_KeySpec, v_ParamSpec);
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
     * @createDate  2020-09-16
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
            
            return new String(Base64Factory.getIntance().encode(v_Byte_AES) ,"UTF-8");
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
     * @createDate  2020-09-16
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
            byte [] v_ByteContent = Base64Factory.getIntance().decode(i_Content);
            byte [] v_ByteDecode  = this.cipherDecrypt.doFinal(v_ByteContent);
            
            return new String(v_ByteDecode, $CharsetName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
