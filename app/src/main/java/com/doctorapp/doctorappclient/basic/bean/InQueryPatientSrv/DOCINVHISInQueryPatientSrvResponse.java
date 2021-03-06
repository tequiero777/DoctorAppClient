
package com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv;

import com.doctorapp.doctorappclient.basic.bean.InLoginSrv.DOCINVHISInLoginSrvOutputCollection;

import java.util.Hashtable;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;



/**
 * <p>DOC_INV_HIS_InQueryPatientSrvResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryPatientSrvResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DOC_INV_HIS_InQueryPatientSrvOutputCollection" type="{http://tj.his.com/DOC_INV_HIS_InQueryPatientSrv}DOC_INV_HIS_InQueryPatientSrvOutputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryPatientSrvResponse implements KvmSerializable{

    protected String errorFlag;
    protected String errorMessage;
    protected DOCINVHISInQueryPatientSrvOutputCollection docinvhisInQueryPatientSrvOutputCollection;

    /**
     * ��ȡerrorFlag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorFlag() {
        return errorFlag;
    }

    /**
     * ����errorFlag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorFlag(String value) {
        this.errorFlag = value;
    }

    /**
     * ��ȡerrorMessage���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * ����errorMessage���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * ��ȡdocinvhisInQueryPatientSrvOutputCollection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DOCINVHISInQueryPatientSrvOutputCollection }
     *     
     */
    public DOCINVHISInQueryPatientSrvOutputCollection getDOCINVHISInQueryPatientSrvOutputCollection() {
        return docinvhisInQueryPatientSrvOutputCollection;
    }

    /**
     * ����docinvhisInQueryPatientSrvOutputCollection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DOCINVHISInQueryPatientSrvOutputCollection }
     *     
     */
    public void setDOCINVHISInQueryPatientSrvOutputCollection(DOCINVHISInQueryPatientSrvOutputCollection value) {
        this.docinvhisInQueryPatientSrvOutputCollection = value;
    }

    @Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:return errorFlag;
		case 1:return errorMessage;
		case 2:return docinvhisInQueryPatientSrvOutputCollection;
		
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 3;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "ErrorFlag";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "ErrorMessage";
			break;
		case 2:
			info.type = DOCINVHISInLoginSrvOutputCollection.class;
			info.name = "DOC_INV_HIS_InLoginSrvOutputCollection";
			break;

		default:
			break;
		}
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:
			 errorFlag = toString(arg1);
			break;
		case 1:
			errorMessage = toString(arg1);
			break;
		case 2:
			SoapObject soapObject = (SoapObject) arg1;
			docinvhisInQueryPatientSrvOutputCollection = new DOCINVHISInQueryPatientSrvOutputCollection();
			for(int i =0 ;i< soapObject.getPropertyCount();i++){
				docinvhisInQueryPatientSrvOutputCollection.setProperty(0, soapObject.getProperty(i));
			}
			
			break;

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
