package org.hy.common.license.junit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.hy.common.Date;
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
    public void test_V1_XSSO() throws UnsupportedEncodingException
    {
        String     v_PrivateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKqLpw60A4bkPsJW5BOYdM4PfOwdx/389AmlKHEAELVrvh1RsTcplt1adQBBz2iCM0tQruSyU3P5/s9j1U1C8Cx0WVYhAIRNhZ5xZcdo91xg92URCZpdQ9QX0ATSPTKK6ZvAMbhFzYFD/MOzaFS51dHdejiJqK9KFeRSzuyHOnfLAgMBAAECgYEAkt1ihpnks6QYm5jiHjHa3Jyf0mGvGP1dVnUAx5brzJ+0/2CbQMqy3XoJaahCqVf+PiyD//PFRAmUMhph1IABfI2LzzDS8DYjrzV05ahFts2sFMbWcDK4f0C/Cmz0vx+Ggn3+DsVqzTyX8IejJChBGWXJk6VDCWZVcsQgpz/FopECQQDkLEmWOsbsa1lN6eZb6ZKqFI00/frpVa5RyvN1whr+j2/FjuUTyekohnYo3uXjYlufPx5uqAJMj3pY/AZ8GH3pAkEAv1gyaRiprKe8/S5haANhx0/E+M2Ik7FkXqDyoAfXE48z1CG3jPahux7ce4UAj3l96f4KXb4iOhdA527PMrbzkwJBAM62ZLBKbZ8QHebdSYnpUKrvVYI1ulQcAIIvWGNNx8DpV7xmGZjU6nuBXZjnXuOiXxklSL+9S9/qeFAXexR/58kCQQCHVwfZBGPHRqHLZsno+zNm+co1vZMT/E4lDKxwevsqz4h2TB77Ktt8cji7eXjLAsEIB/MnGTw2YIo86EjP803XAkAb5vgG94qKDErmO5xSzbKfwXdc4jC0wn+sXvLTOkzkmsLXS5m3WGVwJhcF6IVHkRKoupwg/bA/zIFNxsGE1os+";
        String     v_PublicKey  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqi6cOtAOG5D7CVuQTmHTOD3zsHcf9/PQJpShxABC1a74dUbE3KZbdWnUAQc9ogjNLUK7kslNz+f7PY9VNQvAsdFlWIQCETYWecWXHaPdcYPdlEQmaXUPUF9AE0j0yiumbwDG4Rc2BQ/zDs2hUudXR3Xo4iaivShXkUs7shzp3ywIDAQAB";
        String     v_AppKey     = "D22DCADC06BB4EAE868D5728AACAD370";
        Signaturer v_Signaturer = new Signaturer(1 ,v_PrivateKey);
        long       v_Timestamp  = Date.getNowTime().getTime();
        String     v_Code       = "appKey" + v_AppKey + "timestamp" + v_Timestamp;
        String     v_Signature  = v_Signaturer.sign(v_Code);
        
        System.out.println("时间戳："   + v_Timestamp);
        System.out.println("生成签名：" + v_Signature);
        System.out.println("签名转义：" + URLEncoder.encode(v_Signature ,"UTF-8"));
    
    
        boolean v_Verify = SignProvider.verify(v_PublicKey.getBytes()
                                              ,v_Code
                                              ,v_Signature.getBytes());

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
