package com.lcm.jnode.utils;

import java.util.HashMap;
import java.util.Properties;


/**
 * config util
 * @author chunmeng.lu
 *
 */
public class ConfigUtil {
	
	private static final HashMap<String, String> config = new HashMap<String, String>();
	
	/**
	 * 读取配置文件，将配置文件分配到一个静态HashMap
	 * @param properties
	 * @return
	 */
	public static void loadConfig(Properties properties){
		for (Object object : properties.keySet()) {
			config.put(object.toString(), properties.get(object).toString());
		}
	}
	
	public static String get(String key) {
		return config.get(key);
	}
}
