package org.hy.common.license;

import org.hy.common.Date;
import org.hy.common.Help;
import org.hy.common.license.base64.Base64Factory;
import org.hy.common.xml.SerializableDef;





/**
 * 许可证书信息
 *
 * @author      ZhengWei(HY)
 * @createDate  2017-07-24
 * @version     v1.0
 */
public class License extends SerializableDef
{
    
    private static final long serialVersionUID = 8798746455323239535L;

    /** 生效时间 */
    private String runTime;
    
    /** 到期时间 */
    private String time;
    
    /** License的格式 */
    private String format;
    
    /** 授权码 */
    private String licenseCode;
    
    /** 授权在线数量 */
    private String onLineCount;
    
    /** 授权最大数量 */
    private String maxCount;

    
    
    /**
     * 获取：生效时间
     */
    public String getRunTime()
    {
        return runTime;
    }
    

    
    /**
     * 设置：生效时间
     * 
     * @param runTime
     */
    public void setRunTime(String runTime)
    {
        this.runTime = runTime;
    }
    

    
    /**
     * 获取：到期时间
     */
    public String getTime()
    {
        return time;
    }
    

    
    /**
     * 设置：到期时间
     * 
     * @param time
     */
    public void setTime(String time)
    {
        this.time = time;
    }
    

    
    /**
     * 获取：License的格式
     */
    public String getFormat()
    {
        return format;
    }
    

    
    /**
     * 设置：License的格式
     * 
     * @param format
     */
    public void setFormat(String format)
    {
        this.format = format;
    }


    
    /**
     * 获取：授权码
     */
    public String getLicenseCode()
    {
        return licenseCode;
    }
    

    
    /**
     * 设置：授权码
     * 
     * @param licenseCode
     */
    public void setLicenseCode(String licenseCode)
    {
        this.licenseCode = licenseCode;
    }
    
    
    
    /**
     * 获取：授权在线数量
     */
    public String getOnLineCount()
    {
        return onLineCount;
    }



    /**
     * 设置：授权在线数量
     * 
     * @param onLineCount
     */
    public void setOnLineCount(String onLineCount)
    {
        this.onLineCount = onLineCount;
    }



    /**
     * 获取：授权最大数量
     */
    public String getMaxCount()
    {
        return maxCount;
    }



    /**
     * 设置：授权最大数量
     * 
     * @param maxCount
     */
    public void setMaxCount(String maxCount)
    {
        this.maxCount = maxCount;
    }



    /**
     * 验证基本信息
     * 
     * @author      ZhengWei(HY)
     * @createDate  2017-07-24
     * @version     v1.0
     *
     * @return
     */
    public boolean verify()
    {
        for (int i=0; i<this.gatPropertySize(); i++)
        {
            Object v_Value = this.gatPropertyValue(i);
            
            if ( v_Value == null || Help.isNull(v_Value.toString()) )
            {
                return false;
            }
        }
        
        return true;
    }
    
    
    
    /**
     * 验证许可证书
     * 
     * @author      ZhengWei(HY)
     * @createDate  2022-08-17
     * @version     v1.0
     * 
     * @param io_License
     * @param i_PublicKey    公钥
     * @param i_OnLineCount  授权在线数量
     * @param i_MaxCount     授权最大数量
     * @return
     */
    public static int verifyLicense(License io_License ,String i_PublicKey ,Integer i_OnLineCount ,Integer i_MaxCount)
    {
        if ( !io_License.verify() )
        {
            // "没有许可信息，请用注册码注册：" + makeRegister());
            return -1;
        }
        
        try
        {
            String v_Register  = LicenseRegister.makeRegister();
            String v_PublicKey = io_License.getLicenseCode().split("#")[0];
            String v_Sign      = io_License.getLicenseCode().split("#")[1];
            
            if ( !i_PublicKey.equals(v_PublicKey) )
            {
                return -2;
            }
            
            io_License.setLicenseCode(null);
            
            String    v_MachineID = v_Register + io_License.toString();
            Symmetric v_Symmetric = new Symmetric(v_Register);
            
            boolean v_Verify = SignProvider.verify(v_PublicKey ,v_MachineID ,v_Sign);
            if ( !v_Verify )
            {
                return -2;
            }
            
            Date v_NowTime = new Date();
            Date v_RunTime = new Date(new String(Base64Factory.getIntance().decode(io_License.getRunTime())));
            if ( v_RunTime == null || v_NowTime.differ(v_RunTime) <= 0L )
            {
                return -3;
            }
            
            Date v_Time = new Date(new String(Base64Factory.getIntance().decode(io_License.getTime())));
            if ( v_Time == null || v_NowTime.differ(v_Time) >= 0L )
            {
                return -4;
            }
            
            Integer v_OnLineCount = Integer.parseInt(v_Symmetric.decrypt(io_License.getOnLineCount()));
            if ( v_OnLineCount != null && v_OnLineCount > 0 )
            {
                if ( i_OnLineCount == null )
                {
                    return -5;
                }
                
                if ( i_OnLineCount.intValue() > v_OnLineCount.intValue() )
                {
                    return -5;
                }
            }
            
            Integer v_MaxCount = Integer.parseInt(v_Symmetric.decrypt(io_License.getMaxCount()));
            if ( v_MaxCount != null && v_MaxCount > 0 )
            {
                if ( i_MaxCount == null )
                {
                    return -6;
                }
                
                if ( i_MaxCount.intValue() > v_MaxCount.intValue() )
                {
                    return -6;
                }
            }

            io_License.setTime(v_Time.getFull());
            
            return 0;
        }
        catch (Exception exce)
        {
            // Nothing.
        }
        
        return -99;
    }
    
}
