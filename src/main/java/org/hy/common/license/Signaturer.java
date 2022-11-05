package org.hy.common.license;

import java.nio.charset.StandardCharsets;

import org.hy.common.license.sign.ISignaturer;
import org.hy.common.license.sign.Signaturer_V1;





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
public final class Signaturer implements ISignaturer
{
    
    private ISignaturer signaturer;
    
    
    
    public Signaturer(String i_PrivateKey)
    {
        this(1 ,i_PrivateKey.getBytes(StandardCharsets.UTF_8));
    }

    
    
    public Signaturer(byte [] i_PrivateKey)
    {
        this(1 ,i_PrivateKey);
    }
    
    
    
    public Signaturer(int i_Version ,String i_PrivateKey)
    {
        this(i_Version ,i_PrivateKey.getBytes(StandardCharsets.UTF_8));
    }
    
    
    
    public Signaturer(int i_Version ,byte [] i_PrivateKey)
    {
        if ( i_Version <= 1 )
        {
            this.signaturer = new Signaturer_V1(i_PrivateKey);
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
    public final String sign(String i_PlainText)
    {
        return this.signaturer.sign(i_PlainText);
    }
    
}
