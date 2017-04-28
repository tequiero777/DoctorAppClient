package com.doctorapp.doctorappclient.basic.ui.activity;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.ui.fragment.CaseHistoryFragment;
import com.doctorapp.doctorappclient.basic.ui.fragment.ReportFormFragment;
import com.doctorapp.doctorappclient.basic.ui.fragment.UserInfoFragment;

/**
 * TODO
 * <p>Title: 主界面</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */

public class MainActivity extends FragmentActivity{
	private RadioGroup radioGroup;
	private RadioButton radio_home;
	private FragmentManager fragmentManager;
	private Handler handler;
	private SystemApplcation systemApplcation;
	public static String FROM = null;
	public static MainActivity mainActivity ;
	private ReportFormFragment reportFormFragment;
	private CaseHistoryFragment caseHistoryFragment;
	private UserInfoFragment userInfoFragment;
	private int loginflag;
	
	public static void setFROM(String fROM) {
		FROM = fROM;
	}

	/**线程永久执行标识位*/
	private boolean threadFlag = false;
	
	
	public Handler getHandler() {
		return handler;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_main);
		systemApplcation = (SystemApplcation) getApplication();
		systemApplcation.addActivity(this);
		mainActivity = this;
		
		Intent intent = getIntent();
		loginflag = intent.getIntExtra("loginflag", 0);
		initView();
	}

	private void initView(){
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		radio_home = (RadioButton) findViewById(R.id.home);
		
		//如果不是管理员 隐藏数据报表界面
		if(loginflag!=1){
			radioGroup.check(R.id.dict);
			radio_home.setVisibility(View.GONE);
			caseHistoryFragment = new CaseHistoryFragment();
			showFragment(caseHistoryFragment);
			systemApplcation.setCaseHistoryFragment(caseHistoryFragment);
		}else{
			radioGroup.check(R.id.home);
			reportFormFragment = new ReportFormFragment();
			showFragment(reportFormFragment);
			systemApplcation.setReportFormFragment(reportFormFragment);
		}
		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.home://数据报表
					if(null!=systemApplcation.getReportFormFragment()){
						showFragment(systemApplcation.getReportFormFragment());
					}else{
						reportFormFragment = new ReportFormFragment();
						systemApplcation.setReportFormFragment(reportFormFragment);
						showFragment(reportFormFragment);
					}
					break;
				case R.id.dict://电子病历
					if(null!=systemApplcation.getCaseHistoryFragment() && systemApplcation.getPatientListFragment()==null){
						showFragment(systemApplcation.getCaseHistoryFragment());
					}else if(null!=systemApplcation.getCaseHistoryFragment() && null!=systemApplcation.getPatientListFragment()){
						showFragment(systemApplcation.getPatientListFragment());
					}else{
						caseHistoryFragment = new CaseHistoryFragment();
						systemApplcation.setCaseHistoryFragment(caseHistoryFragment);
						showFragment(caseHistoryFragment);
					}
					break;
				case R.id.my://个人中心
					if(null!=systemApplcation.getUserInfoFragment()){
						showFragment(systemApplcation.getUserInfoFragment());
					}else{
						userInfoFragment = new UserInfoFragment();
						systemApplcation.setUserInfoFragment(userInfoFragment);
						showFragment(userInfoFragment);
					}
					break;
				}
			}
		});
		
	}
		

	public void showFragment(Fragment f) {
		if (fragmentManager == null) {
			fragmentManager = getSupportFragmentManager();
		}
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.mainFrameLayout, f);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
	
	@Override
	public void onBackPressed() {
		Builder builder = new Builder(this);
		builder.setTitle("退出提示");
		builder.setMessage("确定要退出吗？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				SystemApplcation sys = (SystemApplcation)getMainActivity().getApplication();
				sys.exit();
				sys = null;
				
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}
	

	
	@Override
	protected void onDestroy() {
		threadFlag = false;
		((SystemApplcation)getApplication()).setCallBack(null);
		super.onDestroy();
	}


	public static Activity getMainActivity(){
		return mainActivity;
		
	}

	public SystemApplcation getSystemApplcation() {
		return systemApplcation;
	}

	public void setSystemApplcation(SystemApplcation systemApplcation) {
		this.systemApplcation = systemApplcation;
	}
	
}
