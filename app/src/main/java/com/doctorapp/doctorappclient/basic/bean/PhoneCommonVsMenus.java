package com.doctorapp.doctorappclient.basic.bean;

/**
 * PhoneCommonVsMenus entity. @author MyEclipse Persistence Tools
 */

public class PhoneCommonVsMenus implements java.io.Serializable {

	// Fields

	private String id;
	private String securityConfigMenusId;
	private String phoneUserId;
	private String comments;
	private String tenantId;

	// Constructors

	/** default constructor */
	public PhoneCommonVsMenus() {
	}

	/** full constructor */
	public PhoneCommonVsMenus(String securityConfigMenusId,
			String phoneUserId, String comments, String tenantId) {
		this.securityConfigMenusId = securityConfigMenusId;
		this.phoneUserId = phoneUserId;
		this.comments = comments;
		this.tenantId = tenantId;
	}

	// Property accessors

	public String getPhoneUserIdUserId() {
		return phoneUserId;
	}

	public void setPhoneUserId(String phoneUserId) {
		this.phoneUserId = phoneUserId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecurityConfigMenusId() {
		return this.securityConfigMenusId;
	}

	public void setSecurityConfigMenusId(String securityConfigMenusId) {
		this.securityConfigMenusId = securityConfigMenusId;
	}


	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}