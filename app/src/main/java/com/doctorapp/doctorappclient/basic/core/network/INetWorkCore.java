package com.doctorapp.doctorappclient.basic.core.network;

import java.io.File;
import java.util.List;
import java.util.Map;


import com.doctorapp.doctorappclient.basic.bean.FormFile;


/**
 * 
 * @author luoqb
 *
 * @param <T> 
 */
public interface INetWorkCore {
	
	/**
     * 提交post 提交的方式
     * @param url   请求的url地址
     * @param clazz 请求的对象
     * @return  返回json字符串
     */
	public String postDataBySsl(String url, String jsonStr, String authorization);
	
    /**
     * 提交post 提交表单的方式
     * @param url   请求的url地址
     * @param clazz 请求的对象
     * @return  返回json字符串
     */
	public String postDataFormBySsl(String url, Map<String, Object> params, String authorization);
	/**
	 * post多文件上传
	 * @param path   请求的url地址
	 * @param params 参数
	 * @param files  文件集合
	 * @return
	 * @throws Exception
	 */
	public String postFile(String path, Map<String, String> params, List<FormFile> fileByte) throws Exception;
	
	/**
	 * ws请求
	 */
	
	public String postWsData(String methodName, String jsonStr, String serverMethod, String type);
}
