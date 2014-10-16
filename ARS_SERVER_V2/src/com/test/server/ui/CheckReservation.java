package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.test.server.bean.Plane;
import com.test.server.constant.ErrorCode;
import com.test.server.store.ReservationStoreQueue;

public class CheckReservation extends CommonUI{

	public CheckReservation(PrintWriter os,BufferedReader is) 
	{
		super(os, is);
	}
	
	@Override
	 String generatorView()
	{
		StringBuilder show=new StringBuilder("****************************************");
		show.append("\n");
		show.append("Check Reservation");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append("Pease, Input reservation number.");
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
		if("p".equalsIgnoreCase(message)||"q".equalsIgnoreCase(message))
		{
			return true;
		}
		Plane plane=ReservationStoreQueue.getReservation(message);
		if(plane==null)
		{
			os.println(ErrorCode.ERROR_CODE);
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
