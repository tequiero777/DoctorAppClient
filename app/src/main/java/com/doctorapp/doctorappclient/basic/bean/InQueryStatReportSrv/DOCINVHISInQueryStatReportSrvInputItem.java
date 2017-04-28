
package com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv;



/**
 * <p>DOC_INV_HIS_InQueryStatReportSrvInputItem complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryStatReportSrvInputItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DAY_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MONTH_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="YEAR_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="START_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="END_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryStatReportSrvInputItem {

    protected String daytime;
    protected String monthtime;
    protected String yeartime;
    protected String starttime;
    protected String endtime;

    /**
     * ��ȡdaytime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDAYTIME() {
        return daytime;
    }

    /**
     * ����daytime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDAYTIME(String value) {
        this.daytime = value;
    }

    /**
     * ��ȡmonthtime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTHTIME() {
        return monthtime;
    }

    /**
     * ����monthtime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTHTIME(String value) {
        this.monthtime = value;
    }

    /**
     * ��ȡyeartime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getYEARTIME() {
        return yeartime;
    }

    /**
     * ����yeartime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setYEARTIME(String value) {
        this.yeartime = value;
    }

    /**
     * ��ȡstarttime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTTIME() {
        return starttime;
    }

    /**
     * ����starttime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTTIME(String value) {
        this.starttime = value;
    }

    /**
     * ��ȡendtime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDTIME() {
        return endtime;
    }

    /**
     * ����endtime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDTIME(String value) {
        this.endtime = value;
    }

}
