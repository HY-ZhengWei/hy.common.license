package org.hy.common.license.base64;





/**
 * 用于解决不同设置间的Base64的兼容问题的接口。可由外界决定Base64的实现算法（即，可自行定义算法）
 * 
 *   如android手机用的是：android.util.Base64
 *   如Java老版本用的是：sun.misc.BASE64Decoder 和 sun.misc.BASE64Encoder
 *   如Java新版本用的是：java.util.Base64
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-06-01
 * @version     v1.0
 */
public interface IBase64
{
    
    /**
     * 加密
     * 
     * @param i_Datas
     * @return
     */
    public byte [] encode(byte [] i_Datas);
    
    
    
    /**
     * 加密
     * 
     * @param i_Datas
     * @return
     */
    public byte [] encode(String i_Datas);
    
    
    
    /**
     * 解密
     * 
     * @param i_Datas
     * @return
     */
    public byte [] decode(String i_Datas);
    
    
    
    /**
     * 解密
     * 
     * @param i_Datas
     * @return
     */
    public byte [] decode(byte [] i_Datas);
    
}
