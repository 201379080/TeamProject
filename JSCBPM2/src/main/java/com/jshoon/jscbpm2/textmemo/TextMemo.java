package com.jshoon.jscbpm2.textmemo;

import java.math.BigDecimal;
import java.util.Date;

public class TextMemo {
	private BigDecimal tm_no;
	private String tm_id;
	private String tm_name;
	private String tm_title;
	private String tm_content;
	private Date tm_date;
	
	public TextMemo() {
		// TODO Auto-generated constructor stub
	}

	public TextMemo(BigDecimal tm_no, String tm_id, String tm_name, String tm_title, String tm_content, Date tm_date) {
		super();
		this.tm_no = tm_no;
		this.tm_id = tm_id;
		this.tm_name = tm_name;
		this.tm_title = tm_title;
		this.tm_content = tm_content;
		this.tm_date = tm_date;
	}

	public BigDecimal getTm_no() {
		return tm_no;
	}

	public void setTm_no(BigDecimal tm_no) {
		this.tm_no = tm_no;
	}

	public String getTm_id() {
		return tm_id;
	}

	public void setTm_id(String tm_id) {
		this.tm_id = tm_id;
	}

	public String getTm_name() {
		return tm_name;
	}

	public void setTm_name(String tm_name) {
		this.tm_name = tm_name;
	}

	public String getTm_title() {
		return tm_title;
	}

	public void setTm_title(String tm_title) {
		this.tm_title = tm_title;
	}

	public String getTm_content() {
		return tm_content;
	}

	public void setTm_content(String tm_content) {
		this.tm_content = tm_content;
	}

	public Date getTm_date() {
		return tm_date;
	}

	public void setTm_date(Date tm_date) {
		this.tm_date = tm_date;
	}

}
