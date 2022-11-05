package org.hy.common.license;





/**
 * 对称加密算法的统一接口
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public interface ISymmetric
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



    /**
     * 解密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public String decrypt(String i_Content);
    
}
