package com.doctorapp.doctorappclient.util;

import java.util.ArrayList;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;


public class Utils {
	
	private static Toast toast;
	/**
	 * 消息
	 * @param context
	 * @param msg
	 */

	public static void show(Context context,String msg){
		if(toast==null){
			toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		}else{
			toast.setText(msg);
			toast.setDuration(Toast.LENGTH_LONG);
		}
		toast.show();
	}
	/**
	 * 判断服务是否启动
	 * @param context
	 * @param serverName
	 * @return
	 */
	public static boolean isWorked(Context context,String serverName){
		ActivityManager myManager=(ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
		ArrayList<RunningServiceInfo> runningService = (ArrayList<RunningServiceInfo>) myManager.getRunningServices(30);
		for(int i = 0 ; i<runningService.size();i++){
			if(runningService.get(i).service.getClassName().toString().equals(serverName)){
				return true;
			}
		}
		return false;
	}
	/**
	 * 根据身份证号码算性别
	 * @param idNo
	 * @return
	 */
	public static String getSexFromIdNo(String idNo){
		String commConfigSexName = "";
		String sex = idNo.substring(idNo.length() - 2, idNo.length() - 1);
		if(Integer.parseInt(sex) % 2 == 0){
			commConfigSexName = "女";
		}else{
			commConfigSexName = "男";
		}
		return commConfigSexName;
	}
	/**
     * 用于将给定的内容生成成一维码 注：目前生成内容为中文的话将直接报错，要修改底层jar包的内容
     *
     * @param content 将要生成一维码的内容
     * @return 返回生成好的一维码bitmap
     * @throws WriterException WriterException异常
     */
	public static Bitmap CreateOneDCode(String content,int wide,int high) throws WriterException {
		// 生成一维条码,编码时指定大小,不要生成了图片以后再进行缩放,这样会模糊导致识别失败
		BitMatrix matrix = new MultiFormatWriter().encode(content,
				BarcodeFormat.CODE_128, wide, high);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		int[] pixels = new int[width * height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (matrix.get(x, y)) {
					pixels[y * width + x] = 0xff000000;
				}
			}
		}

		Bitmap bitmap = Bitmap.createBitmap(width, height,
				Bitmap.Config.ARGB_8888);
		// 通过像素数组生成bitmap,具体参考api
		bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
		return bitmap;
	}
}
