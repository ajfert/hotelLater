package com.bdqn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoDate {
	//字符串转Date
	public static Date strtodate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(str);
			
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	//Date转字符串
	public static String datetostr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(date!=null) {
			return sdf.format(date);
		}
		return null;
		
	}
}
