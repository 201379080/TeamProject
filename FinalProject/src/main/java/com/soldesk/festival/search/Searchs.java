package com.soldesk.festival.search;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Searchs {
	private List<Search> searchs;
	
	public Searchs() {
		// TODO Auto-generated constructor stub
	}

	public Searchs(List<Search> searchs) {
		super();
		this.searchs = searchs;
	}

	public List<Search> getSearchs() {
		return searchs;
	}

	@XmlElement
	public void setSearchs(List<Search> searchs) {
		this.searchs = searchs;
	}

}
