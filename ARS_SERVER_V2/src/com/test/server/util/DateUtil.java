package com.test.server.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateUtil 
{

	private DateUtil(){}
	
	public  static String nextNumDate(int num,DateFormat formatter)
	{
		 Date date=new Date();
		 Calendar calendar = new GregorianCalendar();
		 calendar.setTime(date);
		 calendar.add(Calendar.DATE,num);
		 date=calendar.getTime(); 
		 String dateString = formatter.format(date);
		 return dateString;
	}
}
