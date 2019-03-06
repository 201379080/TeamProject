package com.soldesk.festival;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soldesk.festival.search.Search;
import com.soldesk.festival.search.SearchDAO;
import com.soldesk.festival.search.Searchs;

@Controller
public class HomeController {
	
	@Autowired
	private SearchDAO sDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String goHome(HttpServletRequest req) {
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/search.go", method = RequestMethod.GET)
	public String goSearch(Search s, HttpServletRequest req) {
		req.setAttribute("contentPage", "search.jsp");
//		sDAO.getSelect(s, req);
		return "index";
	}
	@RequestMapping(value = "/search.get", method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Searchs goSearch2(Search s, HttpServletRequest req) {
		return sDAO.getSelect2(s, req);
	}
}
