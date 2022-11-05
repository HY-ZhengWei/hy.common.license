package org.hy.common.license.base64;





/**
 * 用于解决不同设置间的Base64的兼容问题的工厂类（默认注册Java的）。可由外界决定Base64的实现算法（即，可自行定义算法）
 * 
 *   如android手机用的是：android.util.Base64
 *   如Java用的是：sun.misc.BASE64Decoder 和 sun.misc.BASE64Encoder
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-06-01
 * @version     v1.0
 */
public class Base64Factory
{
    
    private static IBase64 $Base64;
    
    
    
    private Base64Factory()
    {
        
    }
    
    
    
    /**
     * 注册Base64算法
     * 
     * @param i_IBase64
     */
    public static void register(IBase64 i_IBase64)
    {
        if ( i_IBase64 != null )
        {
            $Base64 = i_IBase64;
        }
    }
    
    
    
    /**
     * 获取即使用Base64算法
     * 
     * @return
     */
    public static synchronized IBase64 getIntance()
    {
        if ( $Base64 == null )
        {
            $Base64 = new Base64Default();
        }
        
        return $Base64;
    }
    
}
