package com.doctorapp.doctorappclient.basic.ui.activity;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import org.ksoap2.serialization.SoapObject;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InQueryAppUpdateSrv.DOCINVHISInQueryAppUpdateSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InQueryAppUpdateSrv.DOCINVHISInQueryAppUpdateSrvResponse;
import com.doctorapp.doctorappclient.basic.service.DownloadFileService;
import com.doctorapp.doctorappclient.basic.ui.ThreadExecutor;
import com.doctorapp.doctorappclient.basic.ui.view.CustomDialog;
import com.doctorapp.doctorappclient.common.Constant;
import com.doctorapp.doctorappclient.util.StringUtil;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.Utils;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;


/**
 * TODO
 * <p>Title: 欢迎页面</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 *
 */
public class WelcomeActivity extends BaseActivity{
	private Builder alert ;
	private static final int SPLASH_DISPLAY_LENGHT = 2000;
	private LinearLayout no_connection;
	private TextView connection_retry;
	private WifiManager wifiManager;
	private CustomDialog progressDialog;
	private List<DOCINVHISInQueryAppUpdateSrvOutputItem> listdata;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_welcome);
		no_connection = (LinearLayout)findViewById(R.id.no_connection);
		connection_retry = (TextView)findViewById(R.id.connection_retry);
		wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
		nextActivity();
	}

	public void onResume() {
		super.onResume();
		}
	public void onPause() {
		super.onPause();
	}

	public class ConnectionDetector {
		private Context _context;

		public ConnectionDetector(Context context) {
			this._context = context;
		}

		public boolean isConnectingToInternet() {
			ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (connectivity != null) {
				NetworkInfo[] info = connectivity.getAllNetworkInfo();
				if (info != null)
					for (int i = 0; i < info.length; i++)
						if (info[i].getState() == NetworkInfo.State.CONNECTED) {
							return true;
						}
			}
			return false;
		}
	}

	/**
	* 检测网络延时
	* @Title: nextActivity
	* @return void
	* @throws
	* @author cheng
	 */
	private void nextActivity() {
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				//检查网络状态
				ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
				Boolean isInternetPresent = cd.isConnectingToInternet();
				if(!isInternetPresent){
					no_connection.setVisibility(View.VISIBLE);
					connection_retry.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							setNetworkMethod(WelcomeActivity.this);
						}
					});
					Toast.makeText(WelcomeActivity.this, "你的网络出错啦！", Toast.LENGTH_LONG).show();
				}else{
					no_connection.setVisibility(View.GONE);
					chechVersion();

//					Intent intent = new Intent(WelcomeActivity.this,LoginActivity.class);
//					startActivity(intent );

				}
			}
		}, SPLASH_DISPLAY_LENGHT);
	}


	/**
	* 设置打开wifi
	* @Title: setWifiNetWork
	* @param context
	* @param wifimanager
	* @return void
	* @throws
	* @author cheng
	 */
	private void setWifiNetWork(final Context context,final WifiManager wifimanager,final DialogInterface dialog){
		new AsyncTask<Void, Void, Boolean>() {


			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				 if (progressDialog == null){
				        progressDialog = CustomDialog.createDialog(WelcomeActivity.this);
				        progressDialog.setMessage("正在开启wifi,请稍等");
				    }

				    progressDialog.show();
			}

			@Override
			protected Boolean doInBackground(Void... params) {
				if(wifimanager.isWifiEnabled()){
					return false;
				}else{
					wifimanager.setWifiEnabled(true);
					int temp = 0;
					ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
					Boolean isInternetPresent = cd.isConnectingToInternet();
					while(!wifimanager.isWifiEnabled()&&temp<10&&!isInternetPresent){
						try {
							temp++;
							isInternetPresent = cd.isConnectingToInternet();
							Log.e("isInternetPresent", isInternetPresent+"");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(temp >=10){
						return false;
					}else{
						return true;
					}
				}
			}

			@Override
			protected void onPostExecute(Boolean result) {
				super.onPostExecute(result);
				if(progressDialog != null)
					progressDialog.dismiss();
				dialog.dismiss();
				if(result){
					Utils.show(WelcomeActivity.this, "wifi开启成功");
				}else{
					Utils.show(WelcomeActivity.this, "wifi已经开启,但未连接可用网络");
				}
				nextActivity();
			}
		}.executeOnExecutor(ThreadExecutor.THREAD_EXECUTOR);
	}


	/**
	* 设置手机数据连接网络
	* @Title: setNetworkMethod
	* @param context
	* @return void
	* @throws
	* @author cheng
	 */
	private void setNetworkMethod(final Context context){
        //提示对话框
        Builder builder=new Builder(context);
        builder.setTitle("网络设置提示").setMessage("网络连接不可用,是否进行设置?").setPositiveButton("数据流量", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            	setMobileDataEnabled(WelcomeActivity.this, true,dialog);
            }
        }).setNegativeButton("wifi", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            	setWifiNetWork(context, wifiManager, dialog);
            }
        }).show();
    }

	/**
	*设置数据使用状态 需要 签名 系统 可以根据 变化
	*
	* @Title: setMobileDataEnabled
	* @param context
	* @return true为 成功 false为失败
	* @throws
	* @author cheng
	 */
	private void setMobileDataEnabled(final Context context,final  boolean flag,final DialogInterface dialog) {
		new AsyncTask<Void, Void, Boolean>(){
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				 if (progressDialog == null){
				        progressDialog = CustomDialog.createDialog(WelcomeActivity.this);
				        progressDialog.setMessage("正在开启数据流量,请稍等");
				    }

				    progressDialog.show();
			}

			@Override
			protected Boolean doInBackground(Void... params) {
				ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
				Method setMobileDataEnabl;
				try {
					setMobileDataEnabl = cm.getClass().getDeclaredMethod(
					"setMobileDataEnabled", boolean.class);
					setMobileDataEnabl.invoke(cm, flag);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}

			@Override
			protected void onPostExecute(Boolean result) {
				super.onPostExecute(result);
				if (progressDialog != null)
					progressDialog.dismiss();
				if(result){
					Utils.show(WelcomeActivity.this, "数据流量开启成功");
				}else{
					Utils.show(WelcomeActivity.this, "数据流量已经开启,但未连接可用网络");
				}
				nextActivity();
			}
		}.executeOnExecutor(ThreadExecutor.THREAD_EXECUTOR);

	}


	/**
	* 版本检测
	* @Title: chechVersion
	* @return void
	* @throws
	* @author cheng
	 */
	@SuppressWarnings("static-access")
	private void chechVersion(){
		HashMap<String, Object> request = new HashMap<String, Object>();
		// 获取packagemanager的实例
		PackageManager packageManager = this. getPackageManager();
		// getPackageName()是你当前类的包名，0代表是获取版本信息
		PackageInfo packInfo = new PackageInfo();
			try {
				packInfo = packageManager.getPackageInfo( "com.doctorapp.doctorappclient",0);
			} catch (Exception e) {
				e.printStackTrace();
		}

		String version = packInfo.versionCode+"";
		request.put("VERSION", version);
		request.put("TENANT_ID", Constant.TENANT_ID);
		postUpdate(request);
	}

	private void postUpdate(HashMap<String, Object> request){
		System.out.println("------------------------appUpdateWs----"+"version"+"----"+"Constant.TENANT_ID");
		NetWorkHepler.postWsData("appUpdateWs", "process", request, new INetWorkCallBack() {
			private SoapObject objectResult;
			@Override
			public void onResult(Object result) {
				if(result == null){
					ToastUtil.showToast(WelcomeActivity.this, "检查更新失败了！");
					Intent in = new Intent();
        			in.setClass(WelcomeActivity.this, LoginActivity.class);
        			startActivity(in);
        			finish();
					return;
				}if(result instanceof SoapObject){
					objectResult = (SoapObject) result;
				}else{
					ToastUtil.showToast(WelcomeActivity.this, "服务器连接失败");
					Intent in = new Intent();
        			in.setClass(WelcomeActivity.this, LoginActivity.class);
        			startActivity(in);
					return;
				}
				DOCINVHISInQueryAppUpdateSrvResponse response = new DOCINVHISInQueryAppUpdateSrvResponse();
				try {
					for(int i=0;i<objectResult.getPropertyCount();i++){
						response.setProperty(i, objectResult.getProperty(i));
					}
				} catch (Exception e) {
					ToastUtil.showToast(WelcomeActivity.this, "遇到了点麻烦出错了，请重试！");
				}

				if(response.getDOCINVHISInQueryAppUpdateSrvOutputCollection()!=null
						&& response.getDOCINVHISInQueryAppUpdateSrvOutputCollection().getDOCINVHISInQueryAppUpdateSrvOutputItem()!=null){
					listdata = response.getDOCINVHISInQueryAppUpdateSrvOutputCollection().getDOCINVHISInQueryAppUpdateSrvOutputItem();
				}else{
					ToastUtil.showToast(WelcomeActivity.this, "检查更新失败！");
				}
				if(listdata !=null && listdata.get(0)!=null){
					 final DOCINVHISInQueryAppUpdateSrvOutputItem au = listdata.get(0);
					 int verson = Integer.valueOf(StringUtil.isBlank(au.getVERSION())?"0":au.getVERSION());
					 int currentVerson = 1;
					 try {
						 currentVerson = getPackageManager().getPackageInfo( "com.doctorapp.doctorappclient",0).versionCode;
					 } catch (NameNotFoundException e) {
						 e.printStackTrace();
					 }
				//如果有更新就下载
				if(au.getUPDATEFLAG().equals("2")){
					 Intent updateIntent =new Intent(WelcomeActivity.this, DownloadFileService.class);
					 updateIntent.putExtra("appName",getResources().getString(R.string.app_name));
					 updateIntent.putExtra("url",au.getUPDATEURL());
					 startService(updateIntent);
				}else if(au.getUPDATEFLAG().equals("1") && verson >currentVerson){
					alert = new Builder(WelcomeActivity.this);
					alert.setCancelable(false);
		            alert.setTitle("软件升级")
		                 .setMessage("发现新版本,建议立即更新使用！")
		                 .setPositiveButton("更新", new DialogInterface.OnClickListener() {
		                     public void onClick(DialogInterface dialog, int which) {
		                         Intent updateIntent =new Intent(WelcomeActivity.this, DownloadFileService.class);
		                         updateIntent.putExtra("appName",getResources().getString(R.string.app_name));
		                         updateIntent.putExtra("url",au.getUPDATEURL());
		                         startService(updateIntent);
		                         Intent in = new Intent();
		             			 in.setClass(WelcomeActivity.this, LoginActivity.class);
		             			 startActivity(in);
		             			 finish();
		                     }
		                 })
		                 .setNegativeButton("取消",new DialogInterface.OnClickListener(){
		                     public void onClick(DialogInterface dialog, int which) {
		                    	 Intent in = new Intent();
		             				in.setClass(WelcomeActivity.this, LoginActivity.class);
	             				startActivity(in);
		                         dialog.dismiss();
		                     }
		                 });
		            if(alert!=null)
		            	alert.create().show();
					}else{
						Intent in = new Intent();
	        			in.setClass(WelcomeActivity.this, LoginActivity.class);
	        			startActivity(in);
					}
				}else{
					Intent in = new Intent();
        			in.setClass(WelcomeActivity.this, LoginActivity.class);
        			startActivity(in);
				}


			}

			@Override
			public void onProgressUpdate(Integer[] values) {

			}

			@Override
			public void onPreExecute() {

			}
		});


	}

}
