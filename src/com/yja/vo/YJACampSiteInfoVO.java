package com.yja.vo;

import java.util.List;

/**
 * The VO class for storing the basic information of camp site.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJACampSiteInfoVO {
	private String siteNo;
	private String siteType;
	private String serviceType;
	private String electricalService;
	private String cost = "0.00";
	private String extraPeopleCost = "0.00";
	private String allowedEquipment;
	private double siteLenth;
	private double siteWidth;
	private int onSiteParking;
	private int offSiteParking;
	private int partySize;
	private int allowedExtraPartySize;
	private int campMapId;
	private List<String> sitePhotoFullPathList;
	/** 0: available, 1: on reserving now, 2: unavailable */
	private int status = 0;
	private YJACampSiteLocationInfoVO campSiteLocationInfo;

	/**
	 * @return the campSiteLocationInfo
	 */
	public YJACampSiteLocationInfoVO getCampSiteLocationInfo() {
		return campSiteLocationInfo;
	}

	/**
	 * @param campSiteLocationInfo
	 *            the campSiteLocationInfo to set
	 */
	public void setCampSiteLocationInfo(
			YJACampSiteLocationInfoVO campSiteLocationInfo) {
		this.campSiteLocationInfo = campSiteLocationInfo;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the campMapId
	 */
	public int getCampMapId() {
		return campMapId;
	}

	/**
	 * @param campMapId
	 *            the campMapId to set
	 */
	public void setCampMapId(int campMapId) {
		this.campMapId = campMapId;
	}

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
	public String getExtraPeopleCost() {
		return extraPeopleCost;
	}

	/**
	 * @param extraPeopleCost
	 *            the extraPeopleCost to set
	 */
	public void setExtraPeopleCost(String extraPeopleCost) {
		this.extraPeopleCost = extraPeopleCost;
	}

	/**
	 * @return the sitePhotoFullPathList
	 */
	public List<String> getSitePhotoFullPathList() {
		return sitePhotoFullPathList;
	}

	/**
	 * @param sitePhotoFullPathList
	 *            the sitePhotoFullPathList to set
	 */
	public void setSitePhotoFullPathList(List<String> sitePhotoFullPathList) {
		this.sitePhotoFullPathList = sitePhotoFullPathList;
	}

	/**
	 * @param partySize
	 *            the partySize to set
	 */
	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	/**
	 * @return the siteNo
	 */
	public String getSiteNo() {
		return siteNo;
	}

	/**
	 * @param siteNo
	 *            the siteNo to set
	 */
	public void setSiteNo(String siteNo) {
		this.siteNo = siteNo;
	}

	/**
	 * @return the siteType
	 */
	public String getSiteType() {
		return siteType;
	}

	/**
	 * @param siteType
	 *            the siteType to set
	 */
	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}

	/**
	 * @param serviceType
	 *            the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * @return the electricalService
	 */
	public String getElectricalService() {
		return electricalService;
	}

	/**
	 * @param electricalService
	 *            the electricalService to set
	 */
	public void setElectricalService(String electricalService) {
		this.electricalService = electricalService;
	}

	/**
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}

	/**
	 * @return the allowedEquipment
	 */
	public String getAllowedEquipment() {
		return allowedEquipment;
	}

	/**
	 * @param allowedEquipment
	 *            the allowedEquipment to set
	 */
	public void setAllowedEquipment(String allowedEquipment) {
		this.allowedEquipment = allowedEquipment;
	}

	/**
	 * @return the siteLenth
	 */
	public double getSiteLenth() {
		return siteLenth;
	}

	/**
	 * @param siteLenth
	 *            the siteLenth to set
	 */
	public void setSiteLenth(double siteLenth) {
		this.siteLenth = siteLenth;
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
	 * @return the onSiteParking
	 */
	public int getOnSiteParking() {
		return onSiteParking;
	}

	/**
	 * @param onSiteParking
	 *            the onSiteParking to set
	 */
	public void setOnSiteParking(int onSiteParking) {
		this.onSiteParking = onSiteParking;
	}

	/**
	 * @return the offSiteParking
	 */
	public int getOffSiteParking() {
		return offSiteParking;
	}

	/**
	 * @param offSiteParking
	 *            the offSiteParking to set
	 */
	public void setOffSiteParking(int offSiteParking) {
		this.offSiteParking = offSiteParking;
	}

	/**
	 * @return the partySize
	 */
	public int getPartySize() {
		return partySize;
	}

	/**
	 * @param partySize
	 *            the partySize to set
	 */
	public void setPartSize(int partySize) {
		this.partySize = partySize;
	}

}
