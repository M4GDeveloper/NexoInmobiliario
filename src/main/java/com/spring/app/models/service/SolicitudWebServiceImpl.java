package com.spring.app.models.service;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.models.dao.ProjectRepository;
import com.spring.app.models.dao.SolicitudWebRepository;
import com.spring.app.models.entity.SolicitudWeb;
import com.zoho.crm.library.exception.ZCRMException;

@Service
public class SolicitudWebServiceImpl implements SolicitudWebService{

	private Logger log = LoggerFactory.getLogger(SolicitudWebServiceImpl.class);
	
	@Autowired
	private SolicitudWebRepository solicitudWebRepository;
	
	@Autowired
	private ProjectRepository projectRepository; 
	
	@Override
	public Map<String, Object> createNewSolicitudWeb(SolicitudWeb solicitudWeb) throws ZCRMException, IOException {
		log.info("Ingresó a SolicitudesWebImpl");
//		
		String projectName =  projectRepository.findNameProyectById(solicitudWeb.getProject_id());
		solicitudWeb.setProject_name(projectName);
		log.info("projectName: "+ projectName);
		return solicitudWebRepository.createNewSolicitudWeb(solicitudWeb);
//		return null; 
	}

}
