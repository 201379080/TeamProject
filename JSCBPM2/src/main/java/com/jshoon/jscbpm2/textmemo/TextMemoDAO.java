package com.jshoon.jscbpm2.textmemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshoon.jscbpm2.member.Member;

@Service
public class TextMemoDAO {
	
	@Autowired
	private SqlSession ss;
	
	// 전체 메모 보기
	public void getAllTextMemoList(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("memo", ss.getMapper(Jscbpm2MemoMapper.class).getAllTextMemoList());
	}

	// 메모 등록
	public void write(TextMemo tm, HttpServletRequest req, HttpServletResponse res) {
		
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			tm.setTm_id(m.getJm_id());
			tm.setTm_name(m.getJm_name());
			String tm_content = tm.getTm_content();
			tm_content = tm_content.replace("\r\n", "<br>");
			tm.setTm_content(tm_content);
			
			if(ss.getMapper(Jscbpm2MemoMapper.class).memoWrite(tm) == 1) {
				req.setAttribute("r", "등록 성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "등록 실패");
		}
		
	}
	
	// 메모 삭제
	public void delete(TextMemo tm, HttpServletRequest req, HttpServletResponse res) {
		try {
			if(ss.getMapper(Jscbpm2MemoMapper.class).memoDelete(tm) == 1) {
				req.setAttribute("r", "삭제 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "삭제 실패");
		}
	}
}
