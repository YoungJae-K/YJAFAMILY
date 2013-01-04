package com.yja.vo;

/**
 * The VO class for storing the reservation information.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAReservedInfoVO {

	private String reservedSiteNo;
	private String reservedSitetype;
	private String reservedPartySize;
	private String campUnitCost = "0.00";
	private String costForextraPeople = "0.00";
	private String totalcost = "0.00";
	private String reservationId;
	private String arrivalDate;
	private String night;
	private String status;
	private String partySize;
	private int campMapId;
	private boolean isEnable = true;

	/**
	 * @return the isEnable
	 */
	public boolean isEnable() {
		return isEnable;
	}

	/**
	 * @param isEnable
	 *            the isEnable to set
	 */
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the reservedSiteNo
	 */
	public String getReservedSiteNo() {
		return reservedSiteNo;
	}

	/**
	 * @param reservedSiteNo
	 *            the reservedSiteNo to set
	 */
	public void setReservedSiteNo(String reservedSiteNo) {
		this.reservedSiteNo = reservedSiteNo;
	}

	/**
	 * @return the reservedSitetype
	 */
	public String getReservedSitetype() {
		return reservedSitetype;
	}

	/**
	 * @param reservedSitetype
	 *            the reservedSitetype to set
	 */
	public void setReservedSitetype(String reservedSitetype) {
		this.reservedSitetype = reservedSitetype;
	}

	/**
	 * @return the reservedPartySize
	 */
	public String getReservedPartySize() {
		return reservedPartySize;
	}

	/**
	 * @param reservedPartySize
	 *            the reservedPartySize to set
	 */
	public void setReservedPartySize(String reservedPartySize) {
		this.reservedPartySize = reservedPartySize;
	}

	/**
	 * @return the campUnitCost
	 */
	public String getCampUnitCost() {
		return campUnitCost;
	}

	/**
	 * @param campUnitCost
	 *            the campUnitCost to set
	 */
	public void setCampUnitCost(String campUnitCost) {
		this.campUnitCost = campUnitCost;
	}

	/**
	 * @return the costForextraPeople
	 */
	public String getCostForextraPeople() {
		return costForextraPeople;
	}

	/**
	 * @param costForextraPeople
	 *            the costForextraPeople to set
	 */
	public void setCostForextraPeople(String costForextraPeople) {
		this.costForextraPeople = costForextraPeople;
	}

	/**
	 * @return the totalcost
	 */
	public String getTotalcost() {
		return totalcost;
	}

	/**
	 * @param totalcost
	 *            the totalcost to set
	 */
	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}

}
