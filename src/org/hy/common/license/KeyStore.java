package org.hy.common.license;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import org.hy.common.license.base64.Base64Factory;





/**
 * 公钥私钥对
 * 
 * 既然是加密，那肯定是不希望别人知道我的消息，所以只有我才能解密，所以可得出：
 *    公钥负责加密，私钥负责解密；
 * 
 * 同理，既然是签名，那肯定是不希望有人冒充我发消息，只有我才能发布这个签名，所以可得出：
 *    私钥负责签名，公钥负责验证
 * 
 * @author      ZhengWei(HY)
 * @createDate  2017-07-23
 * @version     v1.0
 *              v2.0  优化：使用JDK1.8内置的Base64，不再使用第三方的it.sauronsoftware.base64.Base64。
 */
public final class KeyStore
{

    /** 私钥 */
    private byte [] privateKey;

    /** 公钥 */
    private byte [] publicKey;
    
    
    
    /**
     * 生成公钥私钥对
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     */
    public final static KeyStore generater()
    {
        return generater("hy.common.license");
    }

    

    /**
     * 生成公钥私钥对
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-23
     * @version     v1.0
     *
     * @param i_Seed  种子
     */
    public final static KeyStore generater(String i_Seed)
    {
        KeyStore v_Key = null;
        
        try
        {
            KeyPairGenerator v_Keygen       = KeyPairGenerator.getInstance("RSA");
            SecureRandom     v_SecureRandom = new SecureRandom();
            
            v_SecureRandom.setSeed(i_Seed.getBytes());
            v_Keygen.initialize(1024 ,v_SecureRandom);
            
            KeyPair v_Keys = v_Keygen.genKeyPair();
            
            v_Key            = new KeyStore();
            v_Key.publicKey  = Base64Factory.getIntance().encode(v_Keys.getPublic() .getEncoded());
            v_Key.privateKey = Base64Factory.getIntance().encode(v_Keys.getPrivate().getEncoded());
        }
        catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        
        return v_Key;
    }
    
    
    
    
    
    public KeyStore()
    {
        // 私有构造器
    }
    
    
    
    /**
     * 设置私钥
     * 
     * @param i_PrivateKey
     */
    public void setPrivateKey(String i_PrivateKey)
    {
        this.privateKey = i_PrivateKey.getBytes();
    }
    
    
    
    /**
     * 设置公钥
     * 
     * @param i_PrivateKey
     */
    public void setPublicKey(String i_PublicKey)
    {
        this.publicKey = i_PublicKey.getBytes();
    }
    
    
    
    /**
     * 获取：私钥
     */
    public byte [] getPrivateKey()
    {
        return privateKey;
    }
    
    
    
    /**
     * 获取：公钥
     */
    public byte [] getPublicKey()
    {
        return publicKey;
    }
    
    
    
    /**
     * 获取：私钥
     */
    public String getPrivateKeyString()
    {
        return new String(privateKey);
    }
    
    
    
    /**
     * 获取：公钥
     */
    public String getPublicKeyString()
    {
        return new String(publicKey);
    }
}
