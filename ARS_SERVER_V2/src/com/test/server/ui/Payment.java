package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.test.server.constant.ErrorCode;
import com.test.server.store.UserInputStore;
import com.test.server.util.Categorys;
import com.test.server.util.MathUtil;

public class Payment extends CommonUI {

	private UserInputStore clientInputs;

	private int allPay;

	public Payment(PrintWriter os, BufferedReader is, UserInputStore clientInputs) {
		super(os, is);
		this.clientInputs = clientInputs;
	}

	@Override
	String generatorView() {
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Payment");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append("Please, Input money for payment.");
		show.append("\n");
		show.append(generatorData());
		// 动态生成
		show.append("P. Previous Menu");
		show.append("\n");
		show.append("Q. Quit");
		show.append("\n");
		show.append("****************************************");
		return show.toString();
	}

	@Override
	StringBuilder generatorData() {
		StringBuilder data = new StringBuilder();
		String beginCity = Categorys.getCityMaps().get(
				Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 7)));
		String endCity = Categorys.getCityMaps().get(
				Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 6)));
		String beginTime = Categorys
				.getBeginTimeMap()
				.get(beginCity + "," + endCity)
				.get(Integer.parseInt(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 4)));
		String seatClassName = Categorys.getSeatClassNameMaps().get(
				Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 1)));
		int pay = Categorys
				.getSeatClassMap()
				.get(beginCity + "," + endCity)
				.get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 1)));
		allPay = Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 2))
				* pay
				+ Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 1))
				* pay / 2;

		data.append("Flight : ").append(
				Categorys.getAirNoMaps().get(
						beginCity + "," + endCity + "," + beginTime));
		data.append("\n");
		data.append("Departure Airport : ").append(beginCity);
		data.append("\n");
		data.append("Arrival Airport  : ").append(endCity);
		data.append("\n");
		data.append("Depart Date : ").append(
				clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 5));
		data.append("\n");
		data.append("Depart Time : ").append(beginTime);
		data.append("\n");
		data.append("Passenger : ").append(
				clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 3));
		data.append(" Adult, ").append(
				clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 2));
		data.append(" Child");
		data.append("\n");
		data.append("Seat Class : ").append(seatClassName);
		data.append("\n");
		data.append("Total Amount : ").append(allPay);
		data.append("\n");
		return data;
	}

	@Override
	boolean paramCheck(String message) {
		if (message == null || "".equals(message)) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if ("p".equalsIgnoreCase(message)||"q".equalsIgnoreCase(message)) {
			return true;
		}
		if (!MathUtil.isNumeric(message)) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		// 拒绝输入程序无法接受的数值
		if (String.valueOf(Long.MAX_VALUE).length() < message.length()) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if (Long.valueOf(message) < allPay) {
			os.println(ErrorCode.NOT_ENOUGH_MONEY_EERROR_CODE);
			os.flush();
			return false;
		}
		if (Long.valueOf(message) < 0 || Long.valueOf(message) > 999999) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}

		return true;
	}

}
