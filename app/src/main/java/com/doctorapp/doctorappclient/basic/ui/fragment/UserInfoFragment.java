package com.doctorapp.doctorappclient.basic.ui.fragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.common.Constant;
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryAppUpdateSrv.DOCINVHISInQueryAppUpdateSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryAppUpdateSrv.DOCINVHISInQueryAppUpdateSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.activity.AboutActivity;
import com.doctorapp.doctorappclient.basic.ui.activity.RegisterActivity;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
import com.doctorapp.doctorappclient.util.StringUtil;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * TODO
 * <p>Title: 个人中心</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */
public class UserInfoFragment extends Fragment{
	private View rootView;
	private ProgressBar proBar;
	private RelativeLayout update_layout,register_layout,aboutus_layout,setting_layout;
	private TextView username,usertitle,checkupdate;
	private List<DOCINVHISInQueryAppUpdateSrvOutputItem> listdata;
	protected String saveDir;
	private String updateSaveName = "DoctorAppClient.apk";
	private int progress;  
	private Boolean canceled = false;
	private static final int UPDATE_CHECKCOMPLETED = 1;//已经完成检测新版本
	private static final int UPDATE_DOWNLOADING = 2; //下载中
	private static final int UPDATE_DOWNLOAD_ERROR = 3; //下载出错
	private static final int UPDATE_DOWNLOAD_COMPLETED = 4; //下载完成
	private static final int UPDATE_DOWNLOAD_CANCELED = 5;//取消下载
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.userinfo_layout, null);
		initView();
		return rootView;
	}

	private void initView() {
		username = (TextView) rootView.findViewById(R.id.userinfo_name);
		usertitle = (TextView) rootView.findViewById(R.id.userinfo_title);
		SystemApplcation applcation = (SystemApplcation) getActivity().getApplication();
		DOCINVHISInLoginSrvOutputItem dict = applcation.getStaffDict();
		username.setText(dict.getNAME());
		usertitle.setText(dict.getTITLE());
		
		register_layout = (RelativeLayout) rootView.findViewById(R.id.register_layout);
		register_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), RegisterActivity.class);
				startActivity(intent);
			}
		});
		
		
		proBar = (ProgressBar) rootView.findViewById(R.id.update_probar);
		proBar.setVisibility(View.GONE);
		checkupdate = (TextView) rootView.findViewById(R.id.update_text);
		update_layout = (RelativeLayout) rootView.findViewById(R.id.checkupdate_layout);
		update_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				update();
			}
		});
		
		aboutus_layout = (RelativeLayout) rootView.findViewById(R.id.aboutus_layout);
		aboutus_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), AboutActivity.class);
				startActivity(intent);
			}
		});
		
		setting_layout = (RelativeLayout) rootView.findViewById(R.id.setting_layout);
		setting_layout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				ToastUtil.showToast(getActivity(), "功能预留");
			}
		});
	}
	
	
	private void update(){
		HashMap<String, Object> request = new HashMap<String, Object>();
	     // 获取packagemanager的实例
        PackageManager packageManager = getActivity(). getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = new PackageInfo();
		try {
			packInfo = packageManager.getPackageInfo( getActivity().getPackageName(),0);
		} catch (Exception e) {
			e.printStackTrace();
		}
        String version = packInfo.versionCode+"";
		request.put("VERSION", version);
		request.put("TENANT_ID", Constant.TENANT_ID);
		loadData(request);

	}
	
	private void loadData(HashMap<String, Object> request){
		final CustomerProgress customerProgress = new CustomerProgress(getActivity(),R.style.customer_dialog);
		NetWorkHepler.postWsData("appUpdateWs", "process", request, new INetWorkCallBack() {
			private SoapObject objectResult;	
			@Override
			public void onResult(Object result) {
				customerProgress.dismissDialog(customerProgress);
				if(result == null){
					ToastUtil.showToast(getActivity(), "查询数据出错请从新查询！");
					return;
				}if(result instanceof SoapObject){
					objectResult = (SoapObject) result;
				}else{
					ToastUtil.showToast(getActivity(), "服务器连接失败");
					return;
				}
				DOCINVHISInQueryAppUpdateSrvResponse response = new DOCINVHISInQueryAppUpdateSrvResponse();
				try {
					for(int i=0;i<objectResult.getPropertyCount();i++){
						response.setProperty(i, objectResult.getProperty(i));
					}
				} catch (Exception e) {
					ToastUtil.showToast(getActivity(), "遇到了点麻烦出错了，请重试！");
				}
				if(response.getDOCINVHISInQueryAppUpdateSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryAppUpdateSrvOutputCollection().getDOCINVHISInQueryAppUpdateSrvOutputItem()!=null){
					listdata = response.getDOCINVHISInQueryAppUpdateSrvOutputCollection().getDOCINVHISInQueryAppUpdateSrvOutputItem();
				}else{
					ToastUtil.showToast(getActivity(), "检查更新失败了！");
				}
				
				if(listdata !=null && listdata.get(0)!=null){
					final DOCINVHISInQueryAppUpdateSrvOutputItem item = listdata.get(0);
					int verson = Integer.valueOf(StringUtil.isBlank(item.getVERSION())?"0":item.getVERSION());
					 int currentVerson = 1;
					 try {
						 currentVerson = getActivity().getPackageManager().getPackageInfo( "com.doctorapp.doctorappclient",0).versionCode;
					} catch (NameNotFoundException e) {
						e.printStackTrace();
					}
					if("2".equals(item.getUPDATEFLAG())){
						//启动下载
						if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
							 download();
							 checkupdate.setText("正在下载");
	                         proBar.setVisibility(View.VISIBLE);
	                         proBar.setMax(100);
	                         proBar.setProgress(0);
						}else{
							Toast.makeText(getActivity(), "没有内存卡", Toast.LENGTH_LONG).show();
						}
					}else if("1".equals(item.getUPDATEFLAG()) && verson >currentVerson){
						//updateFlag.setVisibility(View.VISIBLE);
							AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
				            alert.setTitle("软件升级")
				                 .setMessage("发现新版本,建议立即更新使用！")
				                 .setPositiveButton("更新", new DialogInterface.OnClickListener() {
				                     public void onClick(DialogInterface dialog, int which) {
				                    	 download();
				                    	 checkupdate.setText("正在下载");
				                         proBar.setVisibility(View.VISIBLE);
				                         proBar.setMax(100);
				                         proBar.setProgress(0);
				                     }
				                 })
				                 .setNegativeButton("取消",new DialogInterface.OnClickListener(){
				                     public void onClick(DialogInterface dialog, int which) {
				                         dialog.dismiss();
				                         
				                     }
				                 });
				            alert.create().show();
					}else{
						ToastUtil.showToast(getActivity(), "已是最新版本");
					}
				}else{
					ToastUtil.showToast(getActivity(), "检查失败");
				}
			}
			
			@Override
			public void onProgressUpdate(Integer[] values) {
				
			}
			
			@Override
			public void onPreExecute() {
				if(customerProgress!=null && !customerProgress.isShowing())
				customerProgress.show();
				
			}
		});
		
		
	}
	
	// 下载
	public void download(){
        //开启一个线程去下载apk
		new Thread() {			
			@Override  
		        public void run() {  
		            try {  
		                URL url = new URL(listdata.get(0).getUPDATEURL());  
		                //新建连接并获取资源
		                HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
		                conn.connect();  
		                int length = conn.getContentLength();  
		                InputStream is = conn.getInputStream();  
		                
		                File external = getActivity().getExternalFilesDir("download");
		                
		                if(external==null){
		                	saveDir = "/mnt/sdcard-ext/dwmsc/download";
		                	File direction = new File(saveDir);
		                	if(!direction.exists()){
		                		direction.mkdir();
		                	}
		                }else{
		                	saveDir = getActivity().getExternalFilesDir("download").toString();
		                }
		        		
		                
		                //如果文件存在，就先删除
		                File ApkFile = new File(saveDir,updateSaveName);  		                
		                if(ApkFile.exists())
		                {
		                	ApkFile.delete();
		                }
		                
		                FileOutputStream fos = new FileOutputStream(ApkFile);  
		                 
		                int count = 0;  
		                byte buf[] = new byte[512];  
		                  
		                do{  
		                    int numread = is.read(buf);  
		                    count += numread;  
		                    //计算下载的进度
		                    progress =(int)(((float)count / length) * 100);  
		                   //把进度传给updateHandler更新ProgressDialog,从消息池中拿来一个msg 不需要另开辟空间
		                    updateHandler.sendMessage(updateHandler.obtainMessage(UPDATE_DOWNLOADING)); 
		                    if(numread <= 0){          
		                    	updateHandler.sendEmptyMessage(UPDATE_DOWNLOAD_COMPLETED);
		                        break;  
		                    }  
		                    fos.write(buf,0,numread);  
		                }while(!canceled);  
			                fos.close();  
			                is.close();  
		            } catch (MalformedURLException e) {  
		                e.printStackTrace(); 
		                updateHandler.sendMessage(updateHandler.obtainMessage(UPDATE_DOWNLOAD_ERROR,e.getMessage()));
		            } catch(IOException e){  
		                e.printStackTrace();  
		                updateHandler.sendMessage(updateHandler.obtainMessage(UPDATE_DOWNLOAD_ERROR,e.getMessage()));
		            }  
		              
		        } 
		}.start();
	}
	
	Handler updateHandler = new Handler() 
	{
		@Override
		public void handleMessage(Message msg) {

			switch (msg.what) {
			case UPDATE_DOWNLOADING:
				//更新ProgressDialog的进度
				downloadProgressChanged(progress);
				break;
			case UPDATE_DOWNLOAD_ERROR:
				//下载失败
				downloadCompleted(false, msg.obj.toString());
				break;
			case UPDATE_DOWNLOAD_COMPLETED:
				//下载完成
				downloadCompleted(true, "");
				break;
			default:
				break;
			}
		}
	};
	
	//更新ProgressDialog的进度
	public void downloadProgressChanged(int progress) {
		if (proBar != null) {
			proBar.setProgress(progress);
		}

	}
	
	//下载完成
	public void downloadCompleted(Boolean sucess, String errorMsg) {
		if (proBar != null) {
			proBar.setVisibility(View.GONE);
			proBar.setProgress(0);
			checkupdate.setText("检查更新");
		}
		if (sucess) {
			installApk();
		} else {
			proBar.setVisibility(View.GONE);
			proBar.setProgress(0);
			checkupdate.setText("检查更新");
			ToastUtil.showToast(getActivity(), "下载失败！");
		}
	}
	
	//提示安装
	public void installApk() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		
		intent.setDataAndType(
				Uri.fromFile(new File(saveDir, updateSaveName)),
				"application/vnd.android.package-archive");
		getActivity().startActivityForResult(intent, 6);
	}
}
