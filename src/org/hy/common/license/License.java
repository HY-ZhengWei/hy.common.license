package org.hy.common.license;

import org.hy.common.Help;
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
    
}
