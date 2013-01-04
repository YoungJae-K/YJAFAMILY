package com.yja.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS005ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.ReservationInfo;
import com.yja.util.YJACommonUtil;
import com.yja.util.YJADateUtil;
import com.yja.vo.YJAReservedInfoVO;
import com.yja.vo.YJASInputSessionVO;

/**
 * This class provides the business logic for the screen to display 
 * and delete the list of reservation information. 
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS005Service extends AbsYJACommonService {

	private YJAS005ActionModel actionModel;	

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS005DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel, java.util.Map)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {
		this.actionModel = (YJAS005ActionModel)actionModel;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@Override
	public void view(String executeFlg) throws Exception {
		
		//Performs this initialization only when the screen is come back from another screen.  
		if(EXECUTE_FLG_BACK_INIT.equals(executeFlg)) {			
			YJASInputSessionVO inputSessionVO = (YJASInputSessionVO) getSession().get(SESSION_YJAS005_INPUT);
			this.actionModel.setReservationId(inputSessionVO.getReservationId());
			getSession().remove(SESSION_YJAS005_INPUT);
		}
		
		//Searches the reservation information based on the searching conditions.
		this.searchReservationInfo();
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@Override
	public Object check(String executeFlg) throws Exception {
		
		String errMessageId = null;
		
		//User must enter either reservationId or email.
		if(EXECUTE_FLG_INPUT_CHECK.equals(executeFlg)) {
			if((this.actionModel.getReservationId() == null || "".equals(this.actionModel.getReservationId().trim())) && 
					(this.actionModel.getUserId() == null || "".equals(this.actionModel.getUserId().trim()))) {
				errMessageId = ERROR_SEARCH_REQUIRED;
			}
		} 
		
		return errMessageId;		
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@Override
	public void modify(String executeFlg) throws Exception {
		
		//Deletes the list of reservation selected.
		if(EXECUTE_FLG_DELETE.equals(executeFlg)) {
			
			//The structure of the string: reservationId + '/' + reservedSiteNo + '/' + arrivalDate
			List<String> selectedRow = this.actionModel.getSelectedReservationId();
			List<HashMap<String, Object>> deleteInfoList = new ArrayList<HashMap<String, Object>>();
			
			//Obtains reservaitionId, siteNo, and date to arrive in order to delete the information selected.
			for(int i = 0; i < selectedRow.size(); i++) {
				
				//Skips the process if the value stored is invalid.
				if(selectedRow.get(i) == null || "false".equals(selectedRow.get(i).toString())) {
					continue;
				}
				
				//Obtains the reservation Id, the number of camp site, and the date to arrive, in order to delete.
				HashMap<String, Object> deleteMap = new HashMap<String, Object>();				
				String[] keyArr = selectedRow.get(i).split("/");				
				deleteMap.put(HIBERNATE_RESERVATION_ID, keyArr[0]);
				deleteMap.put(HIBERNATE_SITE_NO, new Integer(keyArr[1]));
				deleteMap.put(HIBERNATE_ARRIVAL_DATE, YJADateUtil.getDateFromString(keyArr[2] + ZERO_HHMMSS));
				
				deleteInfoList.add(deleteMap);
			}
			
			//Performs the deletion of the list of reservation information selected
			yjaDao.delete(EXECUTE_RESERVATION_DELETE, deleteInfoList);			
		}		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInfoBeforeLogin()
	 */
	@Override
	public void setInfoBeforeLogin() throws Exception {
		//Stores the searching conditions into Session
		YJASInputSessionVO inputSessionVO = new YJASInputSessionVO();
		inputSessionVO.setReservationId(this.actionModel.getReservationId());
		getSession().put(SESSION_YJAS005_INPUT, inputSessionVO);		
	}
	
	/**
	 * Performs to search the reservation information based on 
	 * the searching conditions inputed.
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void searchReservationInfo() throws Exception {
		
		//Creates the searching condition for the selection of database.
		HashMap<String, Object> searchingConditionMap = new HashMap<String, Object>();
		if(this.actionModel.getReservationId() != null && !"".equals(this.actionModel.getReservationId())) {
			searchingConditionMap.put(HIBERNATE_RESERVATION_ID, this.actionModel.getReservationId());
		}
		if(this.actionModel.getUserId() != null && !"".equals(this.actionModel.getUserId())) {
			searchingConditionMap.put(HIBERNATE_USER_ID, this.actionModel.getUserId());	
		}
		
		//Obtains the list of the reservation information from Database.
		List<ReservationInfo> reservationInfoList = (List<ReservationInfo>)yjaDao.getList(EXECUTE_RESERVATION_INFO, searchingConditionMap);		
		List<YJAReservedInfoVO> reservedInfoList = new ArrayList<YJAReservedInfoVO>();
		
		for (int i = 0; i < reservationInfoList.size(); i++) {			
			ReservationInfo reservationInfo = reservationInfoList.get(i);
			YJAReservedInfoVO reservedInfoVO = new YJAReservedInfoVO();
			reservedInfoVO.setReservedSiteNo(String.valueOf(reservationInfo.getSiteNo()));
			reservedInfoVO.setReservedSitetype(reservationInfo.getResservationType());
			reservedInfoVO.setArrivalDate(YJADateUtil.getStringFromDate(YJADateUtil.DATE_YYYYMMDD_HYPEN, reservationInfo.getArrivalDate()));
			
			if(YJADateUtil.getCurrentDay(YJADateUtil.DATE_YYYYMMDD_HYPEN).compareTo(reservedInfoVO.getArrivalDate()) > 0) {
				reservedInfoVO.setEnable(false);
				reservedInfoVO.setStatus("On going");
			} else {
				reservedInfoVO.setEnable(true);
				reservedInfoVO.setStatus("Closed");
			}
			
			reservedInfoVO.setReservedPartySize(String.valueOf(reservationInfo.getReservedPartySize()));
			reservedInfoVO.setNight(String.valueOf(reservationInfo.getReservedNight()));			
			reservedInfoVO.setReservationId(reservationInfo.getReservationId());
			reservedInfoVO.setTotalcost(YJACommonUtil.getStrFromDouble(reservationInfo.getTotalCost()));
			reservedInfoList.add(reservedInfoVO);
		}
		
		this.actionModel.setReservedInfoList(reservedInfoList);
	}
}
