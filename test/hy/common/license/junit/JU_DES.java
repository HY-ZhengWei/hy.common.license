package hy.common.license.junit;

import org.hy.common.license.DES;
import org.junit.Test;

import com.sun.istack.internal.logging.Logger;





/**
 * 测试单元：DES加密
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-05-22
 * @version     v1.0
 */
public class JU_DES
{
    private static final Logger $Logger = Logger.getLogger(JU_DES.class);
    
    
    
    @Test
    public void test()
    {
        DES v_Des = new DES("DS_OA" + "-" + "user" + "-" + "org.hy.common.StringHelp");
        
        $Logger.info(v_Des.decrypt("TlzbKfnd/40="));
    }
    
}
