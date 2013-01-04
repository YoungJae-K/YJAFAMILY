package com.yja.action.model;

import java.util.List;
import com.yja.vo.YJACampSiteInfoVO;

/**
 * The Model class for the pop-up dialog, which is displaying the information of camp site.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAP001ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = -3445014736632111413L;
	private String partySize;
	private YJACampSiteInfoVO campSiteInfo;
	private List<String> peopleList;
	private String screenMode;
	private String siteNo;
	private String siteType;
	private String cost = "0.00";
	private String extraPeopleCost = "0.00";
	private int allowedPartySize;

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
	 * @return the peopleList
	 */
	public List<String> getPeopleList() {

		return peopleList;
	}

	/**
	 * @param peopleList
	 *            the peopleList to set
	 */
	public void setPeopleList(List<String> peopleList) {
		this.peopleList = peopleList;
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
	 * @return the campSiteInfo
	 */
	public YJACampSiteInfoVO getCampSiteInfo() {
		return campSiteInfo;
	}

	/**
	 * @param campSiteInfo
	 *            the campSiteInfo to set
	 */
	public void setCampSiteInfo(YJACampSiteInfoVO campSiteInfo) {
		this.campSiteInfo = campSiteInfo;
	}

}
