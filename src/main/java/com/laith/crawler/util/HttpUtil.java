package com.laith.crawler.util;

import okhttp3.*;

import java.io.IOException;

/**
 * Wrapper for Http Client Call
 */
public class HttpUtil {

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	public static String getJson(String url) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		System.out.println("Response Code: " + response.code() + " For: " + url);
		return response.body().string();
	}

	public static String postJson(String url, String jsonPayLoad) throws IOException {
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(JSON, jsonPayLoad);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		return response.body().string();
	}
}
