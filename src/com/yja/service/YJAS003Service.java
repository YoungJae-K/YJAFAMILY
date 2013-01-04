package com.yja.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS003ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.CampMapInfo;
import com.yja.dao.model.CampPhotoInfo;
import com.yja.dao.model.ReservationTypeMast;
import com.yja.dao.model.ServiceTypeMast;
import com.yja.dao.model.SiteInfo;
import com.yja.util.YJACommonUtil;
import com.yja.util.YJADateUtil;
import com.yja.vo.YJACampSiteInfoVO;
import com.yja.vo.YJACampSiteLocationInfoVO;
import com.yja.vo.YJAReservedInfoVO;
import com.yja.vo.YJASInputSessionVO;
import com.yja.vo.YJASelectTagVO;

/**
 * This class provides the business logic for the screen to search and reserve the camp sites.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS003Service extends AbsYJACommonService {
	
	private YJAS003ActionModel actionModel;

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS003DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {	
			this.actionModel = (YJAS003ActionModel)actionModel;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@Override
	public void view(String executeFlg) throws Exception {
		
		//Performs the initialization for the screen.
		if(EXECUTE_FLG_INIT.equals(executeFlg)) {
			
			//Obtains the list of service type
			this.setServiceTypeList();				
			//Obtains the list of reservation type
			this.setReservationTypeList();			
			//Sets today and one night as a default
			this.actionModel.setArrivalDate(YJADateUtil.getCurrentDay_YYYYMMDD_HYPEN());	
			this.actionModel.setNight("1");	
			
			//Saves the conditions to search in order to display the same result 
			//when the screen is come back from another screen. 
			this.saveSearchCondtoSession();
			
		} 
		//Performs the operation when the button [Search] is pressed.
		else if(EXECUTE_FLG_SEARCH.equals(executeFlg)){		
			//Saves the conditions to search
			this.saveSearchCondtoSession();				
		} 
		//Performs the operation when the screen is come back from another screen. 
		else {
			//Sets the session information of searching conditions to Model.
			this.setSessionInfoToModel();		
		}
		
		//Obtains the information of all camp sites from database.
		this.searchCampingInfo();
	}
	
	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@Override
	public Object check(String executeFlg) throws Exception {
		//Do not use
		return null;	
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void modify(String executeFlg) throws Exception {		
		
		//When the button [X] is pressed.
		if(EXECUTE_FLG_DELETE.equals(executeFlg)) {
			List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>)getSession().get(SESSION_RESERVEDINFO);
			reservedInfoList.remove(Integer.parseInt(this.actionModel.getDeletedSiteNo()));
			
		} 
		//When the button [Delete All] is pressed.
		else if(EXECUTE_FLG_DELETE_ALL.equals(executeFlg)) {			
			getSession().remove(SESSION_RESERVEDINFO);			
		}
		
		this.searchCampingInfo();	
	}
	
	/**
	 * Performs to obtain all the information of camp sites based on 
	 * the searching conditions on the screen.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void searchCampingInfo() throws Exception {
	
		//Obtains and sets the list of service and reservation type
		List<YJASelectTagVO> serviceTypeList = (ArrayList<YJASelectTagVO>)getSession().get(SESSION_SERVICETYPE_LIST);
		List<YJASelectTagVO> reservationTypeList = (ArrayList<YJASelectTagVO>)getSession().get(SESSION_RESERVATIONTYPE_LIST);		
		this.actionModel.setServiceTypeList(serviceTypeList);		
		this.actionModel.setReservationTypeList(reservationTypeList);		

		//Obtains and sets the images of camp site and locations to display on camp map of the screen.
		this.setCampImageInfo();	
		this.setSiteInfo();
		
		//Sets the status of camp sites if it is available or not.
		this.setSiteStatus();
		
		//Calculates the cost information based on the reservation information that has already reserved.
		List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>)getSession().get(SESSION_RESERVEDINFO);		
		if(reservedInfoList != null) {
			this.actionModel.setReservedInfoList(reservedInfoList);			
			//Calculate total cost.
			double totalCost = 0.0;			
			for(int i = 0; i < reservedInfoList.size(); i++ ) {				
				totalCost += Double.parseDouble(reservedInfoList.get(i).getTotalcost());				
			}			
			this.actionModel.setCostNotTax(YJACommonUtil.getStrFromDouble(totalCost));
			this.actionModel.setTax(YJACommonUtil.getStrFromDouble(totalCost * HST));
			this.actionModel.setCostWithTax(YJACommonUtil.getStrFromDouble(totalCost * (1 + HST)));			
		}
	}
	
	/**
	 * Performs to get the information which camp sites are available.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setSiteStatus() throws Exception {
		
		//Creates the searching condition for the selection of database.
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();
		searchingConditionMap.put(HIBERNATE_MAP_ID, new Integer(this.actionModel.getCampMapId()));
		searchingConditionMap.put(HIBERNATE_ARRIVAL_DATE, YJADateUtil.getDateFromString(this.actionModel.getArrivalDate() + ZERO_HHMMSS));
		searchingConditionMap.put(HIBERNATE_END_DATE, YJADateUtil.getDatePlusDay(this.actionModel.getArrivalDate() + 
				ZERO_HHMMSS, Integer.parseInt(this.actionModel.getNight())));
		
		//Obtains the list of the number of unavailable camp site from database.
		List<Integer> siteInfoList = (List<Integer>)yjaDao.getList(EXECUTE_SITE_UNAVAIL_INFO, searchingConditionMap);			

		//Obtains the list of the number of camp sites that are reserving currently 
		List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>)getSession().get(SESSION_RESERVEDINFO);
		ArrayList<Integer> reservedSiteNoList = new ArrayList<Integer>();
		
		if(reservedInfoList != null) {
			//Calculates the date to end (Form information)
			String aEndDateStr =YJADateUtil.getDatePlusDayStr(this.actionModel.getArrivalDate(), Integer.parseInt(this.actionModel.getNight()));			
			for(int i = 0; i < reservedInfoList.size(); i++) {				
				YJAReservedInfoVO reservedInfo = reservedInfoList.get(i);				
				//Calculate the date to end (Session information)
				String rEndDateStr =  YJADateUtil.getDatePlusDayStr(reservedInfo.getArrivalDate(), Integer.parseInt(reservedInfo.getNight()));				
				if((this.actionModel.getArrivalDate().compareTo(reservedInfo.getArrivalDate()) <= 0 && aEndDateStr.compareTo(reservedInfo.getArrivalDate()) > 0) ||
						(this.actionModel.getArrivalDate().compareTo(rEndDateStr) < 0 && aEndDateStr.compareTo(rEndDateStr) >= 0)) {
					reservedSiteNoList.add(new Integer(reservedInfo.getReservedSiteNo()));
				}				
			}			
		}
		
		//Checks the status of camp site if it is available or not, and sets the status into VO for the screen.
		List<YJACampSiteInfoVO> campSiteInfoList = this.actionModel.getCampSiteInfoList();		
		for(int i = 0; i < campSiteInfoList.size(); i++) {
			YJACampSiteInfoVO campSiteInfo = campSiteInfoList.get(i);			
			//On reserving Site.
			if(reservedSiteNoList.contains(new Integer(campSiteInfo.getSiteNo()))) {
				campSiteInfo.setStatus(1);
			}
			//Unavailable site
			else if(siteInfoList.contains(new Integer(campSiteInfo.getSiteNo()))) {
				campSiteInfo.setStatus(2);
			}
		}		
	}

	/**
	 * Sets the information of camp sites obtained from Database.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setSiteInfo() throws Exception {
		
		//Creates the searching conditions into Map
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();
		searchingConditionMap.put(HIBERNATE_MAP_ID, new Integer(this.actionModel.getCampMapId()));
		
		//The type of reservation
		if(this.actionModel.getSelectedReservationType() != null && !"-1".equals(this.actionModel.getSelectedReservationType())) {
			ReservationTypeMast reservationTypeMast = new ReservationTypeMast();
			reservationTypeMast.setReservationTypeID(Integer.parseInt(this.actionModel.getSelectedReservationType()));
			searchingConditionMap.put(HIBERNATE_RESERVATION_MAST, reservationTypeMast);
		}
		
		//The type of service.
		if(this.actionModel.getSelectedServiceType() != null && !"-1".equals(this.actionModel.getSelectedServiceType())) {
			ServiceTypeMast serviceTypeMast = new ServiceTypeMast();
			serviceTypeMast.setServiceTypeID(Integer.parseInt(this.actionModel.getSelectedServiceType()));
			searchingConditionMap.put(HIBERNATE_SERVICE_MAST, serviceTypeMast);
		}
		
		//Obtains the list of the information of camp sites.
		List<SiteInfo> siteInfoList = (List<SiteInfo>)yjaDao.getList(EXECUTE_SITE_INFO, searchingConditionMap);
		
		//Sets all the information of camp sites into the corresponding ActionModel.
		List<YJACampSiteInfoVO> campSiteInfoList = new ArrayList<YJACampSiteInfoVO>(); 		
		for(int i = 0; i < siteInfoList.size(); i++) {			
			YJACampSiteInfoVO campSiteInfo = new YJACampSiteInfoVO();
			SiteInfo siteInfo = siteInfoList.get(i);
			campSiteInfo.setSiteNo(String.valueOf(siteInfo.getSiteNo()));
			campSiteInfo.setSiteType(siteInfo.getReservationTypeMast().getReservationTypeDesc());		
			campSiteInfo.setCost(YJACommonUtil.getStrFromDouble(siteInfo.getSiteCost()));
			campSiteInfo.setElectricalService(siteInfo.getServiceTypeMast().getServiceTypeDesc());
			campSiteInfo.setOffSiteParking(siteInfo.getAllowedOffParking());
			campSiteInfo.setOnSiteParking(siteInfo.getAllowedOnParking());
			campSiteInfo.setSiteLenth(siteInfo.getSiteLength());
			campSiteInfo.setSiteWidth(siteInfo.getSiteWidth());
			campSiteInfo.setPartSize(siteInfo.getAllowedPartySize());
			campSiteInfo.setCampMapId(siteInfo.getCampMapID());
		
			//For the images of camp site
			List<String> sitePhotoFullPathList = new ArrayList<String>();			
			for(int j = 0; j < siteInfo.getCampPhotoInfoList().size(); j++) {
				CampPhotoInfo campPhotoInfo = siteInfo.getCampPhotoInfoList().get(j);				
				sitePhotoFullPathList.add(this.sitePhotoPath + campPhotoInfo.getCampPhotoImage());
			}					
			campSiteInfo.setSitePhotoFullPathList(sitePhotoFullPathList);			
			
			//For the location information of camp site on camp map.
			YJACampSiteLocationInfoVO campSiteLocationInfoVO = new YJACampSiteLocationInfoVO();			
			campSiteLocationInfoVO.setSiteNo(siteInfo.getSiteNo());
			campSiteLocationInfoVO.setSiteLeft(siteInfo.getSiteLeftLoct());
			campSiteLocationInfoVO.setSiteTop(siteInfo.getSiteTopLoct() + 20);			
			campSiteInfo.setCampSiteLocationInfo(campSiteLocationInfoVO);			
			campSiteInfoList.add(campSiteInfo);			
		}
		
		this.actionModel.setCampSiteInfoList(campSiteInfoList);
	}
	
	
	/**
	 * Stores the searching conditions into Session in order to control for screen back.
	 * 
	 * @throws Exception
	 */
	private void saveSearchCondtoSession() throws Exception {
		
		//Remove the previous session data.
		getSession().remove(SESSION_SEARCH_CONDITION);
		
		/* *****************************************
		 *  Store the searching condition to session
		 * ****************************************/
		YJASInputSessionVO searchConditionsVO = new YJASInputSessionVO();		
		searchConditionsVO.setArrivalDate(this.actionModel.getArrivalDate());
		searchConditionsVO.setSelectedEquipment(this.actionModel.getSelectedEquipment());
		searchConditionsVO.setSelectedReservationType(this.actionModel.getSelectedReservationType());
		searchConditionsVO.setSelectedServiceType(this.actionModel.getSelectedServiceType());		
		searchConditionsVO.setNight(this.actionModel.getNight());
		searchConditionsVO.setTabMode(this.actionModel.getTabMode());
		searchConditionsVO.setPartySize(this.actionModel.getPartySize());		
		getSession().put(SESSION_SEARCH_CONDITION, searchConditionsVO);				
	}
	
	/**
	 * Sets the information of searching conditions in Session into ActionModel.
	 * 
	 * @throws Exception
	 */
	private void setSessionInfoToModel() throws Exception {		
		YJASInputSessionVO searchConditionsVO = (YJASInputSessionVO)getSession().get(SESSION_SEARCH_CONDITION);		
		
		if(searchConditionsVO !=null) {				
			this.actionModel.setArrivalDate(searchConditionsVO.getArrivalDate());
			this.actionModel.setSelectedEquipment(searchConditionsVO.getSelectedEquipment());
			this.actionModel.setSelectedReservationType(searchConditionsVO.getSelectedReservationType());
			this.actionModel.setSelectedServiceType(searchConditionsVO.getSelectedServiceType());		
			this.actionModel.setNight(searchConditionsVO.getNight());
			this.actionModel.setTabMode(searchConditionsVO.getTabMode());
			this.actionModel.setPartySize(searchConditionsVO.getPartySize());
		}
	}
	
	/**
	 * Obtains the list of reservation type from Database, and sets the list into ActionModel.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setReservationTypeList() throws Exception {
		
		//If the list of reservation type is already existing in Session.
		if(getSession().get(SESSION_RESERVATIONTYPE_LIST) != null) {
			this.actionModel.setReservationTypeList((List<YJASelectTagVO>) getSession().get(SESSION_RESERVATIONTYPE_LIST));
		
		} else { //Otherwise, Obtains the list from Database.
			
			//Obtains all reservation types from Database.	
			List<ReservationTypeMast> reservationTypeMasterList = (List<ReservationTypeMast>) yjaDao.getList(EXECUTE_RESERVTYPE_ALL, null);
			List<YJASelectTagVO> reservationTypeList = new ArrayList<YJASelectTagVO>();	
			
			for(int i = 0; i < reservationTypeMasterList.size(); i++ ) {	
				ReservationTypeMast reservationTypeMast = reservationTypeMasterList.get(i);
				YJASelectTagVO selectVo = new YJASelectTagVO(String.valueOf(reservationTypeMast.getReservationTypeID()), reservationTypeMast.getReservationTypeDesc());				
				reservationTypeList.add(selectVo);				
			}
			
			this.actionModel.setReservationTypeList(reservationTypeList);
			getSession().put(SESSION_RESERVATIONTYPE_LIST, reservationTypeList);
		}
	}
	
	/**
	 * Obtains the list of service type from Database, and sets the list into ActionModel.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setServiceTypeList() throws Exception {
		
		//If the list of reservation type is already existing in Session.
		if(getSession().get(SESSION_SERVICETYPE_LIST) != null) {
			this.actionModel.setServiceTypeList((List<YJASelectTagVO>) getSession().get(SESSION_SERVICETYPE_LIST));
		
		} else { //Otherwise, Obtains the list from database.
			
			//Obtain all service type from master database of service type.			
			List<ServiceTypeMast> serviceTypeMasterList = (List<ServiceTypeMast>) yjaDao.getList(EXECUTE_SERVICETYPE_ALL, null);
			List<YJASelectTagVO> serviceTypeList = new ArrayList<YJASelectTagVO>();
			
			for(int i = 0; i < serviceTypeMasterList.size(); i++ ) {				
				ServiceTypeMast serviceTypeMast = serviceTypeMasterList.get(i);
				YJASelectTagVO selectVo = new YJASelectTagVO(String.valueOf(serviceTypeMast.getServiceTypeID()), serviceTypeMast.getServiceTypeDesc());	
				serviceTypeList.add(selectVo);				
			}
			
			this.actionModel.setServiceTypeList(serviceTypeList);		
			getSession().put(SESSION_SERVICETYPE_LIST, serviceTypeList);
		}
	}

	/**
	 * Obtains the name of file of camp Map from Database, and sets it into ActionModel.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void setCampImageInfo() throws Exception {	
		
		//Creates the searching conditions
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();
		searchingConditionMap.put(HIBERNATE_CAMP_USE_FLG, new Integer(1));
		
		//Store the image of camp map.
		List<CampMapInfo> campMapInfoList = (List<CampMapInfo>)yjaDao.getList(EXECUTE_CAMPMAP_INFO, searchingConditionMap);
		CampMapInfo campMapInfo = campMapInfoList.get(0);	
		
		//Store camp map ID
		this.actionModel.setCampMapId(campMapInfo.getCampMapID());
		this.actionModel.setCampMapFullPath(this.campMapPath +  campMapInfo.getCampImage());		
	}
}
