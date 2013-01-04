package com.yja.dao.model;

import java.io.Serializable;
import java.util.Date;

public class ReservationInfo implements Serializable {

	private static final long serialVersionUID = 6481857286210525531L;
	private String reservationId;
	private int campMapID;
	private int siteNo;
	private Date arrivalDate;
	private Date endDate;;
	private String userId;
	private String reservedEmail;
	private String reservedLName;
	private String reservedFName;
	private String reservedPhone;
	private String reservedAddress;
	private String reservedCity;
	private String reservedProvince;
	private String reservedPost;
	private int reservedNight;
	private int reservedPartySize;
	private String extraService;
	private String statusId;
	private String resservationType;
	private double totalCost;
	private double extraPeopleCost;
	private Date insertDate;

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
	 * @return the resservationType
	 */
	public String getResservationType() {
		return resservationType;
	}

	/**
	 * @param resservationType
	 *            the resservationType to set
	 */
	public void setResservationType(String resservationType) {
		this.resservationType = resservationType;
	}

	/**
	 * @return the reservationId
	 */
	public String getReservationId() {
		return reservationId;
	}

	/**
	 * @param reservationId
	 *            the reservationId to set
	 */
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
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
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate
	 *            the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the reservedEmail
	 */
	public String getReservedEmail() {
		return reservedEmail;
	}

	/**
	 * @param reservedEmail
	 *            the reservedEmail to set
	 */
	public void setReservedEmail(String reservedEmail) {
		this.reservedEmail = reservedEmail;
	}

	/**
	 * @return the reservedLName
	 */
	public String getReservedLName() {
		return reservedLName;
	}

	/**
	 * @param reservedLName
	 *            the reservedLName to set
	 */
	public void setReservedLName(String reservedLName) {
		this.reservedLName = reservedLName;
	}

	/**
	 * @return the reservedFName
	 */
	public String getReservedFName() {
		return reservedFName;
	}

	/**
	 * @param reservedFName
	 *            the reservedFName to set
	 */
	public void setReservedFName(String reservedFName) {
		this.reservedFName = reservedFName;
	}

	/**
	 * @return the reservedPhone
	 */
	public String getReservedPhone() {
		return reservedPhone;
	}

	/**
	 * @param reservedPhone
	 *            the reservedPhone to set
	 */
	public void setReservedPhone(String reservedPhone) {
		this.reservedPhone = reservedPhone;
	}

	/**
	 * @return the reservedAddress
	 */
	public String getReservedAddress() {
		return reservedAddress;
	}

	/**
	 * @param reservedAddress
	 *            the reservedAddress to set
	 */
	public void setReservedAddress(String reservedAddress) {
		this.reservedAddress = reservedAddress;
	}

	/**
	 * @return the reservedCity
	 */
	public String getReservedCity() {
		return reservedCity;
	}

	/**
	 * @param reservedCity
	 *            the reservedCity to set
	 */
	public void setReservedCity(String reservedCity) {
		this.reservedCity = reservedCity;
	}

	/**
	 * @return the reservedProvince
	 */
	public String getReservedProvince() {
		return reservedProvince;
	}

	/**
	 * @param reservedProvince
	 *            the reservedProvince to set
	 */
	public void setReservedProvince(String reservedProvince) {
		this.reservedProvince = reservedProvince;
	}

	/**
	 * @return the reservedPost
	 */
	public String getReservedPost() {
		return reservedPost;
	}

	/**
	 * @param reservedPost
	 *            the reservedPost to set
	 */
	public void setReservedPost(String reservedPost) {
		this.reservedPost = reservedPost;
	}

	/**
	 * @return the reservedNight
	 */
	public int getReservedNight() {
		return reservedNight;
	}

	/**
	 * @param reservedNight
	 *            the reservedNight to set
	 */
	public void setReservedNight(int reservedNight) {
		this.reservedNight = reservedNight;
	}

	/**
	 * @return the reservedPartySize
	 */
	public int getReservedPartySize() {
		return reservedPartySize;
	}

	/**
	 * @param reservedPartySize
	 *            the reservedPartySize to set
	 */
	public void setReservedPartySize(int reservedPartySize) {
		this.reservedPartySize = reservedPartySize;
	}

	/**
	 * @return the extraService
	 */
	public String getExtraService() {
		return extraService;
	}

	/**
	 * @param extraService
	 *            the extraService to set
	 */
	public void setExtraService(String extraService) {
		this.extraService = extraService;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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

}
