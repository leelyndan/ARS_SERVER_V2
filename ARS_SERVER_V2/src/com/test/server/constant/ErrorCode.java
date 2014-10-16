package com.test.server.constant;

public class ErrorCode 
{

	public static final String ERROR_CODE = "Wrong Input. Select Again";
	
	public static final String SAME_CITY_CODE = "Can¡¯t select the same airport as Departure";
	
	public static final String ERROR_DATE = "You have to input date in right format.)";
	
	private static String ERROR_DATE_CODE="You can input date from begindate to enddate";
	
	public static final String NUM_ERROR_CODE = "Wrong Input. Please Input Num Between 0 - 10";
	
	public static final String ERROR_PASSENGER_NUM_CODE = "You have toinput more than 0";
	
	public static final String NOT_ENOUGH_MONEY_EERROR_CODE = "Not enough money";
	
	public static String genratorErrorDateCode(String begindate, String enddate)
	{
		return ERROR_DATE_CODE.replaceAll("begindate", begindate).replaceAll("enddate", enddate);
	}
		
}
