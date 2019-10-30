package com.laith.crawler.util;

import com.google.gson.Gson;
import com.laith.crawler.stackoverflow.entities.Post;

public class JsonUtil {

	public static <T> T parse(String jsonString, Class<T> tClass) {
		Gson gson = new Gson();
		return gson.fromJson(jsonString, tClass);
	}
}
