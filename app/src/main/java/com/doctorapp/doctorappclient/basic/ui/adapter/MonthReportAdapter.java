/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.adapter;

import java.lang.reflect.Array;
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
 * <p>Title: MonthReportAdapter.java</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月19日上午9:03:03
 * @version 1.0
 * 
 */
public class MonthReportAdapter extends BaseAdapter{

	private List<DOCINVHISInQueryStatReportSrvOutputItem> monthReport = new LinkedList<DOCINVHISInQueryStatReportSrvOutputItem>();
	private Context context;
	private String[] array = {"总门诊量", "门诊量日均", "急诊量","急诊量日均", "入院人数", "出院人数", "治愈好转率", "病死率"};
	
	public MonthReportAdapter(List<DOCINVHISInQueryStatReportSrvOutputItem> monthReport, Context context) {
		super();
		this.context = context;
		this.monthReport = monthReport;
	}

	@Override
	public int getCount() {
		return array.length;
	}

	@Override
	public Object getItem(int position) {
		return array[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = LayoutInflater.from(context).inflate(R.layout.perm_item_layout, null);
		TextView tv_title = (TextView) view.findViewById(R.id.perm_title);
		TextView tv_month1 = (TextView) view.findViewById(R.id.perm_month1);
		TextView tv_month2 = (TextView) view.findViewById(R.id.perm_month2);
		TextView tv_tb = (TextView) view.findViewById(R.id.perm_tb);
		TextView tv_month3 = (TextView) view.findViewById(R.id.perm_month3);
		TextView tv_hb = (TextView) view.findViewById(R.id.perm_hb);
		
		if(position==0){
			tv_title.setText("总门诊量");
			tv_month1.setText(monthReport.get(0).getMZRS());
			tv_month2.setText(monthReport.get(1).getMZRS());
			tv_tb.setText(monthReport.get(3).getMZRS().startsWith("-")?(monthReport.get(3).getMZRS().replace("-", "")+"↓"):(monthReport.get(3).getMZRS()+"↑"));
			tv_month3.setText(monthReport.get(2).getMZRS());
			tv_hb.setText(monthReport.get(4).getMZRS().startsWith("-")?(monthReport.get(4).getMZRS().replace("-", "")+"↓"):(monthReport.get(4).getMZRS()+"↑"));
		}else if(position==1){
			tv_title.setText("日均门诊");
			tv_month1.setText(monthReport.get(0).getRJMZ());
			tv_month2.setText(monthReport.get(1).getRJMZ());
			tv_tb.setText(monthReport.get(3).getRJMZ().startsWith("-")?(monthReport.get(3).getRJMZ().replace("-", "")+"↓"):(monthReport.get(3).getRJMZ()+"↑"));
			tv_month3.setText(monthReport.get(2).getRJMZ());
			tv_hb.setText(monthReport.get(4).getRJMZ().startsWith("-")?(monthReport.get(4).getRJMZ().replace("-", "")+"↓"):(monthReport.get(4).getRJMZ()+"↑"));
		}else if(position==2){
			tv_title.setText("总急诊量");
			tv_month1.setText(monthReport.get(0).getJZRS());
			tv_month2.setText(monthReport.get(1).getJZRS());
			tv_tb.setText(monthReport.get(3).getJZRS().startsWith("-")?(monthReport.get(3).getJZRS().replace("-", "")+"↓"):(monthReport.get(3).getJZRS()+"↑"));
			tv_month3.setText(monthReport.get(2).getJZRS());
			tv_hb.setText(monthReport.get(4).getJZRS().startsWith("-")?(monthReport.get(4).getJZRS().replace("-", "")+"↓"):(monthReport.get(4).getJZRS()+"↑"));
		}else if(position==3){
			tv_title.setText("日均急诊");
			tv_month1.setText(monthReport.get(0).getRJJZ());
			tv_month2.setText(monthReport.get(1).getRJJZ());
			tv_tb.setText(monthReport.get(3).getRJJZ().startsWith("-")?(monthReport.get(3).getRJJZ().replace("-", "")+"↓"):(monthReport.get(3).getRJJZ()+"↑"));
			tv_month3.setText(monthReport.get(2).getRJJZ());
			tv_hb.setText(monthReport.get(4).getRJJZ().startsWith("-")?(monthReport.get(4).getRJJZ().replace("-", "")+"↓"):(monthReport.get(4).getRJJZ()+"↑"));
		}else if(position==4){
			tv_title.setText("入院人数");
			tv_month1.setText(monthReport.get(0).getRYRS());
			tv_month2.setText(monthReport.get(1).getRYRS());
			tv_tb.setText(monthReport.get(3).getRYRS().startsWith("-")?(monthReport.get(3).getRYRS().replace("-", "")+"↓"):(monthReport.get(3).getRYRS()+"↑"));
			tv_month3.setText(monthReport.get(2).getRYRS());
			tv_hb.setText(monthReport.get(4).getRYRS().startsWith("-")?(monthReport.get(4).getRYRS().replace("-", "")+"↓"):(monthReport.get(4).getMZRS()+"↑"));
		}else if(position==5){
			tv_title.setText("出院人数");
			tv_month1.setText(monthReport.get(0).getCYRS());
			tv_month2.setText(monthReport.get(1).getCYRS());
			tv_tb.setText(monthReport.get(3).getCYRS().startsWith("-")?(monthReport.get(3).getCYRS().replace("-", "")+"↓"):(monthReport.get(3).getCYRS()+"↑"));
			tv_month3.setText(monthReport.get(2).getCYRS());
			tv_hb.setText(monthReport.get(4).getCYRS().startsWith("-")?(monthReport.get(4).getCYRS().replace("-", "")+"↓"):(monthReport.get(4).getCYRS()+"↑"));
		}else if(position==6){
			tv_title.setText("好转率%");
			tv_month1.setText(monthReport.get(0).getZYHZL());
			tv_month2.setText(monthReport.get(1).getZYHZL());
			tv_tb.setText(monthReport.get(3).getZYHZL().startsWith("-")?(monthReport.get(3).getZYHZL().replace("-", "")+"↓"):(monthReport.get(3).getZYHZL()+"↑"));
			tv_month3.setText(monthReport.get(2).getZYHZL());
			tv_hb.setText(monthReport.get(4).getZYHZL().startsWith("-")?(monthReport.get(4).getZYHZL().replace("-", "")+"↓"):(monthReport.get(4).getZYHZL()+"↑"));
		}else if(position==7){
			tv_title.setText("病死率%");
			tv_month1.setText(monthReport.get(0).getBSL());
			tv_month2.setText(monthReport.get(1).getBSL());
			tv_tb.setText(monthReport.get(3).getBSL().startsWith("-")?(monthReport.get(3).getBSL().replace("-", "")+"↓"):(monthReport.get(3).getBSL()+"↑"));
			tv_month3.setText(monthReport.get(2).getBSL());
			tv_hb.setText(monthReport.get(4).getBSL().startsWith("-")?(monthReport.get(4).getBSL().replace("-", "")+"↓"):(monthReport.get(4).getBSL()+"↑"));
		}
		
		
		return view;
	}

	public List<DOCINVHISInQueryStatReportSrvOutputItem> getList() {
		return monthReport;
	}

	public void setList(List<DOCINVHISInQueryStatReportSrvOutputItem> monthReport) {
		this.monthReport = monthReport;
	}

}
