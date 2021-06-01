package org.hy.common.license.sha;

import java.net.URLEncoder;
import java.security.MessageDigest;

import org.hy.common.license.base64.Base64Factory;





/**
 * Hash算法（摘要算法）
 * 
 * 与SHA256一样，只是长度为512
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-14
 * @version     v1.0
 */
public class SHA512 implements ISHA
{
    
    private final boolean isEncode;
    
    
    
    /**
     * 构造摘要加密
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-16
     * @version     v1.0
     *
     * @param i_PrivateKey    密钥
     * @param i_IsURLEnocode  是否转码
     */
    public SHA512(boolean i_IsURLEnocode)
    {
        this.isEncode = i_IsURLEnocode;
    }
    
    
    
    /**
     * 加密
     * 
     *   公式为：URLEncode(Base64.encode(SHA512(文本)))
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
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
            MessageDigest v_MessageDigest = MessageDigest.getInstance("SHA-512");
            v_MessageDigest.update(i_Content.getBytes("UTF-8"));
            
            String v_Encode = new String(Base64Factory.getIntance().encode(v_MessageDigest.digest()) ,"UTF-8");
            
            if ( this.isEncode )
            {
                return URLEncoder.encode(v_Encode, "UTF-8");
            }
            else
            {
                return v_Encode;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
}
