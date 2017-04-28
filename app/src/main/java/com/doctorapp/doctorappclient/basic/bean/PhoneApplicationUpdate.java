package com.doctorapp.doctorappclient.basic.bean;

import java.util.Date;

/**
 * PhoneApplicationUpdate entity. @author MyEclipse Persistence Tools
 */

public class PhoneApplicationUpdate implements java.io.Serializable {

	// Fields

	private String id;
	private String version;
	private String updateUrl;
	private String updateFlag;
	private Date createDate;
	private String createUserId;
	private String createUserName;
	private String tenantId;

	// Constructors

	/** default constructor */
	public PhoneApplicationUpdate() {
	}

	/** minimal constructor */
	public PhoneApplicationUpdate(String version, String updateUrl,
			String updateFlag) {
		this.version = version;
		this.updateUrl = updateUrl;
		this.updateFlag = updateFlag;
	}

	/** full constructor */
	public PhoneApplicationUpdate(String version, String updateUrl,
			String updateFlag, Date createDate, String createUserId,
			String createUserName, String tenantId) {
		this.version = version;
		this.updateUrl = updateUrl;
		this.updateFlag = updateFlag;
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

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUpdateUrl() {
		return this.updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getUpdateFlag() {
		return this.updateFlag;
	}

	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
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