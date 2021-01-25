package hy.common.license.junit;

import org.junit.Test;





/**
 * 测试单元：有效的括号 
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-22
 * @version     v1.0
 */
public class JU_LK_00002_Brackets
{
    
    @Test
    public void LK()
    {
        System.out.println(isValid_V2("(1+2)*5"));
    }
    
    
    
    public boolean isValid_V2(String s) 
    {
        // ZhengWei(HY) Add 2021-01-22
        int v_Len = s.length();
        if ( v_Len < 2)
        {
            return false;
        }
        
        int[] v_Datas = new int[v_Len];
        int   v_Size  = -1;
        char  v_One   = 0;
        
        for (int i=0; i<v_Len; i++)
        {
            v_One = s.charAt(i);
            if ( v_One == '(' )
            {
                v_Datas[++v_Size] = 1;
            }
            else if ( v_One == '[' )
            {
                v_Datas[++v_Size] = 2;
            }
            else if ( v_One == '{' )
            {
                v_Datas[++v_Size] = 3;
            }
            else if ( v_One == ')' )
            {
                if ( v_Size >= 0 && v_Datas[v_Size] == 1 )
                {
                    --v_Size;
                }
                else
                {
                    return false;
                }
            }
            else if ( v_One == ']' )
            {
                if ( v_Size >= 0 && v_Datas[v_Size] == 2 )
                {
                    --v_Size;
                }
                else
                {
                    return false;
                }
            }
            else if ( v_One == '}' )
            {
                if ( v_Size >= 0 && v_Datas[v_Size] == 3 )
                {
                    --v_Size;
                }
                else
                {
                    return false;
                }
            }
        }

        return v_Size == -1;
    }
    
    
    
    public boolean isValid_V1(String s) 
    {
        // ZhengWei(HY) Add 2020-01-21
        int[] v_Datas = new int[s.length()];
        int   v_Last  = 0;
        int   v_Size  = -1;
        char  v_One   = 0;
        
        for (int i=0; i<s.length(); i++)
        {
            v_One = s.charAt(i);
            if ( v_One == '(' )
            {
                v_Datas[++v_Size] = 1;
                v_Last = 1;
            }
            else if ( v_One == '[' )
            {
                v_Datas[++v_Size] = 2;
                v_Last = 2;
            }
            else if ( v_One == '{' )
            {
                v_Datas[++v_Size] = 3;
                v_Last = 3;
            }
            else if ( v_One == ')' )
            {
                if ( v_Last == 1 )
                {
                    if ( --v_Size >= 0 )
                    {
                        v_Last = v_Datas[v_Size];
                    }
                    else
                    {
                        v_Last = 0;
                    }
                }
                else
                {
                    return false;
                }
            }
            else if ( v_One == ']' )
            {
                if ( v_Last == 2 )
                {
                    if ( --v_Size >= 0 )
                    {
                        v_Last = v_Datas[v_Size];
                    }
                    else
                    {
                        v_Last = 0;
                    }
                }
                else
                {
                    return false;
                }
            }
            else if ( v_One == '}' )
            {
                if ( v_Last == 3 )
                {
                    if ( --v_Size >= 0 )
                    {
                        v_Last = v_Datas[v_Size];
                    }
                    else
                    {
                        v_Last = 0;
                    }
                }
                else
                {
                    return false;
                }
            }
        }

        return v_Last == 0;
    }
    
}
