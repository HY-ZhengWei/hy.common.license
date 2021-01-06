package org.hy.common.license.md5;

import org.hy.common.StringHelp;





/**
 * Hash算法（摘要算法）：MD5加密。全数字密文
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public class MD5_V3 implements IMD5
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
        return StringHelp.md5(i_Content ,1);
    }
    
}
