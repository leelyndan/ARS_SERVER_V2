package com.test.server.ui;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Map;

import com.test.server.constant.ErrorCode;
import com.test.server.store.UserInputStore;
import com.test.server.util.Categorys;

public class DepartTime extends CommonUI {

	private UserInputStore clientInputs;

	public DepartTime(PrintWriter os, BufferedReader is,
			UserInputStore clientInputs) {
		super(os, is);
		this.clientInputs = clientInputs;
	}

	@Override
	String generatorView() {
		// ¶¯Ì¬Éú³É
		StringBuilder show = new StringBuilder(
				"****************************************");
		show.append("\n");
		show.append("Depart Time");
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

		Map<String, Map<Integer, String>> beginTimeMap = Categorys
				.getBeginTimeMap();
		StringBuilder data = new StringBuilder();
		String cityKey = Categorys.getCityMaps().get(
				Integer.valueOf(clientInputs.getUserInputCmd(clientInputs
						.getInputListSize() - 3)))
				+ ","
				+ Categorys.getCityMaps().get(
						Integer.valueOf(clientInputs
								.getUserInputCmd(clientInputs
										.getInputListSize() - 2)));
		Map<Integer, String> timeMap = beginTimeMap.get(cityKey);
		for (Integer index : timeMap.keySet()) {
			data.append(index + ". " + timeMap.get(index));
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
