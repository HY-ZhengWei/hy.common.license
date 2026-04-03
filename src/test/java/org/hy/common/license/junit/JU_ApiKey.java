package org.hy.common.license.junit;

import org.hy.common.license.ApiKey;
import org.junit.Test;





/**
 * 测试单元：LLM接口访问的Api Key
 *
 * @author      ZhengWei(HY)
 * @createDate  2026-04-03
 * @version     v1.0
 */
public class JU_ApiKey
{
    
    @Test
    public void test()
    {
        ApiKey v_ApiKey = ApiKey.make();
        System.out.println(" Api Key：" + v_ApiKey.getKey());
        System.out.println(" Api Key：" + v_ApiKey.getKey());
        System.out.println("Key Name：" + v_ApiKey.getKeyName());
        System.out.println("   Token：" + v_ApiKey.getToken());
    }
    
}
