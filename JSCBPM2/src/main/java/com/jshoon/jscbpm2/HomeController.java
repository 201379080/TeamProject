package com.jshoon.jscbpm2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jshoon.jscbpm2.member.MemberDAO;
import com.jshoon.jscbpm2.reply.MemoReply;
import com.jshoon.jscbpm2.reply.MemoReplyDAO;
import com.jshoon.jscbpm2.textmemo.TextMemo;
import com.jshoon.jscbpm2.textmemo.TextMemoDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TextMemoDAO tmDAO;
	@Autowired
	private MemoReplyDAO rDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(TextMemo tm, MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		tmDAO.getAllTextMemoList(req, res);
		if(mDAO.loginCheck(req)) {
			req.setAttribute("loginPage", "login/loginSuccess.jsp");
			req.setAttribute("contentPage", "home.jsp");
		} else {
			req.setAttribute("loginPage", "login/login.jsp");
			req.setAttribute("contentPage", "member/first.jsp");
		}
		rDAO.getAllMemoReply(r, req, res);
		return "index";
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String homeGo(TextMemo tm, MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		tmDAO.getAllTextMemoList(req, res);
		if(mDAO.loginCheck(req)) {
			req.setAttribute("loginPage", "login/loginSuccess.jsp");
			req.setAttribute("contentPage", "home.jsp");
		} else {
			req.setAttribute("loginPage", "login/login.jsp");
			req.setAttribute("contentPage", "member/first.jsp");
		}
		rDAO.getAllMemoReply(r, req, res);
		return "index";
	}
	
}
