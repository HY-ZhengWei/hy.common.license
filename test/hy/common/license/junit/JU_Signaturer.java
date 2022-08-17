package hy.common.license.junit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.hy.common.Date;
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
    public void test_V1() throws UnsupportedEncodingException
    {
        Signaturer v_Signaturer = new Signaturer(1 ,"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ5QRPHHx4xEnxL2N+MZukCCh+ugsEbw5e0/M67ZNOWenA/EEOyNmFYW9X/+SK/K1V8GTUyZF/aiqDFrr0uKkf6zJZeHBfkH5Q5g3wxFjLqmFoqwf4RtWjmB+gJaEwbYZKlZprlppJwUlF0AvS/kkbMhGVP2KXumoWR6GFDTSOojAgMBAAECgYEAjBF47nJTm0cbdythRwz8PRdAKrmBPULmK4I/t/N1WbN7YHeYgbLFlWW60AOrS92p6ukoexz4lr5TEWa1MaDoiYncwX7MoyqSIKX62TZ/Saz/Mg15xfXnRnjOYA+8jo4nFfUo8V7OdFuJHl4j5Y/jyE/s+1SeMzPAHNv1u39l6AECQQDkiHqMJUNNksz2Y4U+fgFv0mSIgdXzK2RvS2T//M//7HInc0nrfXmKBCdAL+kTh+DfMOP/WkmIAsEGgs453LTrAkEAsVdFQ7dOWXND/mxF0hxJH1bxi0JCC8jYChz8cSFiB7P1hG5SEn9959HKfQKF4asOf0VZon5ZUPizt1EG4r2xqQJACNRNB8UYyJJ3YL2PlE6B97QFNlDt1ytCAhrDmDBISPb1ohiOLo72dyKZ8ZzoQFzrjzPwWxk95gdVNc8v8IRaaQJALHu+lRDK52chXBVeoiiUMvdFGXBiTsBvaIIC1IHSLCp44GIn1hoCw/58s0TJvmSA+22y4S6eStBHjCkX+BIrGQJBAKW1xrYNjZ5T2ymRrWX7ZGIorks7W+WiVb+9BsSkifD8n8KCjzhopzKQjV9zu0qG19n0UTPALXGpqdcJhn0WFnM=");
        long       v_Timestamp  = Date.getNowTime().getTime();
        
        System.out.println("时间戳：" + v_Timestamp);
        System.out.println("生成签名：" + v_Signaturer.sign("appKey" + "0904202FB2EA4AC3A899B423928A0F8E" + "timestamp" + v_Timestamp));
        System.out.println("签名转义：" + URLEncoder.encode(v_Signaturer.sign("appKey" + "0904202FB2EA4AC3A899B423928A0F8E" + "timestamp" + v_Timestamp) ,"UTF-8"));
    }
    
    
    
    @Test
    public void test_V2() throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
    {
        Signaturer v_Signaturer = new Signaturer(1 ,"7197afb19b8c4796b9f87c90a6427704");
        
        System.out.println(v_Signaturer.sign("appKey435af69873fc4e72849cd95060148435timestamp1608624227145"));
        
        
        Map<String, String> params = new HashMap<String ,String>();
        // 除签名外的其他参数
        params.put("appKey", "435af69873fc4e72849cd95060148435");
        params.put("timestamp", "1608624227145");
        System.out.println(SignHelper.sign(params ,"7197afb19b8c4796b9f87c90a6427704"));
    }
    
}
