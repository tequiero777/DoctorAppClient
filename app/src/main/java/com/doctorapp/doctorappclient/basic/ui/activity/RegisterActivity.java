package com.doctorapp.doctorappclient.basic.ui.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.SoapObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.doctorapp.doctorappclient.R;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputItem;
import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvResponse;
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
 * <p>Title: 注册人脸</p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Tianjian</p>
 * <p>team: TianjianTeam</p>
 * @author: Yehao
 * @date 2016年7月15日上午11:31:43
 * @version 1.0
 * 
 */
public class RegisterActivity extends Activity implements OnClickListener{
	private final int REQUEST_PICTURE_CHOOSE = 1;
	private final int REQUEST_CAMERA_IMAGE = 2;
	private EditText username;//用户名
	private EditText pwd;//密码
	private ImageButton claer_but;
	private ImageButton toggleButton;
	private boolean toggleBut=false;
	private Bitmap mImage = null;
	private byte[] mImageData = null;
	// authid为6-18个字符长度，用于唯一标识用户
	private Toast mToast;
	// 进度对话框
	private ProgressDialog mProDialog;
	// 拍照得到的照片文件
	private File mPictureFile;
	// FaceRequest对象，集成了人脸识别的各种功能
	private FaceRequest mFaceRequest;
	private ImageButton phone_back_to_login;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		// 在程序入口处传入appid，初始化SDK
		SpeechUtility.createUtility(this, "appid=" + getString(R.string.app_id));
		
		mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
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

	private void initView() {
		phone_back_to_login = (ImageButton) findViewById(R.id.phone_back_to_login);
		phone_back_to_login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		findViewById(R.id.online_reg).setOnClickListener(RegisterActivity.this);
		findViewById(R.id.online_camera).setOnClickListener(RegisterActivity.this);
		
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
		
		username = (EditText)findViewById(R.id.username);
		pwd = (EditText)findViewById(R.id.pwd);
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
	}

	private void register(JSONObject obj) throws JSONException {
		int ret = obj.getInt("ret");
		if (ret != 0) {
			showTip("注册失败");
			return;
		}
		if ("success".equals(obj.get("rst"))) {
			showTip("注册成功");
			finish();
		} else {
			showTip("注册失败");
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
				if ("reg".equals(type)) {
					register(object);
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
					showTip("该用户名已经被注册，请更换后再试");
					break;
					
				default:
					showTip(error.getPlainDescription(true));
					break;
				}
			}
		}
	};
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.online_reg:
			username = ((EditText) findViewById(R.id.username));
			if (TextUtils.isEmpty(username.getText().toString())) {
				showTip("用户名不能为空");
				return;
			}
			
			if (null != mImageData) {
				doLoginFirst();
			} else {
				showTip("请拍照后再注册");
			}
			break;
		case R.id.online_camera:
			// 设置相机拍照后照片保存路径
			mPictureFile = new File(Environment.getExternalStorageDirectory(), 
					"picture" + System.currentTimeMillis()/1000 + ".jpg");
			// 启动拍照,并保存到临时文件
			Intent mIntent = new Intent();
			mIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
			mIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mPictureFile));
			mIntent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
			startActivityForResult(mIntent, REQUEST_CAMERA_IMAGE);
			break;

		default:
			break;
		}
	}

	private void doLoginFirst() {
		if(StringUtil.isBlank(username.getText()+"") || StringUtil.isBlank(pwd.getText()+"")){
			ToastUtil.showToast(RegisterActivity.this, "用户名或密码不能为空");
			return;
		}
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("NAME", username.getText());
		hashMap.put("PWD", pwd.getText());
		queryLogin(hashMap);
	}

	private void showTip(final String str) {
		mToast.setText(str);
		mToast.show();
	}
	
	private void queryLogin(HashMap<String, Object>  request) {
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
					DOCINVHISInLoginSrvOutputItem userInfo = response.getDOCINVHISInLoginSrvOutputCollection().getDOCINVHISInLoginSrvOutputItem().get(0);
					if(userInfo.getTITLE().equals("管理员")){
						//进行注册人脸
						// 设置用户标识，格式为6-18个字符（由字母、数字、下划线组成，不得以数字开头，不能包含空格）。
						// 当不设置时，云端将使用用户设备的设备ID来标识终端用户。
						mProDialog.setMessage("人脸注册中...");
						mProDialog.show();
						mFaceRequest.setParameter(SpeechConstant.AUTH_ID, username.getText().toString());
						mFaceRequest.setParameter(SpeechConstant.WFR_SST, "reg");
						mFaceRequest.sendRequest(mImageData, mRequestListener);
					}else{
						ToastUtil.showToast(getApplication(), "当前用户没有注册人脸权限！");
					}
					
				}else{
					ToastUtil.showToast(getApplication(), "验证遇到问题，请重试!");
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
				showTip("拍照失败，请重试");
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
				FaceUtil.saveBitmapToFile(RegisterActivity.this, bmp);
			}
			// 获取图片保存路径
			fileSrc = FaceUtil.getImagePath(RegisterActivity.this);
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
				showTip("图片信息无法正常获取！");
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
			
			((ImageView) findViewById(R.id.online_img)).setImageBitmap(mImage);
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
	public void finish() {
		if (null != mProDialog) {
			mProDialog.dismiss();
		}
		super.finish();
	}
}
