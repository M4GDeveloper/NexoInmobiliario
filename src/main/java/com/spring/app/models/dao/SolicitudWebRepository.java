package com.spring.app.models.dao;

import java.util.Map;

import com.spring.app.models.entity.SolicitudWeb;
import com.zoho.crm.library.exception.ZCRMException;

public interface SolicitudWebRepository {

	
	public Map<String,Object> createNewSolicitudWeb(SolicitudWeb solicitudWeb) throws ZCRMException ;
	
}
