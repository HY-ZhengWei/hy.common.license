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
        byte []  v_Sign      = Signaturer.sign(v_KeyStore.getPrivateKey() ,v_PlainText);
        
        System.out.println("-- 公匙：" + v_KeyStore.getPublicKeyString());
        System.out.println("-- 私匙：" + v_KeyStore.getPrivateKeyString());
        System.out.println("-- 签名：" + new String(v_Sign));
        
        boolean v_Verify = SignProvider.verify(v_KeyStore.getPublicKey() ,v_PlainText ,v_Sign);
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
