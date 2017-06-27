package com.focus.Counter.common.utils;

import java.util.UUID;

/**
 * GUID唯一码生成助手
 * @author if
 *
 */
public class GuidUtils {
	//生成GUID唯一码
	public static String getGuid(){
		String uuid = UUID.randomUUID().toString();
		String[] us = uuid.split("-");
		String result = "";
		for (String s : us) {
			result = result+s;
		}
		return result;
	}
}
