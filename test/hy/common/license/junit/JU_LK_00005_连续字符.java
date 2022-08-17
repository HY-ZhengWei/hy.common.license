package hy.common.license.junit;

import org.junit.Test;





/**
 * 连续字符
 * 
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 * 
 * 示例 1：
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 
 * 示例 2：
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 
 * 示例 3：
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 
 * 示例 4：
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 
 * 示例 5：
 * 输入：s = "tourist"
 * 输出：1
 * 
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 * 
 * @author      ZhengWei(HY)
 * @createDate  2021-12-01
 * @version     v1.0
 */
public class JU_LK_00005_连续字符
{
    
    @Test
    public void LK()
    {
        maxPower("leetcode");
        maxPower("abbcccddddeeeeedcba");
        maxPower("triplepillooooow");
        maxPower("hooraaaaaaaaaaay");
        maxPower("tourist");
        maxPower("a");
        maxPower("cc");
    }
    
    
    
    public int maxPower(String i_Str)
    {
        int v_Len      = i_Str.length();
        int v_HalfLen  = (v_Len / 2);
        int v_Count    = 1;
        int v_Char     = i_Str.charAt(0);
        int v_OneChar  = -1;
        int v_MaxCount = 1;                  // 最大连续字符数量
        
        for (int x=1; x<v_Len; x++)
        {
            v_OneChar = i_Str.charAt(x);
            if ( v_Char == v_OneChar )
            {
                v_Count++;
            }
            else
            {
                if ( v_Count > v_MaxCount )
                {
                    v_MaxCount = v_Count;
                    
                    if ( v_MaxCount >= v_HalfLen )
                    {
                        break;
                    }
                }
                
                v_Count = 1;
                v_Char  = v_OneChar;
            }
        }
        
        if ( v_Count > v_MaxCount )
        {
            v_MaxCount = v_Count;
        }
        
        System.out.println(i_Str + "：最大连续出现了 " + v_MaxCount + " 次");
        
        return v_MaxCount;
    }
    
}
