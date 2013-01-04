package com.yja.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import com.yja.action.model.YJAS004ActionModel;
import com.yja.action.model.YJAS008ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.ReservationInfo;
import com.yja.util.YJACommonUtil;
import com.yja.util.YJADateUtil;
import com.yja.vo.YJAReservedInfoVO;
import com.yja.vo.YJASInputSessionVO;

/**
 * This class provides the business logic for the screen to save 
 * the reservation information into Database.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS004Service extends AbsYJACommonService {
	
	private YJAS004ActionModel actionModel;

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS004DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel, java.util.Map)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {
		this.actionModel = (YJAS004ActionModel)actionModel;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void view(String executeFlg) throws Exception {
		//Calculate total cost.
		double totalCost = 0.0;
		
		//Performs the initialization of the screen.
		if(EXECUTE_FLG_INIT.equals(executeFlg)) {
		
			List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>)getSession().get(SESSION_RESERVEDINFO);
			this.actionModel.setReservedInfoList(reservedInfoList);
			this.actionModel.setReservedEmail(this.actionModel.getUserId());
			
			for(int i = 0; i < reservedInfoList.size(); i++ ) {				
				totalCost += Double.parseDouble(reservedInfoList.get(i).getTotalcost());				
			}
			
			this.actionModel.setCostNotTax(YJACommonUtil.getStrFromDouble(totalCost));
			this.actionModel.setTax(YJACommonUtil.getStrFromDouble(totalCost * HST));
			this.actionModel.setCostWithTax(YJACommonUtil.getStrFromDouble(totalCost * (1 + HST)));				
		
		} 
		//Performs the initialization when the screen is come back from another screen.  
		else if(EXECUTE_FLG_BACK_INIT.equals(executeFlg)) {
			
			//Set the Session information into ActionModel.
			YJASInputSessionVO inputSessionVO = (YJASInputSessionVO)getSession().get(SESSION_YJAS004_INPUT);		
			this.actionModel.setReservedEmail(this.actionModel.getUserId());
			this.actionModel.setUserPhoneNumber(inputSessionVO.getUserPhoneNumber());
			this.actionModel.setExtraService(inputSessionVO.getExtraService());	
			this.actionModel.setCostNotTax(inputSessionVO.getCostNotTax());
			this.actionModel.setCostWithTax(inputSessionVO.getCostWithTax());
			this.actionModel.setTax(inputSessionVO.getTax());				
			List<YJAReservedInfoVO> reservedInfoList = (ArrayList<YJAReservedInfoVO>)getSession().get(SESSION_RESERVEDINFO);
			this.actionModel.setReservedInfoList(reservedInfoList);
			
			//Delete unnecessary Session information.
			getSession().remove(SESSION_YJAS004_INPUT);
		}
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@Override
	public Object check(String executeFlg) throws Exception {		
		//Do not use.
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void modify(String executeFlg) throws Exception {
		
		//Performs the insertion of the reservation information into Database
		if(EXECUTE_FLG_INSERT.equals(executeFlg)) {			
			
			//Creates reservation ID
			List<Long> count = (List<Long>)yjaDao.getList(EXECUTE_CREATE_RESERVATION_ID, null);			
			String reservationId = YJADateUtil.getCurrentDayYYYYMMDD() + "-" + YJACommonUtil.getZeroFillString(6, count.get(0).intValue() + 1);			
			this.actionModel.setReservationId(reservationId);
			
			//Obtains the list of reservation information from session.
			List<YJAReservedInfoVO> reservedInfoVOList = (ArrayList<YJAReservedInfoVO>)getSession().get(SESSION_RESERVEDINFO);			
			List<ReservationInfo> reservationInfoList = new ArrayList<ReservationInfo>();
			
			for(int i = 0; i < reservedInfoVOList.size(); i++) {
				ReservationInfo reservationInfo = new ReservationInfo();
				YJAReservedInfoVO reservedInfoVO = reservedInfoVOList.get(i);
				reservationInfo.setReservationId(reservationId);
				reservationInfo.setExtraService(this.actionModel.getExtraService());				
				reservationInfo.setReservedAddress(this.actionModel.getUserAddr());
				reservationInfo.setReservedCity(this.actionModel.getUserCity());
				reservationInfo.setReservedEmail(this.actionModel.getReservedEmail());
				reservationInfo.setReservedFName(this.actionModel.getUserFName());
				reservationInfo.setReservedLName(this.actionModel.getUserLName());				
				reservationInfo.setReservedPhone(this.actionModel.getUserPhoneNumber());
				reservationInfo.setReservedPost(this.actionModel.getUserPost());
				reservationInfo.setReservedProvince(this.actionModel.getUserProv());
				
				//Sets the login user Id if it exists.
				if(getSession().get(SESSION_USERINFO) != null) {			
					YJAS008ActionModel sessionModel = (YJAS008ActionModel)getSession().get(SESSION_USERINFO);					
					reservationInfo.setUserId(sessionModel.getUserId());
				}
				
				reservationInfo.setCampMapID(reservedInfoVO.getCampMapId());	
				reservationInfo.setArrivalDate(YJADateUtil.getDateFromString(reservedInfoVO.getArrivalDate() + ZERO_HHMMSS));
				
				//Calculate the end date with the number of night to stay.
				reservationInfo.setEndDate(YJADateUtil.getDatePlusDay(reservedInfoVO.getArrivalDate() + LAST_HHMMSS, Integer.parseInt(reservedInfoVO.getNight())));			
				reservationInfo.setSiteNo(Integer.parseInt(reservedInfoVO.getReservedSiteNo()));
				reservationInfo.setResservationType(reservedInfoVO.getReservedSitetype());
				reservationInfo.setReservedNight(Integer.parseInt(reservedInfoVO.getNight()));
				reservationInfo.setReservedPartySize(Integer.parseInt(reservedInfoVO.getPartySize()));
				reservationInfo.setTotalCost((Double.parseDouble(reservedInfoVO.getTotalcost()) + Double.parseDouble(reservedInfoVO.getCostForextraPeople())) * (1 + HST));
				reservationInfo.setExtraPeopleCost(Double.parseDouble(reservedInfoVO.getCostForextraPeople()));				
				reservationInfo.setInsertDate(new Date());
				reservationInfo.setStatusId("01");
				
				reservationInfoList.add(reservationInfo);
			}
			
			yjaDao.insert(EXECUTE_RESERVATION_INSERT, reservationInfoList);
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInfoBeforeLogin()
	 */
	@Override
	public void setInfoBeforeLogin() throws Exception {		
		//Stores the searching condition into Session
		YJASInputSessionVO inputSessionVO = new YJASInputSessionVO();
		inputSessionVO.setUserPhoneNumber(this.actionModel.getUserPhoneNumber());
		inputSessionVO.setUserEmail(this.actionModel.getReservedEmail());	
		inputSessionVO.setExtraService(this.actionModel.getExtraService());	
		inputSessionVO.setCostNotTax(this.actionModel.getCostNotTax());
		inputSessionVO.setCostWithTax(this.actionModel.getCostWithTax());
		inputSessionVO.setTax(this.actionModel.getTax());			
		getSession().put(SESSION_YJAS004_INPUT, inputSessionVO);		
	}

}
