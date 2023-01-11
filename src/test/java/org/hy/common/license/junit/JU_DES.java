package org.hy.common.license.junit;

import org.hy.common.license.DES;
import org.hy.common.xml.log.Logger;
import org.junit.Test;





/**
 * 测试单元：DES加密
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-05-22
 * @version     v1.0
 */
public class JU_DES
{
    private static final Logger $Logger = Logger.getLogger(JU_DES.class ,true);
    
    
    
    @Test
    public void test()
    {
        DES v_Des = new DES("DS_OA" + "-" + "user" + "-" + "org.hy.common.StringHelp");
        
        $Logger.info(v_Des.decrypt("TlzbKfnd/40="));
    }
    
    
    
    @Test
    public void test02()
    {
        DES    v_Des  = new DES("DSG_MS_阿波罗_Target_MQ" + "-password-org.hy.common.Help");
        String v_Text = v_Des.decrypt("ZzO4cQt8NoU=");
        
        $Logger.info(v_Text);
    }
    
}
