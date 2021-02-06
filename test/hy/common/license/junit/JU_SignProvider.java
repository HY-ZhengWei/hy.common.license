package hy.common.license.junit;

import org.hy.common.license.KeyStore;
import org.hy.common.license.SignProvider;
import org.hy.common.license.Signaturer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;





/**
 * 测试单位：公钥、私钥、签名验证
 *
 * @author      ZhengWei(HY)
 * @createDate  2017-07-23
 * @version     v1.0
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JU_SignProvider
{

    @Test
    public void test_SignProvider()
    {
        KeyStore v_KeyStore  = KeyStore.generater("A");
        String   v_PlainText = "ABCDEFG";
        String   v_Sign      = new Signaturer(v_KeyStore.getPrivateKey()).sign(v_PlainText);
        
        System.out.println("-- 公匙：" + v_KeyStore.getPublicKeyString());
        System.out.println("-- 私匙：" + v_KeyStore.getPrivateKeyString());
        System.out.println("-- 签名：" + v_Sign);
        
        boolean v_Verify = SignProvider.verify(v_KeyStore.getPublicKey() ,v_PlainText ,v_Sign.getBytes());
        if ( v_Verify )
        {
            System.out.println("验证成功.");
        }
        else
        {
            System.err.println("验证失败.");
        }
    }
    
    
    
    @Test
    public void test_Verify()
    {
        boolean v_Verify = SignProvider.verify("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqi6cOtAOG5D7CVuQTmHTOD3zsHcf9/PQJpShxABC1a74dUbE3KZbdWnUAQc9ogjNLUK7kslNz+f7PY9VNQvAsdFlWIQCETYWecWXHaPdcYPdlEQmaXUPUF9AE0j0yiumbwDG4Rc2BQ/zDs2hUudXR3Xo4iaivShXkUs7shzp3ywIDAQAB".getBytes() 
                                              ,"appKey" + "D22DCADC06BB4EAE868D5728AACAD370" + "timestamp" + "1612233808286" 
                                              ,"B4ccLzzX7x57RBv/TrMOb17Tz9JDV0fh6jug7RCrmMGQgq3AVKjpEXKQYjDB9vm+SwdftYP7wso1us1lR3xmB6VG/l6jEb6FSeco9f//imGOM8nbwBTjfIIHx/Nl8hT7N5CdZR1aimoxcbb8wtd9ESNCZwP0OSwI957wbGlHBgA=".getBytes());
        
        if ( v_Verify )
        {
            System.out.println("验证成功.");
        }
        else
        {
            System.err.println("验证失败.");
        }
    }
    
}
