/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.adapter;

import java.util.LinkedList;
import java.util.List;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvOutputItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * TODO
 * <p>Title: FewMonthReportAdapter.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月21日下午2:57:35
 * @version 1.0
 * 
 */
public class FewMonthReportAdapter extends BaseAdapter{

	private List<DOCINVHISInQueryStatReportSrvOutputItem> monthsReport = new LinkedList<DOCINVHISInQueryStatReportSrvOutputItem>();
	private Context context;
	
	public FewMonthReportAdapter(List<DOCINVHISInQueryStatReportSrvOutputItem> monthsReport, Context context) {
		super();
		this.context = context;
		this.monthsReport = monthsReport;
	}

	@Override
	public int getCount() {
		return monthsReport==null?0:monthsReport.size();
	}

	@Override
	public Object getItem(int position) {
		return monthsReport==null?0:monthsReport.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.fewm_item_layout, null);
		TextView tv_date = (TextView) view.findViewById(R.id.fewm_item_date);
		TextView tv_mzrs = (TextView) view.findViewById(R.id.fewm_item_mzrs);
		TextView tv_rjmz = (TextView) view.findViewById(R.id.fewm_item_rjmz);
		TextView tv_jzrs = (TextView) view.findViewById(R.id.fewm_item_jzrs);
		TextView tv_rjjz = (TextView) view.findViewById(R.id.fewm_item_rjjz);
		TextView tv_ryrs = (TextView) view.findViewById(R.id.fewm_item_ryrs);
		TextView tv_cyrs = (TextView) view.findViewById(R.id.fewm_item_cyrs);
		TextView tv_zyhzl = (TextView) view.findViewById(R.id.fewm_item_zyhzl);
		TextView tv_bsl = (TextView) view.findViewById(R.id.fewm_item_bsl);
		
		DOCINVHISInQueryStatReportSrvOutputItem monthReport = new DOCINVHISInQueryStatReportSrvOutputItem();
		monthReport = monthsReport.get(position);
		if(monthReport!=null){
			tv_date.setText(monthReport.getCXSJ());
			tv_mzrs.setText(monthReport.getMZRS());
			tv_rjmz.setText(monthReport.getRJMZ());
			tv_jzrs.setText(monthReport.getJZRS());
			tv_rjjz.setText(monthReport.getRJJZ());
			tv_ryrs.setText(monthReport.getRYRS());
			tv_cyrs.setText(monthReport.getCYRS());
			tv_zyhzl.setText(monthReport.getZYHZL());
			tv_bsl.setText(monthReport.getBSL());
		}
		
		return view;
	}

	public List<DOCINVHISInQueryStatReportSrvOutputItem> getList() {
		return monthsReport;
	}

	public void setList(List<DOCINVHISInQueryStatReportSrvOutputItem> monthsReport) {
		this.monthsReport = monthsReport;
	}

}
