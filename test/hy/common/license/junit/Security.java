package hy.common.license.junit;

import java.util.Random;





/**
 * 安全类
 *
 * @author   ZhengWei(HY)
 * @version  V1.0  2011-04-18
 */
public final class Security 
{
	public final static int  SECURITYLEN = 128;

	private static Security $Security;
	
	
	
	public static Security getInstance()
	{
		if ( $Security == null )
		{
			$Security = new Security();
		}
		
		return $Security;
	}
	
	
	
	/**
	 * 私有的构造器
	 */
	private Security()
	{
		
	}
	
	
	
	/**
	 * 加密
	 * 
	 * @param i_Str  要被加密的字符串
	 * @param i_Key  加密Key
	 * @return
	 */
    public String getEncrypt(String i_Str ,String i_Key)
    {
    	StringBuilder buffer = new StringBuilder();
    	
    	// 生成 Key
        Random v_Random = new Random();
        int    v_RKey   = Math.abs((v_Random.nextInt() % 1000)) + 1;
        
        buffer.append(lpad(v_RKey ,"0" ,4));
        buffer.append(lpad(Integer.toString(i_Str.length() + v_RKey + compute(i_Key) ,16) ,"0" ,4));
        

        for (int i = 0; i < i_Str.length(); i++ )
        {
            int v_TempInt = (int)i_Str.charAt(i);

            if (v_TempInt % 2 == 0)
            {
                v_TempInt = v_TempInt - 2;
            }
            else
            {
                v_TempInt = v_TempInt - 4;
            }

            v_TempInt = v_TempInt + i + v_RKey;

            String v_Str_16 = Integer.toString(v_TempInt ,16);
            buffer.append(lpad(v_Str_16 ,"0" ,4));
        }
        
        
        for (int i=buffer.toString().length(); i<SECURITYLEN; i=i+4 )
        {
        	buffer.append(lpad(Math.abs((v_Random.nextInt() % 10000)) ,"0" ,4));
        }
        
        return buffer.toString();
    }


    
    /**
     * 解密
     * 
     * @param i_Str  要被解密的字符串
     * @param i_Key  加密Key
     * @return
     */
    public String getDecrypt(String i_Str ,String i_Key)
    {
        StringBuilder buffer       = new StringBuilder();
        int           v_ParseIndex = 0;
        int           v_RKey       = 0;
        int           v_PWDLen     = 0;
        	

        for (int i = 0; i < i_Str.length(); i = i + 4)
        {
            String v_TempStr = i_Str.substring(i, i + 4);
            for (int byte_i = 0; byte_i < v_TempStr.length(); byte_i++)
            {
                if ( '0' == v_TempStr.charAt(byte_i) )
                {
                    // Nothing;
                }
                else
                {
                    v_TempStr = v_TempStr.substring(byte_i);
                    break;
                }
            }

            v_ParseIndex++;
            
            if ( v_ParseIndex ==1 )
            {
            	v_RKey = Integer.parseInt(v_TempStr);
            }
            else if ( v_ParseIndex == 2)
            {
            	v_PWDLen = Integer.parseInt(v_TempStr ,16) - v_RKey - compute(i_Key);
            }
            else if ( v_PWDLen < v_ParseIndex - 2 )
            {
            	break;
            }
            else
            {
	            int v_TempInt = Integer.parseInt(v_TempStr, 16);
	            v_TempInt     = v_TempInt - ((i - 8) / 4) - v_RKey;
	
	            if (v_TempInt % 2 == 0)
	            {
	                v_TempInt = v_TempInt + 2;
	            }
	            else
	            {
	                v_TempInt = v_TempInt + 4;
	            }
	
	            buffer.append((char)(v_TempInt));
            }
        }

        return buffer.toString();
    }
    
    
    
    /**
     * 获取加密长度
     *  
     * @return
     */
    public int getSecurityLen()
    {
    	return SECURITYLEN;
    }
    
    
    
    /**
     * 左填充方法
     * 
     * @param i_Int          数字
     * @param i_PadString    填充字符
     * @param i_TotalLengh   填充后的总长度
     * @return
     */
    public static String lpad(int i_Int ,String i_PadString ,int i_TotalLengh)
    {
    	StringBuffer buffer = new StringBuffer();
    	
        for (int byte_i = String.valueOf(i_Int).length(); byte_i < i_TotalLengh; byte_i++)
        {
            buffer.append(i_PadString);
        }
        buffer.append(i_Int);
        
        return buffer.toString();
    }
    
    
    
    /**
     * 左填充方法
     * 
     * @param i_Str          字符
     * @param i_PadString    填充字符
     * @param i_TotalLengh   填充后的总长度
     * @return
     */
    public static String lpad(String i_Str ,String i_PadString ,int i_TotalLengh)
    {
    	StringBuffer buffer = new StringBuffer();
    	
    	i_Str = i_Str == null ? "" : i_Str;
    	
        for (int byte_i = i_Str.length(); byte_i < i_TotalLengh; byte_i++)
        {
            buffer.append(i_PadString);
        }
        buffer.append(i_Str);
        
        return buffer.toString();
    }
    
    
    
    /**
     * 左填充方法
     * 
     * @param i_Str          字符
     * @param i_PadString    填充字符
     * @param i_TotalLengh   填充后的总长度
     * @return
     */
    public static String rpad(String i_Str ,String i_PadString ,int i_TotalLengh)
    {
    	StringBuffer buffer = new StringBuffer();
    	
    	i_Str = i_Str == null ? "" : i_Str;
    	
    	buffer.append(i_Str);
        for (int byte_i = i_Str.length(); byte_i < i_TotalLengh; byte_i++)
        {
            buffer.append(i_PadString);
        }
        
        return buffer.toString();
    }
    
    
    
    /**
     *  计算某一字符串对值是多少。即特殊的字符转数字
     * 
     * @param i_Str
     * @return
     */
    public static int compute(String i_Str)
    {
    	int v_Result = 0;
    	
    	for (int i=0; i<i_Str.length(); i++)
    	{
    		v_Result = v_Result + (int)i_Str.charAt(i);
    	}
    	
    	return v_Result;
    }
    
}
