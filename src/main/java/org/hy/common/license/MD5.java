package org.hy.common.license;

import org.hy.common.license.md5.IMD5;
import org.hy.common.license.md5.MD5_V1;
import org.hy.common.license.md5.MD5_V2;
import org.hy.common.license.md5.MD5_V3;
import org.hy.common.license.md5.MD5_V4;





/**
 * Hash算法（摘要算法）：MD5加密。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public class MD5 implements IHash
{
    
    private IMD5 md5;
    

    
    /**
     * 构造16进制加密文本
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_Version     算法版本
     */
    public MD5()
    {
        this(4);
    }
    
    
    
    /**
     * 构造器
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_Version     算法版本
     */
    public MD5(int i_Version)
    {
        if ( i_Version <= 1 )
        {
            this.md5 = new MD5_V1();
        }
        else if ( i_Version == 2 )
        {
            this.md5 = new MD5_V2();
        }
        else if ( i_Version == 3 )
        {
            this.md5 = new MD5_V3();
        }
        else if ( i_Version == 4 )
        {
            this.md5 = new MD5_V4();
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
    public String encrypt(String i_Content)
    {
        return this.md5.encrypt(i_Content);
    }
    
}
