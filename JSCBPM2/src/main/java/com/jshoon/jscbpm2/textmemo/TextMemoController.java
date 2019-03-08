package com.jshoon.jscbpm2.textmemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jshoon.jscbpm2.member.MemberDAO;
import com.jshoon.jscbpm2.reply.MemoReply;
import com.jshoon.jscbpm2.reply.MemoReplyDAO;

@Controller
public class TextMemoController {
	
	@Autowired
	private TextMemoDAO tmDAO;
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private MemoReplyDAO rDAO;
	
	@RequestMapping(value = "/textmemo.write", method = RequestMethod.GET)
	public String write(TextMemo tm, MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		tmDAO.write(tm, req, res);
		tmDAO.getAllTextMemoList(req, res);
		rDAO.getAllMemoReply(r, req, res);
		req.setAttribute("loginPage", "login/loginSuccess.jsp");
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/textmemo.delete", method = RequestMethod.GET)
	public String delete(TextMemo tm, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		tmDAO.delete(tm, req, res);
		tmDAO.getAllTextMemoList(req, res);
		req.setAttribute("loginPage", "login/loginSuccess.jsp");
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

}
