
package com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv;

import java.util.Hashtable;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;



/**
 * <p>DOC_INV_HIS_InQueryStatReportSrvResponse complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryStatReportSrvResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COUNT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DOC_INV_HIS_InQueryStatReportSrvOutputCollection" type="{http://tj.his.com/DOC_INV_HIS_InQueryStatReportSrv}DOC_INV_HIS_InQueryStatReportSrvOutputCollection"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryStatReportSrvResponse implements KvmSerializable{

    protected String errorFlag;
    protected String errorMessage;
    protected String count;
    protected DOCINVHISInQueryStatReportSrvOutputCollection docinvhisInQueryStatReportSrvOutputCollection;

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
     * ��ȡcount���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOUNT() {
        return count;
    }

    /**
     * ����count���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOUNT(String value) {
        this.count = value;
    }

    /**
     * ��ȡdocinvhisInQueryStatReportSrvOutputCollection���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link DOCINVHISInQueryStatReportSrvOutputCollection }
     *     
     */
    public DOCINVHISInQueryStatReportSrvOutputCollection getDOCINVHISInQueryStatReportSrvOutputCollection() {
        return docinvhisInQueryStatReportSrvOutputCollection;
    }

    /**
     * ����docinvhisInQueryStatReportSrvOutputCollection���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link DOCINVHISInQueryStatReportSrvOutputCollection }
     *     
     */
    public void setDOCINVHISInQueryStatReportSrvOutputCollection(DOCINVHISInQueryStatReportSrvOutputCollection value) {
        this.docinvhisInQueryStatReportSrvOutputCollection = value;
    }

    @Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:
			 info.name="ErrorFlag";info.type=PropertyInfo.STRING_CLASS;break;
		case 1:
			 info.name="ErrorMessage";info.type=PropertyInfo.STRING_CLASS;break;
		case 2:
			 info.name="COUNT";info.type=PropertyInfo.STRING_CLASS;break;
		case 3:
			 info.name="DOC_INV_HIS_InQueryStatReportSrvOutputCollection";info.type=DOCINVHISInQueryStatReportSrvOutputCollection.class;break;
			
		default:
			break;
		}
		
	}
    
    @Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:errorFlag = arg1==null?"":arg1+"";break;
		case 1:errorMessage = arg1==null?"":arg1+"";break;
		case 2:count = arg1==null?"":arg1+"";break;
		case 3:
			SoapObject soapObject = (SoapObject) arg1;
			docinvhisInQueryStatReportSrvOutputCollection = new DOCINVHISInQueryStatReportSrvOutputCollection();
			for(int i =0 ;i< soapObject.getPropertyCount();i++){
				docinvhisInQueryStatReportSrvOutputCollection.setProperty(0, soapObject.getProperty(i));
			}break;
		default:
			break;
		}
		
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:return errorFlag;
		case 1:return errorMessage;
		case 2:return count;
		case 3:return docinvhisInQueryStatReportSrvOutputCollection;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 4;
	}
}
