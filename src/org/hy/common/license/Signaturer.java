package org.hy.common.license;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import it.sauronsoftware.base64.Base64;





/**
 * 用私钥进行签名
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
 */
public final class Signaturer
{
    
    /**
     * 私钥进行签名
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     *
     * @param i_KeyStore   公钥私钥对
     * @param i_PlainText  明码文本
     * @return
     */
    public final static byte [] sign(KeyStore i_KeyStore ,String i_PlainText)
    {
        return sign(i_KeyStore.getPrivateKey() ,i_PlainText);
    }
    
    

    /**
     * 私钥进行签名
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     *
     * @param i_PrivateKey  私钥
     * @param i_PlainText   明码文本
     * @return
     */
    public final static byte [] sign(byte [] i_PrivateKey ,String i_PlainText)
    {
        try
        {
            PKCS8EncodedKeySpec v_PKCS8Encode = new PKCS8EncodedKeySpec(Base64.decode(i_PrivateKey));
            KeyFactory          v_KeyFactory  = KeyFactory.getInstance("RSA");
            PrivateKey          v_PrivateKey  = v_KeyFactory.generatePrivate(v_PKCS8Encode);
            Signature           v_Signature   = Signature.getInstance("MD5withRSA");      // 用私钥对信息生成数字签名
            
            v_Signature.initSign(v_PrivateKey);
            v_Signature.update(i_PlainText.getBytes());
            
            return Base64.encode(v_Signature.sign());
        }
        catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    private Signaturer()
    {
        // 私有构造器
    }
    
}
