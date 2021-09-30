package com.spring.app.configuration;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.zoho.crm.library.setup.restclient.ZCRMRestClient;


@Component
public class ConfigurationWebService {

	private Logger log = LoggerFactory.getLogger(ConfigurationWebService.class);
	
	public void configurationZoho() {
		HashMap<String, String> zcrmConfigurations = new HashMap<String, String>();
		zcrmConfigurations.put("minLogLevel", "OFF");
		zcrmConfigurations.put("currentUserEmail", "sistemasei@ei.com.pe");//
		zcrmConfigurations.put("client_id", "1000.LLEDQ7GEY7VQQQMTWKR33DSML3VOQS");//
		zcrmConfigurations.put("client_secret", "5fa836547755dabfa07ffb70796a2a30971657d0ce");//
		zcrmConfigurations.put("redirect_uri", "https://www.google.com/response");
		zcrmConfigurations.put("persistence_handler_class", "com.zoho.oauth.clientapp.ZohoOAuthFilePersistence");
//		zcrmConfigurations.put("oauth_tokens_file_path","C:\\Users\\pc\\Documents\\m4g-projects\\spring-boot-ei-nexo-inmobiliario\\src\\main\\java\\path_to_tokens\\token-nexo.properties");//
		zcrmConfigurations.put("oauth_tokens_file_path", "/opt/edificaciones-inmobiliarias/token-nexo.properties");// optional
		zcrmConfigurations.put("domainSuffix", "com");// optional. Default is com. "cn" and "eu" supported
		zcrmConfigurations.put("accessType", "Production");// Production->www(default), Development->developer,// Sandbox->sandbox(optional)
//		zcrmConfigurations.put("accessType", "Sandbox");// Production->www(default), Development->developer,// Sandbox->sandbox(optional)
		 zcrmConfigurations.put("scope","ZohoCRM.modules.ALL,ZohoCRM.settings.ALL,Aaaserver.profile.read");
		try {
			ZCRMRestClient.initialize(zcrmConfigurations);
			
		} catch (Exception e) {
			log.info(e.getMessage().concat(" : ").concat(e.getCause().getMessage()));
		}
	}
}
