package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.test.server.bean.Plane;
import com.test.server.constant.ErrorCode;
import com.test.server.store.ReservationStoreQueue;

public class CheckReview extends CommonUI{
	
	
	public static final DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private String airNo;
	
	public CheckReview(PrintWriter os, BufferedReader is,String airNo) {
		super(os, is);
		this.airNo=airNo;
	}
	
	@Override
	 String generatorView()
	{
		StringBuilder show=new StringBuilder("****************************************");
		show.append("\n");
		show.append("Review");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append("Please, Input any key.");
		show.append("\n");
		show.append(generatorData());
		//¶¯Ì¬Éú³É 
		show.append("P. Previous Menu");
		show.append("\n");
		show.append("Q. Quit");
		show.append("\n");
		show.append("****************************************");
		return show.toString();
	}
	
	@Override
	 StringBuilder generatorData()
	{
		Plane plane=ReservationStoreQueue.getReservation(airNo);
		StringBuilder data=new StringBuilder();
		data.append("Flight : ").append(airNo);
		data.append("\n");
		data.append("Departure Airport : ").append(plane.getBeginCity());
		data.append("\n");
		data.append("Arrival Airport  : ").append(plane.getEndCity());
		data.append("\n");
		data.append("Depart Date : ").append(plane.getDepartDate());
		data.append("\n");
		data.append("Depart Time : ").append(plane.getBeginTime());
		data.append("\n");
		data.append("Passenger : ").append(plane.getPassengerAdult());
		data.append(" Adult, ").append(plane.getPassengerChild());
		data.append(" Child");
		data.append("\n");
		data.append("Seat Class : ").append(plane.getSeatClass());
		data.append("\n");
		data.append("Total Amount : ").append(plane.getAllPay()).append(" Yuan");
		data.append("\n");	
		data.append("Payment : ").append(plane.getPayment()).append(" Yuan");
		data.append("\n");	
		data.append("Charge :  ").append(plane.getCharge()).append(" Yuan");
		data.append("\n");	
		data.append("Reservation Number : ").append(plane.getNumber());
		data.append("\n");	
		
		return data;
	}
	
	@Override
	boolean paramCheck(String message) {
		
		if (message == null || "".equals(message)) 
		{
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if (!"p".equalsIgnoreCase((message))) 
		{
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		return true;
	}
	
	
	
	
}
