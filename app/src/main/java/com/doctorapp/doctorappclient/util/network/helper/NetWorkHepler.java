package com.doctorapp.doctorappclient.util.network.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.widget.ImageView;

import com.doctorapp.doctorappclient.basic.bean.FormFile;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.task.HttpPostDataByFormTask;
import com.doctorapp.doctorappclient.util.network.task.HttpPostDataTask;
import com.doctorapp.doctorappclient.util.network.task.HttpWsTask;
import com.doctorapp.doctorappclient.util.network.task.HttpsOneSidePostDataTask;


public abstract  class NetWorkHepler {
	
	
	
	/**
	 * 提交form表单
	 * @param url 地址
	 * @param params 参数
	 * @param callBack 回调
	 */
	public static void postDataByForm(String url,Map<String, Object> params,INetWorkCallBack callBack){
		new HttpPostDataByFormTask(callBack, url, params).execute();
	}
	/**
	 * post方式提交json数据
	 * @param url   地址
	 * @param jsonparams 参数
	 * @param callBack 回调
	 */
	public static void postData(String url,String jsonparams,INetWorkCallBack callBack){
		new HttpPostDataTask(callBack, url, jsonparams).execute();
	}
	
	/***
	 * 
	* 发送ssl 单向验证的请求 
	* @Title: postDataSslOneSide
	* @param url 请求地址
	* @param jsonparams 请求的内容
	* @param callBack  回掉方法
	* @return void
	* @throws
	* @author Leipeijie
	 */
	public static void postDataSslOneSide(String url,String jsonAttr,String methodName,INetWorkCallBack callBack,Activity mainActivity){
		new HttpsOneSidePostDataTask(callBack, url, jsonAttr, methodName, mainActivity).execute();
	}
	
	/**
	 * 上传文件
	 * @param url 地址
	 * @param params 参数
	 * @param formFileList 文件集合
	 * @param callBack 回调
	 */
    public static void uploadForm(String url, Map<String, Object> params, List<FormFile> formFileList, INetWorkCallBack callBack){
		
	}
    
    /**
     * 
    * ws查询
    * @Title: postWsDate
    * @param adrressName
    * @param methodName
    * @param jsonStr
    * @param paramsName
    * @param callback
    * @return void
    * @throws
    * @author Leipeijie
     */
    public static void postWsData(String adrressName, String methodName, 
    		HashMap<String, Object> request,INetWorkCallBack callback){
    	new HttpWsTask(adrressName,methodName, request, callback).execute();
    }
	
    /**
     * 显示图片
     */
    
    public static void showImg(String url ,ImageView imageView){
    	//需要改进用线程池管理
    	//TODO
//    	HttpImageTask task = new HttpImageTask(url, imageView);
//    	task.start();
    	//new HttpImageTask(url, imageView).executeOnExecutor(Executors.newCachedThreadPool());
    }
	
}
