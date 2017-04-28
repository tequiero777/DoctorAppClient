package com.doctorapp.doctorappclient.basic.core.callBack;

public abstract class INetWorkCallBack {
	/**
	 * 回调成功方法
	 * @param json
	 * @return
	 */
	public abstract void success(String json);
	
	/**
	 * 加载之前处理的方法
	 */
	public void onPreExecute(){
		
	}
	
}
