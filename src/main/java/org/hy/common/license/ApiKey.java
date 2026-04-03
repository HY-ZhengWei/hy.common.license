package org.hy.common.license;

import org.hy.common.StringHelp;





/**
 * 生成ApiKey密钥
 *
 * @author      ZhengWei(HY)
 * @createDate  2026-04-03
 * @version     v1.0
 */
public class ApiKey
{
    
    private static IHash $Hash;
    
    
    
    /** 验证票据号 */
    private String token;
    
    /** ApiKey密钥 */
    private String key;
    
    /** 密钥名称。如：sk-...1234 */
    private String keyName;
    
    
    
    /**
     * 生成ApiKey密钥
     * 
     * @author      ZhengWei(HY)
     * @createDate  2026-04-03
     * @version     v1.0
     *
     * @return
     */
    public static synchronized ApiKey make()
    {
        return make(35);
    }
    
    
    /**
     * 生成ApiKey密钥
     * 
     * @author      ZhengWei(HY)
     * @createDate  2026-04-03
     * @version     v1.0
     *
     * @param i_Length  ApiKey密钥总长度
     * @return
     */
    public static synchronized ApiKey make(int i_Length)
    {
        ApiKey v_ApiKey = new ApiKey();
        v_ApiKey.setKey("sk-" + StringHelp.random(i_Length - 3 ,true ,true));
        v_ApiKey.setKeyName("sk-..." + v_ApiKey.getKey().substring(i_Length - 4));
        
        if ( $Hash == null )
        {
            $Hash = new Hash();
        }
        v_ApiKey.setToken($Hash.encrypt(v_ApiKey.getKey()));
        return v_ApiKey;
    }
    
    
    /**
     * 获取：验证票据号
     */
    public String getToken()
    {
        return token;
    }

    
    /**
     * 设置：验证票据号
     * 
     * @param i_Token 验证票据号
     */
    public void setToken(String i_Token)
    {
        this.token = i_Token;
    }

    
    /**
     * 获取：ApiKey密钥
     */
    public String getKey()
    {
        return key;
    }


    /**
     * 设置：ApiKey密钥
     * 
     * @param i_Key ApiKey密钥
     */
    public void setKey(String i_Key)
    {
        this.key = i_Key;
    }

    
    /**
     * 获取：密钥名称。如：sk-...1234
     */
    public String getKeyName()
    {
        return keyName;
    }


    /**
     * 设置：密钥名称。如：sk-...1234
     * 
     * @param i_KeyName 密钥名称。如：sk-...1234
     */
    public void setKeyName(String i_KeyName)
    {
        this.keyName = i_KeyName;
    }
    
}
