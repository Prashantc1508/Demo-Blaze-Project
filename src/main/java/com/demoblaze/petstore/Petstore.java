package com.demoblaze.petstore;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.MIME;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.Asserts;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Petstore {

	public static File FileName;
	public static String message, RespValue, accessToken, dataType;
	public static HttpPost post;
	public static HttpGet get;
	public static HttpEntity responseEntity;
	public static CloseableHttpClient httpClient;
	public static CloseableHttpResponse response;
	public static MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	public static JSONObject Object = new JSONObject();
	public static JSONArray array = new JSONArray();

	// Connect GET URL
	public void ConnectGETService(String httpsURL)
			throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {

		SSLContextBuilder blder = new SSLContextBuilder();
		blder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(blder.build());
		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		get = new HttpGet(httpsURL);
	}

	// Send Get Service
	public String SendGETService() throws IOException {
		try {
			response = httpClient.execute(get);
			responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("****************STATUS CODE" + statusCode);
			InputStream Content = responseEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(Content));
			StringBuilder sb = new StringBuilder();
			sb.append(reader.readLine());
			Content.close();
			RespValue = sb.toString();
			System.out.println("Response" + RespValue);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return RespValue;
	}

	// ************************* new method for post
	public String SendPOSTServiceNew(String URL, String Header) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPost request = new HttpPost(URL);
			StringEntity params = new StringEntity(Header);
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("*********Status COde" + statusCode);
			InputStream Content = responseEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(Content));
			StringBuilder sb = new StringBuilder();
			sb.append(reader.readLine());
			Content.close();
			RespValue = sb.toString();
			System.out.println("Response" + RespValue);
		} catch (Exception ex) {
		}
		return RespValue;
	}

	// ************************** new PUT method
	public String SendPUTServiceNew(String URL, String Header) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpPut request = new HttpPut(URL);
			// HttpPost request = new HttpPost(URL);
			StringEntity params = new StringEntity(Header);
			request.addHeader("Content-Type", "application/json");
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("*********Status COde" + statusCode);
			InputStream Content = responseEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(Content));
			StringBuilder sb = new StringBuilder();
			sb.append(reader.readLine());
			Content.close();
			RespValue = sb.toString();
			System.out.println("Response" + RespValue);
		} catch (Exception ex) {
		}
		return RespValue;
	}

	// ************************ new DELETE method
	public String deleteService(String URL) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			HttpDelete request = new HttpDelete(URL);
			HttpResponse response = httpClient.execute(request);
			HttpEntity responseEntity = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("*********Status COde" + statusCode);
			InputStream Content = responseEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(Content));
			StringBuilder sb = new StringBuilder();
			sb.append(reader.readLine());
			Content.close();
			RespValue = sb.toString();
			System.out.println("Response" + RespValue);
		} catch (Exception ex) {
		}
		return RespValue;
	}

	// Connect Post URL
	public void ConnectPOSTService(String httpsURL)
			throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
		SSLContextBuilder blder = new SSLContextBuilder();
		blder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(blder.build());
		httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		post = new HttpPost(httpsURL);
	}

	// Send POST request
	public static void SendPOSTService() throws IOException {
		try {
			HttpEntity multipart = builder.build();
			post.setEntity(multipart);
			response = httpClient.execute(post);
			responseEntity = response.getEntity();

			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println("*********Status COde" + statusCode);

			InputStream Content = responseEntity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(Content));
			StringBuilder sb = new StringBuilder();
			sb.append(reader.readLine());
			Content.close();
			RespValue = sb.toString();
			System.out.println("Response" + RespValue);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		} finally {
			response.close();
		}
	}

}
