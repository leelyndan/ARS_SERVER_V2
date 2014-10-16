package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
//****************************************
//
//Depart Date
//
//****************************************
//
//Please, Input depart date. (YYYY-MM-DD)
//
// 
//
//P. Previous Menu
//
//Q. Quit
//
//****************************************
//
//Input : 2014-12-24
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.test.server.constant.ErrorCode;
import com.test.server.util.DateUtil;

public class DepartDate extends CommonUI{
	
	
	public static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public DepartDate(PrintWriter os, BufferedReader is) {
		super(os, is);
	}
	
	@Override
	 String generatorView()
	{
		StringBuilder show=new StringBuilder("****************************************");
		show.append("\n");
		show.append("Depart Date");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append("Please, Input depart date. (YYYY-MM-DD)");
		show.append("\n");
		show.append("P. Previous Menu");
		show.append("\n");
		show.append("Q. Quit");
		show.append("\n");
		show.append("****************************************");
		return show.toString();
	}
	
	@Override
    boolean paramCheck(String message) {
		if (message == null || "".equals(message)) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if("p".equalsIgnoreCase(message)||"q".equalsIgnoreCase((message)))
		{
			return true;
		}
		Date date;
		try {
			date = (Date)formatter.parse(message);
			if(!message.equals(formatter.format(date)))
			{
				os.println(ErrorCode.ERROR_DATE);
				os.flush();
				return false;
			}
			String tomorrow=DateUtil.nextNumDate(1,formatter);
			String nextYearToday=DateUtil.nextNumDate(365,formatter);
			if(message.compareTo(tomorrow)<0||message.compareTo(nextYearToday)>0)
			{
				os.println(ErrorCode.genratorErrorDateCode(tomorrow, nextYearToday));
				os.flush();
				return false;
			}
		} catch (ParseException e) {
			os.println(ErrorCode.ERROR_DATE);
			os.flush();
			return false;
		}
		return true;
	}
	
	@Override
	StringBuilder generatorData() {
		return null;
	}
	
}
