package com.yja.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.yja.dao.model.ReservationInfo;

/**
 * This class provides implementation to control database for the screen 
 * to search and delete the reservation information.
 * 
 * @author  YOUNGJAE KIM
 *
 */
public class YJAS005DAO extends AbsYJACommonDAO {

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#insert(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object insert(String executeFlg, Object insertInfo) throws Exception {
		//Not using
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#getList(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<?> getList(String executeFlg, Object conditions) throws Exception {
		//Obtains all the reservation information.
		if(EXECUTE_RESERVATION_INFO.equals(executeFlg)) {
			ArrayList<String[]> orderList = new ArrayList<String[]>();
			String[] orderArr = new String[2];
			orderArr[0] = HIBERNATE_ARRIVAL_DATE;
			orderArr[1] = HIBERNATE_ORDER_ASC;
			orderList.add(orderArr);			
			return this.getListOptionalEqWithOrder(ReservationInfo.class, conditions, orderList);
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
		
		//Delete the reservation information selected
		if(EXECUTE_RESERVATION_DELETE.equals(executeFlg)) {
			this.deleteReservationInfo(deleteInfo);
		}
		return null;
	}
	
	/**
	 * Performs to delete all the reservation information selected.
	 * 
	 * @param List of the reservation information to delete
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void deleteReservationInfo(Object deleteInfo) throws Exception {
		List<HashMap<String, Object>> deleteList = (List<HashMap<String, Object>>)deleteInfo;
		
		Session session = getSession();
		
		try{
			session.beginTransaction();
			
			for(int i = 0; i < deleteList.size(); i++) {
				HashMap<String, Object> deleteConditionMap = deleteList.get(i);
				ReservationInfo reservationInfo = 
						(ReservationInfo)session.createCriteria(ReservationInfo.class)
						.add(Restrictions.eq(HIBERNATE_RESERVATION_ID, deleteConditionMap.get(HIBERNATE_RESERVATION_ID)))
						.add(Restrictions.eq(HIBERNATE_SITE_NO, deleteConditionMap.get(HIBERNATE_SITE_NO)))
						.add(Restrictions.eq(HIBERNATE_ARRIVAL_DATE, deleteConditionMap.get(HIBERNATE_ARRIVAL_DATE))).uniqueResult();
				
				session.delete(reservationInfo);
			}
		} finally {
			session.getTransaction().commit();
		}
	}
}
