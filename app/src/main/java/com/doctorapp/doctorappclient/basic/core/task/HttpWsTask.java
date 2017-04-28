package com.doctorapp.doctorappclient.basic.core.task;

import android.os.AsyncTask;

import com.doctorapp.doctorappclient.basic.core.callBack.INetWorkCallBack;
import com.doctorapp.doctorappclient.basic.core.network.INetWorkCore;
import com.doctorapp.doctorappclient.basic.core.network.impl.NetWorkCoreImpl;

public class HttpWsTask extends AsyncTask<Void, Void, String> {
	
	private String methodName;
	private String jsonStr;
	private String serverMethod;
	private String type;
	private INetWorkCallBack callback;
	
	private INetWorkCore netWorkCore;

	public HttpWsTask(String methodName, String jsonStr, String serverMethod,
			String type, INetWorkCallBack callback) {
		super();
		this.methodName = methodName;
		this.jsonStr = jsonStr;
		this.serverMethod = serverMethod;
		this.type = type;
		this.callback = callback;
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
		String rs = nw.postWsData(methodName, jsonStr, serverMethod, type);
		return rs;
	}

	@Override
	protected void onPreExecute() {
		callback.onPreExecute();
	}

	@Override
	protected void onPostExecute(String result) {
		callback.success(result);
	}

}
