
package com.doctorapp.doctorappclient.basic.bean.InQueryDeptSrv;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;


/**
 * <p>DOC_INV_HIS_InQueryDeptSrvOutputCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryDeptSrvOutputCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOC_INV_HIS_InQueryDeptSrvOutputItem" type="{http://tj.his.com/DOC_INV_HIS_InQueryDeptSrv}DOC_INV_HIS_InQueryDeptSrvOutputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryDeptSrvOutputCollection implements KvmSerializable{

    protected List<DOCINVHISInQueryDeptSrvOutputItem> docinvhisInQueryDeptSrvOutputItem;

    /**
     * Gets the value of the docinvhisInQueryDeptSrvOutputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docinvhisInQueryDeptSrvOutputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDOCINVHISInQueryDeptSrvOutputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DOCINVHISInQueryDeptSrvOutputItem }
     * 
     * 
     */
    public List<DOCINVHISInQueryDeptSrvOutputItem> getDOCINVHISInQueryDeptSrvOutputItem() {
        if (docinvhisInQueryDeptSrvOutputItem == null) {
            docinvhisInQueryDeptSrvOutputItem = new ArrayList<DOCINVHISInQueryDeptSrvOutputItem>();
        }
        return this.docinvhisInQueryDeptSrvOutputItem;
    }

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return docinvhisInQueryDeptSrvOutputItem;

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
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch (arg0) {
		case 0:
			arg2.name ="DOC_INV_HIS_InQueryDeptSrvOutputItem";arg2.type = getDOCINVHISInQueryDeptSrvOutputItem().getClass();
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
			docinvhisInQueryDeptSrvOutputItem = getDOCINVHISInQueryDeptSrvOutputItem();
			DOCINVHISInQueryDeptSrvOutputItem item = new DOCINVHISInQueryDeptSrvOutputItem(); 
			for(int i =0 ;i< soapObject.getPropertyCount();i++){
				item.setProperty(i, soapObject.getProperty(i));
			}
			docinvhisInQueryDeptSrvOutputItem.add(item);
			break;

		default:
			break;
		}
		
		
	}

}
