package org.hy.common.license.aes;





/**
 * AES加解密接口。
 * 
 * 解决多个AES算法版本间的继承、兼顾等历史问题
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-09-16
 * @version     v1.0
 */
public interface IAES
{
    public static final String $AES_Name    = "AES";
    
    public static final String $CharsetName = "UTF-8";
    
    
    
    /**
     * 加密 
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-09-16
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
     * @createDate  2020-09-16
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public String decrypt(String i_Content);
    
}
