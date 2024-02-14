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
        DES    v_Des  = new DES("" + "-" + "String" + "-" + "org.hy.common.StringHelp");
        String v_Text = v_Des.decrypt("0SzB9tc5ArOBOqAFkU/mwYvbqofYX9dOyWZoNi5HvKCX0CkImONhog==");
                
        $Logger.info(v_Text);
    }
    
    
    
    @Test
    public void test02()
    {
        DES    v_Des  = new DES("MS_CDC_Analyses_Password" + "-value-org.hy.common.StringHelp");
        String v_Text = v_Des.decrypt("uIuEFbSkBYc=");
        
        $Logger.info(v_Text);
    }
    
}
