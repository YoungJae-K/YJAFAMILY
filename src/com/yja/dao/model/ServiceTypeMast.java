package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ServiceTypeMast implements Serializable {

	private static final long serialVersionUID = 8410601305557214771L;
	private int serviceTypeID;
	private String serviceTypeDesc;
	private Date insertDate;
	private Date updateDate;

	/**
	 * @return the serviceTypeID
	 */
	public int getServiceTypeID() {
		return serviceTypeID;
	}

	/**
	 * @param serviceTypeID
	 *            the serviceTypeID to set
	 */
	public void setServiceTypeID(int serviceTypeID) {
		this.serviceTypeID = serviceTypeID;
	}

	/**
	 * @return the serviceTypeDesc
	 */
	public String getServiceTypeDesc() {
		return serviceTypeDesc;
	}

	/**
	 * @param serviceTypeDesc
	 *            the serviceTypeDesc to set
	 */
	public void setServiceTypeDesc(String serviceTypeDesc) {
		this.serviceTypeDesc = serviceTypeDesc;
	}

	/**
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}

	/**
	 * @param insertDate
	 *            the insertDate to set
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
