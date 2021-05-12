package com.hrmgroup.util;

public class ValidityChecker 
{
	
	
	public static int safeParsing(String number)
	{
		try
		{
			int n = Integer.parseInt(number);
			return n;
		}
		catch(NumberFormatException e)
		{
			
			throw new RuntimeException("The string was not correcty converted to int");
		}
	}

	public static String isNotNull(String text)
	{
		if(text==null || text.equals(""))
			throw new RuntimeException("the string is null or empty");
		return text;
	}
	
}


