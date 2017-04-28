/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.ksoap2.serialization.SoapObject;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.adapter.DayReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.adapter.FewMonthReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.adapter.MonthReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerPopwindow;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
import com.doctorapp.doctorappclient.basic.ui.view.HorizontalListView;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.PopupWindow.OnDismissListener;

/**
 * 多月数据统计页面
 * <p>Title: FragmentFour.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月20日上午9:48:02
 * @version 1.0
 * 
 */
public class FewMonthReportFragment extends BaseFragment {
	private View rootView;
	private TextView sdate_text,edate_text;
	private TextView mzrs_text,jzrs_text,ryrs_text,cyrs_text,swrs_text,zyhz_text,rjmz_text,rjjz_text,zyhzl_text,bsl_text;
	private FewMonthReportAdapter fewmonthAdapter;
	private HorizontalListView month_listView;
	private List<DOCINVHISInQueryStatReportSrvOutputItem> monthsReport;
	private HashMap<String, Object> hashMap = new HashMap<String, Object>();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
	Calendar mycalendar=Calendar.getInstance(Locale.CHINA);
    Date mydate=new Date(); //获取当前日期Date对象
	private int syear,smonth,sday,eyear,emonth,eday;
    private int flag;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.fewmonth_reportform_layout, null);
			initView();	
		}
		return rootView;
	}


	private void initView() {
		//时间
		sdate_text = (TextView) rootView.findViewById(R.id.fewm_report_sdate);
		edate_text = (TextView) rootView.findViewById(R.id.fewm_report_edate);
		
        mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期
        syear=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        smonth=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        sday=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        eyear=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        emonth=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        eday=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        
        if(smonth-2==0){
        	sdate_text.setText((syear-1)+"-12");
        }else if(smonth-2==-1){
        	sdate_text.setText((syear-1)+"-11");
        }else{
        	sdate_text.setText(syear+"-"+(smonth-2));
        }
//        sdate_text.setText(syear+"-"+(smonth-2));
        edate_text.setText(eyear+"-"+(emonth));
        
        sdate_text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flag = 1;
				DatePickerDialog dpd=new DatePickerDialog(getActivity(),Datelistener,syear,smonth,sday);
                dpd.show();		
              //隐藏day选择
                DatePicker dp = findDatePicker((ViewGroup) dpd.getWindow().getDecorView());  
				if (dp != null) {  
				    ((ViewGroup)((ViewGroup) dp.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(View.GONE);  
				}   
			}
		});
        
        edate_text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flag = 2;
				DatePickerDialog dpd=new DatePickerDialog(getActivity(),Datelistener,eyear,emonth,eday);
                dpd.show();	
              //隐藏day选择
                DatePicker dp = findDatePicker((ViewGroup) dpd.getWindow().getDecorView());  
				if (dp != null) {  
				    ((ViewGroup)((ViewGroup) dp.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(View.GONE);  
				}   
			}
		});
		
		queryData(hashMap);
	}

	private DatePicker findDatePicker(ViewGroup group) {  
        if (group != null) {  
            for (int i = 0, j = group.getChildCount(); i < j; i++) {  
                View child = group.getChildAt(i);  
                if (child instanceof DatePicker) {  
                    return (DatePicker) child;  
                } else if (child instanceof ViewGroup) {  
                    DatePicker result = findDatePicker((ViewGroup) child);  
                    if (result != null)  
                        return result;  
                }  
            }  
        }  
        return null;  
    }   
	
	private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int myyear, int monthOfYear,int dayOfMonth) {
            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
        	if(flag==1){
        		syear=myyear;
                smonth=monthOfYear;
        	}else{
        		eyear=myyear;
                emonth=monthOfYear;
        	}
            //更新日期
            updateDate();
            
        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
        	if(flag==1){
        		sdate_text.setText(syear+"-"+(smonth+1));
        	}else{
        		edate_text.setText(eyear+"-"+(emonth+1));
        	}
    		
        	queryData(hashMap);
        }
    };
    
    
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		initViews(getView());
	}
	
	
	private void queryData(HashMap<String, Object> hashMap) {
		hashMap = new HashMap<String, Object>();
		hashMap.put("OPERATE_TYPE", "4");
		try {
			if(formatter.parse(sdate_text.getText().toString()).after(formatter.parse(edate_text.getText().toString()))){
				ToastUtil.showToast(getActivity(), "起始时间不能在截止时间之后！");
				return;
			}else{
				hashMap.put("START_TIME", sdate_text.getText().toString());
				hashMap.put("END_TIME", edate_text.getText().toString());
			}
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		final CustomerProgress customerProgress =  new CustomerProgress(getActivity(),R.style.customer_dialog);
		NetWorkHepler.postWsData("InQueryStatReportSrvWs","process",hashMap, new INetWorkCallBack() {
			private SoapObject objectResult;	
			@Override
			public void onResult(Object result) {
				customerProgress.dismissDialog(customerProgress);
				if(result == null){
					ToastUtil.showToast(getActivity(), "查询数据出错请重新查询！");
					return;
				}if(result instanceof SoapObject){
					objectResult = (SoapObject) result;
				}else{
					ToastUtil.showToast(getActivity(), "服务器连接失败");
					return;
				}
				DOCINVHISInQueryStatReportSrvResponse response = new DOCINVHISInQueryStatReportSrvResponse();
				try {
					for(int i=0;i<objectResult.getPropertyCount();i++){
						response.setProperty(i, objectResult.getProperty(i));
					}
				} catch (Exception e) {
					ToastUtil.showToast(getActivity(), "遇到了点麻烦出错了，请重试！");
				}
				monthsReport = null;
				if(response.getDOCINVHISInQueryStatReportSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryStatReportSrvOutputCollection().getDOCINVHISInQueryStatReportSrvOutputItem()!=null){
					monthsReport = response.getDOCINVHISInQueryStatReportSrvOutputCollection().getDOCINVHISInQueryStatReportSrvOutputItem();
				}
				if(monthsReport != null){
					initMonthsReportView(monthsReport);
				}else{
					initMonthsReportView(null);
				}
				
			}
			

			@Override
			public void onPreExecute() {
				customerProgress.show();
			}

			@Override
			public void onProgressUpdate(Integer[] values) {
			}
			
		});
	}
	
	
	private void initMonthsReportView(
			List<DOCINVHISInQueryStatReportSrvOutputItem> monthsReport) {
		if(null!=monthsReport){
			month_listView = (HorizontalListView) rootView.findViewById(R.id.frem_report_listView);
			if(fewmonthAdapter == null){
				fewmonthAdapter = new FewMonthReportAdapter(monthsReport,getActivity());
			}else{
				fewmonthAdapter.setList(monthsReport);
			}
			month_listView.setAdapter(fewmonthAdapter);
			
		}else{
			List<DOCINVHISInQueryStatReportSrvOutputItem> items = new ArrayList<DOCINVHISInQueryStatReportSrvOutputItem>();
			month_listView = (HorizontalListView) rootView.findViewById(R.id.frem_report_listView);
			if(fewmonthAdapter == null){
				fewmonthAdapter = new FewMonthReportAdapter(items,getActivity());
			}else{
				fewmonthAdapter.setList(items);
			}
			month_listView.setAdapter(fewmonthAdapter);
		}
		
	}
}
