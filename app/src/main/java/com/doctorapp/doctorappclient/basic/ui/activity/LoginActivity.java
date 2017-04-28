package com.doctorapp.doctorappclient.basic.ui.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;

import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.applcation.SystemApplcation;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvResponse;
import com.doctorapp.doctorappclient.basic.ui.view.CustomDialog;
import com.doctorapp.doctorappclient.basic.ui.view.CustomerProgress;
import com.doctorapp.doctorappclient.util.FaceUtil;
import com.doctorapp.doctorappclient.util.StringUtil;
import com.doctorapp.doctorappclient.util.ToastUtil;
import com.doctorapp.doctorappclient.util.network.callback.INetWorkCallBack;
import com.doctorapp.doctorappclient.util.network.helper.NetWorkHepler;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.FaceRequest;
import com.iflytek.cloud.RequestListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
/**
 * TODO
 * <p>Title: 登录页面</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */
public class LoginActivity extends BaseActivity implements OnClickListener,OnCheckedChangeListener{
	private EditText username;//用户名
	private EditText pwd;//密码
	private CheckBox rePassword;//记住密码
	private Button subBut;//登录按钮
	private Button regBut;//注册按钮
	private ImageButton claer_but;
	private ImageButton toggleButton;
	private boolean toggleBut=false;
	private SystemApplcation applcation;
	String loginIp="";
	public static String FROM = null;
	public static String class_url=null;
	private Intent intent;
	private File file;
	private Bitmap mImage = null;
	private byte[] mImageData = null;
	// authid为6-18个字符长度，用于唯一标识用户
	private String mAuthid = null;
	private CustomDialog progressDialog;
	private ProgressDialog mProDialog;
	private SharedPreferences preferences;
	private final int REQUEST_PICTURE_CHOOSE = 1;
	private final int REQUEST_CAMERA_IMAGE = 2;
	// 拍照得到的照片文件
	private File mPictureFile;
	// FaceRequest对象，集成了人脸识别的各种功能
	private FaceRequest mFaceRequest;
	public static void setClazz(String class_url) {
		LoginActivity.class_url = class_url;
	}

	public static void setFROM(String fROM) {
		FROM = fROM;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basic_login);
		
