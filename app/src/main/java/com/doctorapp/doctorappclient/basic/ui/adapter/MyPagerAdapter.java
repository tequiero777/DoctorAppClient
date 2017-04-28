package com.doctorapp.doctorappclient.basic.ui.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter{

	private List<Fragment> fragmentList;
	
	public MyPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.fragmentList = fragmentList;
	}	
	
	@Override            
	public int getCount() {                
		return fragmentList == null ? 0 : fragmentList.size();           
	} 

	@Override            
	public Fragment getItem(int index)//直接创建fragment对象并返回            
	{                
		return (fragmentList == null || fragmentList.size() == 0) ? null : fragmentList.get(index);           
	}

}
