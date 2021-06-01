package org.hy.common.license;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

import org.hy.common.license.base64.Base64Factory;





/**
 * 公钥验证
 * 
 * 既然是加密，那肯定是不希望别人知道我的消息，所以只有我才能解密，所以可得出：
 *    公钥负责加密，私钥负责解密；
 * 
 * 同理，既然是签名，那肯定是不希望有人冒充我发消息，只有我才能发布这个签名，所以可得出：
 *    私钥负责签名，公钥负责验证
 *
 * @author      ZhengWei(HY)
 * @createDate  2017-07-23
 * @version     v1.0
 *              v2.0  优化：使用JDK1.8内置的Base64，不再使用第三方的it.sauronsoftware.base64.Base64。
 */
public final class SignProvider
{
    
    /**
     * 公钥验证
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     *
     * @param i_PublicKey   公钥
     * @param i_PlainText   明码文本
     * @param i_Sign        签名
     * @return
     */
    public static boolean verify(String i_PublicKey ,String i_PlainText ,String i_Sign)
    {
        return verify(i_PublicKey.getBytes() ,i_PlainText ,i_Sign.getBytes());
    }
    
    

    /**
     * 公钥验证
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     *
     * @param i_PublicKey   公钥
     * @param i_PlainText   明码文本
     * @param i_Sign        签名
     * @return
     */
    public static boolean verify(byte [] i_PublicKey ,String i_PlainText ,byte [] i_Sign)
    {
        try
        {
            // 解密由base64编码的公钥,并构造X509EncodedKeySpec对象
            X509EncodedKeySpec v_X509Encoded = new X509EncodedKeySpec(Base64Factory.getIntance().decode(i_PublicKey));
            KeyFactory         v_KeyFactory  = KeyFactory.getInstance("RSA");
            PublicKey          v_PublicKey   = v_KeyFactory.generatePublic(v_X509Encoded); // 取公钥匙对象
            byte []            v_Sign        = Base64Factory.getIntance().decode(i_Sign);  // 解密由base64编码的数字签名
            Signature          v_Signature   = Signature.getInstance("MD5withRSA");
            
            v_Signature.initVerify(v_PublicKey);
            v_Signature.update(i_PlainText.getBytes());
            
            if ( v_Signature.verify(v_Sign) )
            {
                return true;
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    
    private SignProvider()
    {
        // 私有构造器
    }
    
}
