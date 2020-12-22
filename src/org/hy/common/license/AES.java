package org.hy.common.license;

import org.hy.common.license.aes.AES_V1;
import org.hy.common.license.aes.AES_V2;
import org.hy.common.license.aes.IAES;





/**
 * 高级加密标准（Advanced Encryption Standard），是一种区块加密标准。
 * 这个标准用来替代原先的DES，已经被多方分析且广为全世界所使用。
 * 
 * 那么为什么原来的DES会被取代呢?
 * 原因就在于其使用56位密钥，比较容易被破解。
 * 而AES可以使用128、192、和256位密钥，并且用128位分组加密和解密数据，相对来说安全很多。
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-04-26
 * @version     v1.0
 *              v2.0  2020-09-16  添加：AES加解密版本2：用于解决Android手机与Java服务AES版本1加密结果不一样的问题。
 */
public final class AES implements IAES
{
    
    private IAES aes;
    

    
    public AES(String i_PrivateKey)
    {
        this(1 ,i_PrivateKey);
    }
    
    
    
    public AES(int i_Version ,String i_PrivateKey)
    {
        if ( i_Version <= 1 )
        {
            this.aes = new AES_V1(i_PrivateKey);
        }
        else if ( i_Version == 2 )
        {
            this.aes = new AES_V2(i_PrivateKey);
        }
    }
    
    
    
    /**
     * 加密 
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-04-26
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public final String encrypt(String i_Content)
    {
        return this.aes.encrypt(i_Content);
    }



    /**
     * 解密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2020-04-26
     * @version     v1.0
     *
     * @param i_Content
     * @return
     */
    public final String decrypt(String i_Content)
    {
        return this.aes.decrypt(i_Content);
    }
}
