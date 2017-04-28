package com.doctorapp.doctorappclient.basic.ui.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.common.Constant;
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv.DOCINVHISInQueryPatientSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv.DOCINVHISInQueryPatientSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.activity.WebViewActivity;
import com.doctorapp.doctorappclient.basic.ui.adapter.PatientListCardsAdapter;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;

/**
 * TODO
 * <p>Title: 病人列表界面</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月18日上午10:43:52
 * @version 1.0
 * 
 */
public class PatientsListFragment extends BaseFragment implements OnItemClickListener{
	//节点VIEW
	private View rootView;
	private List<DOCINVHISInQueryPatientSrvOutputItem> patientInfos;
	private List<DOCINVHISInQueryPatientSrvOutputItem> patientInfos_temp;
	private ListView gridView ;
	private PatientListCardsAdapter adapter;
	private int currentPage = 1;
	private String deptNo,deptName;
	private ImageButton button_back;
	private TextView title;
	private EditText search_et_input;
	private ImageView search_iv_delete;
	private SystemApplcation systemApplcation;
	private FragmentManager fragmentManager;
	
	/**监听*/
	/**查询条件的MAP**/
	private HashMap<String, Object> jsonMap = new HashMap<String, Object>();
	
	public PatientsListFragment() {
		super();
	}


	public PatientsListFragment(String deptNo,String deptName) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.mobile_rounds_patient_gridview, null);
			init();
		}else if(adapter ==null || adapter.getPatientInfos() == null || adapter.getPatientInfos().size()==0){
			queryData(jsonMap);
		}
		return rootView;
	}
	
	@Override
	public void onStart() {
		super.onStart();
		final SystemApplcation applcation = (SystemApplcation) getActivity().getApplication();
	}

	/***
	 * 
	* 初始化
	* @Title: init
	* @return void
	* @throws
	* @author Yehao
	 */
	private void init() {
		systemApplcation = (SystemApplcation) getActivity().getApplication();
		
		//搜索框删除按钮
		search_iv_delete = (ImageView) rootView.findViewById(R.id.patient_search_iv_delete);
		search_iv_delete.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				search_et_input.setText("");
				search_iv_delete.setVisibility(View.GONE);
			}
		});
		
		//搜索框Edittext
		search_et_input = (EditText) rootView.findViewById(R.id.patient_search_et_input);
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
		
		button_back = (ImageButton) rootView.findViewById(R.id.button_back);
		button_back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				systemApplcation.setPatientListFragment(null);
				showFragment(systemApplcation.getCaseHistoryFragment());
//				getFragmentManager().popBackStack();
			}
		});
		
		title = (TextView) rootView.findViewById(R.id.patientList_title);
		title.setText(deptName);
		
		initListener();
		SystemApplcation applcation = (SystemApplcation) getActivity().getApplication();
		DOCINVHISInLoginSrvOutputItem dict = applcation.getStaffDict();
		if(dict != null){
			jsonMap.put("DOCTOR_NAME", dict.getNAME());
			jsonMap.put("DOCTOR_ID", dict.getEMPNO());
			jsonMap.put("DEPT_NO", deptNo);
			jsonMap.put("CURRENTPAGE", currentPage);
			jsonMap.put("PAGESIZE", Constant.PAGE_SIZE);
		}
		gridView = (ListView) rootView.findViewById(R.id.patient_newin);
		queryData(jsonMap);
	}

	public void showFragment(Fragment f) {
		if (fragmentManager == null) {
			fragmentManager = getActivity().getSupportFragmentManager();
		}
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.mainFrameLayout, f);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
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
	        	patientInfos_temp = new ArrayList<DOCINVHISInQueryPatientSrvOutputItem>();
	        	for (int j = 0; j < patientInfos.size(); j++) {
					if(patientInfos.get(j).getPATIENTNAME().contains(charSequence) || patientInfos.get(j).getBEDNO().equals(charSequence.toString())){
						patientInfos_temp.add(patientInfos.get(j));
					}
				}
	        	if(adapter!=null){
	        		adapter.setPatientInfos(patientInfos_temp);
	        		adapter.notifyDataSetChanged();
	        	}
	        } else if("".equals(charSequence.toString())){
	        	search_iv_delete.setVisibility(View.GONE);
	        	if(adapter!=null){
	        		adapter.setPatientInfos(patientInfos);
	        		adapter.notifyDataSetChanged();
	        	}
	        	patientInfos_temp = patientInfos;
	        }else {
	        	search_iv_delete.setVisibility(View.GONE);
	        	patientInfos_temp = patientInfos;
	        }
	
	    }
	
	    @Override
	    public void afterTextChanged(Editable editable) {
	    }
	}	

	/***
	 * 
	* 监听的赋值
	* @Title: initListener
	* @return void
	* @throws
	* @author Yehao
	 */
	private void initListener() {
	}

	private void initData(ListView ListView) {
		if(adapter == null){
			adapter = new PatientListCardsAdapter(patientInfos, getMainActivity());
			ListView.setAdapter(adapter);
			ListView.setOnItemClickListener(this);
		}else{
			adapter.setPatientInfos(patientInfos);
			adapter.notifyDataSetChanged();
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
		final CustomerProgress customerProgress = new CustomerProgress(getActivity(),R.style.customer_dialog);
		NetWorkHepler.postWsData("patientListWs","process",jsonStr, new INetWorkCallBack() {
			
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
				DOCINVHISInQueryPatientSrvResponse response = new DOCINVHISInQueryPatientSrvResponse();
				try {
					for(int i=0;i<objectResult.getPropertyCount();i++){
						response.setProperty(i, objectResult.getProperty(i));
					}
				} catch (Exception e) {
					ToastUtil.showToast(getActivity(), "遇到了点麻烦出错了，请重试！");
				}
				if(response.getDOCINVHISInQueryPatientSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryPatientSrvOutputCollection().getDocinvhisInQueryPatientSrvOutputItem()!=null){
					patientInfos = response.getDOCINVHISInQueryPatientSrvOutputCollection().getDocinvhisInQueryPatientSrvOutputItem();
				}else{
					patientInfos = null;
				}
				initData(gridView);
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
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		DOCINVHISInQueryPatientSrvOutputItem patientInfo = adapter.getPatientInfos().get(position);
		//跳转到电子病历WebView
//		WebViewFragment newFragment = new WebViewFragment(patientInfo.getPATIENTID(),patientInfo.getVISITID(),patientInfo.getPATIENTNAME());
//		FragmentTransaction transaction =getFragmentManager().beginTransaction();
//		transaction.replace(R.id.mainFrameLayout,newFragment);
//		transaction.addToBackStack(null);
//		transaction.commit();
		
		Intent intent = new Intent(getActivity(), WebViewActivity.class);
		intent.putExtra("patientid", patientInfo.getPATIENTID());
		intent.putExtra("visitid", patientInfo.getVISITID());
		intent.putExtra("patientname", patientInfo.getPATIENTNAME());
		startActivity(intent);
	}

	
}
