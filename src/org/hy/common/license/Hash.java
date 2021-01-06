package org.hy.common.license;





/**
 * Hash算法（摘要算法）的统一实现类。
 * 
 * 1. 支持 MD5 算法
 * 2. 支持 SHA 算法
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public final class Hash implements IHash
{
    
    private IHash hash;
    
    
    
    /**
     * 构造对称加密（默认为：MD5算法）
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_PrivateKey  密钥
     */
    public Hash()
    {
        this(1 ,4 ,null);
    }
    
    
    
    /**
     * 构造对称加密
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_Type        算法类型
     * @param i_Version     算法版本
     * @param i_PrivateKey  密钥
     */
    public Hash(int i_Type ,int i_Version ,String i_PrivateKey)
    {
        if ( i_Type <= 1 )
        {
            this.hash = new MD5(i_Version);
        }
        else if ( i_Type == 2 )
        {
            this.hash = new SHA(i_Version ,i_PrivateKey);
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
        return this.hash.encrypt(i_Content);
    }
    
}
