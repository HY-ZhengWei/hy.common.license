package org.hy.common.license;

import org.hy.common.Help;
import org.hy.common.StringHelp;





/**
 * 许可证书的注册码
 *
 * @author      ZhengWei(HY)
 * @createDate  2022-08-18
 * @version     v1.0
 */
public class LicenseRegister
{
    
    /**
     * 生成注册码
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-24
     * @version     v1.0
     *
     * @return
     */
    public static String makeRegister()
    {
        StringBuilder v_Builder = new StringBuilder();
        
        v_Builder.append(StringHelp.replaceAll(Help.getMacs() ,new String[]{"-" ,";"} ,new String[]{""}));
        
        return v_Builder.toString();
    }
    
    
    
    private LicenseRegister()
    {
        
    }
    
}
