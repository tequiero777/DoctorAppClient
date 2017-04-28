
package com.doctorapp.doctorappclient.basic.bean.InQueryStatReportSrv;



/**
 * <p>DOC_INV_HIS_InQueryStatReportSrvRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryStatReportSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://tj.his.com/MsgHeader}MsgHeader"/>
 *         &lt;element name="FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="OPERATE_TYPE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="COUNT_FLAG" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="EMP_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MONTH_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="YEAR_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DAY_TIME" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
public class DOCINVHISInQueryStatReportSrvRequest {

    protected MsgHeader msgHeader;
    protected String flag;
    protected String operatetype;
    protected String countflag;
    protected String empno;
    protected String monthtime;
    protected String yeartime;
    protected String daytime;
    protected String starttime;
    protected String endtime;

    /**
     * ��ȡmsgHeader���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link MsgHeader }
     *     
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * ����msgHeader���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link MsgHeader }
     *     
     */
    public void setMsgHeader(MsgHeader value) {
        this.msgHeader = value;
    }

    /**
     * ��ȡflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLAG() {
        return flag;
    }

    /**
     * ����flag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLAG(String value) {
        this.flag = value;
    }

    /**
     * ��ȡoperatetype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOPERATETYPE() {
        return operatetype;
    }

    /**
     * ����operatetype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOPERATETYPE(String value) {
        this.operatetype = value;
    }

    /**
     * ��ȡcountflag���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOUNTFLAG() {
        return countflag;
    }

    /**
     * ����countflag���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOUNTFLAG(String value) {
        this.countflag = value;
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
