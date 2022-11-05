package org.hy.common.license.md5;

import java.security.MessageDigest;

import org.hy.common.license.base64.Base64Factory;





/**
 * Hash算法（摘要算法）：MD5加密。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public class MD5_V1 implements IMD5
{
    
    /**
     * 加密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
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
            MessageDigest v_MD5 = MessageDigest.getInstance("MD5");
            
            return new String(Base64Factory.getIntance().encode(v_MD5.digest(i_Content.getBytes("UTF-8"))) ,"UTF-8");
        }
        catch (Exception exce)
        {
            return null;
        }
    }
    
}
