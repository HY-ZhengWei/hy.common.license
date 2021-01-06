package hy.common.license.junit;

import java.io.UnsupportedEncodingException;

import org.hy.common.license.VBBase64;
import org.junit.Test;





public class JU_VBBase64
{
    
    @Test
    public void test_Decrypt()
    {
        String   v_Password = "MTQyLDIxOSwyNDYsMjExLDIsMTcyLDg3LDEwNCwzNSwxNjQsMzksMTk4LDE5LDE4MSwzLDIyNiwyNDQsMTQ1LDEzLDEzMiwxMjksMjE5LDYzLDEzMQ==";
        VBBase64 v_VBBase64 = new VBBase64("795597");

        System.out.println(v_VBBase64.decrypt(v_Password));
        
        
        
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
    public void test_Encrypt() throws UnsupportedEncodingException
    {
        String   v_Text = "AM27421-2101-5428";
        VBBase64 v_VBBase64 = new VBBase64("795597");
        String   v_Pwd  = v_VBBase64.encrypt(v_Text);
        
        System.out.println(v_Pwd);
        System.out.println(v_VBBase64.decrypt(v_Pwd));
    }
    
}
