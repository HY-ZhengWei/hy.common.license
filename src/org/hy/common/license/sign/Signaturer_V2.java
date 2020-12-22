package org.hy.common.license.sign;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;





/**
 * 用私钥进行签名（用友的签名）
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
public final class Signaturer_V2 implements ISignaturer
{
    
    private final byte [] privateKey;
    
    
    
    public Signaturer_V2(String i_PrivateKey)
    {
       this(i_PrivateKey.getBytes());
    }
    
    
    
    public Signaturer_V2(byte [] i_PrivateKey)
    {
        this.privateKey = i_PrivateKey;
    }
    
    
    
    /**
     * 私钥进行签名
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-12-21
     * @version     v1.0
     *
     * @param i_PlainText   明码文本
     * @return
     */
    public final String sign(String i_PlainText)
    {
        try
        {
            Mac v_Mac = Mac.getInstance("HmacSHA256");
            v_Mac.init(new SecretKeySpec(i_PlainText.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            
            byte[] v_SignData         = v_Mac.doFinal(this.privateKey);
            String v_SignDataToEnCode = Base64.getEncoder().encodeToString(v_SignData);
            return URLEncoder.encode(v_SignDataToEnCode, StandardCharsets.UTF_8.toString());
        }
        catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
