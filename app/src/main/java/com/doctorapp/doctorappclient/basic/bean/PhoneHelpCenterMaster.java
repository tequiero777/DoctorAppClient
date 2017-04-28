package com.doctorapp.doctorappclient.basic.bean;

import java.util.Date;

/**
 * PhoneHelpCenterMaster entity. @author MyEclipse Persistence Tools
 */

public class PhoneHelpCenterMaster implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 246719020950244413L;
	private String id;
	private String phoneHelpCenterTypeName;
	private String inputCode;
	private String phoneHelpCenterConter;
//	private Date createDate;
	private String createUserId;
	private String createUserName;
	private String tenantId;

	// Constructors

	/** default constructor */
	public PhoneHelpCenterMaster() {
	}

	/** minimal constructor */
	public PhoneHelpCenterMaster(String phoneHelpCenterTypeName) {
		this.phoneHelpCenterTypeName = phoneHelpCenterTypeName;
	}

	/** full constructor */
	public PhoneHelpCenterMaster(String phoneHelpCenterTypeName,
			String inputCode, String phoneHelpCenterConter, 
			String createUserId, String createUserName, String tenantId) {
		this.phoneHelpCenterTypeName = phoneHelpCenterTypeName;
		this.inputCode = inputCode;
		this.phoneHelpCenterConter = phoneHelpCenterConter;
//		this.createDate = createDate;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.tenantId = tenantId;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoneHelpCenterTypeName() {
		return this.phoneHelpCenterTypeName;
	}

	public void setPhoneHelpCenterTypeName(String phoneHelpCenterTypeName) {
		this.phoneHelpCenterTypeName = phoneHelpCenterTypeName;
	}

	

	

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

//	public Date getCreateDate() {
//		return createDate;
//	}
//
//	public void setCreateDate(Date createDate) {
//		this.createDate = createDate;
//	}

	public String getPhoneHelpCenterConter() {
		return this.phoneHelpCenterConter;
	}

	public void setPhoneHelpCenterConter(String phoneHelpCenterConter) {
		this.phoneHelpCenterConter = phoneHelpCenterConter;
	}


	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}