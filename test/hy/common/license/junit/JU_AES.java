package hy.common.license.junit;

import org.hy.common.StringHelp;
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
        AES v_AES_V1 = new AES("nkoc2Cr@V0ZVSWFEM");
        AES v_AES_V2 = new AES(2 ,"nkoc2Cr@V0ZVSWFEM");
        
        // mzj0809123456
        String v_AESPassword = v_AES_V1.encrypt("52140@3381d50a061a46fcaf90b9779310665d");
        String v_OrgPassword = v_AES_V1.decrypt(v_AESPassword);
        
        System.out.println(v_OrgPassword + " = [" + v_AESPassword + "]");
        System.out.println(v_OrgPassword + " = [" + StringHelp.replaceAll(v_AESPassword ,"+" ,"@") + "]");
        
        v_AESPassword = v_AES_V2.encrypt("52140@3381d50a061a46fcaf90b9779310665d");
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
    
}
