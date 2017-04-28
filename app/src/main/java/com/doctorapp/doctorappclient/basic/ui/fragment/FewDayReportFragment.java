package com.doctorapp.doctorappclient.basic.ui.fragment;

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
import com.doctorapp.doctorappclient.basic.ui.adapter.DayReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.adapter.MonthReportAdapter;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerPopwindow;
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
 * 多日数据统计页面
 * <p>Title: FragmentTwo.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月20日上午9:48:02
 * @version 1.0
 * 
 */
public class FewDayReportFragment extends BaseFragment {
	private View rootView;
	private TextView sdate_text,edate_text;
	private TextView mzrs_text,jzrs_text,ryrs_text,cyrs_text,swrs_text,zyhz_text,rjmz_text,rjjz_text,zyhzl_text,bsl_text;
	private List<DOCINVHISInQueryStatReportSrvOutputItem> dayReport;
	private HashMap<String, Object> hashMap = new HashMap<String, Object>();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	Calendar mycalendar=Calendar.getInstance(Locale.CHINA);
    Date mydate=new Date(); //获取当前日期Date对象
	private int syear,smonth,sday,eyear,emonth,eday;
    private int flag;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.fewday_reportform_layout, null);
			initView();	
		}
		return rootView;
	}


	private void initView() {
		mzrs_text = (TextView) rootView.findViewById(R.id.fewd_mzrs_value);
		jzrs_text = (TextView) rootView.findViewById(R.id.fewd_jzrs_value);
		ryrs_text = (TextView) rootView.findViewById(R.id.fewd_ryrs_value);
		cyrs_text = (TextView) rootView.findViewById(R.id.fewd_cyrs_value);
		swrs_text = (TextView) rootView.findViewById(R.id.fewd_swrs_value);
		zyhz_text = (TextView) rootView.findViewById(R.id.fewd_zyhz_value);
		rjmz_text =  (TextView) rootView.findViewById(R.id.fewd_rjmz_value);
		rjjz_text = (TextView) rootView.findViewById(R.id.fewd_rjjz_value);
		zyhzl_text = (TextView) rootView.findViewById(R.id.fewd_zyhzl_value);
		bsl_text = (TextView) rootView.findViewById(R.id.fewd_bsl_value);
		
		//时间
		sdate_text = (TextView) rootView.findViewById(R.id.fewd_report_sdate);
		edate_text = (TextView) rootView.findViewById(R.id.fewd_report_edate);
		
        mycalendar.setTime(mydate);////为Calendar对象设置时间为当前日期
        syear=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        smonth=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        sday=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        eyear=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        emonth=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        eday=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        
        sdate_text.setText(syear+"-"+(smonth+1)+"-"+sday);
        edate_text.setText(eyear+"-"+(emonth+1)+"-"+eday);
        
        sdate_text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flag = 1;
				DatePickerDialog dpd=new DatePickerDialog(getActivity(),Datelistener,syear,smonth,sday);
                dpd.show();				
			}
		});
        
        edate_text.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				flag = 2;
				DatePickerDialog dpd=new DatePickerDialog(getActivity(),Datelistener,eyear,emonth,eday);
                dpd.show();				
			}
		});
		
		queryData(hashMap);
	}

	private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener()
    {
        @Override
        public void onDateSet(DatePicker view, int myyear, int monthOfYear,int dayOfMonth) {
            //修改year、month、day的变量值，以便以后单击按钮时，DatePickerDialog上显示上一次修改后的值
        	if(flag==1){
        		syear=myyear;
                smonth=monthOfYear;
                sday=dayOfMonth;
        	}else{
        		eyear=myyear;
                emonth=monthOfYear;
                eday=dayOfMonth;
        	}
            //更新日期
            updateDate();
            
        }
        //当DatePickerDialog关闭时，更新日期显示
        private void updateDate()
        {
            //在TextView上显示日期
        	if(flag==1){
        		sdate_text.setText(syear+"-"+(smonth+1)+"-"+sday);
        	}else{
        		edate_text.setText(eyear+"-"+(emonth+1)+"-"+eday);
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
		hashMap.put("OPERATE_TYPE", "2");
		try {
			if(formatter.parse(sdate_text.getText().toString()).after(formatter.parse(edate_text.getText().toString()))){
				ToastUtil.showToast(getActivity(), "起始时间不能在截止时间之后！");
				return;
			}else{
				hashMap.put("START_TIME", formatter.format(formatter.parse(sdate_text.getText().toString())));
				hashMap.put("END_TIME", formatter.format(formatter.parse(edate_text.getText().toString())));
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
			if(null!=item.getRJMZ() && !item.getRJMZ().equals("null")){
				rjmz_text.setText(item.getRJMZ());
				rjmz_text.setTextColor(Color.parseColor("#656565"));
			}else{
				rjmz_text.setText("暂无数据！");
				rjmz_text.setTextColor(Color.RED);
			}
			if(null!=item.getRJJZ() && !item.getRJJZ().equals("null")){
				rjjz_text.setText(item.getRJJZ());
				rjjz_text.setTextColor(Color.parseColor("#656565"));
			}else{
				rjjz_text.setText("暂无数据！");
				rjjz_text.setTextColor(Color.RED);
			}
			if(null!=item.getZYHZL() && !item.getZYHZL().equals("null")){
				zyhzl_text.setText(item.getZYHZL()+"%");
				zyhzl_text.setTextColor(Color.parseColor("#656565"));
			}else{
				zyhzl_text.setText("暂无数据！");
				zyhzl_text.setTextColor(Color.RED);
			}
			if(null!=item.getBSL() && !item.getBSL().equals("null")){
				bsl_text.setText(item.getBSL()+"%");
				bsl_text.setTextColor(Color.parseColor("#656565"));
			}else{
				bsl_text.setText("暂无数据！");
				bsl_text.setTextColor(Color.RED);
			}
		}else{
			mzrs_text.setText("暂无数据！");
			jzrs_text.setText("暂无数据！");
			ryrs_text.setText("暂无数据！");
			cyrs_text.setText("暂无数据！");
			swrs_text.setText("暂无数据！");
			zyhz_text.setText("暂无数据！");
			rjmz_text.setText("暂无数据！");
			rjjz_text.setText("暂无数据！");
			zyhzl_text.setText("暂无数据！");
			bsl_text.setText("暂无数据！");
			mzrs_text.setTextColor(Color.RED);
			jzrs_text.setTextColor(Color.RED);
			ryrs_text.setTextColor(Color.RED);
			cyrs_text.setTextColor(Color.RED);
			swrs_text.setTextColor(Color.RED);
			zyhz_text.setTextColor(Color.RED);
			rjmz_text.setTextColor(Color.RED);
			rjjz_text.setTextColor(Color.RED);
			zyhzl_text.setTextColor(Color.RED);
			bsl_text.setTextColor(Color.RED);
		}
		
	}
}
