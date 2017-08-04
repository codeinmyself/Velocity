package xmu.mystore.goodsmgt.cwh.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<Date, String> {

	@Override
	public String convert(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
        return sdf.format(date);
	}

}
