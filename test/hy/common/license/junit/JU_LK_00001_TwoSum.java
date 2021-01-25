package hy.common.license.junit;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;




/**
 * 测试单元：两数之和
 * 
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案
 * 
 * 
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 
 * 
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 
 * 
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * @author      ZhengWei(HY)
 * @createDate  2020-12-24
 * @version     v1.0
 */
public class JU_LK_00001_TwoSum
{
    
    @Test
    public void LK()
    {
        System.out.println(twoSum(new int[]{2,7,11,15} ,9));
    }
    
    
    
    public int[] twoSum(int[] nums, int target) 
    {

        if ( nums == null || nums.length < 2 )
        {
            return null;
        }

        Map<Integer ,Integer> v_Datas = new HashMap<Integer ,Integer>();

        for (int x=0; x<nums.length; x++)
        {
            int     v_Diff  = target - nums[x];
            Integer v_Index = v_Datas.get(v_Diff);

            if ( v_Index == null )
            {
                v_Datas.put(nums[x] ,x);
            }
            else
            {
                return new int[] {v_Index ,x};
            }
        }

        return null;
    }
    
}
