package com.yja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

import com.yja.action.model.YJAS002ActionModel;
import com.yja.action.model.YJASCommonActionModel;
import com.yja.dao.AbsYJACommonDAO;
import com.yja.dao.model.GalleryPoto;

/**
 * This class provides the business logic for the gallery screen.
 * 
 * @author YOUNGJAE KIM
 *
 */
public class YJAS002Service extends AbsYJACommonService {

	private YJAS002ActionModel actionModel;
	
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setYjaDao(com.yja.dao.AbsYJACommonDAO)
	 */
	@Override
	@Qualifier("YJAS002DAO")
	public void setYjaDao(AbsYJACommonDAO yjaDao) throws Exception {
		this.yjaDao = yjaDao;		
	}
	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#setInitialInfo(com.yja.action.model.YJASCommonActionModel, java.util.Map)
	 */
	@Override
	public void setInitialInfo(YJASCommonActionModel actionModel) throws Exception {
		// TODO Auto-generated method stub
		this.actionModel = (YJAS002ActionModel)actionModel;
	}

	/*
	 * (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#view(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void view(String executeFlg) throws Exception {
		
		//Obtains the list of gallery photos
		List<GalleryPoto> galleryPhotoList = (List<GalleryPoto>)yjaDao.getList(EXECUTE_GALLERY_PHOTO, null);
		ArrayList<String> photoNmList = new ArrayList<String>();		
		for(int i = 0; i < galleryPhotoList.size(); i++) {
			GalleryPoto galleryPoto = galleryPhotoList.get(i);
			photoNmList.add(this.galleryPhotoPath + galleryPoto.getGalleryPhotoName());
		}		
		this.actionModel.setImageFullPathList(photoNmList);		
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#check()
	 */
	@Override
	public Object check(String executeFlg) throws Exception {		
		//Does not use.
		return null;
	}

	/* (non-Javadoc)
	 * @see com.yja.service.AbsYJACommonService#modify(java.lang.String)
	 */
	@Override
	public void modify(String executeFlg) throws Exception {
		//Does not use.	
	}

}
