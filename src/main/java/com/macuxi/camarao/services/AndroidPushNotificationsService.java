package com.macuxi.camarao.services;

	import java.io.IOException;
import java.util.ArrayList;
	import java.util.concurrent.CompletableFuture;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
	import org.springframework.http.client.ClientHttpRequestInterceptor;
	import org.springframework.scheduling.annotation.Async;
	import org.springframework.stereotype.Service;
	import org.springframework.web.client.RestTemplate;
	 
	@Service
	public class AndroidPushNotificationsService {
	 
		private static final String FIREBASE_SERVER_KEY = "AAAAc9_DTqY:APA91bFePnvsXwDUuuj_x4Kdj8ylAbY-GFygzGAGn8Q6262O_lTjLS0NWuOj-rLNd-ZljOhO4Y9fYVO6dgP7F0hswqddrsFOOtQcZguTX7vGwfoAHcsaGWG7DB3qjn6qsH2EG6QHJEwG";
		private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";		
		
		public void send(double medicao) throws JSONException {		
			
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost post = new HttpPost(FIREBASE_API_URL);
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization", "key=" + FIREBASE_SERVER_KEY);

			JSONObject message = new JSONObject();
			message.put("to", "/topics/all");
			message.put("priority", "high");		

			JSONObject notification = new JSONObject();
			notification.put("title", "Alerta de medição");
			notification.put("body", "Temperatura atingiu o limite: " + medicao);

			message.put("notification", notification);

			post.setEntity(new StringEntity(message.toString(), "UTF-8"));
			HttpResponse response = null;
			try {
				response = client.execute(post);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}



