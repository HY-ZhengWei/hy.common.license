package org.hy.common.license;

import org.hy.common.license.sha.HmacSHA256;
import org.hy.common.license.sha.ISHA;





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
    

    
    public SHA(String i_PrivateKey)
    {
        this(1 ,i_PrivateKey);
    }
    
    
    
    public SHA(int i_Version ,String i_PrivateKey)
    {
        if ( i_Version <= 1 )
        {
            this.sha = new HmacSHA256(i_PrivateKey);
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
