package hy.common.license.junit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.hy.common.Date;
import org.hy.common.license.SignProvider;
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
    public void test_V1_XSSO() throws UnsupportedEncodingException
    {
        Signaturer v_Signaturer = new Signaturer(1 ,"MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKqLpw60A4bkPsJW5BOYdM4PfOwdx/389AmlKHEAELVrvh1RsTcplt1adQBBz2iCM0tQruSyU3P5/s9j1U1C8Cx0WVYhAIRNhZ5xZcdo91xg92URCZpdQ9QX0ATSPTKK6ZvAMbhFzYFD/MOzaFS51dHdejiJqK9KFeRSzuyHOnfLAgMBAAECgYEAkt1ihpnks6QYm5jiHjHa3Jyf0mGvGP1dVnUAx5brzJ+0/2CbQMqy3XoJaahCqVf+PiyD//PFRAmUMhph1IABfI2LzzDS8DYjrzV05ahFts2sFMbWcDK4f0C/Cmz0vx+Ggn3+DsVqzTyX8IejJChBGWXJk6VDCWZVcsQgpz/FopECQQDkLEmWOsbsa1lN6eZb6ZKqFI00/frpVa5RyvN1whr+j2/FjuUTyekohnYo3uXjYlufPx5uqAJMj3pY/AZ8GH3pAkEAv1gyaRiprKe8/S5haANhx0/E+M2Ik7FkXqDyoAfXE48z1CG3jPahux7ce4UAj3l96f4KXb4iOhdA527PMrbzkwJBAM62ZLBKbZ8QHebdSYnpUKrvVYI1ulQcAIIvWGNNx8DpV7xmGZjU6nuBXZjnXuOiXxklSL+9S9/qeFAXexR/58kCQQCHVwfZBGPHRqHLZsno+zNm+co1vZMT/E4lDKxwevsqz4h2TB77Ktt8cji7eXjLAsEIB/MnGTw2YIo86EjP803XAkAb5vgG94qKDErmO5xSzbKfwXdc4jC0wn+sXvLTOkzkmsLXS5m3WGVwJhcF6IVHkRKoupwg/bA/zIFNxsGE1os+");
        long       v_Timestamp  = Date.getNowTime().getTime();
        String     v_Code       = "appKey" + "D22DCADC06BB4EAE868D5728AACAD370" + "timestamp" + v_Timestamp;
        String     v_Signature  = v_Signaturer.sign(v_Code);
        
        System.out.println("时间戳："   + v_Timestamp);
        System.out.println("生成签名：" + v_Signature);
        System.out.println("签名转义：" + URLEncoder.encode(v_Signature ,"UTF-8"));
    
    
        boolean v_Verify = SignProvider.verify("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCqi6cOtAOG5D7CVuQTmHTOD3zsHcf9/PQJpShxABC1a74dUbE3KZbdWnUAQc9ogjNLUK7kslNz+f7PY9VNQvAsdFlWIQCETYWecWXHaPdcYPdlEQmaXUPUF9AE0j0yiumbwDG4Rc2BQ/zDs2hUudXR3Xo4iaivShXkUs7shzp3ywIDAQAB".getBytes() 
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
