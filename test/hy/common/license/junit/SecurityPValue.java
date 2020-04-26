package hy.common.license.junit;

import org.hy.common.JavaHelp;
import org.hy.common.app.AppParameter;





/**
 * 安全类的测试类
 *
 * @author   ZhengWei(HY)
 * @version  V1.0  2013-03-25
 */
public class SecurityPValue 
{

	public static void main(String[] args) 
	{
		AppParameter v_AppParam = new AppParameter(args);
		
		String v_PV  = v_AppParam.getParamValue("pv");
		String v_Key = v_AppParam.getParamValue("key");
		
		if ( JavaHelp.isNull(v_PV) )
		{
			System.out.println("PV is null.");
			return;
		}
		
		if ( JavaHelp.isNull(v_Key) )
		{
			System.out.println("Key is null.");
			return;
		}
		
		
		if ( v_PV.length() == Security.SECURITYLEN )
		{
			System.out.println(Security.getInstance().getDecrypt(v_PV ,v_Key));
		}
		else
		{
			System.out.println(Security.getInstance().getEncrypt(v_PV ,v_Key));
		}
	}

}
