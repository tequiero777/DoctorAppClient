package com.doctorapp.doctorappclient.util.network.task;

import java.util.Map;

import android.os.AsyncTask;

import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.internet.INetWorkCore;
import com.doctorapp.doctorappclient.util.network.internet.impl.NetWorkCoreImpl;


public class HttpPostDataByFormTask extends AsyncTask<Void, Void, String> {
	
	private INetWorkCallBack callBack;
	
	private String url;
	
	private Map<String, Object> params;
	
	
	private INetWorkCore netWorkCore;
	

	public HttpPostDataByFormTask(INetWorkCallBack callBack, String url,
			Map<String, Object> params) {
		super();
		this.callBack = callBack;
		this.url = url;
		this.params = params;
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
		String rs = nw.postDataFormBySsl(url, this.params, authorization);
		return rs;
	}

	@Override
	protected void onPreExecute() {
		callBack.onPreExecute();
	}
	
	@Override
	protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	}

	@Override
	protected void onPostExecute(String result) {
 		callBack.onResult(result);
		
	}

}
