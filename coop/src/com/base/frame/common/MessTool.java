package com.base.frame.common;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class MessTool {

	private static Map<String, String> messageMap = new HashMap<String, String>();

	static {
		Configuration config = null;
		try {
			config = new PropertiesConfiguration("message.properties");
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<String> it = config.getKeys();
		String key = null;
		while (it.hasNext()) {
			key = it.next();
			messageMap.put(key, config.getString(key));
		}
	}

	public static String getMessage(String key) {
		String value = messageMap.get(key);
		String res = value;
		try {
			res = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public static String getMessage2(String key) {
		return messageMap.get(key);

	}

	// public static void main(String[] args) throws Exception{
	// System.out.println(MessTool.getMessage("error001"));
	//		
	// System.out.println(URLEncoder.encode(MessTool.getMessage("error001"),"UTF-8"));
	// }

}
