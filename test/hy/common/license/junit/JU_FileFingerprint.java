package hy.common.license.junit;

import java.io.File;

import org.hy.common.Date;
import org.hy.common.license.FileFingerprint;
import org.hy.common.license.Hash;
import org.junit.Test;





/**
 * 测试单元：文件指纹
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-14
 * @version     v1.0
 */
public class JU_FileFingerprint
{
    
    @Test
    public void test()
    {
        Hash v_Hash_MD5    = new Hash(1 ,1 ,null ,false);
        Hash v_Hash_SHA256 = new Hash(2 ,2 ,null ,false);
        
        System.out.println("\n\n-----MD5-----");
        this.test(v_Hash_MD5);
        
        System.out.println("\n\n-----SHA256-----");
        this.test(v_Hash_SHA256);
    }
    
    
    
    public void test(Hash i_Hash)
    {
        FileFingerprint v_FFingerprint = new FileFingerprint(i_Hash);
        
        long v_BTime = Date.getNowTime().getTime();
        System.out.println("文件的指纹：" + v_FFingerprint.calcFingerprint(new File("D:\\WorkSpace_SearchDesktop\\hy.common.license\\hy.common.license.jar")));
        long v_ETime = Date.getNowTime().getTime();
        System.out.println("用时：" + Date.toTimeLen(v_ETime - v_BTime));
        
        
        v_BTime = Date.getNowTime().getTime();
        System.out.println("目录的指纹：" + v_FFingerprint.calcFingerprint(new File("D:\\WorkSpace_SearchDesktop\\hy.common.license")));
        v_ETime = Date.getNowTime().getTime();
        System.out.println("用时：" + Date.toTimeLen(v_ETime - v_BTime));
    }
    
}
