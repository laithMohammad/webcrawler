package com.laith.crawler.config;

import com.laith.crawler.Main;

import java.io.*;
import java.util.Properties;

public class PropertiesConfig {
	private static Properties properties = new Properties();

	static {
		File file = new File(PropertiesConfig.class.getClassLoader().getResource("config.properties").getFile());
		if(!file.exists()) {
			System.out.println("Exist");
			System.exit(1);
		}
		try {
			InputStream is = new FileInputStream(file);
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static long getLong(String propertyName) {
		return Long.parseLong(get(propertyName));
	}

	public static String get(String propertyName) {
		return properties.getProperty(propertyName);
	}
}
