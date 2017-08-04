package xmu.mystore.goodsmgt.cwh.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConvertor {
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public static Calendar StringToCalendar(String str){ //String转为Calendar
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(str));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return c;
	}
	
	public static String DateToString(Date date){ //Date转为String
		return sdf.format(date);
	}
}
