package hy.common.license.junit;

import org.hy.common.license.Hash;
import org.junit.Test;





/**
 * 测试单元：SHA256
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-14
 * @version     v1.0
 */
public class JU_SHA256
{
    
    @Test
    public void test_SHA256()
    {
        Hash v_Hash_SHA256_1 = new Hash(2 ,2 ,null ,true);
        Hash v_Hash_SHA256_2 = new Hash(2 ,2 ,null ,false);
        Hash v_Hash_SHA512_2 = new Hash(2 ,3 ,null ,false);
        
        System.out.println(v_Hash_SHA256_1.encrypt("Hello World!"));
        System.out.println(v_Hash_SHA256_2.encrypt("Hello World!"));
        System.out.println(v_Hash_SHA512_2.encrypt("Hello World!"));
    }
    
}
