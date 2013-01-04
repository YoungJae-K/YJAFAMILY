package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class EquipmentMast implements Serializable {

	private static final long serialVersionUID = -1041793135087938521L;
	private int equipmentTypeID;
	private String equipmentTypeDesc;
	private Date insertDate;
	private Date updateDate;

	/**
	 * @return the equipmentTypeID
	 */
	public int getEquipmentTypeID() {
		return equipmentTypeID;
	}

	/**
	 * @param equipmentTypeID
	 *            the equipmentTypeID to set
	 */
	public void setEquipmentTypeID(int equipmentTypeID) {
		this.equipmentTypeID = equipmentTypeID;
	}

	/**
	 * @return the equipmentTypeDesc
	 */
	public String getEquipmentTypeDesc() {
		return equipmentTypeDesc;
	}

	/**
	 * @param equipmentTypeDesc
	 *            the equipmentTypeDesc to set
	 */
	public void setEquipmentTypeDesc(String equipmentTypeDesc) {
		this.equipmentTypeDesc = equipmentTypeDesc;
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
