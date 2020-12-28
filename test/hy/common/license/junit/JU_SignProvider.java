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
        boolean v_Verify = SignProvider.verify("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCeUETxx8eMRJ8S9jfjGbpAgofroLBG8OXtPzOu2TTlnpwPxBDsjZhWFvV//kivytVfBk1MmRf2oqgxa69LipH+syWXhwX5B+UOYN8MRYy6phaKsH+EbVo5gfoCWhMG2GSpWaa5aaScFJRdAL0v5JGzIRlT9il7pqFkehhQ00jqIwIDAQAB".getBytes() 
                                              ,"appKey" + "0904202FB2EA4AC3A899B423928A0F8E" + "timestamp" + "1609145532201" 
                                              ,"kMrxWaPCcg1wMaBOSpGqmxwWVOFsrje4ekiovoCfWnBGqAkcup+mBHYKDP84WGfdArlbXSI5wZ4/6OdzYu6E4+7HbLSBaP8fbnU15zyWIi1LFSfpmuHNPLUtvKTjvsUbwPSPTGYPNCxCPC9USIf0MIpayDKrAt/4jW3ymf7vp7Y=".getBytes());
        
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
