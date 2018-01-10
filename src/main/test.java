package main;
import java.io.*;
import java.net.*;

import model.CatalogueFut;
import Dao.CatalogueFutDAO;
import Dao.GenericImplDAO;

public class test {
	  private static final String targetURL =" http://localhost:8081/Jax-rs_Gestion_Fut/fut/string";
	public static void main(String[] args) {
		  try {

			              URL targetUrl = new URL(targetURL);
			              HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			              httpConnection.setDoOutput(true);
			              httpConnection.setRequestMethod("GET");
			              httpConnection.setRequestProperty("Accept", "application/json");
			  
			              if (httpConnection.getResponseCode() != 200) {
			  
			                  throw new RuntimeException("HTTP GET Request Failed with Error code : "

			  
			                      + httpConnection.getResponseCode());
			  
			              }
			  
			   
			  
			              BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
			  
			                      (httpConnection.getInputStream())));
			  
			   
			  
			              String output;
			  
			              System.out.println("Output from Server:\n");
			  
			              while ((output = responseBuffer.readLine()) != null) {
			  
			                  System.out.println(output);
			  
			              }
			  
			   
			  
			              httpConnection.disconnect();
			  
			   
			  
			            } catch (MalformedURLException e) {
			  
			   
			  
			              e.printStackTrace();
			  
			   
			  
			            } catch (IOException e) {
			  
			   
			  
			              e.printStackTrace();

	}

	}
	}
