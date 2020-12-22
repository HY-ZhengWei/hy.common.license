package hy.common.license.junit;

import java.io.IOException;

import org.hy.common.Date;
import org.hy.common.Help;
import org.hy.common.StringHelp;
import org.hy.common.file.FileHelp;
import org.hy.common.license.KeyStore;
import org.hy.common.license.License;
import org.hy.common.license.LicenseFactory;
import org.hy.common.license.SignProvider;
import org.hy.common.license.Signaturer;
import org.hy.common.xml.XJava;
import org.hy.common.xml.annotation.XType;
import org.hy.common.xml.annotation.Xjava;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;





@Xjava(value=XType.XML)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JU_License
{
    
    private static boolean $isInit = false;
    
    
    
    public JU_License()
    {
        if ( !$isInit )
        {
            $isInit = true;
            
            try
            {
                XJava.parserAnnotation(JU_License.class.getName());
            }
            catch (Exception exce)
            {
                // Nothing.
            }
        }
    }
    
    
    
    /**
     * 生成注册码
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-24
     * @version     v1.0
     *
     * @return
     */
    public String makeRegister()
    {
        StringBuilder v_Builder = new StringBuilder();
        
        v_Builder.append(StringHelp.replaceAll(Help.getMacs() ,new String[]{"-" ,";"} ,new String[]{""}));
        
        return v_Builder.toString();
    }
    
    
    
    @Test
    public void test_License_Setp01_Client()
    {
        License v_License = (License)XJava.getObject("License");
        
        if ( v_License == null || !v_License.verify() )
        {
            System.out.println("没有许可信息，请用注册码注册：" + makeRegister());
            return;
        }
    }
    
    
    
    @Test
    public void test_License_Setp02_Server() throws IOException
    {
        String  v_Register = makeRegister();
        License v_License  = new License();
        
        v_License.setRunTime(StringHelp.BASE64Encoder("2017-01-01 00:00:00".getBytes()));
        v_License.setTime   (StringHelp.BASE64Encoder("2018-01-01 00:00:00".getBytes()));
        v_License.setFormat ("1.0");
        
        String v_MachineID = v_Register +  v_License.toString();
        
        KeyStore v_KeyStore  = KeyStore.generater();
        String   v_Sign      = new Signaturer(v_KeyStore.getPrivateKey()).sign(v_MachineID);
        
        v_License.setLicenseCode(v_KeyStore.getPublicKeyString() + "#" + v_Sign);
        
        
        String   v_Contents = LicenseFactory.create(v_License);
        Date     v_Date     = new Date();
        FileHelp v_FileHelp = new FileHelp();
        v_FileHelp.create(Help.getClassPath(this).replaceAll("bin" ,"test") + Help.getSysPathSeparator() + "License" + v_Date.getFull_ID() + ".xml" ,v_Contents ,"UTF-8");
        
        XJava.putObject("License" ,v_License);
    }
    
    
    
    @Test
    public void test_License_Setp03_Client()
    {
        License v_License = (License)XJava.getObject("License");
        
        if ( v_License == null || !v_License.verify() )
        {
            System.out.println("没有许可信息，请用注册码注册：" + makeRegister());
            return;
        }
        
        String v_PublicKey = v_License.getLicenseCode().split("#")[0];
        String v_Sign      = v_License.getLicenseCode().split("#")[1];
        
        v_License.setLicenseCode(null);
        
        String v_MachineID = makeRegister() +  v_License.toString();
        
        boolean v_Verify = SignProvider.verify(v_PublicKey ,v_MachineID ,v_Sign);
        if ( v_Verify )
        {
            System.out.println("验证成功.");
        }
        else
        {
            System.err.println("验证失败.");
        }
    }
    
}
