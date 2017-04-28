/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.widget.ImageButton;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.MyWebViewClient;
import com.doctorapp.doctorappclient.basic.ui.view.ProgressWebView;


/**
 * TODO
 * <p>Title: WebViewActivity.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2017年4月17日上午11:35:44
 * @version 1.0
 * 
 */
public class WebViewActivity extends BaseActivity{
	private String patient_id,patient_name,visit_id;
	private ProgressWebView webView;
	private ImageButton button_back;
	private TextView title;
	private String url;
	private boolean flag = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_advert_fragment);
		
		patient_id = getIntent().getStringExtra("patientid");
		patient_name = getIntent().getStringExtra("patientname");
		visit_id = getIntent().getStringExtra("visitid");
		initView();
	}

	private void initView() {
		button_back = (ImageButton)findViewById(R.id.web_button_back);
		button_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		title = (TextView)findViewById(R.id.web_title);
		title.setText(patient_name);
		
		webView = (ProgressWebView)findViewById(R.id.webView);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//		webView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NARROW_COLUMNS);
//		webView.getSettings().setUseWideViewPort(true);
//		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setDefaultTextEncodingName("UTF-8");
	    webView.getSettings().setSupportZoom(true); 
	    webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
		webView.setWebViewClient(new MyWebViewClient());
		String url = "http://192.168.3.243/WebMr/Selected.aspx?PATIENT_ID="+patient_id+"&VISIT_ID="+visit_id;
//		String url = "https://www.oschina.net/android";
//		String url = "http://172.27.35.1:8080/html/html/contact.html";
		if(flag){
			webView.getSettings().setDefaultTextEncodingName("UTF-8") ;
			webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
		}else{
			webView.loadUrl(url);
		}
		webView.setOnKeyListener(new View.OnKeyListener() {    
            @Override    
            public boolean onKey(View v, int keyCode, KeyEvent event) {    
                if (event.getAction() == KeyEvent.ACTION_DOWN) {    
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
                    	webView.goBack();   //后退    
                        return true;    //已处理    
                    }    
                }    
                return false;    
            }    
        });  
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE|  
	             WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
	}
}
