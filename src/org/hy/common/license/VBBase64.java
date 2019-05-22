package org.hy.common.license;

import java.util.Arrays;





/**
 * VB Base64 加解密
 *
 * @author      ZhengWei(HY)
 * @createDate  2019-05-21
 * @version     v1.0
 */
public class VBBase64
{
    
    private static final byte [] $IP = { 57 ,49 ,41 ,33 ,25 ,17 ,9  ,1  ,59 ,51
                                        ,43 ,35 ,27 ,19 ,11 ,3  ,61 ,53 ,45 ,37 
                                        ,29 ,21 ,13 ,5  ,63 ,55 ,47 ,39 ,31 ,23 
                                        ,15 ,7  ,56 ,48 ,40 ,32 ,24 ,16 ,8  ,0  
                                        ,58 ,50 ,42 ,34 ,26 ,18 ,10 ,2  ,60 ,52 
                                        ,44 ,36 ,28 ,20 ,12 ,4  ,62 ,54 ,46 ,38 
                                        ,30 ,22 ,14 ,6 };
 
    private static final byte [] $IP_1 = {39 ,7  ,47 ,15 ,55 ,23 ,63 ,31 ,38 ,6 
                                         ,46 ,14 ,54 ,22 ,62 ,30 ,37 ,5  ,45 ,13
                                         ,53 ,21 ,61 ,29 ,36 ,4  ,44 ,12 ,52 ,20
                                         ,60 ,28 ,35 ,3  ,43 ,11 ,51 ,19 ,59 ,27
                                         ,34 ,2  ,42 ,10 ,50 ,18 ,58 ,26 ,33 ,1 
                                         ,41 ,9  ,49 ,17 ,57 ,25 ,32 ,0  ,40 ,8 
                                         ,48 ,16 ,56 ,24 };
    
    private static final byte [] $P = {15 ,6  ,19 ,20 ,28 ,11 ,27 ,16 ,0  ,14
                                      ,22 ,25 ,4  ,17 ,30 ,9  ,1  ,7  ,23 ,13
                                      ,31 ,26 ,2  ,8  ,18 ,12 ,29 ,5  ,21 ,10
                                      ,3  ,24 };
            
    private static final byte [] $PC_1 = {56 ,48 ,40 ,32 ,24 ,16 ,8  ,0  ,57 ,49
                                         ,41 ,33 ,25 ,17 ,9  ,1  ,58 ,50 ,42 ,34
                                         ,26 ,18 ,10 ,2  ,59 ,51 ,43 ,35 ,62 ,54
                                         ,46 ,38 ,30 ,22 ,14 ,6  ,61 ,53 ,45 ,37
                                         ,29 ,21 ,13 ,5  ,60 ,52 ,44 ,36 ,28 ,20
                                         ,12 ,4  ,27 ,19 ,11 ,3 };
    
    private static final byte [] $PC_2 = {13 ,16 ,10 ,23 ,0  ,4  ,2  ,27 ,14 ,5
                                         ,20 ,9  ,22 ,18 ,11 ,3  ,25 ,7  ,15 ,6
                                         ,26 ,19 ,12 ,1  ,40 ,51 ,30 ,36 ,46 ,54
                                         ,29 ,39 ,50 ,44 ,32 ,47 ,43 ,48 ,38 ,55
                                         ,33 ,52 ,45 ,41 ,49 ,35 ,28 ,31 };
    
    private static final byte [] $Lsi = {0, 1 ,1 ,2 ,2 ,2 ,2 ,2 ,2 ,1 
                                        ,2 ,2 ,2 ,2 ,2 ,2 ,1 };
    
