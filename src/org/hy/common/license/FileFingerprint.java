package org.hy.common.license;

import java.io.File;
import java.io.IOException;

import org.hy.common.Help;
import org.hy.common.file.FileHelp;
import org.hy.common.xml.log.Logger;





/**
 * 文件指纹（支持目录及子目录的文件指纹）
 *
 * @author      ZhengWei(HY)
 * @createDate  2021-01-14
 * @version     v1.0
 */
public class FileFingerprint
{
    
    private static final Logger $Logger = Logger.getLogger(FileFingerprint.class);
    
    private FileHelp fileHelp;
    
    private Hash     hash;
    
    
    
    public FileFingerprint()
    {
        this(new Hash(2 ,2 ,null ,false));
    }
    
    
    public FileFingerprint(Hash i_Hash)
    {
        if ( i_Hash == null )
        {
            throw new NullPointerException("Hash is null ,for FileFingerprint.");
        }
        
        this.hash     = i_Hash;
        this.fileHelp = new FileHelp();
    }
    
    
    
    /**
     * 递归的计算目录所有文件及子目录文件的计算文件指纹。
     * 
     * 此方法相对简单，未实现多线程等计算功能。
     * 
     * 适用于递归层级及文件不是十分多的情况。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
     * @version     v1.0
     *
     * @param i_Folder  父目录或文件
     * @return          返回文件指纹。 
     *                     1. 当目录下无任何文件时，指纹为空字符串。
     *                     2. 当文件内容为空时，指纹为空字符串。
     */
    public String calcFingerprint(File i_Folder)
    {
        return this.calcFingerprint(i_Folder ,0);
    }
    
    
    
    /**
     * 递归的计算目录所有文件及子目录文件的计算文件指纹。
     * 
     * 此方法相对简单，未实现多线程等计算功能。
     * 
     * 适用于递归层级及文件不是十分多的情况。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
     * @version     v1.0
     *
     * @param i_Folder  父目录或文件
     * @param i_Level   目录层级。有效下标从0开始
     * @return          返回文件指纹。 
     *                     1. 当目录下无任何文件时，指纹为空字符串。
     *                     2. 当文件内容为空时，指纹为空字符串。
     */
    private String calcFingerprint(File i_Folder ,int i_Level)
    {
        StringBuilder v_Fingerprint = new StringBuilder();
        
        if ( i_Folder == null )
        {
            return "";
        }
        
        if ( !i_Folder.exists() )
        {
            return "";
        }
        
        if ( !i_Folder.isDirectory() )
        {
            if ( !i_Folder.isFile() )
            {
                return "";
            }
            
            String v_Content = "";
            try
            {
                v_Content = this.fileHelp.getContent(i_Folder);
            }
            catch (IOException e)
            {
                v_Content = "";
                $Logger.error(e);
            }
            
            if ( v_Content != null && !"".equals(v_Content) )
            {
                return this.hash.encrypt(v_Content);
            }
            else
            {
                return "";
            }
        }
        
        File [] v_Files = i_Folder.listFiles();
        if ( Help.isNull(v_Files) )
        {
            return "";
        }
        
        for (File v_File : v_Files)
        {
            String v_Content = "";
            
            if ( v_File.isFile() )
            {
                try
                {
                    v_Content = this.fileHelp.getContent(v_File);
                }
                catch (IOException e)
                {
                    v_Content = "";
                    $Logger.error(e);
                }
                
                if ( v_Content != null && !"".equals(v_Content) )
                {
                    v_Content = this.hash.encrypt(v_Content);
                    v_Fingerprint.append(v_Content);
                }
            }
            else if ( v_File.isDirectory() )
            {
                v_Content = this.calcFingerprint(v_File ,i_Level + 1);
                
                if ( v_Content != null && !"".equals(v_Content) )
                {
                    v_Fingerprint.append(v_Content);
                }
            }
        }
        
        
        if ( !Help.isNull(v_Fingerprint.toString()) )
        {
            if ( i_Level == 0 )
            {
                return this.hash.encrypt(v_Fingerprint.toString());
            }
            else
            {
                return v_Fingerprint.toString();
            }
        }
        else
        {
            return "";
        }
    }
    
    
    
    /**
     * 递归的计算目录所有文件及子目录文件的计算文件指纹。
     * 
     * 此方法相对简单，未实现多线程等计算功能。
     * 
     * 适用于递归层级及文件不是十分多的情况。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
     * @version     v1.0
     *
     * @param i_Folder          父目录或文件
     * @param i_ExcludeFiles    排除在外的文件是哪些，格式如："|文件名称|"。为NULL时表示不排除
     * @return                  返回文件指纹。 
     *                             1. 当目录下无任何文件时，指纹为空字符串。
     *                             2. 当文件内容为空时，指纹为空字符串。
     */
    public String calcFingerprint(File i_Folder ,String i_ExcludeFiles)
    {
        return calcFingerprint(i_Folder ,i_ExcludeFiles ,null);
    }
    
    
    
