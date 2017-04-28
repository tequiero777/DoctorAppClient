package com.doctorapp.doctorappclient.basic.core.task;

import java.util.Map;


import android.content.Context;
import android.os.AsyncTask;

import com.doctorapp.doctorappclient.basic.core.callBack.INetWorkCallBack;
import com.doctorapp.doctorappclient.basic.core.network.INetWorkCore;
import com.doctorapp.doctorappclient.basic.core.network.impl.NetWorkCoreImpl;

public class HttpPostDataTask extends AsyncTask<Void, Void, String> {
	
	private INetWorkCallBack callBack;
	
	private String url;
	
	private String jsonStr;
	
	
	private INetWorkCore netWorkCore;

	public HttpPostDataTask(INetWorkCallBack callBack, String url,
			String jsonStr) {
		super();
		this.callBack = callBack;
		this.url = url;
		this.jsonStr = jsonStr;
	}

	private INetWorkCore getNetWorkByForm(){
		if(netWorkCore==null){
			this.netWorkCore = new NetWorkCoreImpl();
		}
		return netWorkCore;
	}


	@Override
	protected String doInBackground(Void... params) {
		INetWorkCore nw = getNetWorkByForm();
		//TODO 验证信息暂时为null
		String authorization = null;
		String rs = nw.postDataBySsl(url, jsonStr, authorization);
		return rs;
	}

	@Override
	protected void onPreExecute() {
		callBack.onPreExecute();
	}

	@Override
	protected void onPostExecute(String result) {
		callBack.success(result);
	}

}
