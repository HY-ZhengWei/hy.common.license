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
        Hash v_Hash_SHA256_3 = new Hash(2 ,3 ,null ,false);
        Hash v_Hash_SHA512_1 = new Hash(2 ,5 ,null ,false);
        
        System.out.println(v_Hash_SHA256_1.encrypt("Hello World!"));
        System.out.println(v_Hash_SHA256_2.encrypt("Hello World!"));
        System.out.println(v_Hash_SHA256_3.encrypt("Hello World!"));
        System.out.println(v_Hash_SHA512_1.encrypt("Hello World!"));
    }
    
    
    
    @Test
    public void test_SMS()
    {
        Hash v_Hash_SHA256_1 = new Hash(2 ,3 ,null ,false);
        
        System.out.println(v_Hash_SHA256_1.encrypt("AccountId=yanfa001&PhoneNos=13699999999&Password=B54B89712EB997BE99114478E3673E3F&Random=6203922&Timestamp=1532928860"));
    }
    
}
