package org.hy.common.license.junit;

import org.hy.common.StringHelp;
import org.hy.common.license.AppKey;
import org.hy.common.license.KeyStore;
import org.junit.Test;





/**
 * 测试单元：生成应用签名及密钥对
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-12-28
 * @version     v1.0
 */
public class JU_AppKey
{
    
    @Test
    public void test()
    {
        AppKey v_AppKey = new AppKey();
        
        v_AppKey.setAppKey(StringHelp.getUUID());
        
        KeyStore v_KeyStore  = KeyStore.generater(v_AppKey.getAppKey());
        
        v_AppKey.setPublicKey( v_KeyStore.getPublicKeyString());
        v_AppKey.setPrivateKey(v_KeyStore.getPrivateKeyString());
        
        
        System.out.println("-- appKey："  + v_AppKey.getAppKey());
        System.out.println("-- 应用公匙：" + v_AppKey.getPublicKey());
        System.out.println("-- 应用私匙：" + v_AppKey.getPrivateKey());
    }
    
}
