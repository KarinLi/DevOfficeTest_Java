package com.JunitTest.TestFramework;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Utility {
	static { }
	public static String GetConfigurationValue(String propertyName) {
		return AppConfig.getKeyValue(propertyName);
	}

	public static boolean ImageExist(String url) {
	    CloseableHttpClient httpclient = HttpClients.createDefault();
	    HttpGet httpGet = new HttpGet(url);
	    CloseableHttpResponse response;
	    try {
		    response = httpclient.execute(httpGet);
		    boolean isSuccess = response.getStatusLine().getStatusCode() == 200 || response.getStatusLine().getStatusCode() == 304;
		    response.close();
            return isSuccess;
	    } 
	    catch (Exception e) {
            return false;
	    }
	}

}
