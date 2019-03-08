package com.jshoon.jscbpm2.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jshoon.jscbpm2.reply.MemoReply;
import com.jshoon.jscbpm2.reply.MemoReplyDAO;
import com.jshoon.jscbpm2.textmemo.TextMemoDAO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TextMemoDAO tmDAO;
	@Autowired
	private MemoReplyDAO rDAO;
	
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET,
					produces = "application/xml; charset=utf-8")
	public @ResponseBody Members idCheck(Member m) {
		return mDAO.idCheck(m);
	}
	
	@RequestMapping(value = "/member.register", method = RequestMethod.GET)
	public String register(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		req.setAttribute("loginPage", "login/login.jsp");
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.joinSuccess", method = RequestMethod.POST)
	public String joinSuccess(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.register(m, req, res);
		mDAO.loginCheck(req);
		req.setAttribute("loginPage", "login/login.jsp");
		req.setAttribute("contentPage", "member/join.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.loginSuccess", method = RequestMethod.POST)
	public String loginSuccess(Member m, MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		tmDAO.getAllTextMemoList(req, res);
		rDAO.getAllMemoReply(r, req, res);
		if(mDAO.loginCheck(req)) {
			req.setAttribute("loginPage", "login/loginSuccess.jsp");
			req.setAttribute("contentPage", "home.jsp");
		} else {
			req.setAttribute("loginPage", "login/login.jsp");
			req.setAttribute("contentPage", "member/first.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/member.logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		mDAO.logout(req, res);
		req.setAttribute("loginPage", "login/login.jsp");
		req.setAttribute("contentPage", "member/first.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.Info", method = RequestMethod.GET)
	public String memberInfo(HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		req.setAttribute("loginPage", "login/loginSuccess.jsp");
		req.setAttribute("contentPage", "member/memberInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String update(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		mDAO.updateByMemberInfo(m, req);
		req.setAttribute("loginPage", "login/loginSuccess.jsp");
		req.setAttribute("contentPage", "member/memberInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/member.delete", method = RequestMethod.GET)
	public String delete(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.loginCheck(req);
		mDAO.deleteByMemberId(req, res);
		req.setAttribute("loginPage", "login/login.jsp");
		req.setAttribute("contentPage", "member/first.jsp");
		return "index";
	}
	

}
