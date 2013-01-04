package com.yja.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.yja.constant.YJACommonConst;
import com.yja.constant.YJAHibernateConst;

/**
 * <p>This class provides default implementations for the YJAFaimly DAO interface.</p>
 * <p>All the action class must extend this class.</p> 
 * 
 * @author YOUNGJAE KIM
 *
 */
public abstract class AbsYJACommonDAO extends HibernateDaoSupport implements
		YJACommonConst, YJAHibernateConst {

	/**
	 * <p>Performs to insert information into database.</p>
	 * <p>Using Insert statement</p>
	 * 
	 * @param Flag to distinguish among the different process.
	 * @param Information to insert into database
	 * @return Result Object
	 * @throws Exception
	 */
	public abstract Object insert(String executeFlg, Object insertInfo) throws Exception;
	

	/**
	 * <p>Performs to get the list of the corresponding information from database.</p>
	 * <p>Using Select statement</p>
	 * 
	 * @param Flag to distinguish among the different process.
	 * @param Conditions to search information on database
	 * @return List of result.
	 * @throws Exception
	 */
	public abstract List<?> getList(String executeFlg, Object conditions) throws Exception;
	
	/**
	 * <p>Performs to insert information into database.</p>
	 * <p>Using Update statement</p>
	 * 
	 * @param Flag to distinguish among the different process.
	 * @param Information to update into database
	 * @return Result Object
	 * @throws Exception
	 */
	public abstract Object update(String executeFlg, Object updateInfo) throws Exception;
	
	/**
	 * <p>Performs to delete information on database.</p>
	 * <p>Using Delete statement</p>
	 *  
	 * @param Flag to distinguish among the different process.
	 * @param Information to update into database
	 * @return Result Object
	 * @throws Exception
	 */
	public abstract Object delete(String executeFlg, Object deleteInfo) throws Exception;

	/**
	 * Performs to get the list of the necessary information by Hibernate Criteria with in restriction.
	 * 
	 * @param Class type
	 * @param Conditions to search
	 * @return List of result
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected List<?> getListOptionalIn(Class<?> classType, Object conditionsMap) throws Exception {			
		
		HashMap<String, ArrayList<?>> searchingConditionMap = null;
		Iterator keyIterator = null;
		String keyStr = "";
		
		if(conditionsMap != null) {
			searchingConditionMap = (HashMap<String, ArrayList<?>>)conditionsMap;
			keyIterator = searchingConditionMap.keySet().iterator();
		}		
		
		Criteria crit = getSession().createCriteria(classType);
		
		if(conditionsMap != null) {			
			while(keyIterator.hasNext()) {
				keyStr =  (String)keyIterator.next();
				
				if(searchingConditionMap.get(keyStr) != null) {		
					crit.add(Restrictions.in(keyStr, searchingConditionMap.get(keyStr)));
				}
			}			
		}
		
		return crit.list();	
	}
	
	/**
	 * Performs to get the list of the necessary information by Hibernate Criteria with eq restriction.
	 * 
	 * @param Class type
	 * @param Conditions to search
	 * @return List of result
	 * @throws Exception
	 */
	protected List<?> getListOptionalEq(Class<?> classType, Object conditionsMap) throws Exception {		
		return this.getCriteriaOptionalEq(classType, conditionsMap).list();
	}
	
	/**
	 * Performs to get the list of the necessary information sorted by Hibernate Criteria with eq restriction.
	 * 
	 * @param Class type
	 * @param Conditions to search
	 * @param the list of the name to sort: String[0]: the name of column, String[1]: ASC, or DESC
	 * @return List of result
	 * @throws Exception
	 */
	protected List<?> getListOptionalEqWithOrder(Class<?> classType, Object conditionsMap, ArrayList<String[]> orderList) throws Exception {		
		
		Criteria crit = this.getCriteriaOptionalEq(classType, conditionsMap);
		
		if(orderList != null) {			
			for(int i = 0; i < orderList.size(); i++) {				
				String[] orderArr = orderList.get(i);
				
				//Order by ASC
				if(HIBERNATE_ORDER_ASC.equals(orderArr[1])) {
					crit.addOrder(Order.asc(orderArr[0]));
				} 
				//Order by DESC
				else {
					crit.addOrder(Order.desc(orderArr[0]));
				}				
			}			
		}		
		return crit.list();
	}

	/**
	 * Performs to get the Hibernate Criteria with eq restriction.
	 * 
	 * @param Class type
	 * @param Conditions to search
	 * @return List of result
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Criteria getCriteriaOptionalEq(Class<?> classType, Object conditionsMap) throws Exception {
		
		HashMap<String, Object> searchingConditionMap = null;
		Iterator keyIterator = null;
		String keyStr = "";
		
		if(conditionsMap != null) {
			searchingConditionMap = (HashMap<String, Object>)conditionsMap;
			keyIterator = searchingConditionMap.keySet().iterator();
		}		
		
		Criteria crit = getSession().createCriteria(classType);
		
		if(conditionsMap != null) {			
			while(keyIterator.hasNext()) {	
				keyStr =  (String)keyIterator.next();
				
				//Only the value of key exists.
				if(searchingConditionMap.get(keyStr) != null) {				
					crit.add(Restrictions.eq(keyStr, searchingConditionMap.get(keyStr)));
				}
			}			
		}		
		return crit;
	}
	
	
}
