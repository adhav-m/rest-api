package com.example.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(RestApiApplication.class, args);
		long seconds = 60000L;
		//GET
		final String GETuri1 = "https://dummy.restapiexample.com/api/v1/employees";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(GETuri1, String.class);
		System.out.println(result);
		Thread.sleep(seconds);

		//GET
		final String GETuri2 = "https://dummy.restapiexample.com/api/v1/employee/1";
//        RestTemplate restTemplate = new RestTemplate();
		String result2 = restTemplate.getForObject(GETuri2, String.class);
		System.out.println(result2);
		Thread.sleep(seconds);

		//POST
		final String POSTuri = "https://dummy.restapiexample.com/api/v1/create";
		String requestJson = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

//        RestTemplate restTemplate = new RestTemplate();
		String responseJson = restTemplate.postForObject(POSTuri, requestJson, String.class);
		System.out.println("Response JSON:");
		System.out.println(responseJson);
		Thread.sleep(seconds);


		//PUT
		final String putUri = "https://dummy.restapiexample.com/api/v1/update/21";
		String putRequestJson = "{\"name\":\"updated\",\"salary\":\"456\",\"age\":\"30\"}";
//        RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<String> putRequestEntity = new HttpEntity<>(putRequestJson, headers);

		ResponseEntity<String> putResponse = restTemplate.exchange(putUri, HttpMethod.PUT, putRequestEntity, String.class);

		System.out.println("PUT Response JSON:");
		System.out.println(putResponse.getBody());
		Thread.sleep(seconds);

		//DELETE
		final String deleteUri = "https://dummy.restapiexample.com/api/v1/delete/2";
		HttpEntity<String> deleteRequestEntity = new HttpEntity<>(null);

//        RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> deleteResponse = restTemplate.exchange(
				deleteUri,
				HttpMethod.DELETE,
				deleteRequestEntity,
				String.class
		);

		System.out.println("DELETE Request JSON:");
		System.out.println(deleteResponse.getBody());
		Thread.sleep(seconds);

	}

}
