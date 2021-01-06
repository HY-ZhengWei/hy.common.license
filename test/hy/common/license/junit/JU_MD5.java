package hy.common.license.junit;

import org.hy.common.license.md5.MD5_V1;
import org.hy.common.license.md5.MD5_V2;
import org.hy.common.license.md5.MD5_V3;
import org.hy.common.license.md5.MD5_V4;
import org.junit.Test;





/**
 * 测试单元：MD5加密
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-06
 * @version     v1.0
 */
public class JU_MD5
{
    
    @Test
    public void test_MD5_V1()
    {
        MD5_V1 v_MD5 = new MD5_V1();
        
        System.out.println("MD5_V1 = " + v_MD5.encrypt("Hello World！"));
    }
    
    
    
    @Test
    public void test_MD5_V2()
    {
        MD5_V2 v_MD5 = new MD5_V2();
        
        System.out.println("MD5_V2 = " + v_MD5.encrypt("Hello World！"));
    }
    
    
    
    @Test
    public void test_MD5_V3()
    {
        MD5_V3 v_MD5 = new MD5_V3();
        
        System.out.println("MD5_V3 = " + v_MD5.encrypt("Hello World！"));
    }
    
    
    
    @Test
    public void test_MD5_V4()
    {
        MD5_V4 v_MD5 = new MD5_V4();
        
        System.out.println("MD5_V4 = " + v_MD5.encrypt("Hello World！"));
    }
    
}
