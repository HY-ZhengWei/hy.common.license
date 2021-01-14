package org.hy.common.license.sha;

import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Base64;





/**
 * Hash算法（摘要算法）
 * 
 * 1993年，美国国家安全局发布了SHA算法，全称是Secure Hash Algorithm。
 * 比特币采用SHA-256算法，即生成的数字指纹固定长度是256位。
 * 
 * 有2的256次方种组合。这是一个庞大的数值，哈希值越大，碰撞的机率就越小。
 * 
 * 算法的特点是：
 *    1. 无论原始信息是什么，输出的数字指纹都是256位数。这个256位的数值是二进制的。
 *    2. 只要原文改了任何一个字，生成的数字指纹就会发生巨大的变化。也就是说，完全没有任何规律，无法通过数字指纹反推原文。
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-14
 * @version     v1.0
 */
public class SHA256 implements ISHA
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
    public SHA256(boolean i_IsURLEnocode)
    {
        this.isEncode = i_IsURLEnocode;
    }
    
    
    
    /**
     * 加密
     * 
     *   公式为：URLEncode(Base64.encode(SHA256(文本))) 
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public String encrypt(String i_Content)
    {
        try
        {
            MessageDigest v_MessageDigest = MessageDigest.getInstance("SHA-256");
            v_MessageDigest.update(i_Content.getBytes("UTF-8"));
            
            String v_Encode = Base64.getEncoder().encodeToString(v_MessageDigest.digest());
            
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
