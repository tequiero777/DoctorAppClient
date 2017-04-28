
package com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv;

import java.util.Hashtable;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


/**
 * <p>DOC_INV_HIS_InQueryPatientSrvOutputItem complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryPatientSrvOutputItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PATIENT_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PATIENT_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VISIT_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DEPT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="WARD_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BED_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ADMISSION_DATE_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ADM_WARD_DATE_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DIAGNOSIS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PATIENT_CONDITION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NURSING_CLASS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DOCTOR_IN_CHARGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OPERATING_DATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BILLING_DATE_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PREPAYMENTS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TOTAL_COSTS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TOTAL_CHARGES" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GUARANTOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GUARANTOR_ORG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GUARANTOR_PHONE_NUM" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BILL_CHECKED_DATE_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SETTLED_INDICATOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LEND_BED_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BED_DEPT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BED_WARD_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DEPT_CODE_LEND" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LEND_INDICATOR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IS_NEWBORN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SEX" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ADMISSIONSECTIONS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ADMISSIONHOSPITAL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DISCHARGESECTIONS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DISCHARGEHOSPITAL" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryPatientSrvOutputItem implements KvmSerializable {

    protected String patientid;
    protected String patientname;
    protected String visitid;
    protected String deptcode;
    protected String wardcode;
    protected String bedno;
    protected String admissiondatetime;
    protected String admwarddatetime;
    protected String diagnosis;
    protected String patientcondition;
    protected String nursingclass;
    protected String doctorincharge;
    protected String operatingdate;
    protected String billingdatetime;
    protected String prepayments;
    protected String totalcosts;
    protected String totalcharges;
    protected String guarantor;
    protected String guarantororg;
    protected String guarantorphonenum;
    protected String billcheckeddatetime;
    protected String settledindicator;
    protected String lendbedno;
    protected String beddeptcode;
    protected String bedwardcode;
    protected String deptcodelend;
    protected String lendindicator;
    protected String isnewborn;
    protected String sex;
    protected String age;
    protected String focused;
    protected String namephonetic;
    protected String identity;
    protected String chargetype;
    private String isChecked;
    protected String dischargesections;
    protected String dischargehospital;
    protected String admissionsections;
    protected String admissionhospital;
    /**
     * ��ȡpatientid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPATIENTID() {
        return patientid;
    }

    /**
     * ����patientid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPATIENTID(String value) {
        this.patientid = value;
    }

    /**
     * ��ȡpatientname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPATIENTNAME() {
        return patientname;
    }

    /**
     * ����patientname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPATIENTNAME(String value) {
        this.patientname = value;
    }

    /**
     * ��ȡvisitid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVISITID() {
        return visitid;
    }

    /**
     * ����visitid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVISITID(String value) {
        this.visitid = value;
    }

    /**
     * ��ȡdeptcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTCODE() {
        return deptcode;
    }

    /**
     * ����deptcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTCODE(String value) {
        this.deptcode = value;
    }

    /**
     * ��ȡwardcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWARDCODE() {
        return wardcode;
    }

    /**
     * ����wardcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWARDCODE(String value) {
        this.wardcode = value;
    }

    /**
     * ��ȡbedno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBEDNO() {
        return bedno;
    }

    /**
     * ����bedno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBEDNO(String value) {
        this.bedno = value;
    }

    /**
     * ��ȡadmissiondatetime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADMISSIONDATETIME() {
        return admissiondatetime;
    }

    /**
     * ����admissiondatetime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADMISSIONDATETIME(String value) {
        this.admissiondatetime = value;
    }

    /**
     * ��ȡadmwarddatetime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADMWARDDATETIME() {
        return admwarddatetime;
    }

    /**
     * ����admwarddatetime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADMWARDDATETIME(String value) {
        this.admwarddatetime = value;
    }

    /**
     * ��ȡdiagnosis���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIAGNOSIS() {
        return diagnosis;
    }

    /**
     * ����diagnosis���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIAGNOSIS(String value) {
        this.diagnosis = value;
    }

    /**
     * ��ȡpatientcondition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPATIENTCONDITION() {
        return patientcondition;
    }

    /**
     * ����patientcondition���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPATIENTCONDITION(String value) {
        this.patientcondition = value;
    }

    /**
     * ��ȡnursingclass���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNURSINGCLASS() {
        return nursingclass;
    }

    /**
     * ����nursingclass���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNURSINGCLASS(String value) {
        this.nursingclass = value;
    }

    /**
     * ��ȡdoctorincharge���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCTORINCHARGE() {
        return doctorincharge;
    }

    /**
     * ����doctorincharge���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCTORINCHARGE(String value) {
        this.doctorincharge = value;
    }

    /**
     * ��ȡoperatingdate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATINGDATE() {
        return operatingdate;
    }

    /**
     * ����operatingdate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATINGDATE(String value) {
        this.operatingdate = value;
    }

    /**
     * ��ȡbillingdatetime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBILLINGDATETIME() {
        return billingdatetime;
    }

    /**
     * ����billingdatetime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBILLINGDATETIME(String value) {
        this.billingdatetime = value;
    }

    /**
     * ��ȡprepayments���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPREPAYMENTS() {
        return prepayments;
    }

    /**
     * ����prepayments���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPREPAYMENTS(String value) {
        this.prepayments = value;
    }

    /**
     * ��ȡtotalcosts���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALCOSTS() {
        return totalcosts;
    }

    /**
     * ����totalcosts���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALCOSTS(String value) {
        this.totalcosts = value;
    }

    /**
     * ��ȡtotalcharges���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALCHARGES() {
        return totalcharges;
    }

    /**
     * ����totalcharges���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALCHARGES(String value) {
        this.totalcharges = value;
    }

    /**
     * ��ȡguarantor���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUARANTOR() {
        return guarantor;
    }

    /**
     * ����guarantor���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUARANTOR(String value) {
        this.guarantor = value;
    }

    /**
     * ��ȡguarantororg���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUARANTORORG() {
        return guarantororg;
    }

    /**
     * ����guarantororg���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUARANTORORG(String value) {
        this.guarantororg = value;
    }

    /**
     * ��ȡguarantorphonenum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUARANTORPHONENUM() {
        return guarantorphonenum;
    }

    /**
     * ����guarantorphonenum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUARANTORPHONENUM(String value) {
        this.guarantorphonenum = value;
    }

    /**
     * ��ȡbillcheckeddatetime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBILLCHECKEDDATETIME() {
        return billcheckeddatetime;
    }

    /**
     * ����billcheckeddatetime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBILLCHECKEDDATETIME(String value) {
        this.billcheckeddatetime = value;
    }

    /**
     * ��ȡsettledindicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSETTLEDINDICATOR() {
        return settledindicator;
    }

    /**
     * ����settledindicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSETTLEDINDICATOR(String value) {
        this.settledindicator = value;
    }

    /**
     * ��ȡlendbedno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLENDBEDNO() {
        return lendbedno;
    }

    /**
     * ����lendbedno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLENDBEDNO(String value) {
        this.lendbedno = value;
    }

    /**
     * ��ȡbeddeptcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBEDDEPTCODE() {
        return beddeptcode;
    }

    /**
     * ����beddeptcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBEDDEPTCODE(String value) {
        this.beddeptcode = value;
    }

    /**
     * ��ȡbedwardcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBEDWARDCODE() {
        return bedwardcode;
    }

    /**
     * ����bedwardcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBEDWARDCODE(String value) {
        this.bedwardcode = value;
    }

    /**
     * ��ȡdeptcodelend���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTCODELEND() {
        return deptcodelend;
    }

    /**
     * ����deptcodelend���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTCODELEND(String value) {
        this.deptcodelend = value;
    }

    /**
     * ��ȡlendindicator���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLENDINDICATOR() {
        return lendindicator;
    }

    /**
     * ����lendindicator���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLENDINDICATOR(String value) {
        this.lendindicator = value;
    }

    /**
     * ��ȡisnewborn���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISNEWBORN() {
        return isnewborn;
    }

    /**
     * ����isnewborn���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISNEWBORN(String value) {
        this.isnewborn = value;
    }

    /**
     * ��ȡsex���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEX() {
        return sex;
    }

    /**
     * ����sex���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEX(String value) {
        this.sex = value;
    }

    /**
     * ��ȡage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAGE() {
        return age;
    }

    /**
     * ����age���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAGE(String value) {
        this.age = value;
    }
    
    /**
     * ��ȡage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOCUSED() {
        return focused;
    }

    /**
     * ����age���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOCUSED(String value) {
        this.focused = value;
    }

    public String getNamephonetic() {
		return namephonetic;
	}

	public void setNamephonetic(String namephonetic) {
		this.namephonetic = namephonetic;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getChargetype() {
		return chargetype;
	}

	public void setChargetype(String chargetype) {
		this.chargetype = chargetype;
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:return patientid;
		case 1:return patientname;
		case 2:return visitid;
		case 3:return deptcode;
		case 4:return wardcode;
		case 5:return bedno;
		case 6:return admissiondatetime;
		case 7:return admwarddatetime;
		case 8:return diagnosis;
		case 9:return patientcondition;
		case 10:return nursingclass;
		case 11:return doctorincharge;
		case 12:return operatingdate;
		case 13:return billingdatetime;
		case 14:return prepayments;
		case 15:return totalcosts;
		case 16:return totalcharges;
		case 17:return guarantor;
		case 18:return guarantororg;
		case 19:return guarantorphonenum;
		case 20:return billcheckeddatetime;
		case 21:return settledindicator;
		case 22:return lendbedno;
		case 23:return beddeptcode;
		case 24:return bedwardcode;
		case 25:return deptcodelend;
		case 26:return lendindicator;
		case 27:return isnewborn;
		case 28:return sex;
		case 29:return age;
		case 30:return focused;
		case 31:return namephonetic;
		case 32:return identity;
		case 33:return chargetype;
		case 34:return dischargesections;
		case 35:return dischargehospital;
		case 36:return admissionsections;
		case 37:return admissionhospital;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 38;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:info.name ="PATIENT_ID";info.type = PropertyInfo.STRING_CLASS;break;
		case 1:info.name ="PATIENT_NAME";info.type = PropertyInfo.STRING_CLASS;break;
		case 2:info.name ="VISIT_ID";info.type = PropertyInfo.STRING_CLASS;break;
		case 3:info.name ="DEPT_CODE";info.type = PropertyInfo.STRING_CLASS;break;
		case 4:info.name ="WARD_CODE";info.type = PropertyInfo.STRING_CLASS;break;
		case 5:info.name ="BED_NO";info.type = PropertyInfo.STRING_CLASS;break;
		case 6:info.name ="ADMISSION_DATE_TIME";info.type = PropertyInfo.STRING_CLASS;break;
		case 7:info.name ="ADM_WARD_DATE_TIME";info.type = PropertyInfo.STRING_CLASS;break;
		case 8:info.name ="DIAGNOSIS";info.type = PropertyInfo.STRING_CLASS;break;
		case 9:info.name ="PATIENT_CONDITION";info.type = PropertyInfo.STRING_CLASS;break;
		case 10:info.name ="NURSING_CLASS";info.type = PropertyInfo.STRING_CLASS;break;
		case 11:info.name ="DOCTOR_IN_CHARGE";info.type = PropertyInfo.STRING_CLASS;break;
		case 12:info.name ="OPERATING_DATE";info.type = PropertyInfo.STRING_CLASS;break;
		case 13:info.name ="BILLING_DATE_TIME";info.type = PropertyInfo.STRING_CLASS;break;
		case 14:info.name ="PREPAYMENTS";info.type = PropertyInfo.STRING_CLASS;break;
		case 15:info.name ="TOTAL_COSTS";info.type = PropertyInfo.STRING_CLASS;break;
		case 16:info.name ="TOTAL_CHARGES";info.type = PropertyInfo.STRING_CLASS;break;
		case 17:info.name ="GUARANTOR";info.type = PropertyInfo.STRING_CLASS;break;
		case 18:info.name ="GUARANTOR_ORG";info.type = PropertyInfo.STRING_CLASS;break;
		case 19:info.name ="GUARANTOR_PHONE_NUM";info.type = PropertyInfo.STRING_CLASS;break;
		case 20:info.name ="BILL_CHECKED_DATE_TIME";info.type = PropertyInfo.STRING_CLASS;break;
		case 21:info.name ="SETTLED_INDICATOR";info.type = PropertyInfo.STRING_CLASS;break;
		case 22:info.name ="LEND_BED_NO";info.type = PropertyInfo.STRING_CLASS;break;
		case 23:info.name ="BED_DEPT_CODE";info.type = PropertyInfo.STRING_CLASS;break;
		case 24:info.name ="BED_WARD_CODE";info.type = PropertyInfo.STRING_CLASS;break;
		case 25:info.name ="DEPT_CODE_LEND";info.type = PropertyInfo.STRING_CLASS;break;
		case 26:info.name ="LEND_INDICATOR";info.type = PropertyInfo.STRING_CLASS;break;
		case 27:info.name ="IS_NEWBORN";info.type = PropertyInfo.STRING_CLASS;break;
		case 28:info.name ="SEX";info.type = PropertyInfo.STRING_CLASS;break;
		case 29:info.name ="AGE";info.type = PropertyInfo.STRING_CLASS;break;
		case 30:info.name ="FOCUSED";info.type = PropertyInfo.STRING_CLASS;break;
		case 31:info.name ="NAME_PHONETIC";info.type = PropertyInfo.STRING_CLASS;break;
		case 32:info.name ="IDENTITY";info.type = PropertyInfo.STRING_CLASS;break;
		case 33:info.name ="CHARGE_TYPE";info.type = PropertyInfo.STRING_CLASS;break;
		case 34:info.name ="DISCHARGESECTIONS";info.type = PropertyInfo.STRING_CLASS;break;
		case 35:info.name ="DISCHARGEHOSPITAL";info.type = PropertyInfo.STRING_CLASS;break;
		case 36:info.name ="ADMISSIONSECTIONS";info.type = PropertyInfo.STRING_CLASS;break;
		case 37:info.name ="ADMISSIONHOSPITAL";info.type = PropertyInfo.STRING_CLASS;break;
		default:
			break;
		}

	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:  patientid = toString(arg1);
		case 1:  patientname = toString(arg1);
		case 2:  visitid = toString(arg1);
		case 3:  deptcode = toString(arg1);
		case 4:  wardcode = toString(arg1);
		case 5:  bedno = toString(arg1);
		case 6:  admissiondatetime = toString(arg1);
		case 7:  admwarddatetime = toString(arg1);
		case 8:  diagnosis = toString(arg1);
		case 9:  patientcondition = toString(arg1);
		case 10:  nursingclass = toString(arg1);
		case 11:  doctorincharge = toString(arg1);
		case 12:  operatingdate = toString(arg1);
		case 13:  billingdatetime = toString(arg1);
		case 14:  prepayments = toString(arg1);
		case 15:  totalcosts = toString(arg1);
		case 16:  totalcharges = toString(arg1);
		case 17:  guarantor = toString(arg1);
		case 18:  guarantororg = toString(arg1);
		case 19:  guarantorphonenum = toString(arg1);
		case 20:  billcheckeddatetime = toString(arg1);
		case 21:  settledindicator = toString(arg1);
		case 22:  lendbedno = toString(arg1);
		case 23:  beddeptcode = toString(arg1);
		case 24:  bedwardcode = toString(arg1);
		case 25:  deptcodelend = toString(arg1);
		case 26:  lendindicator = toString(arg1);
		case 27:  isnewborn = toString(arg1);
		case 28:  sex = toString(arg1);
		case 29:  age = toString(arg1);
		case 30:  focused = toString(arg1);
		case 31:  namephonetic = toString(arg1);
		case 32:  identity = toString(arg1);
		case 33:  chargetype = toString(arg1);
		case 34:  dischargesections = toString(arg1);
		case 35:  dischargehospital = toString(arg1);
		case 36:  admissionsections = toString(arg1);
		case 37:  admissionhospital = toString(arg1);
		default:
			break;
		}
		
	}
	/**
	*TODO
	* @Title: toString
	* @param arg1
	* @return
	* @return String
	* @throws
	* @author Leipeijie
	*/
	private String toString(Object arg1) {
		return arg1==null?"":arg1+"";
	}

	public String getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}

	public String getDischargesections() {
		return dischargesections;
	}

	public void setDischargesections(String dischargesections) {
		this.dischargesections = dischargesections;
	}

	public String getDischargehospital() {
		return dischargehospital;
	}

	public void setDischargehospital(String dischargehospital) {
		this.dischargehospital = dischargehospital;
	}

	public String getAdmissionsections() {
		return admissionsections;
	}

	public void setAdmissionsections(String admissionsections) {
		this.admissionsections = admissionsections;
	}

	public String getAdmissionhospital() {
		return admissionhospital;
	}

	public void setAdmissionhospital(String admissionhospital) {
		this.admissionhospital = admissionhospital;
	}

    
}
