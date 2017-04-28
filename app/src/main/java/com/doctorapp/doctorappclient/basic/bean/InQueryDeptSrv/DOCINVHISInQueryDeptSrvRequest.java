
package com.doctorapp.doctorappclient.basic.bean.InQueryDeptSrv;

import java.util.Hashtable;


import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


/**
 * <p>DOC_INV_HIS_InQueryDeptSrvRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="DOC_INV_HIS_InQueryDeptSrvRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MsgHeader" type="{http://tj.his.com/MsgHeader}MsgHeader"/>
 *         &lt;element name="DEPT_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class DOCINVHISInQueryDeptSrvRequest implements KvmSerializable {

    protected MsgHeader msgHeader;
    protected String deptno;
    protected String docname;

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
     * ��ȡdeptno���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTNO() {
        return deptno;
    }

    /**
     * ����deptno���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTNO(String value) {
        this.deptno = value;
    }

	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
		case 0:return msgHeader;
		case 1:return deptno;
		case 2:return docname;
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
		case 0:info.name ="MsgHeader";info.type=MsgHeader.class;break;
		case 1:info.name ="DEPT_NO";info.type=PropertyInfo.STRING_CLASS;break;
		case 2:info.name ="DOC_NAME";info.type=PropertyInfo.STRING_CLASS;break;
		default:
			break;
		}
		
	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		switch (arg0) {
		case 0:msgHeader = arg1 == null?null:(MsgHeader)arg1;break;
		case 1:deptno = arg1==null?"":arg1+"";break;
		case 2:docname = arg1==null?"":arg1+"";break;
		default:
			break;
		}
		
	}

}
