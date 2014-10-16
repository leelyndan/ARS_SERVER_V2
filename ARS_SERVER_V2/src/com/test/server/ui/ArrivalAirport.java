package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

import com.test.server.constant.ErrorCode;
import com.test.server.store.UserInputStore;
import com.test.server.util.Categorys;

public class ArrivalAirport extends CommonUI {
	
	private UserInputStore clientInputs;

	public ArrivalAirport(PrintWriter os, UserInputStore clientInputs,BufferedReader is ) {
		super(os, is);
		this.os = os;
		this.is=is;
		this.clientInputs = clientInputs;
	}
	
	@Override
	String generatorView() {
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Arrival Airport");
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
		StringBuilder datas = new StringBuilder();
		Map<Integer, String> beginCitys = Categorys.getCityMaps();
		for (Integer index : beginCitys.keySet()) {
			datas.append("\n");
			datas.append(index + ". " + beginCitys.get(index));
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
		if (message.equals(clientInputs.getLastUserInputCmd())) {
			os.println(ErrorCode.SAME_CITY_CODE);
			os.flush();
			return false;
		}
		return true;
	}

}
