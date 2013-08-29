package com.cantodo.content.front.tool;

import java.util.Random;

public class CharacterUtils {

	public static String getRandomString(int length) {
		String str = "abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer sf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(62);// 0~61
			sf.append(str.charAt(number));

		}
		return sf.toString();
	}
	
	//public static void main(String[] args) {
	//	System.out.println(getRandomString(8));
	//}

}