    /**
     * 递归的计算目录所有文件及子目录文件的计算文件指纹。
     * 
     * 此方法相对简单，未实现多线程等计算功能。
     * 
     * 适用于递归层级及文件不是十分多的情况。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
     * @version     v1.0
     *
     * @param i_Folder          父目录或文件
     * @param i_ExcludeFiles    排除在外的文件是哪些，格式如："|文件名称|"。为NULL时表示不排除
     * @param i_ExcludeFolders  排除在外的目录是哪些，格式如："|目录名称|"。为NULL时表示不排除
     * @return                  返回文件指纹。 
     *                             1. 当目录下无任何文件时，指纹为空字符串。
     *                             2. 当文件内容为空时，指纹为空字符串。
     */
    public String calcFingerprint(File i_Folder ,String i_ExcludeFiles ,String i_ExcludeFolders)
    {
        return calcFingerprint(i_Folder ,i_ExcludeFiles ,null ,0);
    }
    
    
    
    /**
     * 递归的计算目录所有文件及子目录文件的计算文件指纹。
     * 
     * 此方法相对简单，未实现多线程等计算功能。
     * 
     * 适用于递归层级及文件不是十分多的情况。
     * 
     * @author      ZhengWei(HY)
     * @createDate  2021-01-14
     * @version     v1.0
     *
     * @param i_Folder          父目录或文件
     * @param i_ExcludeFiles    排除在外的文件是哪些，格式如："|文件名称|"。为NULL时表示不排除
     * @param i_ExcludeFolders  排除在外的目录是哪些，格式如："|目录名称|"。为NULL时表示不排除
     * @param i_Level           目录层级。有效下标从0开始
     * @return                  返回文件指纹。 
     *                             1. 当目录下无任何文件时，指纹为空字符串。
     *                             2. 当文件内容为空时，指纹为空字符串。
     */
    private String calcFingerprint(File i_Folder ,String i_ExcludeFiles ,String i_ExcludeFolders ,int i_Level)
    {
        StringBuilder v_Fingerprint = new StringBuilder();
        
        if ( i_Folder == null )
        {
            return "";
        }
        
        if ( !i_Folder.exists() )
        {
            return "";
        }
        
        String v_ExcludeFiles   = Help.NVL(i_ExcludeFiles)  .toLowerCase();
        String v_ExcludeFolders = Help.NVL(i_ExcludeFolders).toLowerCase();
        
        if ( !i_Folder.isDirectory() )
        {
            if ( !i_Folder.isFile() )
            {
                return "";
            }
            
            if ( !Help.isNull(v_ExcludeFiles) && v_ExcludeFiles.indexOf("|" + i_Folder.getName().toLowerCase() + "|") >= 0 )
            {
                return "";
            }
            
            String v_Content = "";
            try
            {
                v_Content = this.fileHelp.getContent(i_Folder);
            }
            catch (IOException e)
            {
                v_Content = "";
                $Logger.error(e);
            }
            
            if ( v_Content != null && !"".equals(v_Content) )
            {
                return this.hash.encrypt(v_Content);
            }
            else
            {
                return "";
            }
        }
        
        File [] v_Files = i_Folder.listFiles();
        if ( Help.isNull(v_Files) )
        {
            return "";
        }
        
        for (File v_File : v_Files)
        {
            String v_Content = "";
            
            if ( v_File.isFile() )
            {
                if ( !Help.isNull(v_ExcludeFiles) && v_ExcludeFiles.indexOf("|" + v_File.getName().toLowerCase() + "|") >= 0 )
                {
                    continue;
                }
                
                try
                {
                    v_Content = this.fileHelp.getContent(v_File);
                }
                catch (IOException e)
                {
                    v_Content = "";
                    $Logger.error(e);
                }
                
                if ( v_Content != null && !"".equals(v_Content) )
                {
                    v_Content = this.hash.encrypt(v_Content);
                    v_Fingerprint.append(v_Content);
                }
            }
            else if ( v_File.isDirectory() )
            {
                if ( !Help.isNull(v_ExcludeFolders) && v_ExcludeFolders.indexOf("|" + v_File.getName().toLowerCase() + "|") >= 0 )
                {
                    continue;
                }
                
                v_Content = this.calcFingerprint(v_File ,v_ExcludeFiles ,v_ExcludeFolders ,i_Level + 1);
                
                if ( v_Content != null && !"".equals(v_Content) )
                {
                    v_Fingerprint.append(v_Content);
                }
            }
        }
        
        
        if ( !Help.isNull(v_Fingerprint.toString()) )
        {
            if ( i_Level == 0 )
            {
                return this.hash.encrypt(v_Fingerprint.toString());
            }
            else
            {
                return v_Fingerprint.toString();
            }
        }
        else
        {
            return "";
        }
    }
    
}
