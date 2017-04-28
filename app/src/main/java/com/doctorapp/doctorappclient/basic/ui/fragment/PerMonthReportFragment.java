package com.doctorapp.doctorappclient.basic.ui.fragment;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.ksoap2.serialization.SoapObject;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.adapter.MonthReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
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
 * 单月数据查询页面
 * <p>Title: FragmentFour.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月20日上午9:48:02
 * @version 1.0
 * 
 */
public class PerMonthReportFragment extends BaseFragment {
	private View rootView;
	private Button pre_bnt,next_bnt;
	private TextView date_text;
	private TextView month1_text,month2_text,month3_text;
	private MonthReportAdapter monthAdapter;
	private ListView month_listView;
	private List<DOCINVHISInQueryStatReportSrvOutputItem> monthReport;
	private HashMap<String, Object> hashMap = new HashMap<String, Object>();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
	Calendar mycalendar=Calendar.getInstance(Locale.CHINA);
    Date mydate=new Date(); //获取当前日期Date对象
	private int year;
    private int month;
    private int day;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.permonth_reportform_layout, null);
			initView();	
		}
		return rootView;
	}


	private void initView() {
		//时间
		date_text = (TextView) rootView.findViewById(R.id.permonth_report_date);
        mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期
        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
		date_text.setText(year+"-"+(month));
		date_text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DatePickerDialog dpd=new DatePickerDialog(getActivity(),Datelistener,year,month,day);
                dpd.show();		
                //隐藏day选择
                DatePicker dp = findDatePicker((ViewGroup) dpd.getWindow().getDecorView());  
				if (dp != null) {  
				    ((ViewGroup)((ViewGroup) dp.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(View.GONE);  
				}   
			}
		});
		
		//前一月
		pre_bnt = (Button) rootView.findViewById(R.id.permonth_report_pre);
		pre_bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String year1 = date_text.getText().toString().split("-")[0];
				String month1 = date_text.getText().toString().split("-")[1];
				if(Integer.parseInt(month1)==1){
					year1 = String.valueOf(Integer.parseInt(year1)-1);
					month1 = "12";
				}else{
					month1 = String.valueOf(Integer.parseInt(month1)-1);
				}
				date_text.setText(year1+"-"+month1);
				year = Integer.parseInt(year1);
				month = Integer.parseInt(month1)-1;
				
				queryData(hashMap);
			}
		});
		
		//后一月
		next_bnt = (Button) rootView.findViewById(R.id.permonth_report_next);
		next_bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String year1 = date_text.getText().toString().split("-")[0];
				String month1 = date_text.getText().toString().split("-")[1];
				if(Integer.parseInt(month1)==12){
					year1 = String.valueOf(Integer.parseInt(year1)+1);
					month1 = "1";
				}else{
					month1 = String.valueOf(Integer.parseInt(month1)+1);
				}
				date_text.setText(year1+"-"+month1);
				year = Integer.parseInt(year1);
				month = Integer.parseInt(month1)-1;
				
				queryData(hashMap);
			}
		});
		month1_text = (TextView) rootView.findViewById(R.id.perm_report_month1);
		month2_text = (TextView) rootView.findViewById(R.id.perm_report_month2);
		month3_text = (TextView) rootView.findViewById(R.id.perm_report_month3);
		
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
            year=myyear;
            month=monthOfYear;
            //更新日期
            updateDate();
            
        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
    		date_text.setText(year+"-"+(month+1));
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
		hashMap.put("OPERATE_TYPE", "3");
		try {
			hashMap.put("MONTH_TIME", formatter.format(formatter.parse(date_text.getText().toString())));
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
//					ToastUtil.showToast(getActivity(), "服务器连接失败");
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
				if(response.getDOCINVHISInQueryStatReportSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryStatReportSrvOutputCollection().getDOCINVHISInQueryStatReportSrvOutputItem()!=null){
					monthReport = response.getDOCINVHISInQueryStatReportSrvOutputCollection().getDOCINVHISInQueryStatReportSrvOutputItem();
				}
				if(monthAdapter == null){
					if(monthReport.size()==5){
						initMonthReportView(monthReport);
					}else{
						initMonthReportView(null);
						ToastUtil.showToast(getActivity(), "暂无数据！");
					}
				}else{
					if(monthReport.size()==5){
						month1_text.setText(monthReport.get(0).getCXSJ());
						month2_text.setText(monthReport.get(1).getCXSJ());
						month3_text.setText(monthReport.get(2).getCXSJ());
						monthAdapter.setList(monthReport);
						monthAdapter.notifyDataSetChanged();
					}else{
						initMonthReportView(null);
						ToastUtil.showToast(getActivity(), "暂无数据！");
					}
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
	
	
	private void initMonthReportView(
			List<DOCINVHISInQueryStatReportSrvOutputItem> monthReport) {
		if(monthReport!=null){
			month1_text.setText(monthReport.get(0).getCXSJ());
			month2_text.setText(monthReport.get(1).getCXSJ());
			month3_text.setText(monthReport.get(2).getCXSJ());
			month_listView = (ListView) rootView.findViewById(R.id.prem_report_listView);
			if(monthAdapter == null){
				monthAdapter = new MonthReportAdapter(monthReport,getActivity());
			}else{
				monthAdapter.setList(monthReport);
			}
			month_listView.setAdapter(monthAdapter);
		}else{
			month1_text.setText("月份");
			month2_text.setText("月份");
			month3_text.setText("月份");
			month_listView = (ListView) rootView.findViewById(R.id.prem_report_listView);
			monthAdapter = null;
			month_listView.setAdapter(monthAdapter);
		}
		
	}
}
