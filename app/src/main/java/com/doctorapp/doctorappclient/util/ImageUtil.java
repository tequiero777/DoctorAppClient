package com.doctorapp.doctorappclient.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

public class ImageUtil {
	protected static ImageLoader imageLoader = ImageLoader.getInstance();

	protected static DisplayImageOptions options;
	
	public static void loadImage(ImageView imageView,String uri,Context context){
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
		options = new DisplayImageOptions.Builder()
//		.showImageOnLoading(R.drawable.ic_stub)
//		.showImageForEmptyUri(R.drawable.ic_empty)
//		.showImageOnFail(R.drawable.ic_error)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
		imageLoader.displayImage(uri, imageView, options);
	}
	
	public static void loadImage(ImageView imageView,String uri,SimpleImageLoadingListener simpleImageLoadingListener){
		options = new DisplayImageOptions.Builder()
	//	.showImageOnLoading(R.drawable.ic_stub)
	//	.showImageForEmptyUri(R.drawable.ic_empty)
	//	.showImageOnFail(R.drawable.ic_error)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
		imageLoader.displayImage(uri, imageView, options,simpleImageLoadingListener);
	}
}
