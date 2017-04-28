/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.widget.ImageButton;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.MyWebViewClient;
import com.doctorapp.doctorappclient.basic.ui.view.ProgressWebView;

/**
 * TODO
 * <p>Title: 浏览器访问电子病历页面</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebViewFragment extends BaseFragment implements Handler.Callback{
	private ProgressWebView webView;
	private ImageButton button_back;
	private TextView title;
	private String url;
	private String patient_id,visit_id,patient_name;
	private boolean flag = false;
	private View rootView;
	private WebViewFragment webViewFragment;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.basic_advert_fragment, container, false);
		initView();
		return rootView;
	}
	
	public WebViewFragment(String patient_id,String visit_id,String patient_name) {
		this.patient_id = patient_id;
		this.visit_id = visit_id;
		this.patient_name = patient_name;
	}
	
	public WebViewFragment() {
		super();
	}
	
	private void initView() {
		button_back = (ImageButton) rootView.findViewById(R.id.web_button_back);
		button_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getFragmentManager().popBackStack();
			}
		});
		
		title = (TextView) rootView.findViewById(R.id.web_title);
		title.setText(patient_name);
		
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		webView = (ProgressWebView) getView().findViewById(R.id.webView);
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
//		String url = "http://192.168.3.243/WebMr/Selected.aspx?PATIENT_ID="+patient_id+"&VISIT_ID="+visit_id;
//		String url = "http://www.sina.com";
		String url = "http://172.27.35.1:8080/html/html/contact.html";
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
		getMainActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE|  
	             WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		
	}
	
	@Override
	public boolean handleMessage(Message msg) {
		return false;
	}
	public ProgressWebView getWebView() {
		return webView;
	}
	
//	public void relapleRight(Map<Integer, Fragment> map){
//		listFragmentAsAnActioncommitAllowingStateLoss(map);
//	}
	
}