    private static final byte [][] $S1 = {{14 ,4  ,13 ,1 ,2  ,15 ,11 ,8  ,3  ,10 ,6  ,12 ,5  ,9  ,0 ,7}
                                         ,{0  ,15 ,7  ,4 ,14 ,2  ,13 ,1  ,10 ,6  ,12 ,11 ,9  ,5  ,3 ,8}
                                         ,{4  ,1  ,14 ,8 ,13 ,6  ,2  ,11 ,15 ,12 ,9  ,7  ,3  ,10 ,5 ,0}
                                         ,{15 ,12 ,8  ,2 ,4  ,9  ,1  ,7  ,5  ,11 ,3  ,14 ,10 ,0  ,6 ,13}};
    
    private static final byte [][] $S2 = {{15 ,1  ,8  ,14 ,6  ,11 ,3  ,4  ,9  ,7 ,2  ,13 ,12 ,0 ,5  ,10}
                                         ,{3  ,13 ,4  ,7  ,15 ,2  ,8  ,14 ,12 ,0 ,1  ,10 ,6  ,9 ,11 ,5}
                                         ,{0  ,14 ,7  ,11 ,10 ,4  ,13 ,1  ,5  ,8 ,12 ,6  ,9  ,3 ,2  ,15}
                                         ,{13 ,8  ,10 ,1  ,3  ,15 ,4  ,2  ,11 ,6 ,7  ,12 ,0  ,5 ,14 ,9}};
    
    private static final byte [][] $S3 = {{10 ,0  ,9  ,14 ,6 ,3  ,15 ,5  ,1  ,13 ,12 ,7  ,11 ,4  ,2  ,8}
                                         ,{13 ,7  ,0  ,9  ,3 ,4  ,6  ,10 ,2  ,8  ,5  ,14 ,12 ,11 ,15 ,1}
                                         ,{13 ,6  ,4  ,9  ,8 ,15 ,3  ,0  ,11 ,1  ,2  ,12 ,5  ,10 ,14 ,7}
                                         ,{1  ,10 ,13 ,0  ,6 ,9  ,8  ,7  ,4  ,15 ,14 ,3  ,11 ,5  ,2  ,12}};
    
    private static final byte [][] $S4 = {{7  ,13 ,14 ,3 ,0  ,6  ,9  ,10 ,1  ,2 ,8 ,5  ,11 ,12 ,4  ,15}
                                         ,{13 ,8  ,11 ,5 ,6  ,15 ,0  ,3  ,4  ,7 ,2 ,12 ,1  ,10 ,14 ,9}
                                         ,{10 ,6  ,9  ,0 ,12 ,11 ,7  ,13 ,15 ,1 ,3 ,14 ,5  ,2  ,8  ,4}
                                         ,{3  ,15 ,0  ,6 ,10 ,1  ,13 ,8  ,9  ,4 ,5 ,11 ,12 ,7  ,2  ,14}};
    
    private static final byte [][] $S5 = {{2  ,12 ,4  ,1  ,7  ,10 ,11 ,6  ,8  ,5  ,3  ,15 ,13 ,0 ,14 ,9}
                                         ,{14 ,11 ,2  ,12 ,4  ,7  ,13 ,1  ,5  ,0  ,15 ,10 ,3  ,9 ,8  ,6}
                                         ,{4  ,2  ,1  ,11 ,10 ,13 ,7  ,8  ,15 ,9  ,12 ,5  ,6  ,3 ,0  ,14}
                                         ,{11 ,8  ,12 ,7  ,1  ,14 ,2  ,13 ,6  ,15 ,0  ,9  ,10 ,4 ,5  ,3}};
    
    private static final byte [][] $S6 = {{12 ,1  ,10 ,15 ,9 ,2  ,6  ,8  ,0  ,13 ,3  ,4  ,14 ,7  ,5  ,11}
                                         ,{10 ,15 ,4  ,2  ,7 ,12 ,9  ,5  ,6  ,1  ,13 ,14 ,0  ,11 ,3  ,8}
                                         ,{9  ,14 ,15 ,5  ,2 ,8  ,12 ,3  ,7  ,0  ,4  ,10 ,1  ,13 ,11 ,6}
                                         ,{4  ,3  ,2  ,12 ,9 ,5  ,15 ,10 ,11 ,14 ,1  ,7  ,6  ,0  ,8  ,13}};
    
