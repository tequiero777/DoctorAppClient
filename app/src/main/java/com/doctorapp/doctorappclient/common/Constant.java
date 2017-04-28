package com.doctorapp.doctorappclient.common;

import com.doctorapp.doctorappclient.util.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;



public class Constant {
	//15922911693 123456

	/*********************************** http配置信息*****************************************/
	/** 地址端口*/
	public static String IP_ADDRESS = PropertiesUtil.getProperty("IP_ADDRESS");
	/*** ws地址 ***/
	public static final String SERVER_URL = IP_ADDRESS+"/JinChuangServer";
//	public static final String SERVER_URL = IP_ADDRESS+"/DWMSWS";
	
	public static final String KEY_STORE_PASSWORD = "123456";
	public static final String KEY_STORE_TRUST_PASSWORD = "123456";
	public static final int HTTPS_PORT = 8443;
	public static final String KEY_STORE_CLIENT_PATH = "com/doctorapp/basic/core/certificate/client.key.p12";
	public static final String KEY_STORE_TRUST_PATH = "com/doctorapp/basic/core/certificate/client.truststore";

	/** 服务器webservice地址前缀 */
	public static final String SERVER_WEBSERVICE_URL_PREFIX = SERVER_URL + "/ws";

	/**
	 * 服务器根目录
	 */
	public static final String SERVER_ROOT= SERVER_URL;
	
	/** 每页加载的数量 */
	public static final int PAGE_SIZE = 100;
	/**
	 * 下载地址
	 */
	public static String downloadDir = "";
	
	/**
	 * 租户id
	 */
	public static String TENANT_ID = PropertiesUtil.getProperty("TENANT_ID");
	public static String PASSWORD = PropertiesUtil.getProperty("PASSWORD");
	//ws请求用户名密码
	public static final String WS_USERNAME="tianjian-ws";
	public static final String WS_PASSWORD="tianjianquyu-panjin-ws";
	
	public static String getServerWsUrl(String key) {
		return putServerWsUrl().get(key);
	}

	public static String getServerNs(String key) {
		return putServerNameSpace().get(key);
	}

	/**
	 * 服务器WS地址
	 */
	private static Map<String, String> putServerWsUrl() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginWs", SERVER_WEBSERVICE_URL_PREFIX + "/login");
		map.put("deptWs", SERVER_WEBSERVICE_URL_PREFIX + "/dept");
		map.put("patientListWs", SERVER_WEBSERVICE_URL_PREFIX + "/patientList");
		map.put("InQueryStatReportSrvWs", SERVER_WEBSERVICE_URL_PREFIX + "/InQueryStatReportSrv");
		map.put("appUpdateWs", SERVER_WEBSERVICE_URL_PREFIX + "/appUpdateWs");
		return map;
	}

	/**
	 * 服务器命名空间
	 */
	private static Map<String, String> putServerNameSpace() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginWs", "http://tj.his.com/DOC_INV_HIS_InLoginSrv");
		map.put("deptWs", "http://tj.his.com/DOC_INV_HIS_InQueryDeptSrv");
		map.put("patientListWs", "http://tj.his.com/DOC_INV_HIS_InQueryPatientSrv");
		map.put("InQueryStatReportSrvWs", "http://tj.his.com/DOC_INV_HIS_InQueryStatReportSrv");
		map.put("appUpdateWs", "http://tj.his.com/DOC_INV_HIS_InQueryAppUpdateSrv");
		return map;
	}
}
