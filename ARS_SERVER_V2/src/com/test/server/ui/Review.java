package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.test.server.bean.Plane;
import com.test.server.store.ReservationStoreQueue;
import com.test.server.store.UserInputStore;
import com.test.server.util.Categorys;
import com.test.server.util.DateUtil;

public class Review extends CommonUI{
	
	private UserInputStore clientInputs;
	
	public static final DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private Plane plane;
	
	public Review(PrintWriter os,BufferedReader is ,UserInputStore clientInputs) 
	{
		super(os, is);
		this.clientInputs=clientInputs;
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
		show.append("\n");
		show.append("****************************************");
		return show.toString();
	}
	
	@Override
	 StringBuilder generatorData()
	{
		StringBuilder data=new StringBuilder();
		
		String beginCity=Categorys.getCityMaps().get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-8)));
		String endCity=Categorys.getCityMaps().get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-7)));
		String beginTime=Categorys.getBeginTimeMap().get(beginCity+","+endCity).get(Integer.parseInt(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-5)));
		String seatClassName=Categorys.getSeatClassNameMaps().get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-2)));
		int pay=Categorys.getSeatClassMap().get(beginCity+","+endCity).get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-2)));
		int allPassenger=Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-4))+Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-3));
		int allPay=allPassenger*pay;
		
		plane=new Plane();
		plane.setBeginCity(beginCity);
		plane.setEndCity(endCity);
		plane.setBeginTime(beginTime);
		plane.setSeatClass(seatClassName);
		plane.setAllPay(allPay);
		plane.setCharge(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-1))-allPay);
		plane.setDepartDate(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-6));
		plane.setPassengerAdult(Integer.parseInt(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-4)));
		plane.setPassengerChild(Integer.parseInt(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-3)));
		plane.setTotalAmount(allPay);
		plane.setNumber(generatorNo());
		plane.setCharge(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-1))-allPay);
		plane.setDepartDate(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-6));
		plane.setPayment(Integer.valueOf(clientInputs.getLastUserInputCmd()));
		plane.setCharge(Integer.valueOf(clientInputs.getLastUserInputCmd())-allPay);
		
		//保存订单成功信息 
		ReservationStoreQueue.putReservation(generatorNo(), plane);
		
		data.append("Flight : ").append(Categorys.getAirNoMaps().get(beginCity+","+endCity+","+beginTime));
		data.append("\n");
		data.append("Departure Airport : ").append(beginCity);
		data.append("\n");
		data.append("Arrival Airport  : ").append(endCity);
		data.append("\n");
		data.append("Depart Date : ").append(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-6));
		data.append("\n");
		data.append("Depart Time : ").append(beginTime);
		data.append("\n");
		data.append("Passenger : ").append(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-4));
		data.append(" Adult, ").append(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-3));
		data.append(" Child");
		data.append("\n");
		data.append("Seat Class : ").append(seatClassName);
		data.append("\n");
		data.append("Total Amount : ").append(allPay).append(" Yuan");
		data.append("\n");	
		data.append("Payment : ").append(clientInputs.getLastUserInputCmd()).append(" Yuan");
		data.append("\n");	
		data.append("Charge :  ").append(Integer.valueOf(clientInputs.getLastUserInputCmd())-allPay).append(" Yuan");
		data.append("\n");	
		data.append("Reservation Number : ").append(generatorNo());
		data.append("\n");	
		
		return data;
	}
	
	//航空名||出发地头一个字母||到达地头一个字母||现在日期(yyyyMMddHHMiss
	private String generatorNo()
	{
		String beginCity=Categorys.getCityMaps().get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-8)));
		String endCity=Categorys.getCityMaps().get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-7)));
		String beginTime=Categorys.getBeginTimeMap().get(beginCity+","+endCity).get(Integer.parseInt(clientInputs.getUserInputCmd(clientInputs.getInputListSize()-5)));
		StringBuilder no=new StringBuilder();
		no.append(Categorys.getAirNoMaps().get(beginCity+","+endCity+","+beginTime));
		no.append(beginCity.substring(0, 1)).append(endCity.substring(0,1));
		no.append(DateUtil.nextNumDate(0,formatter));
		return no.toString();
	}
	
	@Override
	 boolean paramCheck(String message) {
		return true;
	}
	
}
