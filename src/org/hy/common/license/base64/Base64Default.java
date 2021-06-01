package org.hy.common.license.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;





/**
 * 默认的Base64算法
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-06-01
 * @version     v1.0
 */
public class Base64Default implements IBase64
{
    
    
    /**
     * 加密
     * 
     * @param i_Datas
     * @return
     */
    @Override
    public byte [] encode(String i_Datas)
    {
        try
        {
            return this.encode(i_Datas.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    
    /**
     * 加密
     * 
     * @param i_Datas
     * @return
     */
    @Override
    public byte [] encode(byte [] i_Datas)
    {
        return Base64.getEncoder().encode(i_Datas);
    }
    
    
    
    /**
     * 解密
     * 
     * @param i_Datas
     * @return
     */
    @Override
    public byte [] decode(String i_Datas)
    {
        return Base64.getDecoder().decode(i_Datas);
    }
    
    
    
    /**
     * 解密
     * 
     * @param i_Datas
     * @return
     */
    @Override
    public byte [] decode(byte [] i_Datas)
    {
        return Base64.getDecoder().decode(i_Datas);
    }
    
}
