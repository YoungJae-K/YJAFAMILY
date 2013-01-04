package com.yja.action.model;

import java.util.List;

import com.yja.vo.YJAReservedInfoVO;

/**
 * The Model class for the screen to confirm new reservation.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS004ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = 1L;
	private List<YJAReservedInfoVO> reservedInfoList;
	private String costNotTax = "0.00";
	private String tax = "0.00";
	private String costWithTax = "0.00";
	private String userPhoneNumber;
	private String extraService;
	private String selectedReservationType;
	private String selectedEquipment;
	private String selectedServiceType;
	private String reservationId;
	private String reservedEmail;

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
	 * @return the reservedInfoList
	 */
	public List<YJAReservedInfoVO> getReservedInfoList() {
		return reservedInfoList;
	}

	/**
	 * @param reservedInfoList
	 *            the reservedInfoList to set
	 */
	public void setReservedInfoList(List<YJAReservedInfoVO> reservedInfoList) {
		this.reservedInfoList = reservedInfoList;
	}

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

}
