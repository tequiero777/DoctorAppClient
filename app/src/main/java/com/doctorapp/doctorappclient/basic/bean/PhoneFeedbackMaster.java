package com.doctorapp.doctorappclient.basic.bean;

import java.util.Date;

/**
 * PhoneFeedbackMaster entity. @author MyEclipse Persistence Tools
 */

public class PhoneFeedbackMaster implements java.io.Serializable {

	// Fields

	private String id;
	private String phoneFeedbackType;
	private String inputCode;
	private Date createDate;
	private String createUserId;
	private String createUserName;
	private String tenantId;

	// Constructors

	/** default constructor */
	public PhoneFeedbackMaster() {
	}

	/** minimal constructor */
	public PhoneFeedbackMaster(String phoneFeedbackType, String inputCode) {
		this.phoneFeedbackType = phoneFeedbackType;
		this.inputCode = inputCode;
	}

	/** full constructor */
	public PhoneFeedbackMaster(String phoneFeedbackType, String inputCode,
			Date createDate, String createUserId, String createUserName,
			String tenantId) {
		this.phoneFeedbackType = phoneFeedbackType;
		this.inputCode = inputCode;
		this.createDate = createDate;
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

	public String getPhoneFeedbackType() {
		return this.phoneFeedbackType;
	}

	public void setPhoneFeedbackType(String phoneFeedbackType) {
		this.phoneFeedbackType = phoneFeedbackType;
	}

	public String getInputCode() {
		return this.inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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