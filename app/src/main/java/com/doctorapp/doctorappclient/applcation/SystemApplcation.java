package com.doctorapp.doctorappclient.applcation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.os.Vibrator;
import android.widget.TextView;

import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.LocationBean;
import com.doctorapp.doctorappclient.basic.ui.fragment.CaseHistoryFragment;
import com.doctorapp.doctorappclient.basic.ui.fragment.PatientsListFragment;
import com.doctorapp.doctorappclient.basic.ui.fragment.ReportFormFragment;
import com.doctorapp.doctorappclient.basic.ui.fragment.UserInfoFragment;


public class SystemApplcation extends Application {
	private List<Activity> activityList = new LinkedList<Activity>();

	private Boolean isDownload;
	
	/**是否登陆的标志*/
	private boolean islogin = false;
	//public GeofenceClient mGeofenceClient;
	
	public TextView mLocationResult,logMsg;
	public TextView trigger,exit;
	public Vibrator mVibrator;
	public LocationBean locationBean;
	private NewMsgCountCallBack callBack;
	/**公钥或者私钥*/
	private String clientKey = "";
	/**随机数*/
	private String radomNum = "";
	/**授权码*/
	private String code ="";
	
	private ReportFormFragment reportFormFragment;
	private CaseHistoryFragment caseHistoryFragment;
	private UserInfoFragment userInfoFragment;
	private PatientsListFragment patientListFragment;
	
	
	public void setCallBack(NewMsgCountCallBack callBack) {
		this.callBack = callBack;
	}
	
	/**登陆人员信息*/
	private DOCINVHISInLoginSrvOutputItem staffDict;
	/**
	 * 
	*通知主线程信息数量变化
	* @Title: notifyMainActivity
	* @return void
	* @throws
	* @author cheng
	 */
	public void notifyMainActivity(){
		if(callBack!=null)
			callBack.callBack();
	}
	private Map<String, Object> map = new HashMap<String, Object>();

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	// 添加Activity到容器中
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}

	// 遍历所有Activity并finish
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		
	}


	/**
	 * 判断当前版本是否兼容目标版本的方法
	 * 
	 * @param VersionCode
	 * @return
	 */
	public static boolean isMethodsCompat(int VersionCode) {
		int currentVersion = android.os.Build.VERSION.SDK_INT;
		return currentVersion >= VersionCode;
	}
	
	
	

	@Override
	public void onCreate() {
		super.onCreate();
		
		
		isDownload = true;
		// 注册全局异常处理器 
		CrashHandler crashHandler = CrashHandler.getInstance();  
        // 注册crashHandler  
        crashHandler.init(getApplicationContext());  
		//mGeofenceClient = new GeofenceClient(getApplicationContext());
		if(locationBean==null){
			locationBean = new LocationBean();
		}
		
		
		mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        // 发送以前没发送的报告(可选)  
//        crashHandler.sendPreviousReportsToServer();  
	}
	
	public boolean isDownload() {
		return isDownload;
	}

	public void setDownload(boolean isDownload) {
		this.isDownload = isDownload;
	}

	
	
	public interface NewMsgCountCallBack{
		void callBack();
	}



	public String getClientKey() {
		return clientKey;
	}
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	public String getRadomNum() {
		return radomNum;
	}
	public void setRadomNum(String radomNum) {
		this.radomNum = radomNum;
	}
	public boolean isIslogin() {
		return islogin;
	}
	public void setIslogin(boolean islogin) {
		this.islogin = islogin;
	}
	
	/***
	 * 
	* 授权码
	* @Title: getCode
	* @return
	* @return String
	* @throws
	* @author Leipeijie
	 */
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public DOCINVHISInLoginSrvOutputItem getStaffDict() {
		return staffDict;
	}

	public void setStaffDict(DOCINVHISInLoginSrvOutputItem staffDict) {
		this.staffDict = staffDict;
	}

	public ReportFormFragment getReportFormFragment() {
		return reportFormFragment;
	}

	public void setReportFormFragment(ReportFormFragment reportFormFragment) {
		this.reportFormFragment = reportFormFragment;
	}

	public CaseHistoryFragment getCaseHistoryFragment() {
		return caseHistoryFragment;
	}

	public void setCaseHistoryFragment(CaseHistoryFragment caseHistoryFragment) {
		this.caseHistoryFragment = caseHistoryFragment;
	}

	public UserInfoFragment getUserInfoFragment() {
		return userInfoFragment;
	}

	public void setUserInfoFragment(UserInfoFragment userInfoFragment) {
		this.userInfoFragment = userInfoFragment;
	}

	public PatientsListFragment getPatientListFragment() {
		return patientListFragment;
	}

	public void setPatientListFragment(PatientsListFragment patientListFragment) {
		this.patientListFragment = patientListFragment;
	}
	
	
}
