package org.hy.common.license.sign;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

import org.hy.common.license.base64.Base64Factory;






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
 *              v2.0  优化：使用JDK1.8内置的Base64，不再使用第三方的it.sauronsoftware.base64.Base64。
 */
public final class Signaturer_V1 implements ISignaturer
{
    
    private final PrivateKey privateKey;
    
    
    
    public Signaturer_V1(String i_PrivateKey)
    {
       this(i_PrivateKey.getBytes());
    }
    
    
    
    public Signaturer_V1(byte [] i_PrivateKey)
    {
        try
        {
            PKCS8EncodedKeySpec v_PKCS8Encode = new PKCS8EncodedKeySpec(Base64Factory.getIntance().decode(i_PrivateKey));
            KeyFactory          v_KeyFactory  = KeyFactory.getInstance("RSA");
            
            this.privateKey = v_KeyFactory.generatePrivate(v_PKCS8Encode);
        }
        catch (Exception exce)
        {
            exce.printStackTrace();
            throw new java.lang.InstantiationError(exce.toString());
        }
    }
    
    
    
    /**
     * 私钥进行签名
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     *
     * @param i_PlainText   明码文本
     * @return
     */
    @Override
    public final String sign(String i_PlainText)
    {
        try
        {
            Signature v_Signature = Signature.getInstance("MD5withRSA");      // 用私钥对信息生成数字签名
            
            v_Signature.initSign(this.privateKey);
            v_Signature.update(i_PlainText.getBytes());
            
            return new String(Base64Factory.getIntance().encode(v_Signature.sign()) ,"UTF-8");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
