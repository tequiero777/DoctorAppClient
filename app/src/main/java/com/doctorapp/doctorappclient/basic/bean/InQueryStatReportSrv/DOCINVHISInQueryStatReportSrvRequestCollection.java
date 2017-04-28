
package com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>DOC_INV_HIS_InQueryStatReportSrvRequestCollection complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryStatReportSrvRequestCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DOC_INV_HIS_InQueryStatReportSrvInputItem" type="{http://tj.his.com/DOC_INV_HIS_InQueryStatReportSrv}DOC_INV_HIS_InQueryStatReportSrvInputItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryStatReportSrvRequestCollection {

    protected List<DOCINVHISInQueryStatReportSrvInputItem> docinvhisInQueryStatReportSrvInputItem;

    /**
     * Gets the value of the docinvhisInQueryStatReportSrvInputItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docinvhisInQueryStatReportSrvInputItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDOCINVHISInQueryStatReportSrvInputItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DOCINVHISInQueryStatReportSrvInputItem }
     * 
     * 
     */
    public List<DOCINVHISInQueryStatReportSrvInputItem> getDOCINVHISInQueryStatReportSrvInputItem() {
        if (docinvhisInQueryStatReportSrvInputItem == null) {
            docinvhisInQueryStatReportSrvInputItem = new ArrayList<DOCINVHISInQueryStatReportSrvInputItem>();
        }
        return this.docinvhisInQueryStatReportSrvInputItem;
    }

}
