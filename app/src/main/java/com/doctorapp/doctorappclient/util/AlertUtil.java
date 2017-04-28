package com.doctorapp.doctorappclient.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface.OnClickListener;

/**
 * 弹出框工具类
 * @author luoqb
 *
 */
public class AlertUtil {
	
	
	public static void defaultAlert(Activity mActivity,String title,String messgae,OnClickListener submit,OnClickListener cancel){
		if(submit!=null&&cancel!=null){
			new AlertDialog.Builder(mActivity).setTitle(title)
		     .setMessage(messgae)
		     .setPositiveButton("确定",submit).setNegativeButton("取消",cancel).show();
		}else if(submit!=null&&cancel==null){
			new AlertDialog.Builder(mActivity).setTitle(title)
		     .setMessage(messgae)
		     .setPositiveButton("确定",submit).show();
		}else if(submit==null&&cancel!=null){
			new AlertDialog.Builder(mActivity).setTitle(title)
		     .setMessage(messgae)
		     .setNegativeButton("取消",cancel).show();
		}
		
	
	}
	
}
