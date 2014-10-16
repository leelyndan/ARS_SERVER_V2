package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.test.server.constant.ErrorCode;
import com.test.server.util.MathUtil;

public class PassengerAdult extends CommonUI {

	public PassengerAdult(PrintWriter os, BufferedReader is) {
		super(os, is);
	}

	@Override
	String generatorView() {
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Passenger");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append("Please, Input the number of Adult.");
		show.append("\n");
		show.append("(0 ~ 10)");
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
		if ("p".equalsIgnoreCase(message)||"q".equalsIgnoreCase(message)) {
			return true;
		}
		if (!MathUtil.isNumeric(message)) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if (Integer.valueOf(message) < 0 || Integer.valueOf(message) > 10) {
			os.println(ErrorCode.NUM_ERROR_CODE);
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
