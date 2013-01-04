package com.yja.constant;

/**
 * <p>Interface class</p>
 * <p>This class provides the common constant variables to be used by YJAFamily.</p>
 *  
 * @author YOUNGJAE KIM
 * 
 */
public interface YJACommonConst {

	/* ******************************
	 * Forward String Constants.
	 * ******************************/
	public static final String FORWARD_SUCCESS = "success";
	public static final String FORWARD_FAIL = "fail";
	public static final String FORWARD_EXCEPTION = "exception";
	public static final String FORWARD_INPUT = "input";
	public static final String FORWARD_ERROR = "error";
	
	/* ******************************
	 * Seesion ID Constants.
	 * ******************************/
	public static final String SESSION_USERINFO = "userInfo";
	public static final String SESSION_RESERVEDINFO = "reservedInfo";
	public static final String SESSION_CAMPSITEINFO = "campSiteInfo";
	public static final String SESSION_EQUIPMENT_LIST = "equipmentList";
	public static final String SESSION_SERVICETYPE_LIST = "serviceTypeList";
	public static final String SESSION_RESERVATIONTYPE_LIST = "reservationTypeList";
	public static final String SESSION_SEARCH_CONDITION = "searchConditions";
	public static final String SESSION_YJAS004_INPUT = "yjas004InputInfo";
	public static final String SESSION_YJAS005_INPUT = "yjas005InputInfo";
	public static final String SESSION_YJAS006_INPUT = "yjas006InputInfo";	
	public static final String SESSION_CAMP_MAP_BYTE = "campMapByte";
	public static final String SESSION_SITE_PHOTO_BYTE = "sitePhotoByte";	
	
	/* ******************************
	 * Screen ID Constants.
	 * ******************************/
	public static final String SCREEN_ID_YJAS004 = "YJAS004";	
	
	/* ******************************
	 * Execute Flag Constants
	 * ******************************/
	public static final String EXECUTE_FLG_INIT = "init";
	public static final String EXECUTE_FLG_BACK_INIT = "backInit";
	public static final String EXECUTE_FLG_SEARCH ="search";
	public static final String EXECUTE_FLG_DELETE = "delete";
	public static final String EXECUTE_FLG_DELETE_ALL = "deleteall";
	public static final String EXECUTE_FLG_UPDATE = "update";
	public static final String EXECUTE_FLG_INSERT = "insert";
	public static final String EXECUTE_FLG_SELECT = "select";
	public static final String EXECUTE_FLG_CANCEL = "cancel";
	public static final String EXECUTE_FLG_EMAIL = "email";
	public static final String EXECUTE_FLG_LOGOUT = "logout";
	public static final String EXECUTE_FLG_LOGIN = "login";
	public static final String EXECUTE_FLG_USERID_CHECK = "userIdCheck";
	public static final String EXECUTE_FLG_INPUT_CHECK = "inputCheck";
	public static final String EXECUTE_FLG_DELETE_CHECK = "deleteCheck";	
	public static final String EXECUTE_USER_INSERT = "userInsert";
	public static final String EXECUTE_RESERVTYPE_ALL = "reservationTypeAll";
	public static final String EXECUTE_SERVICETYPE_ALL = "serviceTypeAll";
	public static final String EXECUTE_CAMPMAP_INFO = "campMapInfo";
	public static final String EXECUTE_SITE_INFO = "siteInfo";
	public static final String EXECUTE_RESERVATION_INFO = "reservationInfo";
	public static final String EXECUTE_CREATE_RESERVATION_ID = "createReservationId";
	public static final String EXECUTE_RESERVATION_INSERT = "reservationInfoInsert";
	public static final String EXECUTE_RESERVATION_DELETE = "reservationInfoDelete";
	public static final String EXECUTE_GALLERY_PHOTO = "galleryPhoto";
	public static final String EXECUTE_SITE_UNAVAIL_INFO = "siteUnavailInfo";

	/* ******************************************
	 * The type of screen mode Constants.
	 * (For pop-up dialog)
	 * *****************************************/
	public static final String MODE_SELECT ="select";
	public static final String MODE_RESERVED ="reserved";
	public static final String MODE_INSERT ="insert";	
	
	/* ***********************************
	 * Action Error or Message ID
	 * *********************************/
	public static final String ERROR_USER_NO_EXIST = "error.userNoExist";
	public static final String MESSAGE_USER_AVAILABLE = "message.userAvailable";
	public static final String MESSAGE_USER_NO_AVAILABLE = "message.userNoAvailable";
	public static final String ERROR_SEARCH_REQUIRED = "error.search.required";
	public static final String ERROR_DELETE_REQUIRED = "error.delete.required";

	/* ******************************
	 * Image file path ID
	 * ******************************/
	public static final String PATH_CAMP_MAP = "path.campmap";
	public static final String PATH_SITE_PHOTO = "path.sitePhoto";
	
	/* ******************************
	 * Image type
	 * ******************************/
	public static final String IMAGE_CAMP_MAP ="1";
	public static final String IMAGE_SITE_PHOTO ="2";
	public static final String IMAGE_SMALL ="small";
	public static final String IMAGE_BIG ="big";
	
	public static final double HST = 0.13; 
	public static final String ZERO_HHMMSS = " 00:00:00";
	public static final String LAST_HHMMSS = " 23:59:59";
}
