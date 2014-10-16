package com.test.server.util;

public final class StringUtils 
{

	private StringUtils(){}
	
	public static boolean isEmpty(String data)
	{
		if(data==null||"".equals(data))
		{
			return true;
		}
		return false;
	}
	
}
