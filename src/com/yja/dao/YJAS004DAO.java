package com.yja.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import com.yja.dao.model.ReservationInfo;
import com.yja.util.YJADateUtil;

/**
 * This class provides implementation to control database for the screen 
 * to confirm reservation of camp sites.
 * 
 * @author  YOUNGJAE KIM
 *
 */
public class YJAS004DAO extends AbsYJACommonDAO {

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#insert(java.lang.String, java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object insert(String executeFlg, Object insertInfo) throws Exception {
		if(EXECUTE_RESERVATION_INSERT.equals(executeFlg)) {			
			List<ReservationInfo> reservationInfoList = (ArrayList<ReservationInfo>)insertInfo;			
			Session session = getSession();
			try{
				session.beginTransaction();			
				for(int i = 0; i < reservationInfoList.size(); i++) {				
					session.save(reservationInfoList.get(i));				
				}
			} finally {
				session.getTransaction().commit();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#getList(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<?> getList(String executeFlg, Object conditions) throws Exception {		
		
		//In order to create new reservation Id, getting all the reservation IDs existing on the current date.
		if(EXECUTE_CREATE_RESERVATION_ID.equals(executeFlg)) {
			return this.getCountReservationID(conditions);
		}		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object update(String executeFlg, Object updateInfo) throws Exception {
		//Not using
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object delete(String executeFlg, Object deleteInfo) throws Exception {
		//Not using
		return null;
	}
	
	/**
	 * Performs to get the list of the reservation Id existing on the current date.
	 * 
	 * @param Conditions to search information on database(the current date - max, min) 
	 * @return List of reservation IDs.
	 * @throws Exception
	 */
	private List<?> getCountReservationID(Object conditionsMap) throws Exception {		
		Criteria crit = getSession().createCriteria(ReservationInfo.class);		
		crit.setProjection(Projections.countDistinct(HIBERNATE_RESERVATION_ID));		
		Date minDate = YJADateUtil.getCurrentMinDate();
		Date maxDate = YJADateUtil.getCurrentMaxDate();		
		crit.add(Restrictions.between(HIBERNATE_INSERT_DATE, minDate, maxDate));		
		return crit.list();
	}

}
