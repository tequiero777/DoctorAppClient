package com.doctorapp.doctorappclient.basic.ui.fragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.ksoap2.serialization.SoapObject;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.adapter.MonthReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;
/**
 * 单日数据查询页面
 * <p>Title: FragmentOne.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月20日上午9:48:02
 * @version 1.0
 * 
 */
public class PerDayReportFragment extends BaseFragment {
	private View rootView;
	private View popuRootView;
	private Button pre_bnt,next_bnt,setting_btn,pop_sure_btn;
	private TextView date_text,pop_startdate_text,pop_enddate_text;
	private TextView mzrs_text,jzrs_text,ryrs_text,cyrs_text,swrs_text,zyhz_text;
	private PopupWindow popupWindow;
	private MonthReportAdapter monthAdapter;
	private ListView day_listView;
	private List<DOCINVHISInQueryStatReportSrvOutputItem> dayReport;
	private HashMap<String, Object> hashMap = new HashMap<String, Object>();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar mycalendar=Calendar.getInstance(Locale.CHINA);
    Date mydate=new Date(); //获取当前日期Date对象
	private int year;
    private int month;
    private int day;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.perday_reportform_layout, null);
			initView();	
		}
		return rootView;
	}


	private void initView() {
		mzrs_text = (TextView) rootView.findViewById(R.id.mzrs_value);
		jzrs_text = (TextView) rootView.findViewById(R.id.jzrs_value);
		ryrs_text = (TextView) rootView.findViewById(R.id.ryrs_value);
		cyrs_text = (TextView) rootView.findViewById(R.id.cyrs_value);
		swrs_text = (TextView) rootView.findViewById(R.id.swrs_value);
		zyhz_text = (TextView) rootView.findViewById(R.id.zyhz_value);
		
		//时间
		date_text = (TextView) rootView.findViewById(R.id.report_date);
        mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期
        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
		date_text.setText(year+"-"+(month+1)+"-"+day);
		date_text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DatePickerDialog dpd=new DatePickerDialog(getActivity(),Datelistener,year,month,day);
                dpd.show();				
			}
		});
		
		//前一天
		pre_bnt = (Button) rootView.findViewById(R.id.report_pre);
		pre_bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Date newDate = null;
				try {
					newDate = new Date((formatter.parse(date_text.getText().toString())).getTime() - 1 * 24 * 60 * 60 * 1000);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mycalendar.setTime(newDate);
		        year=mycalendar.get(Calendar.YEAR); 
		        month=mycalendar.get(Calendar.MONTH);
		        day=mycalendar.get(Calendar.DAY_OF_MONTH);
				date_text.setText(year+"-"+(month+1)+"-"+day);
				
				queryData(hashMap);
			}
		});
		
		//后一天
		next_bnt = (Button) rootView.findViewById(R.id.report_next);
		next_bnt.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Date newDate = null;
				try {
					newDate = new Date((formatter.parse(date_text.getText().toString())).getTime() + 1 * 24 * 60 * 60 * 1000);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				mycalendar.setTime(newDate);
		        year=mycalendar.get(Calendar.YEAR); 
		        month=mycalendar.get(Calendar.MONTH);
		        day=mycalendar.get(Calendar.DAY_OF_MONTH);
				date_text.setText(year+"-"+(month+1)+"-"+day);
				
				queryData(hashMap);
			}
		});
		
//		setting_btn = (Button) rootView.findViewById(R.id.setting_btn);
//		setting_btn.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				showPopuMenus();
//			}
//		});
		
		queryData(hashMap);
	}

	private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int myyear, int monthOfYear,int dayOfMonth) {
            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
            year=myyear;
            month=monthOfYear;
            day=dayOfMonth;
            //更新日期
            updateDate();
            
        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
    		date_text.setText(year+"-"+(month+1)+"-"+day);
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
		hashMap.put("OPERATE_TYPE", "1");
		try {
			hashMap.put("DAY_TIME", formatter.format(formatter.parse(date_text.getText().toString())));
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
				if(response.getDOCINVHISInQueryStatReportSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryStatReportSrvOutputCollection().getDOCINVHISInQueryStatReportSrvOutputItem()!=null){
					dayReport = response.getDOCINVHISInQueryStatReportSrvOutputCollection().getDOCINVHISInQueryStatReportSrvOutputItem();
				}
				if(dayReport != null){
					initDayReportView(dayReport.get(0));
				}else{
					initDayReportView(null);
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
	
	
	@SuppressLint("ResourceAsColor") 
	private void initDayReportView(
			DOCINVHISInQueryStatReportSrvOutputItem item) {
		if(item!=null){
			if(null!=item.getMZRS() && !item.getMZRS().equals("null")){
				mzrs_text.setText(item.getMZRS());
				mzrs_text.setTextColor(Color.parseColor("#656565"));
			}else{
				mzrs_text.setText("暂无数据！");
				mzrs_text.setTextColor(Color.RED);
			}
			if(null!=item.getJZRS() && !item.getJZRS().equals("null")){
				jzrs_text.setText(item.getJZRS());
				jzrs_text.setTextColor(Color.parseColor("#656565"));
			}else{
				jzrs_text.setText("暂无数据！");
				jzrs_text.setTextColor(Color.RED);
			}
			if(null!=item.getRYRS() && !item.getRYRS().equals("null")){
				ryrs_text.setText(item.getRYRS());
				ryrs_text.setTextColor(Color.parseColor("#656565"));
			}else{
				ryrs_text.setText("暂无数据！");
				ryrs_text.setTextColor(Color.RED);
			}
			if(null!=item.getCYRS() && !item.getCYRS().equals("null")){
				cyrs_text.setText(item.getCYRS());
				cyrs_text.setTextColor(Color.parseColor("#656565"));
			}else{
				cyrs_text.setText("暂无数据！");
				cyrs_text.setTextColor(Color.RED);
			}
			if(null!=item.getSWRS() && !item.getSWRS().equals("null")){
				swrs_text.setText(item.getSWRS());
				swrs_text.setTextColor(Color.parseColor("#656565"));
			}else{
				swrs_text.setText("暂无数据！");
				swrs_text.setTextColor(Color.RED);
			}
			if(null!=item.getZYHZ() && !item.getZYHZ().equals("null")){
				zyhz_text.setText(item.getZYHZ());
				zyhz_text.setTextColor(Color.parseColor("#656565"));
			}else{
				zyhz_text.setText("暂无数据！");
				zyhz_text.setTextColor(Color.RED);
			}
		}else{
			mzrs_text.setText("暂无数据！");
			jzrs_text.setText("暂无数据！");
			ryrs_text.setText("暂无数据！");
			cyrs_text.setText("暂无数据！");
			swrs_text.setText("暂无数据！");
			zyhz_text.setText("暂无数据！");
			mzrs_text.setTextColor(Color.RED);
			jzrs_text.setTextColor(Color.RED);
			ryrs_text.setTextColor(Color.RED);
			cyrs_text.setTextColor(Color.RED);
			swrs_text.setTextColor(Color.RED);
			zyhz_text.setTextColor(Color.RED);
		}
		
	}
}
