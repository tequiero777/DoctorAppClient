/**
 * Copyright (c) 2013 Tianjian, Inc. All rights reserved.
 * This software is the confidential and proprietary information of 
 * Tianjian, Inc. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the 
 * license agreement you entered into with Tianjian.
 */
package com.doctorapp.doctorappclient.basic.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ksoap2.serialization.SoapObject;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryDeptSrv.DOCINVHISInQueryDeptSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryDeptSrv.DOCINVHISInQueryDeptSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.adapter.DeptAdapter;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;

/**
 * TODO
 * <p>Title: 电子病历</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */
public class CaseHistoryFragment extends BaseFragment implements OnClickListener{
	private View rootView;
	private DeptAdapter adapter;
	private GridView listView;
	private HashMap<String, Object> hashMap = new HashMap<String, Object>();
	private List<DOCINVHISInQueryDeptSrvOutputItem> depts;
	private List<DOCINVHISInQueryDeptSrvOutputItem> depts_temp;
	private EditText search_et_input;
	private ImageView search_iv_delete;
	private SystemApplcation systemApplcation;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.casehistory_layout, null);
			init();	
		}else if(adapter ==null || adapter.getDepts() == null ||adapter.getDepts().size()==0){
			queryData(hashMap);
		}
		return rootView;
	}

	private void init() {
		systemApplcation = (SystemApplcation) getActivity().getApplication();
		
		//搜索框删除按钮
		search_iv_delete = (ImageView) rootView.findViewById(R.id.search_iv_delete);
		search_iv_delete.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				search_et_input.setText("");
				search_iv_delete.setVisibility(View.GONE);
			}
		});
		
		//搜索框Edittext
		search_et_input = (EditText) rootView.findViewById(R.id.search_et_input);
		search_et_input.addTextChangedListener(new EditChangedListener());
		search_et_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    notifyStartSearching(search_et_input.getText().toString());
                }
                return true;
            }
        });
			
		
		listView = (GridView) rootView.findViewById(R.id.dept_listView);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//跳转到病人列表
				PatientsListFragment newFragment = new PatientsListFragment(depts_temp.get(position).getDEPTCODE(),depts_temp.get(position).getDEPTNAME());
				systemApplcation.setPatientListFragment(newFragment);
				FragmentTransaction transaction =getFragmentManager().beginTransaction();
				transaction.replace(R.id.mainFrameLayout,newFragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
		SystemApplcation applcation = (SystemApplcation) getActivity().getApplication();
		DOCINVHISInLoginSrvOutputItem dict = applcation.getStaffDict();
		hashMap.put("DOC_NAME", dict != null?dict.getUSERNAME():"");
		queryData(hashMap);
	}
	
	private void notifyStartSearching(String text){
	    //隐藏软键盘
	    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
	    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}

	private class EditChangedListener implements TextWatcher {
	    @Override
	    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
	
	    }
	
	    @Override
	    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
	        if (!"".equals(charSequence.toString()) && charSequence.toString().length()>0) {
	        	search_iv_delete.setVisibility(View.VISIBLE);
	        	depts_temp = new ArrayList<DOCINVHISInQueryDeptSrvOutputItem>();
	        	for (int j = 0; j < depts.size(); j++) {
					if(depts.get(j).getDEPTNAME().contains(charSequence)){
						depts_temp.add(depts.get(j));
					}
				}
	        	if(adapter!=null){
	        		adapter.setDepts(depts_temp);
	        		adapter.notifyDataSetChanged();
	        	}
	        } else if("".equals(charSequence.toString())){
	        	search_iv_delete.setVisibility(View.GONE);
	        	if(adapter!=null){
	        		adapter.setDepts(depts);
	        		adapter.notifyDataSetChanged();
	        	}
	        	depts_temp = depts;
	        }else {
	        	search_iv_delete.setVisibility(View.GONE);
	        	depts_temp = depts;
	        }
	
	    }
	
	    @Override
	    public void afterTextChanged(Editable editable) {
	    }
	}	

	/***
	 * 
	* 查询数据
	* @Title: queryData
	* @param jsonStr
	* @return void
	* @throws
	* @author Yehao
	 */
	private void queryData(HashMap<String, Object> jsonStr) {
		final CustomerProgress customerProgress =  new CustomerProgress(getActivity(),R.style.customer_dialog);
		NetWorkHepler.postWsData("deptWs","process",jsonStr, new INetWorkCallBack() {
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
				DOCINVHISInQueryDeptSrvResponse response = new DOCINVHISInQueryDeptSrvResponse();
				try {
					for(int i=0;i<objectResult.getPropertyCount();i++){
						response.setProperty(i, objectResult.getProperty(i));
					}
				} catch (Exception e) {
					ToastUtil.showToast(getActivity(), "遇到了点麻烦出错了，请重试！");
				}
				if(response.getDOCINVHISInQueryDeptSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryDeptSrvOutputCollection().getDOCINVHISInQueryDeptSrvOutputItem()!=null){
					depts = response.getDOCINVHISInQueryDeptSrvOutputCollection().getDOCINVHISInQueryDeptSrvOutputItem();
					depts_temp = depts;
				}
				if(adapter == null){
					adapter = new DeptAdapter(depts, getActivity());
				}else{
					adapter.setDepts(depts);
				}
				listView.setAdapter(adapter);
				
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
