package org.hy.common.license.md5;





/**
 * Hash算法（摘要算法）：MD5加密接口。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public interface IMD5
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
    public String encrypt(String i_Content);

}
