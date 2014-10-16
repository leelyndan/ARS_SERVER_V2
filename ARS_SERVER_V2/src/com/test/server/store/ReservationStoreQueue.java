package com.test.server.store;

import java.util.HashMap;

import com.test.server.bean.Plane;

public class ReservationStoreQueue {

	private ReservationStoreQueue() {
	}

	private static HashMap<String, Plane> reservationMap;

	static {
		reservationMap = new HashMap<>();
	}

	public static HashMap<String, Plane> getReservationQuene() {
		return reservationMap;
	}

	public static void putReservation(String airNo, Plane plane) {
		if (plane != null) {
			reservationMap.put(airNo, plane);
		}
	}

	public static Plane getReservation(String airNo) {
		return reservationMap.get(airNo);
	}

}
