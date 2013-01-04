package com.yja.action.model;

import java.util.ArrayList;
import java.util.List;

import com.yja.vo.YJAReservedInfoVO;

/**
 * The Model class for the screen to search and delete the reservation information.
 * 
 * @author YOUNGJAE KIM
 * 
 */
public class YJAS005ActionModel extends YJASCommonActionModel {

	private static final long serialVersionUID = -4564506253414318317L;

	private String reservationId;
	private List<String> selectedReservationId = new ArrayList<String>();
	private List<YJAReservedInfoVO> reservedInfoList;

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
	 * @return the selectedReservationId
	 */
	public List<String> getSelectedReservationId() {
		return selectedReservationId;
	}

	/**
	 * @param selectedReservationId
	 *            the selectedReservationId to set
	 */
	public void setSelectedReservationId(int index, String selectedReservationId) {
		this.selectedReservationId.add(index, selectedReservationId);
	}

	/**
	 * @return the reservedInfoList
	 */
	public List<YJAReservedInfoVO> getReservedInfoList() {
		return reservedInfoList;
	}

	/**
	 * @param reservedInfoList
	 *            the reservedInfoList to set
	 */
	public void setReservedInfoList(List<YJAReservedInfoVO> reservedInfoList) {
		this.reservedInfoList = reservedInfoList;
	}

}
