
package com.test.server.business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.test.server.util.DateUtil;
import com.test.server.util.MathUtil;

public class PayManager 
{
	
	public static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public static double payExecute(String departDate,int adultNum,String departTime,int allPay)
	{
		return MathUtil.maxValue(dateAllowance( departDate, allPay), adultNumAllowance(adultNum,allPay), timeAllowance(departTime, allPay));
	} 
	
	private static double dateAllowance(String departDate,int allPay)
	{
		double allowance=0;
		String today=DateUtil.nextNumDate(0, formatter);
		int todayMonth=Integer.valueOf(today.substring(5,7));
		int todayDay=Integer.valueOf(today.substring(8,10));
		int todayYear=Integer.valueOf(today.substring(0,4));
		int beginMonth =Integer.valueOf(departDate.substring(5,7));
		int beginday =Integer.valueOf(departDate.substring(8,10));
		int beginYear=Integer.valueOf(today.substring(0,4));
		
		//�ǿ������ 
		if(beginYear == todayYear)
		{
			if(beginMonth-todayMonth>=6&&beginday>todayDay)
			{
				allowance=allPay*0.15;
			}
		}else
		{
			
		}
		return  allowance;
	}
	
	private static double adultNumAllowance(int adultNum,int allPay)
	{
		double allowance=0;
		if(adultNum>4)
		{
			allowance=allPay*0.1;
		}
		return allowance;
	}
	
	private static double timeAllowance(String departTime,int allPay)
	{
		double allowance=0;
		if(departTime.compareTo("12:00")<=0)
		{
			allowance=allPay*0.5;
		}
		return allowance;
	}
	
	public static void main(String[] args) {
		System.out.println("2014-09-10".substring(0,4));
		System.out.println("2014-09-10".substring(8,10));
	}
}
