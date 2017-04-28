package com.doctorapp.doctorappclient.util;

public class VerifyIdCard {
	// wi =2(n-1)(mod 11);加权因子
	static final int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	// 校验码
	final static int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };
	private static int[] ai = new int[18];

	public VerifyIdCard() {
	}

	// 校验身份证的校验码
	public static boolean verify(String idcard) {
		if (idcard.length() == 15) {
			idcard = uptoeighteen(idcard);
		}
		if (idcard.length() != 18) {
			return false;
		}
		String verify = idcard.substring(17, 18);
		if (verify.equals(getVerify(idcard))) {
			return true;
		}
		return false;
	}

	// 15位转18位
	public static String uptoeighteen(String fifteen) {
		StringBuffer eighteen = new StringBuffer(fifteen);
		eighteen = eighteen.insert(6, "19");
		return eighteen.toString();
	}

	// 计算最后一位校验值
	public static String getVerify(String eighteen) {
		int remain = 0;
		if (eighteen.length() == 18) {
			eighteen = eighteen.substring(0, 17);
		}
		if (eighteen.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eighteen.substring(i, i + 1);
				ai[i] = Integer.valueOf(k);
			}
			for (int i = 0; i < 17; i++) {
				sum += wi[i] * ai[i];
			}
			remain = sum % 11;
		}
		return remain == 2 ? "X" : String.valueOf(vi[remain]);

	}
	
	
	//从身份证号提取出生日期
	/**
	* 从身份证获取出生日期
	* @param cardNumber 已经校验合法的身份证号
	* @return Strig YYYY-MM-DD 出生日期
	*/
	public static String getBirthDateFromCard(String cardNumber){
	String card = cardNumber.trim();
	    String year;
	    String month;
	    String day;
	    if (card.length()==18){ //处理18位身份证
	        year=card.substring(6,10);
	        month=card.substring(10,12);
	        day=card.substring(12,14);
	    }else{ //处理非18位身份证
	    year=card.substring(6,8);
	        month=card.substring(8,10);
	        day=card.substring(10,12);
	    year="19"+year;        
	    }
	    if (month.length()==1){
	        month="0"+month; //补足两位
	    }
	    if (day.length()==1){
	        day="0"+day; //补足两位
	    }
	    return year+"-"+month+"-"+day;
	}

}
