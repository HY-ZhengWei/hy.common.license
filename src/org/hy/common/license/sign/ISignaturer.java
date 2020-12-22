package org.hy.common.license.sign;





/**
 * AES加解密接口。
 * 
 * 解决多个版本间的继承、兼顾等历史问题
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-12-21
 * @version     v1.0
 */
public interface ISignaturer
{
    

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
    public String sign(String i_PlainText);
    
}
