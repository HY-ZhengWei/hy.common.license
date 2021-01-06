package org.hy.common.license;





/**
 * 对称加密算法的统一实现类。
 * 
 * 1. 支持 DES      算法
 * 2. 支持 AES      算法
 * 3. 支持 VBBase64 算法
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public final class Symmetric implements ISymmetric
{
    
    private ISymmetric symmetric;
    
    
    
    /**
     * 构造对称加密（默认为：AES算法）
     *
     * @author      ZhengWei(HY)
     * @createDate  2021-01-06
     * @version     v1.0
     *
     * @param i_PrivateKey  密钥
     */
    public Symmetric(String i_PrivateKey)
    {
        this(2 ,2 ,i_PrivateKey);
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
    public Symmetric(int i_Type ,int i_Version ,String i_PrivateKey)
    {
        if ( i_Type <= 1 )
        {
            this.symmetric = new DES(i_PrivateKey);
        }
        else if ( i_Type == 2 )
        {
            this.symmetric = new AES(i_Version ,i_PrivateKey);
        }
        else if ( i_Type == 3 )
        {
            this.symmetric = new VBBase64(i_PrivateKey);
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
        return this.symmetric.encrypt(i_Content);
    }



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
    public final String decrypt(String i_Content)
    {
        return this.symmetric.decrypt(i_Content);
    }
    
}
