
package com.doctorapp.doctorappclient.basic.bean.InLoginSrv;

import java.util.Hashtable;

import javax.xml.datatype.XMLGregorianCalendar;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


/**
 * <p>DOC_INV_HIS_InLoginSrvOutputItem complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InLoginSrvOutputItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EMP_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DEPT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INPUT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="JOB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="TITLE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="USER_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INPUT_CODE_WB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CREATE_DATE" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="PASSWORD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OA_DEPT_ID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInLoginSrvOutputItem implements KvmSerializable{

    protected String id;
    protected String empno;
    protected String deptcode;
    protected String name;
    protected String inputcode;
    protected String job;
    protected String title;
    protected String username;
    protected String inputcodewb;
    protected String createdate;
    protected String password;
    protected String oadeptid;

    /**
     * ��ȡid���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * ����id���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * ��ȡempno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMPNO() {
        return empno;
    }

    /**
     * ����empno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMPNO(String value) {
        this.empno = value;
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
     * ��ȡname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * ����name���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * ��ȡinputcode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINPUTCODE() {
        return inputcode;
    }

    /**
     * ����inputcode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINPUTCODE(String value) {
        this.inputcode = value;
    }

    /**
     * ��ȡjob���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJOB() {
        return job;
    }

    /**
     * ����job���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJOB(String value) {
        this.job = value;
    }

    /**
     * ��ȡtitle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITLE() {
        return title;
    }

    /**
     * ����title���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITLE(String value) {
        this.title = value;
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
     * ��ȡinputcodewb���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINPUTCODEWB() {
        return inputcodewb;
    }

    /**
     * ����inputcodewb���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINPUTCODEWB(String value) {
        this.inputcodewb = value;
    }

    /**
     * ��ȡcreatedate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public String getCREATEDATE() {
        return createdate;
    }

    /**
     * ����createdate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCREATEDATE(String value) {
        this.createdate = value;
    }

    /**
     * ��ȡpassword���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPASSWORD() {
        return password;
    }

    /**
     * ����password���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPASSWORD(String value) {
        this.password = value;
    }
    public String getOadeptid() {
		return oadeptid;
	}

	public void setOadeptid(String oadeptid) {
		this.oadeptid = oadeptid;
	}


	@Override
	public Object getProperty(int arg0) {
		
		switch (arg0) {
		case 0:return id;
		case 1:return empno;
		case 2:return deptcode;
		case 3:return name;
		case 4:return inputcode;
		case 5:return job;
		case 6:return title;
		case 7:return username;
		case 8:return inputcodewb;
		case 9:return createdate;
		case 10:return password;
		case 11:return oadeptid;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 12;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:
			info.name="ID";
			info.type = PropertyInfo.STRING_CLASS;
		case 1:
			info.name="EMP_NO";
			info.type = PropertyInfo.STRING_CLASS;
		case 2:
			info.name="DEPT_CODE";
			info.type = PropertyInfo.STRING_CLASS;
		case 3:
			info.name="NAME";
			info.type = PropertyInfo.STRING_CLASS;
		case 4:
			info.name="INPUT_CODE";
			info.type = PropertyInfo.STRING_CLASS;
		case 5:
			info.name="JOB";
			info.type = PropertyInfo.STRING_CLASS;
		case 6:
			info.name="TITLE";
			info.type = PropertyInfo.STRING_CLASS;
		case 7:
			info.name="USER_NAME";
			info.type = PropertyInfo.STRING_CLASS;
		case 8:
			info.name="INPUT_CODE_WB";
			info.type = PropertyInfo.STRING_CLASS;
		case 9:
			info.name="CREATE_DATE";
			info.type = PropertyInfo.STRING_CLASS;
		case 10:
			info.name="PASSWORD";
			info.type = PropertyInfo.STRING_CLASS;
			break;
		case 11:
			info.name="OA_DEPT_ID";
			info.type = PropertyInfo.STRING_CLASS;
			break;


		default:
			break;
		}
		
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:id = toString(arg1);break;
		case 1:empno = toString(arg1);break;
		case 2:deptcode = toString(arg1);break;
		case 3:name = toString(arg1);break;
		case 4:inputcode = toString(arg1);break;
		case 5:job = toString(arg1);break;
		case 6:title = toString(arg1);break;
		case 7:username = toString(arg1);break;
		case 8:inputcodewb = toString(arg1);break;
		case 9:createdate = toString(arg1);break;
		case 10:password = toString(arg1);break;
		case 11:oadeptid = toString(arg1);break;

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

}
