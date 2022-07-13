package com.first.frame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		try {
			d = format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

}
