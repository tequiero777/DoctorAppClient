
package com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv;

import java.math.BigDecimal;
import java.util.Hashtable;

import javax.xml.datatype.XMLGregorianCalendar;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


/**
 * <p>MsgHeader complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="MsgHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SOURCESYSTEMID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SOURCESYSTEMNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USERID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USERNAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USERPWD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SUBMITDATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PAGE_SIZE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="CURRENT_PAGE" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="TOTAL_RECORD" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="PROVINCE_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ENVIRONMENT_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class MsgHeader implements KvmSerializable{
    protected String sourcesystemid;
    protected String sourcesystemname;
    protected String userid;
    protected String username;
    protected String userpwd;
    protected XMLGregorianCalendar submitdate;
    protected BigDecimal pagesize;
    protected BigDecimal currentpage;
    protected BigDecimal totalrecord;
    protected String provincecode;
    protected String environmentname;

    /**
     * ��ȡsourcesystemid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCESYSTEMID() {
        return sourcesystemid;
    }

    /**
     * ����sourcesystemid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCESYSTEMID(String value) {
        this.sourcesystemid = value;
    }

    /**
     * ��ȡsourcesystemname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSOURCESYSTEMNAME() {
        return sourcesystemname;
    }

    /**
     * ����sourcesystemname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSOURCESYSTEMNAME(String value) {
        this.sourcesystemname = value;
    }

    /**
     * ��ȡuserid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERID() {
        return userid;
    }

    /**
     * ����userid���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERID(String value) {
        this.userid = value;
    }

    /**
     * ��ȡusername���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERNAME() {
        return username;
    }

    /**
     * ����username���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERNAME(String value) {
        this.username = value;
    }

    /**
     * ��ȡuserpwd���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSERPWD() {
        return userpwd;
    }

    /**
     * ����userpwd���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSERPWD(String value) {
        this.userpwd = value;
    }

    /**
     * ��ȡsubmitdate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSUBMITDATE() {
        return submitdate;
    }

    /**
     * ����submitdate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSUBMITDATE(XMLGregorianCalendar value) {
        this.submitdate = value;
    }

    /**
     * ��ȡpagesize���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPAGESIZE() {
        return pagesize;
    }

    /**
     * ����pagesize���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPAGESIZE(BigDecimal value) {
        this.pagesize = value;
    }

    /**
     * ��ȡcurrentpage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCURRENTPAGE() {
        return currentpage;
    }

    /**
     * ����currentpage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCURRENTPAGE(BigDecimal value) {
        this.currentpage = value;
    }

    /**
     * ��ȡtotalrecord���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTOTALRECORD() {
        return totalrecord;
    }

    /**
     * ����totalrecord���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTOTALRECORD(BigDecimal value) {
        this.totalrecord = value;
    }

    /**
     * ��ȡprovincecode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVINCECODE() {
        return provincecode;
    }

    /**
     * ����provincecode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVINCECODE(String value) {
        this.provincecode = value;
    }

    /**
     * ��ȡenvironmentname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENVIRONMENTNAME() {
        return environmentname;
    }

    /**
     * ����environmentname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENVIRONMENTNAME(String value) {
        this.environmentname = value;
    }

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:return sourcesystemid;
		case 1:return sourcesystemname;
		case 2:return userid;
		case 3:return username;
		case 4:return userpwd;
		case 5:return submitdate;
		case 6:return pagesize;
		case 7:return currentpage;
		case 8:return totalrecord;
		case 9:return provincecode;
		case 10:return environmentname;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 11;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "SOURCESYSTEMID";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "SOURCESYSTEMNAME";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "USERID";
			break;
		case 3:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "USERNAME";
			break;
		case 4:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "USERPWD";
			break;
		case 5:
			info.type = submitdate==null?null:submitdate.getClass();
			info.name = "SUBMITDATE";
			break;
		case 6:
			info.type = pagesize == null?null:pagesize.getClass();
			info.name = "PAGE_SIZE";
			break;
		case 7:
			info.type = currentpage == null?null:currentpage.getClass();
			info.name = "CURRENT_PAGE";
			break;
		case 8:
			info.type = totalrecord == null?null:totalrecord.getClass();
			info.name = "TOTAL_RECORD";
			break;
		case 9:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "PROVINCE_CODE";
			break;
		case 10:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "ENVIRONMENT_NAME";
			break;

		default:
			break;
		}
		    
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0: sourcesystemid = arg1!=null?arg1.toString():"";break;
		case 1: sourcesystemname = arg1!=null?arg1.toString():"";break;
		case 2: userid = arg1!=null?arg1.toString():"";break;
		case 3: username = arg1!=null?arg1.toString():"";break;
		case 4: userpwd = arg1!=null?arg1.toString():"";break;
		case 5: submitdate = arg1 != null?(XMLGregorianCalendar) arg1:null;break;
		case 6: pagesize = arg1 !=null?(BigDecimal) arg1:null;break;
		case 7: currentpage = arg1 !=null?(BigDecimal) arg1:null;break;
		case 8: totalrecord = arg1 !=null?(BigDecimal) arg1:null;return;
		case 9: provincecode = arg1!=null?arg1.toString():"";return;
		case 10:environmentname = arg1!=null?arg1.toString():"";return;
		default:
			break;
		}
		
	}

}
