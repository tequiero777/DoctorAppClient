package com.doctorapp.doctorappclient.basic.core.helper;

import java.util.List;
import java.util.Map;

import com.doctorapp.doctorappclient.basic.bean.FormFile;
import com.doctorapp.doctorappclient.basic.core.callBack.INetWorkCallBack;
import com.doctorapp.doctorappclient.basic.core.task.HttpPostDataByFormTask;
import com.doctorapp.doctorappclient.basic.core.task.HttpPostDataTask;
import com.doctorapp.doctorappclient.basic.core.task.HttpWsTask;


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
     * ws调用
     * @param methodName
     * @param jsonStr
     * @param serverMethod
     * @param type
     * @param callback
     */
    public static void  ws(String methodName, String jsonStr, String serverMethod, String type,INetWorkCallBack callback){
    	new HttpWsTask(methodName, jsonStr, serverMethod, type, callback).execute();
    }
	
	
}
