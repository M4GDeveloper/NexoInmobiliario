package com.spring.app.models.entity;

public class SolicitudWeb {

	private String project_id;
	private String timestamp_action;
	private String type;
	private String tipologia;
	private String unit;
	private String firstname;
	private String lastname;
	private String email;
	private String message;
	private String phone;
	private String document_type;
	private String document_number;
	
//	
	private String project_name;

	public SolicitudWeb() {
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getTimestamp_action() {
		return timestamp_action;
	}

	public void setTimestamp_action(String timestamp_action) {
		this.timestamp_action = timestamp_action;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocument_number() {
		return document_number;
	}

	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	@Override
	public String toString() {
		return "SolicitudWeb [project_id=" + project_id + ", timestamp_action=" + timestamp_action + ", type=" + type
				+ ", tipologia=" + tipologia + ", unit=" + unit + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", message=" + message + ", phone=" + phone + ", document_type=" + document_type
				+ ", document_number=" + document_number + ", project_name=" + project_name + "]";
	}

	

	
}
