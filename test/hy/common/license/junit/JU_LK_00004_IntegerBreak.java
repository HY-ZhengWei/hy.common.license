package hy.common.license.junit;

import org.junit.Test;





/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 
 * 示例 1:
 * 
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 
 * 示例 2:
 * 
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-26
 * @version     v1.0
 */
public class JU_LK_00004_IntegerBreak
{
    
    private int maxSum = 1;
    
    
    
    @Test
    public void LK()
    {
        int v_Num = 5;
        
        integerBreak_V1(v_Num ,new int[v_Num] ,0 ,1);
        System.out.println("最大积是：" + integerBreak_V2(v_Num) + " - " + maxSum);
    }
    
    
    
    public double integerBreak_V2(int i_Num)
    {
        if ( i_Num == 2 )
        {
            return 1;
        }
        else if ( i_Num == 3 )
        {
            return 2;
        }
        
        int v_R    = i_Num % 3;
        int v_Size = i_Num / 3;
        
        if ( v_R == 1 )
        {
            v_Size--;
            v_R += 3;
        }
        else if ( v_R == 0 )
        {
            v_R = 1;
        }
        
        return Math.pow(3 ,v_Size) * v_R;
    }
    
    
    
    public void integerBreak_V1(int i_Num ,int [] io_AddData ,int i_MaxSize ,int i_Sum)
    {
        int v_Size = i_Num / 2 + 1; 
        
        for (int x=1; x<v_Size; x++)
        {
            if ( i_MaxSize >= 1 )
            {
                if ( x < io_AddData[i_MaxSize - 1] )
                {
                    continue;
                }
            }
            
            int v_Next = i_Num - x;
            int v_Sum  = i_Sum * x * v_Next;
            
            if ( maxSum < v_Sum )
            {
                maxSum = v_Sum;
            }
            
            io_AddData[i_MaxSize] = x;
            
            this.integerBreak_V1(v_Next ,io_AddData ,i_MaxSize + 1 ,i_Sum * x);
        }
    }
    
}
