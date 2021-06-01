package hy.common.license.junit;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.hy.common.StringHelp;
import org.hy.common.license.AES;
import org.junit.Test;





/**
 * 测试单元：AES加密
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-04-26
 * @version     v1.0
 */
public class JU_AES
{
 
    @Test
    public void test()
    {
        AES v_AES_V1 = new AES("fimesion");
        AES v_AES_V2 = new AES(2 ,"fimesion");
        
        // mzj0809123456
        String v_AESPassword = v_AES_V1.encrypt("1621837020041");
        String v_OrgPassword = v_AES_V1.decrypt(v_AESPassword);
        
        System.out.println(v_OrgPassword + " = [" + v_AESPassword + "]");
        System.out.println(v_OrgPassword + " = [" + StringHelp.replaceAll(v_AESPassword ,"+" ,"@") + "]");
        
        v_AESPassword = v_AES_V2.encrypt("1621837020041");
        v_OrgPassword = v_AES_V2.decrypt(v_AESPassword);
        System.out.println(v_OrgPassword + " = [" + v_AESPassword + "]");
        System.out.println(v_OrgPassword + " = [" + StringHelp.replaceAll(v_AESPassword ,"+" ,"@") + "]");
    }
    
    
    
    @Test
    public void test_AES_V2()
    {
        AES v_AES_V2 = new AES(2 ,"nkoc2Cr@V0ZVSWFEM");
        
        for (int i=1; i<=10; i++)
        {
            String v_AESPassword = v_AES_V2.encrypt("52140@f77f2e42f6f5464b92344ef5735da329" + i);
            String v_OrgPassword = v_AES_V2.decrypt(v_AESPassword);
            
            System.out.println(v_OrgPassword + " = [" + v_AESPassword + "]");
            System.out.println(v_OrgPassword + " = [" + StringHelp.replaceAll(v_AESPassword ,"+" ,"@") + "]");
        }
    }
    
    
    
    @Test
    public void test_AES_V2_encrypt() throws UnsupportedEncodingException
    {
        AES v_AES_V2 = new AES(2 ,"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ5QRPHHx4xEnxL2N+MZukCCh+ugsEbw5e0/M67ZNOWenA/EEOyNmFYW9X/+SK/K1V8GTUyZF/aiqDFrr0uKkf6zJZeHBfkH5Q5g3wxFjLqmFoqwf4RtWjmB+gJaEwbYZKlZprlppJwUlF0AvS/kkbMhGVP2KXumoWR6GFDTSOojAgMBAAECgYEAjBF47nJTm0cbdythRwz8PRdAKrmBPULmK4I/t/N1WbN7YHeYgbLFlWW60AOrS92p6ukoexz4lr5TEWa1MaDoiYncwX7MoyqSIKX62TZ/Saz/Mg15xfXnRnjOYA+8jo4nFfUo8V7OdFuJHl4j5Y/jyE/s+1SeMzPAHNv1u39l6AECQQDkiHqMJUNNksz2Y4U+fgFv0mSIgdXzK2RvS2T//M//7HInc0nrfXmKBCdAL+kTh+DfMOP/WkmIAsEGgs453LTrAkEAsVdFQ7dOWXND/mxF0hxJH1bxi0JCC8jYChz8cSFiB7P1hG5SEn9959HKfQKF4asOf0VZon5ZUPizt1EG4r2xqQJACNRNB8UYyJJ3YL2PlE6B97QFNlDt1ytCAhrDmDBISPb1ohiOLo72dyKZ8ZzoQFzrjzPwWxk95gdVNc8v8IRaaQJALHu+lRDK52chXBVeoiiUMvdFGXBiTsBvaIIC1IHSLCp44GIn1hoCw/58s0TJvmSA+22y4S6eStBHjCkX+BIrGQJBAKW1xrYNjZ5T2ymRrWX7ZGIorks7W+WiVb+9BsSkifD8n8KCjzhopzKQjV9zu0qG19n0UTPALXGpqdcJhn0WFnM=");
        
        String v_AESPassword = v_AES_V2.encrypt("4D922136C425DA8079773EBB48A2FE4C");
        
        System.out.println(v_AESPassword);
        System.out.println(URLEncoder.encode(v_AESPassword ,"UTF-8"));
    }
    
}
