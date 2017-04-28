
package com.doctorapp.doctorappclient.basic.bean.InQueryPatientSrv;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;


/**
 * <p>DOC_INV_HIS_InQueryPatientSrvOutputCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryPatientSrvOutputCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOC_INV_HIS_InQueryPatientSrvOutputItem" type="{http://tj.his.com/DOC_INV_HIS_InQueryPatientSrv}DOC_INV_HIS_InQueryPatientSrvOutputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryPatientSrvOutputCollection implements KvmSerializable{

    protected List<DOCINVHISInQueryPatientSrvOutputItem> docinvhisInQueryPatientSrvOutputItem;

    /**
     * Gets the value of the docinvhisInQueryPatientSrvOutputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docinvhisInQueryPatientSrvOutputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDOCINVHISInQueryPatientSrvOutputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DOCINVHISInQueryPatientSrvOutputItem }
     * 
     * 
     */
    public List<DOCINVHISInQueryPatientSrvOutputItem> getDOCINVHISInQueryPatientSrvOutputItem() {
        if (docinvhisInQueryPatientSrvOutputItem == null) {
            docinvhisInQueryPatientSrvOutputItem = new LinkedList<DOCINVHISInQueryPatientSrvOutputItem>();
        }
        return this.docinvhisInQueryPatientSrvOutputItem;
    }

	public List<DOCINVHISInQueryPatientSrvOutputItem> getDocinvhisInQueryPatientSrvOutputItem() {
		return docinvhisInQueryPatientSrvOutputItem;
	}

	public void setDocinvhisInQueryPatientSrvOutputItem(
			List<DOCINVHISInQueryPatientSrvOutputItem> docinvhisInQueryPatientSrvOutputItem) {
		this.docinvhisInQueryPatientSrvOutputItem = docinvhisInQueryPatientSrvOutputItem;
	}
	
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:return docinvhisInQueryPatientSrvOutputItem;
			
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 1;
	}

	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo info) {
		switch (arg0) {
		case 0:
			info.name ="DOC_INV_HIS_InLoginSrvOutputItem";
			info.type = PropertyInfo.OBJECT_TYPE;
			break;

		default:
			break;
		}
		
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:
			SoapObject soapObject = (SoapObject) arg1;
			docinvhisInQueryPatientSrvOutputItem = getDOCINVHISInQueryPatientSrvOutputItem();
			DOCINVHISInQueryPatientSrvOutputItem item = new DOCINVHISInQueryPatientSrvOutputItem(); 
			for(int i =0 ;i< soapObject.getPropertyCount();i++){
				item.setProperty(i, soapObject.getProperty(i));
			}
			docinvhisInQueryPatientSrvOutputItem.add(item);
			break;

		default:
			break;
		}
		
	}

}
