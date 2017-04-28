package com.doctorapp.doctorappclient.basic.ui.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;

/**
 * TODO
 * <p>Title: 关于我们</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月25日上午11:31:43
 * @version 1.0
 * 
 */
public class AboutActivity extends BaseActivity {
	private TextView versions_no;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_actvity);
		versions_no = (TextView) findViewById(R.id.versions_no);
		TextView title = (TextView) findViewById(R.id.title);
		title.setText("关于我们");
		ImageButton ib_back = (ImageButton) findViewById(R.id.backImg);
		ib_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		initViews();
	/*	MobclickAgent.setDebugMode(true);
		MobclickAgent.openActivityDurationTrack(false);
		MobclickAgent.updateOnlineConfig(this);*/
	}
	
	private void initViews(){
		final PackageInfo pi;
		try {
			pi = getPackageManager().getPackageInfo(this.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return;
		}  
		String jsonStr = "版本号：v "+pi.versionName;
		versions_no.setText(jsonStr);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
	
	/*public void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
		}
		public void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
		}*/
	
}
