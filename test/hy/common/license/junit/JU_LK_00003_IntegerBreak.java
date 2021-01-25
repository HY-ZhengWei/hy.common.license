package hy.common.license.junit;

import java.util.ArrayList;
import java.util.List;

import org.hy.common.Date;
import org.junit.Test;

public class JU_LK_00003_IntegerBreak
{
    
    @Test
    public void LK()
    {
        int v_Num = 6;
        
        
        List<List<Integer>> v_Ret = new ArrayList<List<Integer>>();
        
        
        v_Ret = this.integerBreak(v_Num);
        
        this.showBinaryTree(v_Num ,v_Ret);
    }
    
    
    
    private void showBinaryTree(int i_Num ,List<List<Integer>> i_DataList)
    {
        for (List<Integer> v_Data : i_DataList)
        {
            StringBuilder v_Buffer = new StringBuilder();
            
            v_Buffer.append(i_Num).append(" = ").append(v_Data.get(0));
            for (int x=1; x<v_Data.size(); x++)
            {
                v_Buffer.append(" + ").append(v_Data.get(x));
            }
            
            System.out.println(v_Buffer.toString());
        }
    }

    
    
    
    public List<List<Integer>> integerBreak(int i_Num)
    {
        List<List<Integer>> v_Ret = new ArrayList<List<Integer>>();
        
        for (int x=1; x<Math.ceil(i_Num / 2.0); x++)
        {
            List<List<Integer>> v_Data = new ArrayList<List<Integer>>();
            
            List<Integer> v_One = new ArrayList<Integer>();
            int v_Next = i_Num - x;
            
            v_One.add(x);
            v_One.add(v_Next);
            
            v_Data.add(v_One);
            
            if ( v_Next > 2 )
            {
                v_Data.addAll(integerBreak(v_Next ,1));
            }
            
            v_Ret.add(v_One);
            
            List<Integer> v_AddData = new ArrayList<Integer>();
            for (int y=1; y<v_Data.size(); y++)
            {
                if ( v_Data.get(y).get(0).intValue() > v_Data.get(y - 1).get(0).intValue() )
                {
                    v_AddData.remove(v_AddData.size() - 1);
                }
                else
                {
                    v_AddData.add(v_Data.get(y - 1).get(0));
                }
                
                v_Data.get(y).addAll(v_AddData);
                v_Ret.add(v_Data.get(y));
            }
        }
        
        return v_Ret;
    }
    
    
    
    
    public List<List<Integer>> integerBreak(int i_Num ,int i_Level)
    {
        List<List<Integer>> v_Data = new ArrayList<List<Integer>>();
        
        for (int x=1; x<i_Num; x++)
        {
            int v_Next = i_Num - x;
            
            if ( v_Next == 1 )
            {
                continue;
            }
            
            List<Integer> v_One = new ArrayList<Integer>();
            
            v_One.add(x);
            v_One.add(v_Next);
            
            v_Data.add(v_One);
            if ( v_Next > 2 )
            {
                v_Data.addAll(integerBreak(v_Next ,i_Level + 1));
            }
        }
        
        return v_Data;
    }
    
}
