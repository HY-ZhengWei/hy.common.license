package org.hy.common.license;

import org.hy.common.xml.SerializableDef;





/**
 * 应用签名及密钥对
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-12-28
 * @version     v1.0
 */
public class AppKey extends SerializableDef
{

    private static final long serialVersionUID = 5643696657370697291L;
    
    
    /** 应用编码 */
    private String appCode;
    
    /** 应用签名 */
    private String appKey;
    
    /** 应用私钥 */
    private String privateKey;
    
    /** 应用公钥 */
    private String publicKey;

    
    
    /**
     * 获取：应用编码
     */
    public String getAppCode()
    {
        return appCode;
    }

    
    /**
     * 获取：应用签名
     */
    public String getAppKey()
    {
        return appKey;
    }

    
    /**
     * 获取：应用私钥
     */
    public String getPrivateKey()
    {
        return privateKey;
    }

    
    /**
     * 获取：应用公钥
     */
    public String getPublicKey()
    {
        return publicKey;
    }

    
    /**
     * 设置：应用编码
     * 
     * @param appCode 
     */
    public void setAppCode(String appCode)
    {
        this.appCode = appCode;
    }

    
    /**
     * 设置：应用签名
     * 
     * @param appKey 
     */
    public void setAppKey(String appKey)
    {
        this.appKey = appKey;
    }

    
    /**
     * 设置：应用私钥
     * 
     * @param privateKey 
     */
    public void setPrivateKey(String privateKey)
    {
        this.privateKey = privateKey;
    }

    
    /**
     * 设置：应用公钥
     * 
     * @param publicKey 
     */
    public void setPublicKey(String publicKey)
    {
        this.publicKey = publicKey;
    }
    
}
