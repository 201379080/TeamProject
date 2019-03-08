package com.jshoon.jscbpm2.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {
	
	@Autowired
	private SqlSession ss;
	
	public Members idCheck(Member m) {
		Member dbM = ss.getMapper(Jscbpm2MemberMapper.class).getMemberById(m);
		ArrayList<Member> al = new ArrayList<Member>();
		al.add(dbM);
		Members ms = new Members(al);
		return ms;
	}
	
	// 회원 등록
	public void register(Member m, HttpServletRequest req, HttpServletResponse res) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "가입 실패");
			return;
		}
		
		try {
			m.setJm_id(mr.getParameter("jm_id"));
			m.setJm_pw(mr.getParameter("jm_pw"));
			m.setJm_name(mr.getParameter("jm_name"));
			String jm_address = String.format("%s=%s=%s", mr.getParameter("jm_addressNumber"), mr.getParameter("jm_address"), mr.getParameter("jm_subAddress"));
			m.setJm_address(jm_address);
			String jm_photo = mr.getFilesystemName("jm_photo");
			jm_photo = URLEncoder.encode(jm_photo, "utf-8");
			jm_photo = jm_photo.replace("+", " ");
			m.setJm_photo(jm_photo);
			
			if(ss.getMapper(Jscbpm2MemberMapper.class).register(m) == 1) {
				req.setAttribute("r", "등록 성공");
			}
			
		} catch (UnsupportedEncodingException e) {
			req.setAttribute("r", "등록 실패");
			File f = new File(path + "/" + mr.getFilesystemName("jm_photo"));
			f.delete();
		}
		
	}

	// 로그인
	public void login(Member m, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member dbM = ss.getMapper(Jscbpm2MemberMapper.class).getMemberById(m);
			if(dbM != null) {
				if(m.getJm_pw().equals(dbM.getJm_pw())) {
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(15 * 60);
					
					// 자동 로그인
					String jm_auto = req.getParameter("jm_auto");
					if(jm_auto != null) {
						Cookie autoLoginID = new Cookie("autoLoginID", dbM.getJm_id());
						autoLoginID.setMaxAge(1 * 60 * 60 * 24);
						res.addCookie(autoLoginID);
					}
				} else {
					req.setAttribute("r", "비번오류");
				}
			} else {
				req.setAttribute("r", "미가입ID");
			}
		} catch (Exception e) {
			req.setAttribute("r", "DB서버오류");
		}
	}
	
	// 로그아웃
	public void logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().setAttribute("loginMember", null);
		
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("autoLoginID")) {
					c.setValue(null);
					res.addCookie(c);
				}
			}
		}
	}
	
	//자동 로그인
	public void autologin(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				if(c.getName().equals("autoLoginID")) {
					String jm_id = c.getValue();
					if(jm_id != null && jm_id != "") {
						try {
							Member m = new Member(jm_id, null, null, null, null);
							Member dbM = ss.getMapper(Jscbpm2MemberMapper.class).getMemberById(m);
							if(dbM != null) {
								req.getSession().setAttribute("loginMember", dbM);
								req.getSession().setMaxInactiveInterval(15 * 60);
							} else {
								req.setAttribute("r", "미가입ID");
							}
						} catch (Exception e) {
							req.setAttribute("r", "DB서버오류");
						}
						
					}
				}
			}
		}
	}
	
	// 로그인 체크
	public boolean loginCheck(HttpServletRequest req) {
		autologin(req);
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if(m != null) {
			req.setAttribute("loginPage", "login/loginSuccess.jsp");
			return true;
		}
		req.setAttribute("loginPage", "login/login.jsp");
		return false;
	}
	
	public void divideAddress(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String[] addr = m.getJm_address().split("=");
		req.setAttribute("jm_addressNumber", addr[0]);
		req.setAttribute("jm_address", addr[1]);
		req.setAttribute("jm_subAddress", addr[2]);
	}
	
	//회원정보 수정
	public void updateByMemberInfo(Member m, HttpServletRequest req) {
		MultipartRequest mr = null;
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.println(path);
		try {
			mr = new MultipartRequest(req, path, 50 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "수정 실패");
			return;
		}
		
		try {
			m.setJm_id(mr.getParameter("jm_id"));
			m.setJm_pw(mr.getParameter("jm_pw"));
			m.setJm_name(mr.getParameter("jm_name"));
			String jm_address = String.format("%s %s %s", mr.getParameter("jm_addressNumber"), mr.getParameter("jm_address"), mr.getParameter("jm_subAddress"));
			m.setJm_address(jm_address);
			String jm_photo = mr.getFilesystemName("jm_photo");
			if(jm_photo != null) {
				jm_photo = URLEncoder.encode(jm_photo, "utf-8");
				jm_photo = jm_photo.replace("+", " ");
			} else {
				Member loginMember = (Member) req.getSession().getAttribute("loginMember");
				jm_photo = loginMember.getJm_photo();
			}
			m.setJm_photo(jm_photo);
			
			if(ss.getMapper(Jscbpm2MemberMapper.class).updateByMemberInfo(m) == 1) {
				req.setAttribute("r", "수정 성공");
				
				req.getSession().setAttribute("loginMember", m);
				req.getSession().setMaxInactiveInterval(15 * 60);
			}
		} catch (Exception e) {
			req.setAttribute("r", "수정 실패");
			File f = new File(path + "/" + mr.getFilesystemName("jm_photo"));
			f.delete();
		}
	}
	
	// 회원 탈퇴
	public void deleteByMemberId(HttpServletRequest req, HttpServletResponse res) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			String jm_id = m.getJm_id();
			
			if(ss.getMapper(Jscbpm2MemberMapper.class).deleteByMemberId(m) == 1) {
				req.setAttribute("r", "삭제 성공");
				logout(req, res);
			}
		} catch (Exception e) {
			req.setAttribute("r", "삭제 실패");
		}
	}

}
