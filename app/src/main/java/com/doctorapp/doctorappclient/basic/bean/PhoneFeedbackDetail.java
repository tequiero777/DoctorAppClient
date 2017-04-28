package com.doctorapp.doctorappclient.basic.bean;

import java.util.Date;

/**
 * PhoneFeedbackDetail entity. @author MyEclipse Persistence Tools
 */

public class PhoneFeedbackDetail implements java.io.Serializable {

	// Fields

	private String id;
	private String phoneFeedbackTypeId;
	private String userId;
	private String hspConfigBaseinfoId;
	private String feedbackContent;
	private String contact;
	private String feedbackResult;
	private String isHandle;
	private Date createDate;
	private String createUserId;
	private String createUserName;
	private String tenantId;

	// Constructors

	/** default constructor */
	public PhoneFeedbackDetail() {
	}

	/** minimal constructor */
	public PhoneFeedbackDetail(String phoneFeedbackTypeId,
			String userId, String feedbackContent) {
		this.phoneFeedbackTypeId = phoneFeedbackTypeId;
		this.userId = userId;
		this.feedbackContent = feedbackContent;
	}

	/** full constructor */
	public PhoneFeedbackDetail(String phoneFeedbackTypeId,
			String userId, String hspConfigBaseinfoId,
			String feedbackContent, String contact, String feedbackResult,
			String isHandle, Date createDate, String createUserId,
			String createUserName, String tenantId) {
		this.phoneFeedbackTypeId = phoneFeedbackTypeId;
		this.userId = userId;
		this.hspConfigBaseinfoId = hspConfigBaseinfoId;
		this.feedbackContent = feedbackContent;
		this.contact = contact;
		this.feedbackResult = feedbackResult;
		this.isHandle = isHandle;
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

	public String getPhoneFeedbackTypeId() {
		return this.phoneFeedbackTypeId;
	}

	public void setPhoneFeedbackTypeId(String phoneFeedbackTypeId) {
		this.phoneFeedbackTypeId = phoneFeedbackTypeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHspConfigBaseinfoId() {
		return this.hspConfigBaseinfoId;
	}

	public void setHspConfigBaseinfoId(String hspConfigBaseinfoId) {
		this.hspConfigBaseinfoId = hspConfigBaseinfoId;
	}

	public String getFeedbackContent() {
		return this.feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getFeedbackResult() {
		return this.feedbackResult;
	}

	public void setFeedbackResult(String feedbackResult) {
		this.feedbackResult = feedbackResult;
	}

	public String getIsHandle() {
		return this.isHandle;
	}

	public void setIsHandle(String isHandle) {
		this.isHandle = isHandle;
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