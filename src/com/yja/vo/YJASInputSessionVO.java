package com.yja.vo;

/**
 * The VO class for the screen data that is necessary to store into Session. 
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJASInputSessionVO {

	private String arrivalDate;
	private String partySize;
	private String night;
	private String selectedReservationType;
	private String selectedEquipment;
	private String selectedServiceType;
	private String tabMode;
	private String userPhoneNumber;
	private String extraService;
	private String reservationId;
	private String userFName;
	private String userLName;
	private String userAddr;
	private String userCity;
	private String userProv;
	private String userPost;
	private String comments;
	private String userEmail;
	private String userFullName;
	private String costNotTax = "0.00";
	private String tax = "0.00";
	private String costWithTax = "0.00";

	/**
	 * @return the costNotTax
	 */
	public String getCostNotTax() {
		return costNotTax;
	}

	/**
	 * @param costNotTax
	 *            the costNotTax to set
	 */
	public void setCostNotTax(String costNotTax) {
		this.costNotTax = costNotTax;
	}

	/**
	 * @return the tax
	 */
	public String getTax() {
		return tax;
	}

	/**
	 * @param tax
	 *            the tax to set
	 */
	public void setTax(String tax) {
		this.tax = tax;
	}

	/**
	 * @return the costWithTax
	 */
	public String getCostWithTax() {
		return costWithTax;
	}

	/**
	 * @param costWithTax
	 *            the costWithTax to set
	 */
	public void setCostWithTax(String costWithTax) {
		this.costWithTax = costWithTax;
	}

	/**
	 * @return the userFullName
	 */
	public String getUserFullName() {
		return userFullName;
	}

	/**
	 * @param userFullName
	 *            the userFullName to set
	 */
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	/**
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate
	 *            the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the partySize
	 */
	public String getPartySize() {
		return partySize;
	}

	/**
	 * @param partySize
	 *            the partySize to set
	 */
	public void setPartySize(String partySize) {
		this.partySize = partySize;
	}

	/**
	 * @return the night
	 */
	public String getNight() {
		return night;
	}

	/**
	 * @param night
	 *            the night to set
	 */
	public void setNight(String night) {
		this.night = night;
	}

	/**
	 * @return the selectedReservationType
	 */
	public String getSelectedReservationType() {
		return selectedReservationType;
	}

	/**
	 * @param selectedReservationType
	 *            the selectedReservationType to set
	 */
	public void setSelectedReservationType(String selectedReservationType) {
		this.selectedReservationType = selectedReservationType;
	}

	/**
	 * @return the selectedEquipment
	 */
	public String getSelectedEquipment() {
		return selectedEquipment;
	}

	/**
	 * @param selectedEquipment
	 *            the selectedEquipment to set
	 */
	public void setSelectedEquipment(String selectedEquipment) {
		this.selectedEquipment = selectedEquipment;
	}

	/**
	 * @return the selectedServiceType
	 */
	public String getSelectedServiceType() {
		return selectedServiceType;
	}

	/**
	 * @param selectedServiceType
	 *            the selectedServiceType to set
	 */
	public void setSelectedServiceType(String selectedServiceType) {
		this.selectedServiceType = selectedServiceType;
	}

	/**
	 * @return the tabMode
	 */
	public String getTabMode() {
		return tabMode;
	}

	/**
	 * @param tabMode
	 *            the tabMode to set
	 */
	public void setTabMode(String tabMode) {
		this.tabMode = tabMode;
	}

	/**
	 * @return the userPhoneNumber
	 */
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}

	/**
	 * @param userPhoneNumber
	 *            the userPhoneNumber to set
	 */
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
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
	 * @return the userFName
	 */
	public String getUserFName() {
		return userFName;
	}

	/**
	 * @param userFName
	 *            the userFName to set
	 */
	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	/**
	 * @return the userLName
	 */
	public String getUserLName() {
		return userLName;
	}

	/**
	 * @param userLName
	 *            the userLName to set
	 */
	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	/**
	 * @return the userAddr
	 */
	public String getUserAddr() {
		return userAddr;
	}

	/**
	 * @param userAddr
	 *            the userAddr to set
	 */
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	/**
	 * @return the userCity
	 */
	public String getUserCity() {
		return userCity;
	}

	/**
	 * @param userCity
	 *            the userCity to set
	 */
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	/**
	 * @return the userProv
	 */
	public String getUserProv() {
		return userProv;
	}

	/**
	 * @param userProv
	 *            the userProv to set
	 */
	public void setUserProv(String userProv) {
		this.userProv = userProv;
	}

	/**
	 * @return the userPost
	 */
	public String getUserPost() {
		return userPost;
	}

	/**
	 * @param userPost
	 *            the userPost to set
	 */
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments
	 *            the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
