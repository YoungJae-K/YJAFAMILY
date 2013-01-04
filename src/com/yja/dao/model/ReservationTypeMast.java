package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ReservationTypeMast implements Serializable {

	private static final long serialVersionUID = 1886081374430962869L;
	private int reservationTypeID;
	private String reservationTypeDesc;
	private Date insertDate;
	private Date updateDate;

	/**
	 * @return the reservationTypeID
	 */
	public int getReservationTypeID() {
		return reservationTypeID;
	}

	/**
	 * @param reservationTypeID
	 *            the reservationTypeID to set
	 */
	public void setReservationTypeID(int reservationTypeID) {
		this.reservationTypeID = reservationTypeID;
	}

	/**
	 * @return the reservationTypeDesc
	 */
	public String getReservationTypeDesc() {
		return reservationTypeDesc;
	}

	/**
	 * @param reservationTypeDesc
	 *            the reservationTypeDesc to set
	 */
	public void setReservationTypeDesc(String reservationTypeDesc) {
		this.reservationTypeDesc = reservationTypeDesc;
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
