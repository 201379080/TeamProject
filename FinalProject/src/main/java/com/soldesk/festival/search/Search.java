package com.soldesk.festival.search;

public class Search {
	private String ge_title;
	private String ge_start_date;
	private String ge_end_date;
	private String ge_addr;
	private String ge_image;
	
	public Search() {
		// TODO Auto-generated constructor stub
	}

	public Search(String ge_title, String ge_start_date, String ge_end_date, String ge_addr, String ge_image) {
		super();
		this.ge_title = ge_title;
		this.ge_start_date = ge_start_date;
		this.ge_end_date = ge_end_date;
		this.ge_addr = ge_addr;
		this.ge_image = ge_image;
	}

	public String getGe_title() {
		return ge_title;
	}

	public void setGe_title(String ge_title) {
		this.ge_title = ge_title;
	}

	public String getGe_start_date() {
		return ge_start_date;
	}

	public void setGe_start_date(String ge_start_date) {
		this.ge_start_date = ge_start_date;
	}

	public String getGe_end_date() {
		return ge_end_date;
	}

	public void setGe_end_date(String ge_end_date) {
		this.ge_end_date = ge_end_date;
	}

	public String getGe_addr() {
		return ge_addr;
	}

	public void setGe_addr(String ge_addr) {
		this.ge_addr = ge_addr;
	}

	public String getGe_image() {
		return ge_image;
	}

	public void setGe_image(String ge_image) {
		this.ge_image = ge_image;
	}

}
