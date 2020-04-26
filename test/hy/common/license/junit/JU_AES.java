package hy.common.license.junit;

import org.hy.common.license.AES;
import org.junit.Test;





/**
 * 测试单：AES加密
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
        AES v_AES = new AES("TcRlEiyjizMOfK4u");
        
        // mzj0809123456
        String v_AESPassword = v_AES.encrypt("admin@2019!");
        String v_OrgPassword = v_AES.decrypt(v_AESPassword);
        
        System.out.println(v_OrgPassword + " = [" + v_AESPassword + "]");
    }
    
}