		applcation = (SystemApplcation)getApplication();
		applcation.addActivity(this);
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
		// 在程序入口处传入appid，初始化SDK
		SpeechUtility.createUtility(this, "appid=" + getString(R.string.app_id));
		mProDialog = new ProgressDialog(this);
		mProDialog.setCancelable(true);
		mProDialog.setTitle("请稍后");
		mProDialog.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				// cancel进度框时,取消正在进行的操作
				if (null != mFaceRequest) {
					mFaceRequest.cancel();
				}
			}
		});
		
		mFaceRequest = new FaceRequest(this);
		initView();
	}
	
	private void initView(){
		claer_but = (ImageButton)findViewById(R.id.claer_but);
		claer_but.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				username.setText("");
			}
		});
		toggleButton = (ImageButton)findViewById(R.id.claer_but_1);
		toggleButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(toggleBut==false){
					pwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
					toggleBut=true;
				}else{
					pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
					toggleBut=false;
				}
				
			}
		});
		
		regBut = (Button) findViewById(R.id.register);
		regBut.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});

		username = (EditText)findViewById(R.id.username);
		pwd = (EditText)findViewById(R.id.pwd);
		String str = getIntent().getStringExtra("phone");
		if(StringUtil.isEmpty(str)){
			username.setText(preferences!=null?preferences.getString("username", null):"");
			pwd.setText(preferences!=null?preferences.getString("password", null):"");
		}else{
			username.setText(str);
		}
		rePassword = (CheckBox)findViewById(R.id.rePassword);
		rePassword.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Editor edit = preferences.edit();
				if (!isChecked) {
					edit.putString("username", "");
					edit.putString("password", "");
				}
				edit.commit();
			}
		});
		subBut = (Button)findViewById(R.id.subBut);
		username.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if(s.toString().equals("")){
					claer_but.setVisibility(View.GONE);
				}else{
					claer_but.setVisibility(View.VISIBLE);
				}
				
			}
		});
		pwd.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				if(s.toString().equals("")){
					toggleButton.setVisibility(View.GONE);
				}else{
					toggleButton.setVisibility(View.VISIBLE);
				}
				
			}
		});
		
       subBut.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(StringUtil.isBlank(username.getText()+"") || StringUtil.isBlank(pwd.getText()+"")){
				ToastUtil.showToast(LoginActivity.this, "用户名或密码不能为空");
				return;
			}
			Editor editor = preferences.edit();
			if(rePassword.isChecked()){
				editor.putString("userName", username.getText()+"");
				editor.putString("userPwd", pwd.getText()+"");
			}else{
				editor.putString("userName", username.getText()+"");
				editor.putString("userPwd", pwd.getText()+"");
				
			}
			editor.putBoolean("savePwd", rePassword.isChecked());
			editor.commit();
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("NAME", username.getText());
			hashMap.put("PWD", pwd.getText());
			intent = new Intent();
			intent.setClass(LoginActivity.this, MainActivity.class);
			queryLogin(hashMap,intent);
			}
       });
       
       preferences = getSharedPreferences("DWMS", MODE_PRIVATE);
		if(preferences.getBoolean("savePwd", false)){
			username.setText(preferences.getString("userName", ""));
			pwd.setText(preferences.getString("userPwd", ""));
		}else{
			username.setText(preferences.getString("userName", ""));
		}
		rePassword.setChecked(preferences.getBoolean("savePwd", false));
		
		rePassword.setOnCheckedChangeListener(this);
		if(getIntent().getExtras()!=null&& getIntent().getExtras().getSerializable("data")!=null){
			username.setText(preferences.getString("userName", ""));
			pwd.setText(preferences.getString("userPwd", ""));
			subBut.performClick();
		}
	}
	
	private void queryLogin(HashMap<String, Object>  request,final Intent  intent) {
		final CustomerProgress customerProgress =  new CustomerProgress(this,R.style.customer_dialog);
		NetWorkHepler.postWsData("loginWs", "process", request, new INetWorkCallBack() {
			SoapObject objectResult;
			@Override
			public void onResult(Object result) {
				customerProgress.dismissDialog(customerProgress);
				if(result == null){
					ToastUtil.showToast(getApplication(), "登陆出错了！");
				}else if(result instanceof SoapObject) {
					objectResult = (SoapObject) result;
				}else{
					ToastUtil.showToast(getApplication(), "服务器连接失败");
					return;
				}
				DOCINVHISInLoginSrvResponse response = new DOCINVHISInLoginSrvResponse();
				try {
					for(int i=0;i<objectResult.getPropertyCount();i++){
						response.setProperty(i, objectResult.getProperty(i));
					}
				} catch (Exception e) {
					ToastUtil.showToast(getApplication(), "数据出错了，请重试！");
				}
				
				if(response.getDOCINVHISInLoginSrvOutputCollection()==null 
						||response.getDOCINVHISInLoginSrvOutputCollection().getDOCINVHISInLoginSrvOutputItem()==null
						||response.getDOCINVHISInLoginSrvOutputCollection().getDOCINVHISInLoginSrvOutputItem().get(0)==null){
					ToastUtil.showToast(getApplication(), "用户名或者密码错误！");
					return;
				}
				if("Y".equals(response.getErrorFlag())){
					boolean isRuning = getIntent().getExtras()!=null&& getIntent().getExtras().getSerializable("data")!=null;
					if(!isRuning){
//						ToastUtil.showToast(getApplication(),"密码验证成功！");
					}
					SystemApplcation systemApplcation = (SystemApplcation) getApplication();
					systemApplcation.setStaffDict(response.getDOCINVHISInLoginSrvOutputCollection().getDOCINVHISInLoginSrvOutputItem().get(0));
					DOCINVHISInLoginSrvOutputItem userInfo = response.getDOCINVHISInLoginSrvOutputCollection().getDOCINVHISInLoginSrvOutputItem().get(0);
					Editor editor = preferences.edit();
					editor.putString("pjoadept", userInfo.getOadeptid()==null?"":userInfo.getOadeptid());
					editor.commit();
					
					if(isRuning){
						intent.putExtras(getIntent().getExtras());
					}
					if(userInfo.getTITLE().trim().equals("管理员")){
						//管理员需进行人脸验证，才能查看数据报表界面
//						ToastUtil.showToast(getApplication(),"密码验证成功，请进行人脸验证！");
//						intent.putExtra("loginflag", 1);
//						mAuthid = username.getText().toString();
//						// 启动拍照,并保存到临时文件
//						mPictureFile = new File(Environment.getExternalStorageDirectory(), 
//								"picture" + System.currentTimeMillis()/1000 + ".jpg");
//						Intent mIntent_ = new Intent();
//						mIntent_.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
//						mIntent_.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPictureFile));
//						mIntent_.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
//						startActivityForResult(mIntent_, REQUEST_CAMERA_IMAGE);
						
						ToastUtil.showToast(getApplication(),"登录成功！");
						intent.putExtra("loginflag", 1);
						startActivity(intent);
						finish();
					}else if(userInfo.getTITLE().trim().equals("主任医师")){
						ToastUtil.showToast(getApplication(),"登录成功！");
						intent.putExtra("loginflag", 2);
						startActivity(intent);
						finish();
					}else if(userInfo.getTITLE().trim().equals("副主任医师")){
						ToastUtil.showToast(getApplication(),"登录成功！");
						intent.putExtra("loginflag", 3);
						startActivity(intent);
						finish();
					}else{
						ToastUtil.showToast(getApplication(),"登录成功！");
						intent.putExtra("loginflag", 4);
						startActivity(intent);
						finish();
					}
				}else{
					ToastUtil.showToast(getApplication(), "登陆遇到问题，请重试!");
				}
				
			}
			
			@Override
			public void onProgressUpdate(Integer[] values) {
				
			}
			
			@Override
			public void onPreExecute() {
				customerProgress.show();
				
			}
		});
	}

	public void onResume() {
		super.onResume();
	}
	
	public void onPause() {
		super.onPause();
	}
	
	
	@Override
	public void onBackPressed() {
		Builder builder = new Builder(this);
		builder.setTitle("退出提示");
		builder.setMessage("确定要退出吗？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				systemApplcation.exit();
				System.exit(0);
				systemApplcation = null;
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builder.show();
	}
	
	private void verify(JSONObject obj) throws JSONException {
		int ret = obj.getInt("ret");
		if (ret != 0) {
			ToastUtil.showToast(getApplication(), "验证失败");
			return;
		}
		if ("success".equals(obj.get("rst"))) {
			if (obj.getBoolean("verf")) {
//				相似度："+String.valueOf(obj.getDouble("score"))
				ToastUtil.showToast(getApplication(), "人脸验证通过！");
				//删除图片文件
				mPictureFile.delete();
				startActivity(intent);
				finish();
			} else {
				ToastUtil.showToast(getApplication(), "验证不通过");
			}
		} else {
			ToastUtil.showToast(getApplication(), "验证失败");
		}
	}
	
	private RequestListener mRequestListener = new RequestListener() {

		@Override
		public void onEvent(int eventType, Bundle params) {
		}

		@Override
		public void onBufferReceived(byte[] buffer) {
			if (null != mProDialog) {
				mProDialog.dismiss();
			}

			try {
				String result = new String(buffer, "utf-8");
				Log.d("FaceDemo", result);
				
				JSONObject object = new JSONObject(result);
				String type = object.optString("sst");
				if ("verify".equals(type)) {
					verify(object);
				} 
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JSONException e) {
			}
		}

		@Override
		public void onCompleted(SpeechError error) {
			if (null != mProDialog) {
				mProDialog.dismiss();
			}

			if (error != null) {
				switch (error.getErrorCode()) {
				case ErrorCode.MSP_ERROR_ALREADY_EXIST:
					ToastUtil.showToast(getApplication(), "用户名已经被注册！");
					break;
					
				default:
					ToastUtil.showToast(getApplication(), error.getPlainDescription(true));
					break;
				}
			}
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode != RESULT_OK) {
			return;
		}
		
		String fileSrc = null;
		if (requestCode == REQUEST_PICTURE_CHOOSE) {
			if ("file".equals(data.getData().getScheme())) {
				// 有些低版本机型返回的Uri模式为file
				fileSrc = data.getData().getPath();
			} else {
				// Uri模型为content
				String[] proj = {MediaStore.Images.Media.DATA};
				Cursor cursor = getContentResolver().query(data.getData(), proj,
						null, null, null);
				cursor.moveToFirst();
				int idx = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				fileSrc = cursor.getString(idx);
				cursor.close();
			}
			// 跳转到图片裁剪页面
			FaceUtil.cropPicture(this,Uri.fromFile(new File(fileSrc)));
		} else if (requestCode == REQUEST_CAMERA_IMAGE) {
			if (null == mPictureFile) {
				ToastUtil.showToast(getApplication(), "拍照失败，请重试");
				return;
			}
			
			fileSrc = mPictureFile.getAbsolutePath();
			updateGallery(fileSrc);
			// 跳转到图片裁剪页面
			FaceUtil.cropPicture(this,Uri.fromFile(new File(fileSrc)));
		} else if (requestCode == FaceUtil.REQUEST_CROP_IMAGE) {
			// 获取返回数据
			Bitmap bmp = data.getParcelableExtra("data");
			// 若返回数据不为null，保存至本地，防止裁剪时未能正常保存
			if(null != bmp){
				FaceUtil.saveBitmapToFile(LoginActivity.this, bmp);
			}
			// 获取图片保存路径
			fileSrc = FaceUtil.getImagePath(LoginActivity.this);
			// 获取图片的宽和高
			Options options = new Options();
			options.inJustDecodeBounds = true;
			mImage = BitmapFactory.decodeFile(fileSrc, options);
			
			// 压缩图片
			options.inSampleSize = Math.max(1, (int) Math.ceil(Math.max(
					(double) options.outWidth / 1024f,
					(double) options.outHeight / 1024f)));
			options.inJustDecodeBounds = false;
			mImage = BitmapFactory.decodeFile(fileSrc, options);
			
			
			// 若mImageBitmap为空则图片信息不能正常获取
			if(null == mImage) {
				ToastUtil.showToast(getApplication(), "图片信息无法正常获取！");
				return;
			}
			
			// 部分手机会对图片做旋转，这里检测旋转角度
			int degree = FaceUtil.readPictureDegree(fileSrc);
			if (degree != 0) {
				// 把图片旋转为正的方向
				mImage = FaceUtil.rotateImage(degree, mImage);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			//可根据流量及网络状况对图片进行压缩
			mImage.compress(Bitmap.CompressFormat.JPEG, 80, baos);
			mImageData = baos.toByteArray();
			
//			((ImageView) findViewById(R.id.online_img)).setImageBitmap(mImage);
			
			if (null != mImageData) {
				mProDialog.setMessage("验证中...");
				mProDialog.show();
				// 设置用户标识，格式为6-18个字符（由字母、数字、下划线组成，不得以数字开头，不能包含空格）。
				// 当不设置时，云端将使用用户设备的设备ID来标识终端用户。
				mFaceRequest.setParameter(SpeechConstant.AUTH_ID, mAuthid);
				mFaceRequest.setParameter(SpeechConstant.WFR_SST, "verify");
				mFaceRequest.sendRequest(mImageData, mRequestListener);
			} else {
				ToastUtil.showToast(getApplication(), "请选择图片后再验证");
			}
		}
		
	}
	
	private void updateGallery(String filename) {
		MediaScannerConnection.scanFile(this, new String[] {filename}, null,
				new MediaScannerConnection.OnScanCompletedListener() {
					
					@Override
					public void onScanCompleted(String path, Uri uri) {

					}
				});
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}
