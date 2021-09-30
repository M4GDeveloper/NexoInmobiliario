package com.spring.app.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.configuration.ConfigurationWebService;
import com.spring.app.models.entity.SolicitudWeb;
import com.spring.app.models.service.SolicitudWebService;
import com.zoho.crm.library.exception.ZCRMException;

@RestController
@RequestMapping("/api-solicitudWeb")
public class SolicitudWebController {

	private Logger log = LoggerFactory.getLogger(SolicitudWebController.class);

	@Autowired
	private SolicitudWebService solicitudWebService;
	
	@Autowired
	private ConfigurationWebService configurationWebService;

	
	@PostConstruct
	public void asignarTokens() {
		configurationWebService.configurationZoho();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createSolicitudWeb(@RequestBody SolicitudWeb solicitudWeb) {
		log.info(solicitudWeb.toString());
		
//		
		configurationWebService.configurationZoho();
//		
		Map<String, Object> response = new HashMap<>();
		try {
			response = solicitudWebService.createNewSolicitudWeb(solicitudWeb);

		} catch (ZCRMException | IOException e) {
			response.put("error", true);
			response.put("message", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
