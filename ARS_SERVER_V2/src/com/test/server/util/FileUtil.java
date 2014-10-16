package com.test.server.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.test.server.bean.Plane;

public final class FileUtil {

	private FileUtil(){}
	
	private static final List<Plane> planeList=new ArrayList<Plane>();
	
	static 
	{
		 InputStream in = Object.class.getResourceAsStream("/plane.properties"); 
		 BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		 
		 String fileMessage;
		 
		 try 
		 {
			while((fileMessage = reader.readLine())!=null && !"".equals(fileMessage))
			{
				String [] detail=fileMessage.split(",");
				Plane plane=new Plane();
				plane.setNumber(detail[0]);
				plane.setBeginCity(detail[1]);
				plane.setEndCity(detail[2]);
				plane.setBeginTime(detail[3]);
				plane.setEndTime(detail[4]);
				plane.setFirstClassPay(Integer.valueOf(detail[5]));
				plane.setBusinessClassPay(Integer.valueOf(detail[6]));
				plane.setEconomyClassPay(Integer.valueOf(detail[7]));
				planeList.add(plane);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally
		{
			
		}
	}

	public static List<Plane> getPlanelist() {
		return planeList;
	}
	
}
