package com.yja.dao;

import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import com.yja.dao.model.CampMapInfo;
import com.yja.dao.model.ReservationInfo;
import com.yja.dao.model.ReservationTypeMast;
import com.yja.dao.model.ServiceTypeMast;
import com.yja.dao.model.SiteInfo;

/**
 * This class provides implementation to control database for the screen 
 * of new reservation of camp sites.
 * 
 * @author  YOUNGJAE KIM
 *
 */
public class YJAS003DAO extends AbsYJACommonDAO {

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#insert(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object insert(String executeFlg, Object insertInfo) {		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#getList(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<?> getList(String executeFlg, Object conditions) throws Exception {
		
		//Obtains the list of all types of reservation
		if(EXECUTE_RESERVTYPE_ALL.equals(executeFlg)) {
			return this.getListOptionalEq(ReservationTypeMast.class, conditions);
		} 
		//Obtains the list of all types of service
		else if (EXECUTE_SERVICETYPE_ALL.equals(executeFlg)) {
			return this.getListOptionalEq(ServiceTypeMast.class, conditions);
		} 
		//Obtains the information of camp map using currently
		else if (EXECUTE_CAMPMAP_INFO.equals(executeFlg)) {
			return this.getListOptionalEq(CampMapInfo.class, conditions);
		} 
		//Obtains the information of all camp sites  
		else if (EXECUTE_SITE_INFO.equals(executeFlg)) {
			return this.getListOptionalEq(SiteInfo.class, conditions);
		} 
		//Obtains the information of the status if a camp site is available or not.
		else if (EXECUTE_SITE_UNAVAIL_INFO.equals(executeFlg)) {
			return this.getSiteUnavailInfo(ReservationInfo.class, conditions);
		}
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#update(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object update(String executeFlg, Object updateInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.dao.AbsYJACommonDAO#delete(java.lang.String, java.lang.Object)
	 */
	@Override
	public Object delete(String executeFlg, Object deleteInfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Performs to get the information of camp sites if it is available or not
	 * 
	 * @param Class type
	 * @param Conditions to search information on database
	 * @return List of the number of unavailable camp sites.
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<?> getSiteUnavailInfo(Class<?> classType, Object conditionsMap) throws Exception {		
		//Create HQL
		StringBuffer hqlBuffer = new StringBuffer("SELECT DISTINCT siteNo FROM ReservationInfo WHERE ");
		hqlBuffer.append("campMapID = :campMapID AND ")
				   .append("((arrivalDate <= :arrivalDate AND endDate > :arrivalDate) OR ")
				   .append("(arrivalDate < :endDate AND endDate >= :endDate) OR ")
				   .append("(arrivalDate >= :arrivalDate AND arrivalDate < :endDate))");
		Query query = getSession().createQuery(hqlBuffer.toString());
		
		HashMap<String, Object> searchingConditionMap = (HashMap<String, Object>)conditionsMap;		
		query.setParameter("campMapID", searchingConditionMap.get(HIBERNATE_MAP_ID));
		query.setParameter("arrivalDate", searchingConditionMap.get(HIBERNATE_ARRIVAL_DATE));
		query.setParameter("endDate", searchingConditionMap.get(HIBERNATE_END_DATE));
		
		return query.list();
	}
}
