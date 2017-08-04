package xmu.mystore.logmgt.xlx.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransTime {
	public static long getTime(String user_time)
	{
		long l=0; 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date d;  
		try {    
		d = sdf.parse(user_time);  
		l = d.getTime();  
		} catch (ParseException e) {  
		// TODO Auto-generated catch block  
		e.printStackTrace();  
		}  
		return l;  
	}

}