    private static final byte [][] $S7 = {{4  ,11 ,2  ,14 ,15 ,0 ,8  ,13 ,3  ,12 ,9 ,7  ,5  ,10 ,6 ,1}
                                         ,{13 ,0  ,11 ,7  ,4  ,9 ,1  ,10 ,14 ,3  ,5 ,12 ,2  ,15 ,8 ,6}
                                         ,{1  ,4  ,11 ,13 ,12 ,3 ,7  ,14 ,10 ,15 ,6 ,8  ,0  ,5  ,9 ,2}
                                         ,{6  ,11 ,13 ,8  ,1  ,4 ,10 ,7  ,9  ,5  ,0 ,15 ,14 ,2  ,3 ,12}};
    
    private static final byte [][] $S8 = {{13 ,2  ,8  ,4 ,6  ,15 ,11 ,1 ,10 ,9  ,3  ,14 ,5  ,0  ,12 ,7}
                                         ,{1  ,15 ,13 ,8 ,10 ,3  ,7  ,4 ,12 ,5  ,6  ,11 ,0  ,14 ,9  ,2}
                                         ,{7  ,11 ,4  ,1 ,9  ,12 ,14 ,2 ,0  ,6  ,10 ,13 ,15 ,3  ,5  ,8}
                                         ,{2  ,1  ,14 ,7 ,4  ,10 ,8 ,13 ,15 ,12 ,9  ,0  ,3  ,5  ,6  ,11}};
    
    private static final byte [][][] $SS = {$S1 ,$S2 ,$S3 ,$S4 ,$S5 ,$S6 ,$S7 ,$S8};
    
    private static final int  [] $BinKeyCalc = {8*16 ,4*16 ,2*16 ,1*16 ,8 ,4 ,2 ,1};
    
    private static final byte [] $E = new byte[48];
    
    
    
    static 
    {
        $E[0] = 31;
        
        for (int x=1 ,y=1 ,i=1; x<=8; x++ ,y+=2)
        {
            int v_Count = x * 6;
            for (; i<v_Count; i++)
            {
                $E[i] = (byte)(i - y);
            }
        }
        
        $E[47] = 30;
    }
    
    
    
