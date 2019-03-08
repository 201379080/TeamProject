package com.jshoon.jscbpm2.reply;

import java.math.BigDecimal;
import java.util.Date;

public class MemoReply {
	private BigDecimal mr_no;
	private BigDecimal mr_tm_no;
	private String mr_owner;
	private String mr_txt;
	private Date mr_date;
	
	public MemoReply() {
		// TODO Auto-generated constructor stub
	}

	public MemoReply(BigDecimal mr_no, BigDecimal mr_tm_no, String mr_owner, String mr_txt, Date mr_date) {
		super();
		this.mr_no = mr_no;
		this.mr_tm_no = mr_tm_no;
		this.mr_owner = mr_owner;
		this.mr_txt = mr_txt;
		this.mr_date = mr_date;
	}

	public BigDecimal getMr_no() {
		return mr_no;
	}

	public void setMr_no(BigDecimal mr_no) {
		this.mr_no = mr_no;
	}

	public BigDecimal getMr_tm_no() {
		return mr_tm_no;
	}

	public void setMr_tm_no(BigDecimal mr_tm_no) {
		this.mr_tm_no = mr_tm_no;
	}

	public String getMr_owner() {
		return mr_owner;
	}

	public void setMr_owner(String mr_owner) {
		this.mr_owner = mr_owner;
	}

	public String getMr_txt() {
		return mr_txt;
	}

	public void setMr_txt(String mr_txt) {
		this.mr_txt = mr_txt;
	}

	public Date getMr_date() {
		return mr_date;
	}

	public void setMr_date(Date mr_date) {
		this.mr_date = mr_date;
	}

}
