package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;

import com.test.server.constant.ErrorCode;

public class Reservation extends CommonUI{

	public Reservation(PrintWriter os, BufferedReader is )
	{
		super(os, is);
	}

	@Override
	 String generatorView() {
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Welcome to Xi¡¯an Airline");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append("1. Reservation");
		show.append("\n");
		show.append("2. Check Reservation");
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
		if (!"1".equals(message) && !"2".equals(message)
				&& !"q".equalsIgnoreCase((message))) {
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
