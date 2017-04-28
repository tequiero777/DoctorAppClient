package com.doctorapp.doctorappclient.basic.ui.fragment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.ClassBean;
import com.doctorapp.doctorappclient.basic.ui.adapter.TabsAdapter;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * TODO
 * <p>Title: 数据报表</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */
public class ReportFormFragment extends BaseFragment {
	private LinkedList<RadioButton> tabRadioButtons = new LinkedList<RadioButton>();
	private ViewPager vPager = null;    
	/**     * 选项卡总数     */    
	private static int tab_count = 4;    
	/**     * 当前显示的选项卡位置     */    
	private int current_index = 0;        
	/**     * 选项卡标题     */ 
	private List<ClassBean> tabsList;
	private TabsAdapter hta;
	private LinearLayout titleListview;
	
	private View rootView;
	
	private List<Fragment> fragmentList = null;
	
	@SuppressWarnings("deprecation")
	@Override    
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(rootView == null){
			rootView = inflater.inflate(R.layout.reportform_tabs, container,false);
			vPager = (ViewPager) rootView.findViewById(R.id.vPager);
			titleListview = (LinearLayout) rootView.findViewById(R.id.reportform_tab_title);	      
			getScreenSize();
			fragmentList = new ArrayList<Fragment>();
			initView();
			
			vPager.setOnPageChangeListener(new OnPageChangeListener() {
				
				@Override            
				public void onPageSelected(int index) {   
					
					//之前选中的组件
					RadioButton beforeCheckedTextView = (RadioButton) titleListview.findViewById(current_index);
					beforeCheckedTextView.setTextColor(Color.WHITE);
					
					//当前选中的组件
					RadioButton nowCheckedTextView = (RadioButton) titleListview.findViewById(index);
					Resources resource = (Resources) getActivity().getBaseContext().getResources();  
					ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.class_title_color);
					nowCheckedTextView.setTextColor(csl);
					
					current_index = index; 
					for(int j =0;j<tabRadioButtons.size();j++){
		        		if(index==j){
		        			tabRadioButtons.get(index).setChecked(true);
		        			continue;
		        		}else{
		        			tabRadioButtons.get(j).setChecked(false);
		        		}
		        	}
					           
				}                        
				
				@Override            
				public void onPageScrolled(int arg0, float arg1, int arg2) {
					
				}                        
				
				@Override            
				public void onPageScrollStateChanged(int index) {            
					
				}        
			});
		}
		
		return rootView;    
	}

	private void initView() {
		tabsList = new ArrayList<ClassBean>();
		ClassBean cb1 = new ClassBean();
		cb1.setClassName("单日");
		ClassBean cb2 = new ClassBean();
		cb2.setClassName("多日");
		ClassBean cb3 = new ClassBean();
		cb3.setClassName("单月");
		ClassBean cb4 = new ClassBean();
		cb4.setClassName("多月");
		tabsList.add(cb1);
		tabsList.add(cb2);
		tabsList.add(cb3);
		tabsList.add(cb4);
		
		PerDayReportFragment viewPagerFragment1 = new PerDayReportFragment();		
		FewDayReportFragment viewPagerFragment2 = new FewDayReportFragment();	
		PerMonthReportFragment viewPagerFragment3 = new PerMonthReportFragment();	
		FewMonthReportFragment viewPagerFragment4 = new FewMonthReportFragment();	
        fragmentList.add(viewPagerFragment1); 
        fragmentList.add(viewPagerFragment2); 
        fragmentList.add(viewPagerFragment3); 
        fragmentList.add(viewPagerFragment4); 
		
        tabRadioButtons = new LinkedList<RadioButton>();
		for (int i = 0; i < tab_count; i++) {
			final LinearLayout layout = new LinearLayout(getActivity());
			layout.setOrientation(LinearLayout.HORIZONTAL);
			DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
		    int px = Math.round(45 * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)); 
			layout.setLayoutParams(new LinearLayout.LayoutParams(screenSize.getWidth()/tab_count, px));
			layout.setGravity(Gravity.CENTER);
			layout.setBackgroundColor(Color.parseColor("#2c65ee"));
			RadioButton tv = (RadioButton) LayoutInflater.from(getActivity()).inflate(R.layout.custom_radiobutton, null);
			tv.setText(tabsList.get(i).getClassName());
			tv.setTextSize(18);
			tv.setId(i);
			tv.setHeight(px);
			tv.setWidth(screenSize.getWidth()/tab_count);
			tv.setGravity(Gravity.CENTER);
//			tv.setBackgroundColor(Color.parseColor("#2c65ee"));
			tabRadioButtons.addLast(tv);
			if(i==current_index){
				Resources resource = (Resources) getActivity().getBaseContext().getResources();  
				ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.class_title_color);  
				
				tv.setTextColor(csl);
				tv.setChecked(true);
			}
			tv.setOnClickListener(new MyOnClickListener(i));
			
			layout.addView(tv);
			titleListview.addView(layout);
		}
		
		hta = new TabsAdapter(getChildFragmentManager(), fragmentList);	
		vPager.setAdapter(hta);
	}    
	
	/**
     * 头标点击监听
     */
    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        @Override
        public void onClick(View v) {
        	RadioButton button = (RadioButton) v;
        	button.setChecked(true);
        	for(int j =0;j<tabRadioButtons.size();j++){
        		if(index==j){
        			continue;
        		}else{
        			tabRadioButtons.get(j).setChecked(false);
        		}
        	}
            vPager.setCurrentItem(index);
        }
    };
	
}
