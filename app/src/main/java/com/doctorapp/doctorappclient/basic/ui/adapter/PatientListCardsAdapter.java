/**
 * Copyright (c) 2015 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.adapter;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv.DOCINVHISInQueryPatientSrvOutputItem;

/**
 * 患者信息卡的 adapter
 * <p>Title: PatientListCardsAdapter.java</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Leipeijie
 * @date 2016年7月18日下午2:09:29
 * @version 1.0
 * 
 */
public class PatientListCardsAdapter extends BaseAdapter{
	/**患者信息卡 需要的info  list**/
	private List<DOCINVHISInQueryPatientSrvOutputItem>  patientInfos = new LinkedList<DOCINVHISInQueryPatientSrvOutputItem>();
	/**context**/
	private Context myContext;
	public PatientListCardsAdapter(List<DOCINVHISInQueryPatientSrvOutputItem>  patientInfos,
			Context myContext) {
		super();
		this.patientInfos = patientInfos;
		this.myContext = myContext;
	}

	@Override
	public int getCount() {
		return patientInfos ==null ? 0:patientInfos.size();
	}

	@Override
	public Object getItem(int position) {
		return patientInfos ==null ? null : patientInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getAdapterView(position, convertView, parent);
	}
	
	private View getAdapterView(int position, View convertView, ViewGroup parent){
		View  view = LayoutInflater.from(myContext).inflate(R.layout.mobile_rounds_patient_list_item, null);
			initInfos(position, view);
		return view;
		
	}
	
	/**
	*TODO
	* @Title: initInfos
	* @param position
	* @param view
	* @return void
	* @throws
	* @author Leipeijie
	*/
	private void initInfos(int position, View view) {
		TextView nurseLevel = (TextView) view.findViewById(R.id.patient_bottom_card_level); 
		ImageView nameIamg = (ImageView) view.findViewById(R.id.patient_card_img); 
		TextView name = (TextView) view.findViewById(R.id.patient_bottom_card_name);
		TextView dateText = (TextView) view.findViewById(R.id.patient_bottom_card_date); 
		TextView cardNumber = (TextView) view.findViewById(R.id.medical_record_number); 
		TextView bedNo = (TextView) view.findViewById(R.id.patient_bed_no); 
		TextView diagnosis = (TextView) view.findViewById(R.id.patient_card_diagnosis); 
		TextView patientName = (TextView) view.findViewById(R.id.patient_card_name); 
		TextView patientAge = (TextView) view.findViewById(R.id.patient_card_age); 
		LinearLayout layout = (LinearLayout) view.findViewById(R.id.patient_card_bottom);
		
		
		
		cardNumber.setText(patientInfos.get(position).getPATIENTID());
		String level = patientInfos.get(position).getNURSINGCLASS();
		name.setText(patientInfos.get(position).getDOCTORINCHARGE());
		dateText.setText(patientInfos.get(position).getADMISSIONDATETIME());
		bedNo.setText(patientInfos.get(position).getBEDNO()+"床");
		diagnosis.setText(patientInfos.get(position).getDIAGNOSIS());
		patientName.setText(patientInfos.get(position).getPATIENTNAME());
		patientAge.setText(patientInfos.get(position).getAGE()+"岁");
		String sex = patientInfos.get(position).getSEX();
		
		if("女".equals(sex)){
			nameIamg.setImageResource(R.drawable.patient_women);
		}else{
			nameIamg.setImageResource(R.drawable.patient_man);
		}
		nurseLevel.setText(level);
		if("特级护理".equals(level)){
			layout.setBackgroundResource(R.drawable.patient_card_bottom_red);
		}else if("一级护理".equals(level)){
			layout.setBackgroundResource(R.drawable.patient_card_bottom_yellow);
		}else if("二级护理".equals(level)){
			layout.setBackgroundResource(R.drawable.patient_card_bottom_purple);
		}else if("三级护理".equals(level)){
			layout.setBackgroundResource(R.drawable.patient_card_bottom_green);
		}else {
			layout.setBackgroundResource(R.drawable.patient_card_null_bac);
		}
	}

	public List<DOCINVHISInQueryPatientSrvOutputItem> getPatientInfos() {
		return patientInfos;
	}

	public void setPatientInfos(List<DOCINVHISInQueryPatientSrvOutputItem> patientInfos) {
		this.patientInfos = patientInfos;
	}

}
