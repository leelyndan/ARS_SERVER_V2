package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

import com.test.server.constant.ErrorCode;
import com.test.server.util.Categorys;

public class DepatureAirport extends CommonUI {

	public DepatureAirport(PrintWriter os, BufferedReader is) {
		super(os, is);
	}

	String generatorView() {
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Departure Airport");
		show.append("\n");
		show.append("****************************************");
		show.append("\n");
		show.append(generatorData());
		show.append("\n");
		show.append("P. Previous Menu");
		show.append("\n");
		show.append("Q. Quit");
		show.append("\n");
		show.append("****************************************");
		return show.toString();
	}

	@Override
	StringBuilder generatorData() {
		Map<Integer, String> beginCity = Categorys.getCityMaps();
		StringBuilder datas = new StringBuilder();
		for (Integer index : beginCity.keySet()) {
			datas.append("\n");
			datas.append(index + ". " + beginCity.get(index));
		}
		return datas;
	}

	@Override
	boolean paramCheck(String message) {
		if (message == null || "".equals(message)) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if (!"1".equals(message) && !"2".equals(message)
				&& !"q".equalsIgnoreCase((message))
				&& !"p".equalsIgnoreCase((message))) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		return true;
	}

}
