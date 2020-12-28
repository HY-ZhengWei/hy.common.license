package hy.common.license.junit;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.hy.common.license.Signaturer;
import org.junit.Test;





/**
 * 用友签名测试
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-12-28
 * @version     v1.0
 */
public class JU_Signaturer
{
    
    @Test
    public void test_V2() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        Signaturer v_Signaturer = new Signaturer(2 ,"7197afb19b8c4796b9f87c90a6427704");
        
        System.out.println(v_Signaturer.sign("appKey435af69873fc4e72849cd95060148435timestamp1608624227145"));
        
        
        Map<String, String> params = new HashMap<String ,String>();
        // 除签名外的其他参数
        params.put("appKey", "435af69873fc4e72849cd95060148435");
        params.put("timestamp", "1608624227145");
        System.out.println(SignHelper.sign(params ,"7197afb19b8c4796b9f87c90a6427704"));
    }
    
}
