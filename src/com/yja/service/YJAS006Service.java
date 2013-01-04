package com.yja.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import com.yja.action.model.YJAS006ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.vo.YJASInputSessionVO;

/**
 * This class provides the business logic for the screen to send email to administrator.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS006Service extends AbsYJACommonService {
	private YJAS006ActionModel actionModel;
	private JavaMailSenderImpl mail;
	private SimpleMailMessage msg;	

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS006DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	
	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel, java.util.Map)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {
		this.actionModel = (YJAS006ActionModel)actionModel;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@Override
	public void view(String executeFlg) throws Exception {
		YJASInputSessionVO inputSessionVO = (YJASInputSessionVO) getSession().get(SESSION_YJAS006_INPUT);
		this.actionModel.setUserFullName(inputSessionVO.getUserFullName());
		this.actionModel.setUserId(inputSessionVO.getUserEmail());
		this.actionModel.setComments(inputSessionVO.getComments());

		//Delete unnecessary Session
		getSession().remove(SESSION_YJAS006_INPUT);		
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
	@Override
	public void modify(String executeFlg) throws Exception {
		//Sending email
		this.msg.setFrom(this.actionModel.getUserId());
        this.msg.setText(this.actionModel.getComments());
        this.mail.send(msg);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInfoBeforeLogin()
	 */
	@Override
	public void setInfoBeforeLogin() throws Exception {
		YJASInputSessionVO inputSessionVO = new YJASInputSessionVO();
		inputSessionVO.setUserFullName(this.actionModel.getUserFullName());
		inputSessionVO.setUserEmail(this.actionModel.getUserId());
		inputSessionVO.setComments(this.actionModel.getComments());
		getSession().put(SESSION_YJAS006_INPUT, inputSessionVO);		
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(JavaMailSenderImpl mail) throws Exception {
		this.mail = mail;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(SimpleMailMessage msg) throws Exception {
		this.msg = msg;
	}

}
