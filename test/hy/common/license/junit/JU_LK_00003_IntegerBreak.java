package hy.common.license.junit;

import java.util.ArrayList;
import java.util.List;

import org.hy.common.Date;
import org.hy.common.StringHelp;
import org.junit.Test;

public class JU_LK_00003_IntegerBreak
{
    
    private static int $ForCount = 0;
    
    
    @Test
    public void LK()
    {
        int v_Num = 81;
        List<List<Integer>> v_Ret = new ArrayList<List<Integer>>();
        
        
        
        long v_STime = System.currentTimeMillis();
        
        // v_Ret = this.integerBreak_V1(v_Num ,new ArrayList<Integer>());
        // this.integerBreak_V2(v_Num ,new ArrayList<Integer>() ,v_Ret);
        this.integerBreak_V3(v_Num ,new ArrayList<Integer>() ,0 ,v_Ret);
        
        long v_ETime = System.currentTimeMillis();
        
        
        
        this.showBinaryTree(v_Num ,v_Ret ,v_Ret.size() >= 100 ? v_Ret.size() - 100 : 0);
        System.out.println("计算：" + $ForCount + " 次。用时：" + Date.toTimeLen(v_ETime - v_STime));
    }
    
    
    
    private void showBinaryTree(int i_Num ,List<List<Integer>> i_DataList ,int i_StartIndex)
    {
        int v_Count = i_StartIndex;
        
        for (int i=i_StartIndex; i<i_DataList.size(); i++)
        {
            List<Integer> v_Data = i_DataList.get(i);
            
            StringBuilder v_Buffer = new StringBuilder();
            
            v_Buffer.append(StringHelp.rpad(++v_Count ,16 ," "));
            
            v_Buffer.append(i_Num).append(" = ").append(v_Data.get(0));
            for (int x=1; x<v_Data.size(); x++)
            {
                v_Buffer.append(" + ").append(v_Data.get(x));
            }
            
            System.out.println(v_Buffer.toString());
        }
    }
    
    
    
    public void integerBreak_V3(int i_Num ,List<Integer> io_AddData ,int i_MaxSize ,List<List<Integer>> io_Ret)
    {
        int v_Size = i_Num / 2 + 1; 
        
        for (int x=1; x<v_Size; x++)
        {
            if ( i_MaxSize >= 1 )
            {
                if ( x < io_AddData.get(i_MaxSize - 1) )
                {
                    continue;
                }
            }
            
            $ForCount++;
            
            int v_Next = i_Num - x;
            
            List<Integer> v_Data = new ArrayList<Integer>();
            
            if ( i_MaxSize >= 1 )
            {
                v_Data.addAll(io_AddData.subList(0 ,i_MaxSize));
            }
            v_Data.add(x);
            v_Data.add(v_Next);
            
            
            io_Ret.add(v_Data);
            
            if ( io_AddData.size() > i_MaxSize )
            {
                io_AddData.set(i_MaxSize ,x);
            }
            else
            {
                io_AddData.add(x);
            }
            
            this.integerBreak_V3(v_Next ,io_AddData ,i_MaxSize + 1 ,io_Ret);
        }
    }
    
    
    
    
    
    public void integerBreak_V2(int i_Num ,List<Integer> i_AddData ,List<List<Integer>> io_Ret)
    {
        int v_Size = i_Num / 2 + 1; 
        
        for (int x=1; x<v_Size; x++)
        {
            if ( i_AddData.size() >= 1 )
            {
                if ( x < i_AddData.get(i_AddData.size() - 1) )
                {
                    continue;
                }
            }
            
            $ForCount++;
            
            int v_Next = i_Num - x;
            
            List<Integer> v_Data = new ArrayList<Integer>();
            
            v_Data.addAll(i_AddData);
            v_Data.add(x);
            v_Data.add(v_Next);
            
            io_Ret.add(v_Data);
            
            
            List<Integer> v_NextAdd = new ArrayList<Integer>();
            v_NextAdd.addAll(i_AddData);
            v_NextAdd.add(x);
            
            this.integerBreak_V2(v_Next ,v_NextAdd ,io_Ret);
        }
    }
    
    
    
    public List<List<Integer>> integerBreak_V1(int i_Num ,List<Integer> i_AddData)
    {
        List<List<Integer>> v_Ret  = new ArrayList<List<Integer>>();
        int                 v_Size = i_Num / 2 + 1; 
        
        for (int x=1; x<v_Size; x++)
        {
            if ( i_AddData.size() >= 1 )
            {
                if ( x < i_AddData.get(i_AddData.size() - 1) )
                {
                    continue;
                }
            }
            
            $ForCount++;
            
            int v_Next = i_Num - x;
            
            List<Integer> v_Data = new ArrayList<Integer>();
            
            v_Data.addAll(i_AddData);
            v_Data.add(x);
            v_Data.add(v_Next);
            
            v_Ret.add(v_Data);
            
            
            List<Integer> v_NextAdd = new ArrayList<Integer>();
            v_NextAdd.addAll(i_AddData);
            v_NextAdd.add(x);
            
            v_Ret.addAll(this.integerBreak_V1(v_Next ,v_NextAdd));
        }
        
        return v_Ret;
    }
    
}
