package org.hy.common.license;

import java.io.IOException;
import java.util.Map;

import org.hy.common.Help;
import org.hy.common.StringHelp;
import org.hy.common.file.FileHelp;





/**
 * 许可证书工厂
 *
 * @author      ZhengWei(HY)
 * @createDate  2017-07-25
 * @version     v1.0
 */
public final class LicenseFactory
{
    
    @SuppressWarnings("unchecked")
    public static String create(License i_License) throws IOException
    {
        Map<String ,Object> v_Datas    = i_License.toMap("");
        FileHelp            v_FileHelp = new FileHelp();
        String              v_Content  = v_FileHelp.getContent(LicenseFactory.class.getResourceAsStream("License" + i_License.getFormat() + ".xml") ,"UTF-8" ,true);
        
        v_Datas = (Map<String ,Object>)Help.toPlaceholders(v_Datas ,":" ,"");
        
        return StringHelp.replaceAll(v_Content ,v_Datas);
    }
    
    
    
    private LicenseFactory()
    {
        // Nothing.
    }
    
}