    /**
     * 解密
     * 
     * @author      ZhengWei(HY)
     * @createDate  2019-05-21
     * @version     v1.0
     *
     * @param i_Password  密文
     * @param i_Key       密钥
     * @return
     */
    public static String decode(String i_Password ,String i_Key)
    {
        String [] v_PwdArr       = StrConv.sFromBase64(i_Password).split(",");
        byte   [] v_KeyBytes     = StrConv.vbFromUnicode(i_Key);
        int    [] v_PwdCode      = new int[(int)(Math.ceil(v_PwdArr.length / 8) * 8)];   // 为8的倍数
        int    [] v_TempCode     = new int[8];
        byte   [] v_BinCode      = new byte[64];                                         // 存放64位的明文
        byte   [] v_CodeIP       = new byte[64];                                         // 存放IP置换结果
        byte   [] v_CodeE        = new byte[48];                                         // E膨胀结果
        byte   [] v_CodeP        = new byte[32];                                         // P变换结果
        byte [][] v_CodeS        = new byte[8][6];
        byte   [] v_S            = new byte[8];                                          // S盒运算8个结果
        byte   [] v_RetS         = new byte[48];                                         // S盒运算32位结果
        byte   [] v_BinKey       = new byte[64];                                         // 64位二进行制原始密钥
        byte   [] v_KeyPC_1      = new byte[56];
        byte   [] v_C0           = new byte[28];
        byte   [] v_Cx           = new byte[28];
        byte   [] v_Cy           = new byte[28];
        byte   [] v_D0           = new byte[28];
        byte   [] v_Dx           = new byte[28];
        byte   [] v_Dy           = new byte[28];
        byte [][] v_K            = new byte[16][48];
        byte   [] v_R0           = new byte[32];
        byte   [] v_Rx           = new byte[32];
        byte   [] v_Ry           = new byte[32];
        byte   [] v_L0           = new byte[32];
        byte   [] v_Lx           = new byte[32];
        byte   [] v_Ly           = new byte[32];
        int    [] v_RetTemp      = new int[8];                                           // 存放8位密文
        int    [] v_Ret          = new int[v_PwdCode.length];
        
        
        // 因Java中的byte是带符号，与VB的不一样，所以用int类型保存密码的byte[]数组
        for (int i=0; i<v_PwdArr.length; i++)
        {
            v_PwdCode[i] = Integer.parseInt(v_PwdArr[i]);
        }
        
        for (int i=0; i<8 && i <v_KeyBytes.length; i++)
        {
            for (int x=0; x<=7; x++)
            {
                v_BinKey[i * 8 + x] = (byte)Math.floor((v_KeyBytes[i] & $BinKeyCalc[x]) / $BinKeyCalc[x]);
            }
        }
        
        // PC_1转换
        for (int i=0; i<56; i++)
        {
            v_KeyPC_1[i] = v_BinKey[$PC_1[i]];
        }
        
        // 生成C0、D0
        for (int i=0; i<28; i++)
        {
            v_C0[i] = v_KeyPC_1[i];
            v_D0[i] = v_KeyPC_1[i + 28];
        }
        
        
        // 生成K
        v_Cx = Arrays.copyOf(v_C0 ,v_C0.length);
        v_Dx = Arrays.copyOf(v_D0 ,v_D0.length);
        for (int i=0; i<16; i++)
        {
            makeCD(v_Cx ,v_Dx ,v_Cy ,v_Dy ,i + 1);
            makeK(v_Cy ,v_Dy ,v_K[i]);
            
            v_Cx = Arrays.copyOf(v_Cy ,v_Cy.length);
            v_Dx = Arrays.copyOf(v_Dy ,v_Dy.length);
        }
        
        
        for (int j=0; j<v_PwdCode.length; j+=8)
        {
            v_TempCode = Arrays.copyOfRange(v_PwdCode ,j ,j + 8);
            
            for (int i=0; i<8; i++)
            {
                for (int x=0; x<8; x++)
                {
                    v_BinCode[i * 8 + x] = (byte)Math.floor((v_TempCode[i] & $BinKeyCalc[x]) / $BinKeyCalc[x]);
                }
            }
            
            // IP置换
            for (int i=0; i<64; i++)
            {
                v_CodeIP[i] = v_BinCode[$IP[i]];
            }
            
            // 分段
            for (int i=0; i<32; i++)
            {
                v_R0[i] = v_CodeIP[i];
                v_L0[i] = v_CodeIP[i + 32];
            }
            
            // 进行16次迭代
            v_Rx = Arrays.copyOf(v_R0 ,v_R0.length);
            v_Lx = Arrays.copyOf(v_L0 ,v_L0.length);
            for (int z=0; z<16; z++)
            {
                for (int i=0; i<48; i++)
                {
                    v_CodeE[i] = v_Rx[$E[i]];                            // 经过E变换扩充，由32位变为48位
                    v_CodeE[i] = (byte) (v_CodeE[i] ^ v_K[15 - z][i]);   // 与K按位作不进位加法运算
                }
                
                // 分8组
                for (int i=0; i<6; i++)
                {
                    for (int x=0; x<8; x++)
                    {
                        v_CodeS[x][i] = v_CodeE[i + x * 6];
                    }
                }
                
                // S盒运算，得到8个数
                // S盒运算32位结果
                for (int i=0; i<8; i++)
                {
                    v_S[i] = $SS[i] [v_CodeS[i][5] + v_CodeS[i][0] * 2] [v_CodeS[i][4] + v_CodeS[i][3] * 2 + v_CodeS[i][2] * 4 + v_CodeS[i][1] * 8];
                    
                    for (int x=0; x<4; x++)
                    {
                        v_RetS[i * 4 + x] = (byte)Math.floor((v_S[i] & $BinKeyCalc[x + 4]) / $BinKeyCalc[x + 4]);
                    }
                }
                
                // P变换，产生Ly、Ry
                for (int i=0; i<32; i++)
                {
                    v_CodeP[i] = v_RetS[$P[i]];
                    
                    v_Ry[i] = (byte) (v_Lx[i] ^ v_CodeP[i]);
                    v_Ly[i] = v_Rx[i];
                }
                
                v_Rx = Arrays.copyOf(v_Ry ,v_Ry.length);
                v_Lx = Arrays.copyOf(v_Ly ,v_Ly.length);
            }
            
            for (int i=0; i<32; i++)
            {
                v_BinCode[i]      = v_Ry[i];
                v_BinCode[i + 32] = v_Ly[i];
            }
            
            for (int i=0; i<64; i++)
            {
                v_CodeIP[i] = v_BinCode[$IP_1[i]];
            }
            
            for (int i=0; i<8; i++)
            {
                v_RetTemp[i] = 0;
                
                for (int x=0; x<8; x++)
                {
                    v_RetTemp[i] =v_RetTemp[i] + v_CodeIP[i * 8 + x] * $BinKeyCalc[x];
                }
                
                v_Ret[j + i] = v_RetTemp[i];
            }
        }
        
        return StrConv.vbUnicode(v_Ret).replaceAll((char)0 + "" ,"");
    }
    
    
    
