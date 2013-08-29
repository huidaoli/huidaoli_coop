package com.base.frame.business;

import java.util.HashMap;
import java.util.Map;

public class Init {

	private static Map<String,String> map = new HashMap<String,String>();
	
	public static Map<Integer,String> imgmap = new HashMap<Integer,String>();

	public static Map<String, String> getMap() {
		return map;
	}

	public static void setMap(Map<String, String> map) {
		Init.map = map;
	}
}
