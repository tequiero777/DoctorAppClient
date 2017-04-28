package com.doctorapp.doctorappclient.basic.bean;
import java.io.Serializable;

public class PatientInfo implements Serializable {
private  String patientId;
private String idNo;
private String name;
private String securityId;

public String getSecurityId() {
	return securityId;
}
public void setSecurityId(String securityId) {
	this.securityId = securityId;
}
public String getPatientId() {
	return patientId;
}
public void setPatientId(String patientId) {
	this.patientId = patientId;
}
public String getIdNo() {
	return idNo;
}
public void setIdNo(String idNo) {
	this.idNo = idNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
