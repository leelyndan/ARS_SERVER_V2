package com.test.server.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.server.bean.Plane;

public final class Categorys 
{

	private Categorys(){}
	
	private static Map<Integer,String> cityMaps;
	
	private static Map<Integer,String> seatClassNameMaps;
	
	private static Map<String, Map<Integer,String>> beginTimeMap;
	
	private static Map<String,Map<Integer,Integer>> seatClassMap;
	
	private static Map<String,Map<Integer,Integer>> payMaps;
	
	private static Map<String,String> airNoMaps;
	
	
	static
	{
		init();
	}
	
	
	
	private static void init()
	{
		cityMaps=new HashMap<Integer,String>();
		beginTimeMap=new HashMap<String, Map<Integer,String>>();
		payMaps=new HashMap<String,Map<Integer,Integer>>();
		seatClassMap=new HashMap<>();
		seatClassNameMaps=new HashMap<>();
		
		
		//城市map信息 
		cityMaps.put(1, "Xi'an");
		cityMaps.put(2, "Incheon");
		
		Map<Integer,String> timesXiToIn = new HashMap<Integer,String>();
		timesXiToIn.put(1,"10:00");
		timesXiToIn.put(2,"15:00");
		timesXiToIn.put(3,"20:00");
		beginTimeMap.put("Xi'an,Incheon", timesXiToIn);
		
		Map<Integer,String> timesInToXi = new HashMap<Integer,String>();
		timesInToXi.put(1,"18:00");
		timesInToXi.put(2,"09:00");
		timesInToXi.put(3,"12:00");
		beginTimeMap.put("Incheon,Xi'an", timesInToXi);
		
		Map<Integer,Integer> payXiToIn=new HashMap<>();
		payXiToIn.put(1, 4000);
		payXiToIn.put(2, 3000);
		payXiToIn.put(3, 2000);
		payMaps.put("Xi'an,Incheon", payXiToIn);
		
		Map<Integer,Integer> payInToXi=new HashMap<>();
		payInToXi.put(1, 3000);
		payInToXi.put(2, 2000);
		payInToXi.put(3, 1500);
		payMaps.put("Incheon,Xi'an", payInToXi);
		
		Map<Integer,Integer> seatClassXiToIn=new HashMap<>();
		seatClassXiToIn.put(1, 4000);
		seatClassXiToIn.put(2, 3000);
		seatClassXiToIn.put(3, 2000);
		seatClassMap.put("Xi'an,Incheon", seatClassXiToIn);
		
		Map<Integer,Integer> seatClassInToXi=new HashMap<>();
		seatClassInToXi.put(1, 3000);
		seatClassInToXi.put(2, 2000);
		seatClassInToXi.put(3, 1500);
		seatClassMap.put("Incheon,Xi'an", seatClassInToXi);
		
		seatClassNameMaps.put(1, "First Class");
		seatClassNameMaps.put(2, "Business Class");
		seatClassNameMaps.put(3, "Economy Class ");
		
		airNoMaps=new HashMap<>();
		List<Plane> planes= FileUtil.getPlanelist();
		
		for(Plane plane:planes)
		{
			StringBuilder key=new StringBuilder();
			String beginCity=plane.getBeginCity();
			String endCity=plane.getEndCity();
			key.append(beginCity).append(",");
			key.append(endCity).append(",");
			key.append(plane.getBeginTime());
			airNoMaps.put(key.toString(), plane.getNumber());
		}
	}

	public static Map<Integer, String> getCityMaps() {
		return cityMaps;
	}

	public static Map<String, Map<Integer,String>> getBeginTimeMap() {
		return beginTimeMap;
	}

	public static Map<String, Map<Integer, Integer>> getPayMaps() {
		return payMaps;
	}

	public static Map<Integer, String> getSeatClassNameMaps() {
		return seatClassNameMaps;
	}

	public static Map<String, Map<Integer, Integer>> getSeatClassMap() {
		return seatClassMap;
	}

	public static Map<String, String> getAirNoMaps() {
		return airNoMaps;
	}
	
}
