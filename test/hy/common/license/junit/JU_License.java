package hy.common.license.junit;

import java.io.IOException;

import org.hy.common.Date;
import org.hy.common.Help;
import org.hy.common.StringHelp;
import org.hy.common.file.FileHelp;
import org.hy.common.license.KeyStore;
import org.hy.common.license.License;
import org.hy.common.license.LicenseFactory;
import org.hy.common.xml.XJava;
import org.hy.common.xml.annotation.XType;
import org.hy.common.xml.annotation.Xjava;
import org.hy.common.xml.log.Logger;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;





@Xjava(value=XType.XML)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JU_License
{
    private static final Logger $Logger = new Logger(JU_License.class ,true);
    
    private static boolean      $isInit = false;
    
    
    
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
    public void test_License_Setp00_MakeKey()
    {
        KeyStore v_KeyStore = KeyStore.generater();
        $Logger.info("公钥：" + v_KeyStore.getPublicKeyString());
        $Logger.info("私钥：" + v_KeyStore.getPrivateKeyString());
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
        KeyStore v_KeyStore = new KeyStore();
        String   v_Register = makeRegister();
        License  v_License  = new License();
        
        v_KeyStore.setPublicKey ("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSDP6YK66JShurdzf7pxTxx+UDlXqhDQhZ2pqHTd5Oh/dAyWUOft1KgWoKNQCAB5n2KFlEXIfmWtU4p/zmThZrpVSrEctYLDsdUZaqQ7mb0MDiv7nmMsu2Tu7vjRb8iL403SeaC9rPUmdloa4r+U1DuqYbSb03qK+WiaotsaZRvwIDAQAB");
        v_KeyStore.setPrivateKey("MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANIM/pgrrolKG6t3N/unFPHH5QOVeqENCFnamodN3k6H90DJZQ5+3UqBago1AIAHmfYoWURch+Za1Tin/OZOFmulVKsRy1gsOx1RlqpDuZvQwOK/ueYyy7ZO7u+NFvyIvjTdJ5oL2s9SZ2Whriv5TUO6phtJvTeor5aJqi2xplG/AgMBAAECgYApsdyjtiAKLoS5j4u0T2Ev8T77bCOQbnbW5za/Xuye6AxjdtaxfutMS84Rwp2bzGZ6X14A3OE5D5S9j1L7IEsArRixJLzciDnti0VUJE5plKOzHdHNMYSdI45iGUL1ezLWe9mNPVszAGBBUKr+vYkESo6cl7D+GyYmtQeRfiMsGQJBAOvs92P5piNT4bVGuun/LbZw2SRaqBRzP3aHN7F5qAeFHereCWo/1PFnmi94TRVUSnM11eHpZX2AmgFZJvYlZF0CQQDj7GkCdQDnvFFzNLscW/R3wt4RRMZJ6v+b3P2B+h7CWmlyFH1jKAIU5YynKN/sTSmeSFIIiB790bFRJtg3wuzLAkEAxzBW3s3Ue1dC5W5GOXH9Al/ctVjlN/7lwgj/+JOiTlcRn06/3DjwbLDv+Mw1KKD2CreVURthWMjPPfwrbP688QJARWuHHFl4uhxQjo9cAio7zpJKwuW4o2DxE47+o60D21xgS3/UJPRVlfnImk1Hzpg9+di7K6ASGGra4AW9y1YSewJAK6vichWZDCsw/FFAvXeto+SXePkq+R2iRED4WQfcpD0bD3IzdzLkrhmfPcnk3LLSKPr5eeB3AnpL3yUZu91lhw==");
        
        v_License.setRunTime("2022-01-01 00:00:00");
        v_License.setTime   ("2022-12-31 59:59:59");
        v_License.setFormat ("1.0");
        v_License.setMaxCount("100");
        v_License.setOnLineCount("64");
        
        String   v_Contents = LicenseFactory.create(v_License ,v_Register ,v_KeyStore);
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
        
        String v_Register  = makeRegister();
        String v_PublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDSDP6YK66JShurdzf7pxTxx+UDlXqhDQhZ2pqHTd5Oh/dAyWUOft1KgWoKNQCAB5n2KFlEXIfmWtU4p/zmThZrpVSrEctYLDsdUZaqQ7mb0MDiv7nmMsu2Tu7vjRb8iL403SeaC9rPUmdloa4r+U1DuqYbSb03qK+WiaotsaZRvwIDAQAB";
        int    v_Ret       = License.verifyLicense(v_License ,v_Register ,v_PublicKey ,1 ,2);
        if ( v_Ret == 0 )
        {
            System.out.println("验证成功.");
        }
        else
        {
            System.err.println("验证失败：" + v_Ret);
        }
    }
    
}
