package com.reidwmulkey.airplane;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import lombok.SneakyThrows;

public class RestRepository {

	private static Gson gson = new Gson();

	@SneakyThrows
	public <T> T getForObject(String url, Class<T> classOfT) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		// HttpPost request = new HttpPost(url);
		HttpGet request = new HttpGet(url);

//		StringEntity params = new StringEntity("");
//		request.addHeader("content-type", "application/json");
//		request.setEntity(params);

		HttpResponse result = httpClient.execute(request);
		String json = EntityUtils.toString(result.getEntity(), "UTF-8");

		return gson.fromJson(json, classOfT);
	}
}
