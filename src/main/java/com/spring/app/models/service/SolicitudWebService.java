package com.spring.app.models.service;

import java.io.IOException;
import java.util.Map;

import com.spring.app.models.entity.SolicitudWeb;
import com.zoho.crm.library.exception.ZCRMException;

public interface SolicitudWebService {

	public Map<String, Object> createNewSolicitudWeb(SolicitudWeb solicitudWeb) throws ZCRMException, IOException;
}
