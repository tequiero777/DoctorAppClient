package com.doctorapp.doctorappclient.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

public class LogUtils {
	
	static	String  pathError = Environment.getExternalStorageDirectory()+"/error.txt";
	
	static String  pathInfo = Environment.getExternalStorageDirectory()+"/info.txt";
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     public static void i(String tag,String content){
    	 Log.i(tag, content);
    	// FileUtils.writeFile(pathInfo,sdf.format(new Date())+":"+ content+"\n", true);
     }
     
     public static void e(String tag,String content){
    	 Log.e(tag, content);
    	// FileUtils.writeFile(pathError,sdf.format(new Date())+":"+ content+"\n", true);
     }
}
