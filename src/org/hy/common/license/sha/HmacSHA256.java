package org.hy.common.license.sha;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;





/**
 * Hash算法（摘要算法）：HmacSHA256加密。
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public final class HmacSHA256 implements ISHA
{
    
    private final byte [] privateKey;
    
    
    
    public HmacSHA256(String i_PrivateKey)
    {
       this(i_PrivateKey.getBytes(StandardCharsets.UTF_8));
    }
    
    
    
    public HmacSHA256(byte [] i_PrivateKey)
    {
        this.privateKey = i_PrivateKey;
    }
    
    
    
    /**
     * 加密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-12-21
     * @version     v1.0
     *
     * @param i_PlainText   明码文本
     * @return
     */
    public final String encrypt(String i_PlainText)
    {
        try
        {
            Mac v_Mac = Mac.getInstance("HmacSHA256");
            v_Mac.init(new SecretKeySpec(privateKey, "HmacSHA256"));
            
            byte[] v_SignData         = v_Mac.doFinal(i_PlainText.getBytes(StandardCharsets.UTF_8));
            String v_SignDataToEnCode = Base64.getEncoder().encodeToString(v_SignData);
            return URLEncoder.encode(v_SignDataToEnCode, "UTF-8");
        }
        catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
