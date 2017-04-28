package com.doctorapp.doctorappclient.util;

import java.io.InputStream;
import java.util.Properties;

import android.content.Context;

public class PropertiesUtil {
	 private static Properties props;
	 static{
		 if(props == null){
			 props = new Properties();
		 }
		  try {
		   InputStream in = PropertiesUtil
				   				.class
				   				.getResourceAsStream("/assets/config.properties"); 
		   props.load(in);
		  } catch (Exception e1) {
		   e1.printStackTrace();
		  }
	 }
	 
	 public static String getProperty(String key){
		 return props.getProperty(key);
	 }
	  
}

