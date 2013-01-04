package com.yja.action.model;

import java.util.List;

import com.yja.vo.YJACampSiteInfoVO;
import com.yja.vo.YJACampSiteLocationInfoVO;
import com.yja.vo.YJAReservedInfoVO;
import com.yja.vo.YJASelectTagVO;

/**
 * The Model class for the screen to search or reserve the camp sites.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS003ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = 1L;	
	private String arrivalDate;
	private String partySize;
	private String night;
	private String selectedReservationType;
	private String selectedEquipment;
	private String selectedServiceType;
	private String campMapFullPath;
	private List<YJASelectTagVO> equipmentList;
	private List<YJASelectTagVO> serviceTypeList;
	private List<YJASelectTagVO> reservationTypeList;
	private List<YJACampSiteLocationInfoVO> campSiteLocationList;
	private List<YJACampSiteInfoVO> campSiteInfoList;
	private List<YJAReservedInfoVO> reservedInfoList;
	private String validateResult = "Wonderful!!!!!";
	private String costNotTax = "0.00";
	private String tax = "0.00";
	private String costWithTax = "0.00";
	private String deletedSiteNo;
	private String tabMode = "1";
	private String screenMode;

	/**
	 * @return the campMapFullPath
	 */
	public String getCampMapFullPath() {
		return campMapFullPath;
	}

	/**
	 * @param campMapFullPath
	 *            the campMapFullPath to set
	 */
	public void setCampMapFullPath(String campMapFullPath) {
		this.campMapFullPath = campMapFullPath;
	}

	/**
	 * @return the screenMode
	 */
	public String getScreenMode() {
		return screenMode;
	}

	/**
	 * @param screenMode
	 *            the screenMode to set
	 */
	public void setScreenMode(String screenMode) {
		this.screenMode = screenMode;
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
	 * @return the deletedSiteNo
	 */
	public String getDeletedSiteNo() {
		return deletedSiteNo;
	}

	/**
	 * @param deletedSiteNo
	 *            the deletedSiteNo to set
	 */
	public void setDeletedSiteNo(String deletedSiteNo) {
		this.deletedSiteNo = deletedSiteNo;
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
	 * @return the campSiteInfoList
	 */
	public List<YJACampSiteInfoVO> getCampSiteInfoList() {
		return campSiteInfoList;
	}

	/**
	 * @param campSiteInfoList
	 *            the campSiteInfoList to set
	 */
	public void setCampSiteInfoList(List<YJACampSiteInfoVO> campSiteInfoList) {
		this.campSiteInfoList = campSiteInfoList;
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
	 * @return the reservationTypeList
	 */
	public List<YJASelectTagVO> getReservationTypeList() {

		return reservationTypeList;
	}

	/**
	 * @param reservationTypeList
	 *            the reservationTypeList to set
	 */
	public void setReservationTypeList(List<YJASelectTagVO> reservationTypeList) {
		this.reservationTypeList = reservationTypeList;
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
	 * @return the equipmentList
	 */
	public List<YJASelectTagVO> getEquipmentList() {

		return equipmentList;
	}

	/**
	 * @param equipmentList
	 *            the equipmentList to set
	 */
	public void setEquipmentList(List<YJASelectTagVO> equipmentList) {
		this.equipmentList = equipmentList;
	}

	/**
	 * @return the serviceTypeList
	 */
	public List<YJASelectTagVO> getServiceTypeList() {

		return serviceTypeList;
	}

	/**
	 * @param serviceTypeList
	 *            the serviceTypeList to set
	 */
	public void setServiceTypeList(List<YJASelectTagVO> serviceTypeList) {
		this.serviceTypeList = serviceTypeList;
	}

	/**
	 * @return the campSiteLocationList
	 */
	public List<YJACampSiteLocationInfoVO> getCampSiteLocationList() {
		return campSiteLocationList;
	}

	/**
	 * @param campSiteLocationList
	 *            the campSiteLocationList to set
	 */
	public void setCampSiteLocationList(
			List<YJACampSiteLocationInfoVO> campSiteLocationList) {
		this.campSiteLocationList = campSiteLocationList;
	}

	/**
	 * @return the validateResult
	 */
	public String getValidateResult() {
		return validateResult;
	}

	/**
	 * @param validateResult
	 *            the validateResult to set
	 */
	public void setValidateResult(String validateResult) {
		this.validateResult = validateResult;
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
}
