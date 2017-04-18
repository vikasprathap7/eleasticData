package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import DAO.Customers;
import beans.CustomerDetails;

import com.google.gson.Gson;

public class LoadData {

	public static void main(String[] args) {
		String path = "src/main/java/resources/Customer";

		try {

			List<CustomerDetails> CustomersList = Customers.getCustomersList(path);
			int id = 1;
			for(CustomerDetails Customer : CustomersList){
				HttpClient httpClient = HttpClientBuilder.create().build();

				Gson gson = new Gson();
				String json = gson.toJson(Customer);

				String url = "http://localhost:9200/Customer/premium/"+id+"";
				HttpPost postRequest = new HttpPost(url);
				StringEntity input = new StringEntity(json);
				input.setContentType("application/json");
				postRequest.setEntity(input);

				HttpResponse response = httpClient.execute(postRequest);

				if ((response.getStatusLine().getStatusCode()!= 200) && (response.getStatusLine().getStatusCode() != 201)) {
					throw new RuntimeException("Failed Error occured: HTTP error code : " + response.getStatusLine().getStatusCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
				//System.out.println(br);
				String postResponse;
				System.out.println("Server is loading data\n");
				while ((postResponse = br.readLine()) != null) {
					System.out.println(postResponse);
				}

				id++;
			}

			HttpClient httpClient = HttpClientBuilder.create().build();

			String url = "http://localhost:9200/Customer/premium/_search";
			HttpGet getRequest = new HttpGet(url);

			HttpResponse response = httpClient.execute(getRequest);

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String getResponse;
			System.out.println("Server getting data");
			while ((getResponse = br.readLine()) != null) {
				System.out.println(getResponse);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
