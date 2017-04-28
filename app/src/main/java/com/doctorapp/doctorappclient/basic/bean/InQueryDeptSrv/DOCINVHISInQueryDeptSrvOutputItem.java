
package com.doctorapp.doctorappclient.basic.bean.InQueryDeptSrv;

import java.util.Hashtable;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


/**
 * <p>DOC_INV_HIS_InQueryDeptSrvOutputItem complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryDeptSrvOutputItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DEPT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SERIAL_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DEPT_NAME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DEPT_ALIAS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CLINIC_ATTR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OUTP_OR_INP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INTERNAL_OR_SERGERY" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INPUT_CODE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="POSITION" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SIGN" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="INPUT_CODE_WB" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DISPENSING_CUMULATE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="VIRTUAL_CABINET" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryDeptSrvOutputItem implements KvmSerializable{

    protected String deptcode;
    protected String serialno;
    protected String deptname;
    protected String deptalias;
    protected String clinicattr;
    protected String outporinp;
    protected String internalorsergery;
    protected String inputcode;
    protected String position;
    protected String sign;
    protected String inputcodewb;
    protected String dispensingcumulate;
    protected String virtualcabinet;

    private String isCheck;
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
     * ��ȡserialno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIALNO() {
        return serialno;
    }

    /**
     * ����serialno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIALNO(String value) {
        this.serialno = value;
    }

    /**
     * ��ȡdeptname���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTNAME() {
        return deptname;
    }

    /**
     * ����deptname���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTNAME(String value) {
        this.deptname = value;
    }

    /**
     * ��ȡdeptalias���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTALIAS() {
        return deptalias;
    }

    /**
     * ����deptalias���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTALIAS(String value) {
        this.deptalias = value;
    }

    /**
     * ��ȡclinicattr���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLINICATTR() {
        return clinicattr;
    }

    /**
     * ����clinicattr���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLINICATTR(String value) {
        this.clinicattr = value;
    }

    /**
     * ��ȡoutporinp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOUTPORINP() {
        return outporinp;
    }

    /**
     * ����outporinp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOUTPORINP(String value) {
        this.outporinp = value;
    }

    /**
     * ��ȡinternalorsergery���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERNALORSERGERY() {
        return internalorsergery;
    }

    /**
     * ����internalorsergery���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERNALORSERGERY(String value) {
        this.internalorsergery = value;
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
     * ��ȡposition���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSITION() {
        return position;
    }

    /**
     * ����position���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSITION(String value) {
        this.position = value;
    }

    /**
     * ��ȡsign���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIGN() {
        return sign;
    }

    /**
     * ����sign���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIGN(String value) {
        this.sign = value;
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
     * ��ȡdispensingcumulate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISPENSINGCUMULATE() {
        return dispensingcumulate;
    }

    /**
     * ����dispensingcumulate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISPENSINGCUMULATE(String value) {
        this.dispensingcumulate = value;
    }

    /**
     * ��ȡvirtualcabinet���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVIRTUALCABINET() {
        return virtualcabinet;
    }

    /**
     * ����virtualcabinet���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVIRTUALCABINET(String value) {
        this.virtualcabinet = value;
    }

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0: return deptcode;
		case 1: return serialno;
		case 2: return deptname;
		case 3: return deptalias;
		case 4: return clinicattr;
		case 5: return outporinp;
		case 6: return internalorsergery;
		case 7: return inputcode;
		case 8: return position;
		case 9: return sign;
		case 10: return inputcodewb;
		case 11: return dispensingcumulate;
		case 12: return virtualcabinet;
		default:
			break;
		}
		return null;
		
	}

	@Override
	public int getPropertyCount() {
		return 13;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:info.name="deptcode"; info.type = PropertyInfo.STRING_CLASS;break;
		case 1:info.name="serialno"; info.type = PropertyInfo.STRING_CLASS;break;
		case 2:info.name="deptname"; info.type = PropertyInfo.STRING_CLASS;break;
		case 3:info.name="deptalias"; info.type = PropertyInfo.STRING_CLASS;break;
		case 4:info.name="clinicattr"; info.type = PropertyInfo.STRING_CLASS;break;
		case 5:info.name="outporinp"; info.type = PropertyInfo.STRING_CLASS;break;
		case 6:info.name="internalorsergery"; info.type = PropertyInfo.STRING_CLASS;break;
		case 7:info.name="inputcode"; info.type = PropertyInfo.STRING_CLASS;break;
		case 8:info.name="position"; info.type = PropertyInfo.STRING_CLASS;break;
		case 9:info.name="sign"; info.type = PropertyInfo.STRING_CLASS;break;
		case 10:info.name="inputcodewb"; info.type = PropertyInfo.STRING_CLASS;break;
		case 11:info.name="dispensingcumulate"; info.type = PropertyInfo.STRING_CLASS;break;
		case 12:info.name="virtualcabinet"; info.type = PropertyInfo.STRING_CLASS;break;
		default:
			break;
		}
		
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:  deptcode = toStringValue(arg1);break;
		case 1: serialno = toStringValue(arg1);break;
		case 2:   deptname = toStringValue(arg1);break;
		case 3:  deptalias = toStringValue(arg1);break;
		case 4:  clinicattr = toStringValue(arg1);break;
		case 5:  outporinp = toStringValue(arg1);break;
		case 6:  internalorsergery = toStringValue(arg1);break;
		case 7:  inputcode = toStringValue(arg1);break;
		case 8:  position = toStringValue(arg1);break;
		case 9:   sign = toStringValue(arg1);break;
		case 10:  inputcodewb = toStringValue(arg1);break;
		case 11:  dispensingcumulate = toStringValue(arg1);break;
		case 12:  virtualcabinet = toStringValue(arg1);break;

		default:
			break;
		}
		
	}
	private String toStringValue(Object obj){
		if(obj!=null){
			return obj+"";
		}
		return "";
	}

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
}
