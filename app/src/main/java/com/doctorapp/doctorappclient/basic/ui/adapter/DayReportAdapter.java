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
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv.DOCINVHISInQueryStatReportSrvOutputItem;
import com.doctorapp.doctorappclient.basic.ui.activity.MainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * TODO
 * <p>Title: DayReportAdapter.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月19日上午9:02:53
 * @version 1.0
 * 
 */
public class DayReportAdapter extends BaseAdapter{

	private List<DOCINVHISInQueryStatReportSrvOutputItem> dayReport = new LinkedList<DOCINVHISInQueryStatReportSrvOutputItem>();
	private Context context;
	
	public DayReportAdapter(List<DOCINVHISInQueryStatReportSrvOutputItem> dayReport, Context context) {
		super();
		this.dayReport = dayReport;
		this.context = context;
		SystemApplcation applcation = MainActivity.mainActivity.getSystemApplcation();
		if(dayReport !=null){
			String dept = applcation.getStaffDict().getDEPTCODE();
			DOCINVHISInQueryStatReportSrvOutputItem item0 = dayReport.size()>0?dayReport.get(0):new DOCINVHISInQueryStatReportSrvOutputItem();
		}
		this.dayReport = dayReport;
	}

	@Override
	public int getCount() {
		return dayReport==null?0:dayReport.size();
	}

	@Override
	public Object getItem(int position) {
		return dayReport==null?null:dayReport.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.dept_item_layout, null);
		TextView textView = (TextView) view.findViewById(R.id.dept_name);
		
		return view;
	}

	public List<DOCINVHISInQueryStatReportSrvOutputItem> getList() {
		return dayReport;
	}

	public void setList(List<DOCINVHISInQueryStatReportSrvOutputItem> depts) {
		this.dayReport = dayReport;
	}

}
