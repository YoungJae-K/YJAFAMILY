package com.yja.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAP001ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.CampPhotoInfo;
import com.yja.dao.model.EquipmentMast;
import com.yja.dao.model.SiteInfo;
import com.yja.util.YJACommonUtil;
import com.yja.vo.YJACampSiteInfoVO;
import com.yja.vo.YJAReservedInfoVO;
import com.yja.vo.YJASInputSessionVO;

/**
 * This class provides the business logic for the pop-up dialog to display the information of camp site.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAP001Service extends AbsYJACommonService {

	private YJAP001ActionModel actionModel;
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAP001DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel, java.util.Map)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {	
		this.actionModel = (YJAP001ActionModel)actionModel;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void view(String executeFlg) throws Exception {	
		
		//Display the number of people reserved if the screen mode is "reserved".
		if(MODE_RESERVED.equals(this.actionModel.getScreenMode())) {
			List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>) getSession()
					.get(SESSION_RESERVEDINFO);
			YJAReservedInfoVO reservedInfo = reservedInfoList.get(Integer.parseInt(this.actionModel.getSiteNo()));
			this.actionModel.setSiteNo(reservedInfo.getReservedSiteNo());
			this.actionModel.setPartySize(reservedInfo.getPartySize());
		} 
		
		//Obtains the information of the camp sited selected.
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();
		searchingConditionMap.put(HIBERNATE_SITE_NO, new Integer(this.actionModel.getSiteNo()));
		searchingConditionMap.put(HIBERNATE_MAP_ID, new Integer(this.actionModel.getCampMapId()));		
		List<SiteInfo> siteInfoList = (List<SiteInfo>)yjaDao.getList(EXECUTE_SITE_INFO, searchingConditionMap);		
		SiteInfo siteInfo = siteInfoList.get(0);
		
		//Sets the information of the camp site to display.
		YJACampSiteInfoVO campSiteInfo = new YJACampSiteInfoVO();			
		campSiteInfo.setSiteNo(String.valueOf(siteInfo.getSiteNo()));
		campSiteInfo.setSiteType(siteInfo.getReservationTypeMast().getReservationTypeDesc());		
		campSiteInfo.setCost(YJACommonUtil.getStrFromDouble(siteInfo.getSiteCost()));
		campSiteInfo.setServiceType(siteInfo.getServiceTypeMast().getServiceTypeDesc());
		campSiteInfo.setOffSiteParking(siteInfo.getAllowedOffParking());
		campSiteInfo.setOnSiteParking(siteInfo.getAllowedOnParking());
		campSiteInfo.setSiteLenth(siteInfo.getSiteLength());
		campSiteInfo.setSiteWidth(siteInfo.getSiteWidth());
		campSiteInfo.setPartSize(siteInfo.getAllowedPartySize());	
		campSiteInfo.setAllowedExtraPartySize(siteInfo.getAllowedExtraPartySize());
		campSiteInfo.setExtraPeopleCost(YJACommonUtil.getStrFromDouble(siteInfo.getExtraPeopleCost()));
		
		//Obtains all the equipments allowed on the camp site reserved.
		List<EquipmentMast> equipmentList = siteInfo.getEquipmentList();		
		StringBuffer equipBuf = new StringBuffer();		
		for(int i = 0; i < equipmentList.size(); i++) {
			equipBuf.append(equipmentList.get(i).getEquipmentTypeDesc());			
			if(i != equipmentList.size() - 1) {
				equipBuf.append(", ");
			}
		}		
		campSiteInfo.setAllowedEquipment(equipBuf.toString());		

		//Creates the list for combo box of party size if the screen mode is "insert".
		ArrayList<String> peopleList = new ArrayList<String>();		
		if(MODE_INSERT.equals(this.actionModel.getScreenMode())) {
			for (int i = 1; i <= campSiteInfo.getPartySize() + campSiteInfo.getAllowedExtraPartySize() ; i++) {
				peopleList.add(String.valueOf(i));
			}
		} 
		
		//Sets the images of camp site selected
		List<String> sitePhotoFullPathList = new ArrayList<String>();		
		for(int j = 0; j < siteInfo.getCampPhotoInfoList().size(); j++) {
			CampPhotoInfo campPhotoInfo = siteInfo.getCampPhotoInfoList().get(j);				
			sitePhotoFullPathList.add(this.sitePhotoPath + campPhotoInfo.getCampPhotoImage());
		}		
		campSiteInfo.setSitePhotoFullPathList(sitePhotoFullPathList);	
		campSiteInfo.setCampMapId(this.actionModel.getCampMapId());
		this.actionModel.setPeopleList(peopleList);
		this.actionModel.setCampSiteInfo(campSiteInfo);		
		getSession().put(SESSION_CAMPSITEINFO, campSiteInfo);
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@Override
	public Object check(String executeFlg) throws Exception {
		//Not using
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void modify(String executeFlg) throws Exception {
		
		//When the button [Select] is pressed.
		if(EXECUTE_FLG_SELECT.equals(executeFlg)) {
			
			boolean isSessionStore = false;
			
			//Obtains the reservation information from Session
			List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>) getSession()
					.get(SESSION_RESERVEDINFO);
	
			//If there is not session information, create new arrayList to store the reservation information
			if (reservedInfoList == null) {
				reservedInfoList = new ArrayList<YJAReservedInfoVO>();
				isSessionStore = true;
			}
			
			//Create new reservation data based on the information of camp site selected.
			YJASInputSessionVO searchConditionsVO = (YJASInputSessionVO)getSession().get(SESSION_SEARCH_CONDITION);
			YJACampSiteInfoVO campSiteInfo = (YJACampSiteInfoVO)getSession().get(SESSION_CAMPSITEINFO);			
			YJAReservedInfoVO reservedInfo = new YJAReservedInfoVO();
			reservedInfo.setArrivalDate(searchConditionsVO.getArrivalDate());
			reservedInfo.setNight(searchConditionsVO.getNight());
			reservedInfo.setPartySize(this.actionModel.getPartySize());
			reservedInfo.setReservedSiteNo(campSiteInfo.getSiteNo());
			reservedInfo.setReservedSitetype(campSiteInfo.getSiteType());
			reservedInfo.setCampUnitCost(campSiteInfo.getCost());
			
			//Calculate the total cost with the cost of extra people, but without HST.	
			double extraPeopleCost = 0.0;			
			if(Integer.parseInt(this.actionModel.getPartySize()) > campSiteInfo.getPartySize()) {
				extraPeopleCost = (Integer.parseInt(this.actionModel.getPartySize()) - campSiteInfo.getPartySize()) * Double.parseDouble(campSiteInfo.getExtraPeopleCost());
			}		
			reservedInfo.setCostForextraPeople(YJACommonUtil.getStrFromDouble(extraPeopleCost));
			reservedInfo.setTotalcost(YJACommonUtil.getStrFromDouble(Double.parseDouble(campSiteInfo.getCost()) + extraPeopleCost));
			reservedInfo.setCampMapId(campSiteInfo.getCampMapId());
			reservedInfoList.add(reservedInfo);
	
			if (isSessionStore) {
				getSession().put(SESSION_RESERVEDINFO, reservedInfoList);
			}
		}
		
		//Removes unnecessary session.
		getSession().remove(SESSION_CAMPSITEINFO);		
	}

}