    /**
     * 通过x系列的C、D，生成y系列的C、D
     * 
     * @author      ZhengWei(HY)
     * @createDate  2019-05-22
     * @version     v1.0
     *
     * @param i_Cx
     * @param i_Dx
     * @param io_Cy
     * @param io_Dy
     * @param i_Index
     */
    private static void makeCD(byte [] i_Cx ,byte [] i_Dx ,byte [] io_Cy ,byte [] io_Dy ,int i_Index)
    {
        int v_Lsi = $Lsi[i_Index];
        
        if ( v_Lsi == 1 )
        {
            for (int i=0; i<=26; i++) 
            {
                io_Cy[i] = i_Cx[i + v_Lsi];
                io_Dy[i] = i_Dx[i + v_Lsi];
            }
            io_Cy[27] = i_Cx[0];
            io_Dy[27] = i_Dx[0];
        }
        else if ( v_Lsi == 2 )
        {
            for (int i=0; i<=25; i++) 
            {
                io_Cy[i] = i_Cx[i + v_Lsi];
                io_Dy[i] = i_Dx[i + v_Lsi];
            }
            io_Cy[26] = i_Cx[0];
            io_Dy[26] = i_Dx[0];
            io_Cy[27] = i_Cx[1];
            io_Dy[27] = i_Dx[1];
        }
    }
    
    
    
    /**
     * 通过C、D组合生成K
     * 
     * @author      ZhengWei(HY)
     * @createDate  2019-05-22
     * @version     v1.0
     *
     * @param i_C   
     * @param i_D
     * @param io_K
     */
    private static void makeK(byte [] i_C ,byte [] i_D ,byte [] io_K)
    {
        byte [] v_C_D = new byte[56];
        
        // 组合C、D，并生成C_D
        for (int i=0; i<=27; i++)
        {
            v_C_D[i]      = i_C[i];
            v_C_D[i + 28] = i_D[i];
        }
        
        // PC_2转换，生成K
        for (int i=0; i<=47; i++)
        {
            io_K[i] = v_C_D[$PC_2[i]];
        }
    }
    
}
