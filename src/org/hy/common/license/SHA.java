package org.hy.common.license;

import org.hy.common.license.sha.HmacSHA256;
import org.hy.common.license.sha.ISHA;
import org.hy.common.license.sha.SHA256;
import org.hy.common.license.sha.SHA512;





/**
 * Hash算法（摘要算法）：SHA的加密算法。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public class SHA implements IHash
{
    
    private ISHA sha;
    

    
    /**
     * 构造摘要加密(默认为：HmacSHA256算法)
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_PrivateKey    密钥
     */
    public SHA(String i_PrivateKey)
    {
        this(1 ,i_PrivateKey);
    }
    
    
    
    /**
     * 构造摘要加密
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_Version       算法版本
     * @param i_PrivateKey    密钥
     */
    public SHA(int i_Version ,String i_PrivateKey)
    {
        this(i_Version ,i_PrivateKey ,true);
    }
    
    
    
    /**
     * 构造摘要加密
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_Version       算法版本
     * @param i_PrivateKey    密钥
     * @param i_IsURLEnocode  是否转码
     */
    public SHA(int i_Version ,String i_PrivateKey ,boolean i_IsURLEnocode)
    {
        if ( i_Version <= 1 )
        {
            this.sha = new HmacSHA256(i_PrivateKey ,i_IsURLEnocode);
        }
        else if ( i_Version == 2 )
        {
            this.sha = new SHA256(i_IsURLEnocode);
        }
        else if ( i_Version == 3 )
        {
            this.sha = new SHA512(i_IsURLEnocode);
        }
    }
    
    
    
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
    public final String encrypt(String i_Content)
    {
        return this.sha.encrypt(i_Content);
    }
    
}
