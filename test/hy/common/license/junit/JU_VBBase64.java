package hy.common.license.junit;

import org.hy.common.license.VBBase64;
import org.junit.Test;





public class JU_VBBase64
{
    
    @Test
    public void test_Decrypt()
    {
        String v_Password = "MjM3LDIzNiw4NywyMDUsMTQzLDEzLDE3MywyMywxNzYsOTcsMTYyLDE2MCwxODksODcsMjQ2LDI0LDE2Niw2NiwxOTMsNjMsNTAsMjA0LDg1LDk5";
        String v_Key      = "795";

        System.out.println(VBBase64.decrypt(v_Password ,v_Key));
        
        
        
//        byte [] v_PwdBytes  = StrConv.stringToByteArray(v_Password);
//        byte [] v_DecodeB64 = new byte[v_PwdBytes.length / 4 * 3];   
//        for (int i=0 ,x=0; i<v_PwdBytes.length; i+=4 ,x++)
//        {
//            String v_4B = "";
//            
//            v_4B += (char)v_PwdBytes[i];
//            v_4B += (char)v_PwdBytes[i + 1];
//            v_4B += (char)v_PwdBytes[i + 2];
//            v_4B += (char)v_PwdBytes[i + 3];
//            
//            byte [] v_3Byte = StrConv.fromBase64(v_4B);
//            
//            v_DecodeB64[x * 3]     = v_3Byte[0];
//            v_DecodeB64[x * 3 + 1] = v_3Byte[1];
//            v_DecodeB64[x * 3 + 2] = v_3Byte[2];
//        }
    }
    
    
    
    @Test
    public void test_Encrypt()
    {
        String v_Text = "GB78/M4X4/0Cr18Ni9";
        String v_Key  = "795";
        
        System.out.println(VBBase64.encrypt(v_Text ,v_Key));
    }
    
}
