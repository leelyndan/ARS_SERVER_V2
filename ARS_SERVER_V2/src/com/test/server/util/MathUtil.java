package com.test.server.util;

import java.util.regex.Pattern;

public final class MathUtil 
{

	private MathUtil(){};
	
	public static boolean isNumeric(String data) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(data).matches();
	}
	
	public static double maxValue(double num1,double num2,double num3)
	{
		double maxValue=(num1>=num2)?num1:num2;
		maxValue=(maxValue>=num3)?maxValue:num3;
		return maxValue;
	}
}
