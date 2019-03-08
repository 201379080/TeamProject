package com.jshoon.jscbpm2.member;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {
	private String jm_id;
	private String jm_pw;
	private String jm_name;
	private String jm_address;
	private String jm_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String jm_id, String jm_pw, String jm_name, String jm_address, String jm_photo) {
		super();
		this.jm_id = jm_id;
		this.jm_pw = jm_pw;
		this.jm_name = jm_name;
		this.jm_address = jm_address;
		this.jm_photo = jm_photo;
	}

	public String getJm_id() {
		return jm_id;
	}
	
	@XmlElement
	public void setJm_id(String jm_id) {
		this.jm_id = jm_id;
	}

	public String getJm_pw() {
		return jm_pw;
	}

	@XmlElement
	public void setJm_pw(String jm_pw) {
		this.jm_pw = jm_pw;
	}

	public String getJm_name() {
		return jm_name;
	}

	@XmlElement
	public void setJm_name(String jm_name) {
		this.jm_name = jm_name;
	}

	public String getJm_address() {
		return jm_address;
	}

	@XmlElement
	public void setJm_address(String jm_address) {
		this.jm_address = jm_address;
	}

	public String getJm_photo() {
		return jm_photo;
	}

	@XmlElement
	public void setJm_photo(String jm_photo) {
		this.jm_photo = jm_photo;
	}
	
}
