package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

import com.test.server.constant.ErrorCode;
import com.test.server.store.UserInputStore;
import com.test.server.util.Categorys;

public class SeatClass extends CommonUI{

	private UserInputStore clientInputs;

	public SeatClass(PrintWriter os, BufferedReader is , UserInputStore clientInputs) 
	{
		super(os, is);
		this.clientInputs = clientInputs;
	}

	@Override
	 String generatorView() {
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Seat Class");
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
		
		Map<String, Map<Integer, Integer>> seatClassMap=Categorys.getSeatClassMap();
		StringBuilder data = new StringBuilder();

		String cityKey = Categorys.getCityMaps().get(
				Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 6)))
				+ ","
				+ Categorys.getCityMaps().get(Integer.valueOf(clientInputs.getUserInputCmd(clientInputs.getInputListSize() - 5)));
		Map<Integer, Integer> seatMap = seatClassMap.get(cityKey);
		for (Integer index : seatMap.keySet()) {
			data.append(index + ". "
					+ Categorys.getSeatClassNameMaps().get(index) + "("
					+ seatMap.get(Integer.valueOf(index)) + " Yuan)");
			data.append("\n");
		}
		return data;
	}

	@Override
	 boolean paramCheck(String message) {
		if (message == null || "".equals(message)) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		if (!"1".equals(message) && !"2".equals(message)
				&& !"3".equals(message) && !"q".equalsIgnoreCase((message))
				&& !"p".equalsIgnoreCase((message))) {
			os.println(ErrorCode.ERROR_CODE);
			os.flush();
			return false;
		}
		return true;
	}
}
