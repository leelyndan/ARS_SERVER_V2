package com.test.server.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class CommonUI 
{
	  protected PrintWriter os = null;
	
	  protected BufferedReader is = null;
	
	  public CommonUI(PrintWriter os,BufferedReader is)
	  {
		  	this.os = os;
			this.is=is;
	  }
	  
	  public  String execute()
	  {
		  	String showView = this.generatorView();
			String messageToClient = showView.replaceAll("\n", "NL");
			os.println(messageToClient);
			os.flush();
			String message="";
			try 
			{
				message=is.readLine();
				while(!paramCheck(message))
				{
					message= is.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return message;
	  }

	  abstract String generatorView();

	  abstract StringBuilder generatorData();

	  abstract boolean paramCheck(String message);

}
