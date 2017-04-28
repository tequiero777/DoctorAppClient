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

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.bean.InQueryDeptSrv.DOCINVHISInQueryDeptSrvOutputItem;
import com.doctorapp.doctorappclient.basic.ui.activity.MainActivity;

/**
 * 科室的adapter
 * <p>Title: DeptAdapter.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Leipeijie
 * @date 2015年7月13日下午4:20:17
 * @version 1.0
 * 
 */
public class DeptAdapter extends BaseAdapter{

	private List<DOCINVHISInQueryDeptSrvOutputItem> depts = new LinkedList<DOCINVHISInQueryDeptSrvOutputItem>();
	private Context context;
	
	public DeptAdapter(List<DOCINVHISInQueryDeptSrvOutputItem> depts, Context context) {
		super();
		this.depts = depts;
		this.context = context;
		SystemApplcation applcation = MainActivity.mainActivity.getSystemApplcation();
		if(depts !=null){
			String dept = applcation.getStaffDict().getDEPTCODE();
			DOCINVHISInQueryDeptSrvOutputItem item0 = depts.size()>0?depts.get(0):new DOCINVHISInQueryDeptSrvOutputItem();
		}
		this.depts = depts;
	}

	@Override
	public int getCount() {
		return depts==null?0:depts.size();
	}

	@Override
	public Object getItem(int position) {
		return depts==null?null:depts.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.dept_item_layout, null);
		TextView textView = (TextView) view.findViewById(R.id.dept_name);
		textView.setText(depts.get(position).getDEPTNAME()+"");
		
		return view;
	}

	public List<DOCINVHISInQueryDeptSrvOutputItem> getDepts() {
		return depts;
	}

	public void setDepts(List<DOCINVHISInQueryDeptSrvOutputItem> depts) {
		this.depts = depts;
	}

}
