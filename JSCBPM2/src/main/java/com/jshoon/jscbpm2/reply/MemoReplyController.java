package com.jshoon.jscbpm2.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jshoon.jscbpm2.member.MemberDAO;
import com.jshoon.jscbpm2.textmemo.TextMemoDAO;

@Controller
public class MemoReplyController {
	
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TextMemoDAO tmDAO;
	@Autowired
	private MemoReplyDAO rDAO;
	
	@RequestMapping(value = "/reply.write", method = RequestMethod.GET)
	public String write(MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		rDAO.replyWrite(r, req, res);
		rDAO.getAllMemoReply(r, req, res);
		tmDAO.getAllTextMemoList(req, res);
		System.out.println(req.getAttribute("rps"));
		req.setAttribute("loginPage", "login/loginSuccess.jsp");
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/reply.delete", method = RequestMethod.GET)
	public String delete(MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		tmDAO.getAllTextMemoList(req, res);
		rDAO.replyDelete(r, req, res);
		rDAO.getAllMemoReply(r, req, res);
		req.setAttribute("loginPage", "login/loginSuccess.jsp");
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

}
