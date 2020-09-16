package org.hy.common.license.aes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.hy.common.StringHelp;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;





/**
 * AES加解密版本2：用于解决Android手机与Java服务AES版本1加密结果不一样的问题。
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-09-16
 * @version     v1.0
 */
public class AES_V2 implements IAES
{
    
    private static final String $AES_Cipher  = "AES/CBC/PKCS5Padding";
    
    private static final String $Key         = "1234567890ABCDEF";
    
    
    
    private Cipher cipherEncrypt;
    
    private Cipher cipherDecrypt;
    
    
    
    public AES_V2(String i_PrivateKey)
    {
        try
        {
            String v_PrivateKey = StringHelp.rpad(i_PrivateKey ,16 ," ");
            
            IvParameterSpec v_ParamSpec = new IvParameterSpec($Key.getBytes());
            SecretKeySpec   v_KeySpec   = new SecretKeySpec(v_PrivateKey.substring(0 ,16).getBytes(), $AES_Name);
            
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
    public String encrypt(String i_Content)
    {
        try
        {
            byte [] v_Byte_AES = this.cipherEncrypt.doFinal(i_Content.getBytes($CharsetName));
            
            return new String(new BASE64Encoder().encode(v_Byte_AES));
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
    public String decrypt(String i_Content)
    {
        try
        {
            byte [] v_ByteContent = new BASE64Decoder().decodeBuffer(i_Content);
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
