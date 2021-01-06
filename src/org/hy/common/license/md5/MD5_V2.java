package org.hy.common.license.md5;

import org.hy.common.StringHelp;





/**
 * Hash算法（摘要算法）：MD5加密。去除=号，不用再URLEncoder.encode
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public class MD5_V2 implements IMD5
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
    public String encrypt(String i_Content)
    {
        return StringHelp.md5(i_Content);
    }
    
}
