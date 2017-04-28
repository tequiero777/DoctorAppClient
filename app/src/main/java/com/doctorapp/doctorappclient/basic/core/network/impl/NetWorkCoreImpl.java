package com.doctorapp.doctorappclient.basic.core.network.impl;

import com.doctorapp.doctorappclient.basic.bean.FormFile;
import com.doctorapp.doctorappclient.basic.core.helper.HttpClientSslHelper;
import com.doctorapp.doctorappclient.basic.core.network.INetWorkCore;
import com.doctorapp.doctorappclient.basic.core.network.SSLConnection;
import com.doctorapp.doctorappclient.common.Constant;
import com.doctorapp.doctorappclient.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.kxml2.kdom.Element;
import org.kxml2.kdom.Node;
import org.xmlpull.v1.XmlPullParserException;


public class NetWorkCoreImpl implements INetWorkCore {

	@Override
	public String postDataFormBySsl(String url, Map<String, Object> params,String authorization) {
		HttpClient httpClient = HttpClientSslHelper.getSslHttpClient();
		if(httpClient != null){
	        try{  
	            // 创建HttpPost对象。  
	            HttpPost post = new HttpPost(url); 
	            if(!StringUtil.isEmpty(authorization)){
	            	 post.addHeader("Authorization", authorization);
	            }
	           
	            // 如果传递参数个数比较多的话可以对传递的参数进行封装  
	            List<NameValuePair> listParams = new ArrayList<NameValuePair>();  
	            for(String key : params.keySet()){  
	                //封装请求参数  
	            	listParams.add(new BasicNameValuePair(key , (String) params.get(key)));  
	            }  
	            // 设置请求参数  
	            post.setEntity(new UrlEncodedFormEntity(listParams,HTTP.UTF_8));  
	            // 发送POST请求  
	            HttpResponse httpResponse = httpClient.execute(post);  
	            // 如果服务器成功地返回响应  
	            if (httpResponse.getStatusLine() .getStatusCode() == 200){  
	                // 获取服务器响应字符串  
	                String result = EntityUtils.toString(httpResponse.getEntity());  
	               return result;
	            		    
	            }  
	        }catch(Exception e){  
	        	return e.getMessage();
	        }finally{  
	            httpClient.getConnectionManager().shutdown();  
	        }  
		}else{
			return "创建httpClien失败";
		}
		return "";
	}

	@Override
	public String postFile(String path, Map<String, String> params,List<FormFile> files) throws Exception {
		
		
		return "";
	}

	
	
	
	@Override
	public String postWsData(String methodName, String jsonStr, String serverMethod, String type)  {
		// 实例化SoapObject对象
		SoapObject request = null;
		if (StringUtil.empty(type)) {
			String ns = Constant.getServerNs("basic");
			request = new SoapObject(ns, methodName);
		} else {
			String ns = Constant.getServerNs(type);
			request = new SoapObject(ns, methodName);
		}
		if (serverMethod != null) {
			request.addProperty(serverMethod, jsonStr);
		}

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		Element[] header = new Element[2]; 
		header[0] = new Element().createElement("", "authorize"); 
		
        Element userName = new Element().createElement("", "username"); 
        userName.addChild(Node.TEXT, Constant.WS_USERNAME); 
        header[0].addChild(Node.ELEMENT, userName); 
        
        Element pass = new Element().createElement("", "password"); 
        pass.addChild(Node.TEXT, Constant.WS_PASSWORD ); 
        header[0].addChild(Node.ELEMENT, pass); 
        
        header[1] = new Element().createElement("", "tenant_id");
        header[1].addChild(Node.TEXT,  Constant.TENANT_ID );
		envelope.headerOut=header;
		
		envelope.bodyOut = request;
		envelope.dotNet = false;
		HttpTransportSE transport = null;
		if (StringUtil.empty(type)) {
			String ws = Constant.getServerWsUrl("basic");
			transport = new HttpTransportSE(ws);
		} else {
			String ws = Constant.getServerWsUrl(type);
			transport = new HttpTransportSE(ws);
		}
		
		envelope.setOutputSoapObject(request);

		String WebMethod = null;
		try {
			SSLConnection.allowAllSSL();
			transport.call(WebMethod, envelope);
			if (envelope.getResponse() != null) {
				SoapObject result = (SoapObject) envelope.bodyIn;
				return result.getProperty(0).toString();
			} 
		} catch (IOException e) {
			return e.getMessage();
		} catch (XmlPullParserException e) {
			return e.getMessage();
		}
		return "";
	}


	@Override
	public String postDataBySsl(String url, String jsonStr,String authorization) {
		HttpClient httpClient = HttpClientSslHelper.getSslHttpClient(); 
	    HttpPost httppost = new HttpPost(url);   
	    if(!StringUtil.isEmpty(authorization)){
	    	httppost.addHeader("Authorization", authorization);
	    }
	    httppost.addHeader("Content-Type", "application/json");  
	    httppost.addHeader("User-Agent", "imgfornote");  
	    try {
			httppost.setEntity(new StringEntity(jsonStr));
			HttpResponse response;  
		    response = httpClient.execute(httppost);  
		    //检验状态码，如果成功接收数据   
		    int code = response.getStatusLine().getStatusCode();  
		    if (code == 200) {   
		        String rev = EntityUtils.toString(response.getEntity());
		        return rev;
		       
		    }  
		    return "";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}     
	    
	}

}
