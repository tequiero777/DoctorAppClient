package com.doctorapp.doctorappclient.basic.ui.activity;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;

public class DeviceIp{
	public String getDeviceId(Activity activity){
		String deviceId= ((TelephonyManager) activity.getSystemService(Activity.TELEPHONY_SERVICE)).getDeviceId();
		return deviceId;
		
	}
	public String getLoginIp(Activity activity){
		String loginIp="";
		WifiManager wifiManager = (WifiManager) activity.getSystemService(Context.WIFI_SERVICE);
		// 判断wifi是否开启
		if (wifiManager.isWifiEnabled()) {
			WifiInfo wifiInfo = wifiManager.getConnectionInfo();
			int ipAddress = wifiInfo.getIpAddress();
			loginIp = intToIp(ipAddress);
			
		}else{
			 try  
			       {  
			          for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();)  
			           {  
			              NetworkInterface intf = en.nextElement();  
			             for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();)  
			               {  
			                  InetAddress inetAddress = enumIpAddr.nextElement();  
			                    if (!inetAddress.isLoopbackAddress())  
			                   {  
			                    	loginIp =  inetAddress.getHostAddress().toString();  
			                   }  
			              }  
			           }  
			       }  
			       catch (SocketException ex)  
			         {  
			           Log.e("WifiPreference IpAddress", ex.toString());  
			         }  


		}
		return loginIp;
		
	}
	
	private String intToIp(int i){
		  return (i & 0xFF ) + "." + ((i >> 8 ) & 0xFF) + "." + ((i >> 16 ) & 0xFF) + "." + ( i >> 24 & 0xFF) ; 
	}
}
