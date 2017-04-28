package com.doctorapp.doctorappclient.util;

import android.app.Activity;
import android.app.ProgressDialog;
/**
 * 进度条工具类
 * @author luoqb
 *
 */
public class ProgressBarUtil {
	
	/**
	 * 系统默认加载进度条
	 * @param mActivity
	 * @param title
	 * @param msg
	 * @return
	 */
	public static ProgressDialog defaultProgress(Activity mActivity,String title,String msg){
		ProgressDialog	pd = new ProgressDialog(mActivity);
		pd.setTitle(title);
		pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		pd.setMessage(msg);
		pd.setIndeterminate(true);
		pd.setCancelable(true);
		return pd;
	}
}
