package com.spring.app.models.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.spring.app.models.entity.SolicitudWeb;
import com.zoho.crm.library.api.response.APIResponse;
import com.zoho.crm.library.common.CommonUtil;
import com.zoho.crm.library.crud.ZCRMRecord;
import com.zoho.crm.library.exception.ZCRMException;

@Repository
public class SolicitudWebRepositoryImpl implements  SolicitudWebRepository{

	private Logger log = LoggerFactory.getLogger(SolicitudWebRepositoryImpl.class);

	private Gson formatJSON = new Gson();
	
	@Override
	public Map<String, Object> createNewSolicitudWeb(SolicitudWeb solicitudWeb) throws ZCRMException {
		log.info("Ingresó a SolicitudesWebRepositoryImpl");
		Map<String, Object> registro = new HashMap<>();
		ZCRMRecord record = new ZCRMRecord("Solicitudes_Web");
//		ZCRMUser owner = ZCRMUser.getInstance((Long) data.get("id_propietario"));// user id
//		record.setOwner(owner);
		record.setFieldValue("Nombre_Proyecto", solicitudWeb.getProject_name() );
//		record.setFieldValue("Account_Name", solicitudWeb.getTimestamp_action() );
//		record.setFieldValue("Last_Name", solicitudWeb.getType() );
//		record.setFieldValue("Account_Name", solicitudWeb.getTipologia() );
//		record.setFieldValue("Last_Name", solicitudWeb.getUnit() );
		record.setFieldValue("Nombres", solicitudWeb.getFirstname() );
		record.setFieldValue("Apellidos", solicitudWeb.getLastname() );
		record.setFieldValue("Email", solicitudWeb.getEmail() );
		record.setFieldValue("Comentarios", solicitudWeb.getMessage() );
		record.setFieldValue("Tel_fono", solicitudWeb.getPhone() );
		record.setFieldValue("Tipo_de_documento", solicitudWeb.getDocument_type() );
		record.setFieldValue("N_mero_de_documento", solicitudWeb.getDocument_number() );
		record.setFieldValue("type", solicitudWeb.getType() );
//		
		List<CommonUtil.Trigger> triggers = Arrays.asList(CommonUtil.Trigger.workflow, CommonUtil.Trigger.approval,CommonUtil.Trigger.blueprint);
		APIResponse response = record.create(triggers);
		String dataJson = response.getResponseJSON().toString();
		registro = formatJSON.fromJson(dataJson, registro.getClass());
		return registro;
	}

}
