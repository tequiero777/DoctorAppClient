
package com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;



/**
 * <p>DOC_INV_HIS_InQueryStatReportSrvOutputCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryStatReportSrvOutputCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOC_INV_HIS_InQueryStatReportSrvOutputItem" type="{http://tj.his.com/DOC_INV_HIS_InQueryStatReportSrv}DOC_INV_HIS_InQueryStatReportSrvOutputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryStatReportSrvOutputCollection implements KvmSerializable{

    protected List<DOCINVHISInQueryStatReportSrvOutputItem> docinvhisInQueryStatReportSrvOutputItem;

    /**
     * Gets the value of the docinvhisInQueryStatReportSrvOutputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docinvhisInQueryStatReportSrvOutputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDOCINVHISInQueryStatReportSrvOutputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DOCINVHISInQueryStatReportSrvOutputItem }
     * 
     * 
     */
    public List<DOCINVHISInQueryStatReportSrvOutputItem> getDOCINVHISInQueryStatReportSrvOutputItem() {
        if (docinvhisInQueryStatReportSrvOutputItem == null) {
            docinvhisInQueryStatReportSrvOutputItem = new ArrayList<DOCINVHISInQueryStatReportSrvOutputItem>();
        }
        return this.docinvhisInQueryStatReportSrvOutputItem;
    }

    @Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		switch (arg0) {
		case 0:
			arg2.name ="DOC_INV_HIS_InQueryStatReportSrvOutputItem";arg2.type = getDOCINVHISInQueryStatReportSrvOutputItem().getClass();
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
			docinvhisInQueryStatReportSrvOutputItem = getDOCINVHISInQueryStatReportSrvOutputItem();
			DOCINVHISInQueryStatReportSrvOutputItem item = new DOCINVHISInQueryStatReportSrvOutputItem(); 
			for(int i =0 ;i< soapObject.getPropertyCount();i++){
				item.setProperty(i, soapObject.getProperty(i));
			}
			docinvhisInQueryStatReportSrvOutputItem.add(item);
			break;

		default:
			break;
		}
		
		
	}

	@Override
	public int getPropertyCount() {
		return 1;
	}

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:
			return docinvhisInQueryStatReportSrvOutputItem;

		default:
			break;
		}
		return null;
	}

}
