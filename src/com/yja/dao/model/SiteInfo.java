package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SiteInfo implements Serializable {

	private static final long serialVersionUID = -2063343902688135622L;
	private int campMapID;
	private int siteNo;
	private ReservationTypeMast reservationTypeMast;
	private ServiceTypeMast serviceTypeMast;
	private int allowedPartySize;
	private int allowedExtraPartySize;
	private double siteLength;
	private double siteWidth;
	private int allowedOnParking;
	private int allowedOffParking;
	private double siteCost;
	private double extraPeopleCost;
	private Date insertDate;
	private Date updateDate;
	private int siteLeftLoct;
	private int siteTopLoct;
	private List<CampPhotoInfo> campPhotoInfoList;
	private List<EquipmentMast> equipmentList;

	/**
	 * @return the allowedExtraPartySize
	 */
	public int getAllowedExtraPartySize() {
		return allowedExtraPartySize;
	}

	/**
	 * @param allowedExtraPartySize
	 *            the allowedExtraPartySize to set
	 */
	public void setAllowedExtraPartySize(int allowedExtraPartySize) {
		this.allowedExtraPartySize = allowedExtraPartySize;
	}

	/**
	 * @return the extraPeopleCost
	 */
	public double getExtraPeopleCost() {
		return extraPeopleCost;
	}

	/**
	 * @param extraPeopleCost
	 *            the extraPeopleCost to set
	 */
	public void setExtraPeopleCost(double extraPeopleCost) {
		this.extraPeopleCost = extraPeopleCost;
	}

	/**
	 * @return the campMapID
	 */
	public int getCampMapID() {
		return campMapID;
	}

	/**
	 * @param campMapID
	 *            the campMapID to set
	 */
	public void setCampMapID(int campMapID) {
		this.campMapID = campMapID;
	}

	/**
	 * @return the siteLeftLoct
	 */
	public int getSiteLeftLoct() {
		return siteLeftLoct;
	}

	/**
	 * @param siteLeftLoct
	 *            the siteLeftLoct to set
	 */
	public void setSiteLeftLoct(int siteLeftLoct) {
		this.siteLeftLoct = siteLeftLoct;
	}

	/**
	 * @return the siteTopLoct
	 */
	public int getSiteTopLoct() {
		return siteTopLoct;
	}

	/**
	 * @param siteTopLoct
	 *            the siteTopLoct to set
	 */
	public void setSiteTopLoct(int siteTopLoct) {
		this.siteTopLoct = siteTopLoct;
	}

	/**
	 * @return the equipmentList
	 */
	public List<EquipmentMast> getEquipmentList() {
		return equipmentList;
	}

	/**
	 * @param equipmentList
	 *            the equipmentList to set
	 */
	public void setEquipmentList(List<EquipmentMast> equipmentList) {
		this.equipmentList = equipmentList;
	}

	/**
	 * @return the campPhotoInfoList
	 */
	public List<CampPhotoInfo> getCampPhotoInfoList() {
		return campPhotoInfoList;
	}

	/**
	 * @param campPhotoInfoList
	 *            the campPhotoInfoList to set
	 */
	public void setCampPhotoInfoList(List<CampPhotoInfo> campPhotoInfoList) {
		this.campPhotoInfoList = campPhotoInfoList;
	}

	/**
	 * @return the siteNo
	 */
	public int getSiteNo() {
		return siteNo;
	}

	/**
	 * @param siteNo
	 *            the siteNo to set
	 */
	public void setSiteNo(int siteNo) {
		this.siteNo = siteNo;
	}

	/**
	 * @return the reservationTypeMast
	 */
	public ReservationTypeMast getReservationTypeMast() {
		return reservationTypeMast;
	}

	/**
	 * @param reservationTypeMast
	 *            the reservationTypeMast to set
	 */
	public void setReservationTypeMast(ReservationTypeMast reservationTypeMast) {
		this.reservationTypeMast = reservationTypeMast;
	}

	/**
	 * @return the serviceTypeMast
	 */
	public ServiceTypeMast getServiceTypeMast() {
		return serviceTypeMast;
	}

	/**
	 * @param serviceTypeMast
	 *            the serviceTypeMast to set
	 */
	public void setServiceTypeMast(ServiceTypeMast serviceTypeMast) {
		this.serviceTypeMast = serviceTypeMast;
	}

	/**
	 * @return the allowedPartySize
	 */
	public int getAllowedPartySize() {
		return allowedPartySize;
	}

	/**
	 * @param allowedPartySize
	 *            the allowedPartySize to set
	 */
	public void setAllowedPartySize(int allowedPartySize) {
		this.allowedPartySize = allowedPartySize;
	}

	/**
	 * @return the siteLength
	 */
	public double getSiteLength() {
		return siteLength;
	}

	/**
	 * @param siteLength
	 *            the siteLength to set
	 */
	public void setSiteLength(double siteLength) {
		this.siteLength = siteLength;
	}

	/**
	 * @return the siteWidth
	 */
	public double getSiteWidth() {
		return siteWidth;
	}

	/**
	 * @param siteWidth
	 *            the siteWidth to set
	 */
	public void setSiteWidth(double siteWidth) {
		this.siteWidth = siteWidth;
	}

	/**
	 * @return the allowedOnParking
	 */
	public int getAllowedOnParking() {
		return allowedOnParking;
	}

	/**
	 * @param allowedOnParking
	 *            the allowedOnParking to set
	 */
	public void setAllowedOnParking(int allowedOnParking) {
		this.allowedOnParking = allowedOnParking;
	}

	/**
	 * @return the allowedOffParking
	 */
	public int getAllowedOffParking() {
		return allowedOffParking;
	}

	/**
	 * @param allowedOffParking
	 *            the allowedOffParking to set
	 */
	public void setAllowedOffParking(int allowedOffParking) {
		this.allowedOffParking = allowedOffParking;
	}

	/**
	 * @return the siteCost
	 */
	public double getSiteCost() {
		return siteCost;
	}

	/**
	 * @param siteCost
	 *            the siteCost to set
	 */
	public void setSiteCost(double siteCost) {
		this.siteCost = siteCost;
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
