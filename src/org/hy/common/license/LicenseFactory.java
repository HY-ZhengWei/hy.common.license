package org.hy.common.license;

import java.io.IOException;
import java.util.Map;

import org.hy.common.Help;
import org.hy.common.StringHelp;
import org.hy.common.file.FileHelp;
import org.hy.common.license.base64.Base64Factory;





/**
 * 许可证书工厂
 *
 * @author      ZhengWei(HY)
 * @createDate  2017-07-25
 * @version     v1.0
 */
public final class LicenseFactory
{
    
    /**
     * 生成许可证书
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-25
     * @version     v1.0
     * 
     * @param io_License  许可证书信息
     * @param i_Register  机器特征码
     * @param i_Key       公私密钥
     * @return
     * @throws IOException
     */
    public static String create(License io_License ,String i_Register ,KeyStore i_Key) throws IOException
    {
        Symmetric v_Symmetric = new Symmetric(i_Register);
        
        io_License.setRunTime(new String(Base64Factory.getIntance().encode(io_License.getRunTime())));
        io_License.setTime   (new String(Base64Factory.getIntance().encode(io_License.getTime())));
        io_License.setFormat (Help.NVL(io_License.getFormat() ,"1.0"));
        io_License.setMaxCount(   v_Symmetric.encrypt(io_License.getMaxCount()));
        io_License.setOnLineCount(v_Symmetric.encrypt("64"));
        io_License.setLicenseCode(null);
        
        String v_MachineID = i_Register + io_License.toString();
        String v_Sign      = new Signaturer(i_Key.getPrivateKeyString()).sign(v_MachineID);
        
        io_License.setLicenseCode(i_Key.getPublicKeyString() + "#" + v_Sign);
        
        return create(io_License);
    }
    
    
    
    /**
     * 生成许可证书
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-25
     * @version     v1.0
     *
     * @param i_License
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    private static String create(License i_License) throws IOException
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
