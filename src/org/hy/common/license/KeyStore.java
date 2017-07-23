package org.hy.common.license;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import it.sauronsoftware.base64.Base64;





/**
 * 公钥私钥对
 * 
 * 既然是加密，那肯定是不希望别人知道我的消息，所以只有我才能解密，所以可得出：
 *    公钥负责加密，私钥负责解密；
 *    
 * 同理，既然是签名，那肯定是不希望有人冒充我发消息，只有我才能发布这个签名，所以可得出：
 *    私钥负责签名，公钥负责验证
 * 
 * 参考于：http://www.cnblogs.com/duanxz/archive/2012/12/28/2837197.html
 *
 * @author      ZhengWei(HY)
 * @createDate  2017-07-23
 * @version     v1.0
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
            v_Key.publicKey  = Base64.encode(v_Keys.getPublic().getEncoded());
            v_Key.privateKey = Base64.encode(v_Keys.getPrivate().getEncoded());
        }
        catch (java.lang.Exception e)
        {
            e.printStackTrace();
        }
        
        return v_Key;
    }
    
    
    
    private KeyStore()
    {
        // 私有构造器
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
