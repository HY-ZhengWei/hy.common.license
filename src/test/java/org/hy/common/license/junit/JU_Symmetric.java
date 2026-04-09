package org.hy.common.license.junit;

import org.hy.common.license.ISymmetric;
import org.hy.common.license.Symmetric;
import org.junit.Test;




/**
 * 测试单元：AES_V3
 *
 * @author      ZhengWei(HY)
 * @createDate  2026-04-09
 * @version     v1.0
 */
public class JU_Symmetric
{
    
    @Test
    public void test()
    {                  
        //                        1         2         3
        //               1234567890123456789012345678901234567890
        String v_PK1  = "llmgate@3edc#EDCXModel_10.0.1.192_11434_qwen3.5:9b";
        String v_PK2  = "llmgate@3edc#EDCXModel_11.0.106.95_11434_gemma4:31b";
        String v_Text = "sk-ZhengWei"; 
        
        ISymmetric v_ISymmetric1 = new Symmetric(2 ,13 ,v_PK1);
        ISymmetric v_ISymmetric2 = new Symmetric(2 ,13 ,v_PK2);
        ISymmetric v_ISymmetric3 = new Symmetric(2 ,13 ,v_PK2);
        
        String v_E1 = v_ISymmetric1.encrypt(v_Text);
        String v_E2 = v_ISymmetric2.encrypt(v_Text);
        String v_D1 = v_ISymmetric1.decrypt(v_E1);
        String v_D2 = v_ISymmetric2.decrypt(v_E2);
        String v_D3 = v_ISymmetric3.decrypt(v_E2);
        
        System.out.println(v_E1 + " | " + v_D1);
        System.out.println(v_E2 + " | " + v_D2);
        System.out.println(v_E2 + " | " + v_D3);
    }
    
}
