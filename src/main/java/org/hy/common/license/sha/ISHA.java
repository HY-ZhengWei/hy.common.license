package org.hy.common.license.sha;





/**
 * Hash算法（摘要算法）：SHA加密接口。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public interface ISHA
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
