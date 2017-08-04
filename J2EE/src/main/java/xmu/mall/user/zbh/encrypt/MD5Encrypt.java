package xmu.mall.user.zbh.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5Encrypt 
{
	private static final int LONGTH_OF_MD5_STRING=32;
	
	public static String getEncryptionString(String string) throws Exception
	{
		MessageDigest md5=MessageDigest.getInstance("MD5");
		 // 计算md5函数
        md5.update(string.getBytes());
        
        // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        String newEncrytionString=new BigInteger(1,md5.digest()).toString(16);
       
        
        //如果位数不足，补充前导零
        if(newEncrytionString.length()<LONGTH_OF_MD5_STRING)
        	return String.format("%0" + (LONGTH_OF_MD5_STRING-newEncrytionString.length()) + "d%s", 0,newEncrytionString);
        else
        	return newEncrytionString;
	}
}