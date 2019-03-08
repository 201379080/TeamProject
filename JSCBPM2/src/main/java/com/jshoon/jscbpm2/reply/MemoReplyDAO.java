package com.jshoon.jscbpm2.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jshoon.jscbpm2.member.Member;

@Service
public class MemoReplyDAO {
	
	@Autowired
	private SqlSession ss;
	
	// 댓글 보기
	public void getAllMemoReply(MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("rps", ss.getMapper(Jscbpm2MemoReplyMapper.class).getAllMemoReply());
	}
	
	// 댓글 등록
	public void replyWrite(MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			r.setMr_owner(m.getJm_id());
			if(ss.getMapper(Jscbpm2MemoReplyMapper.class).replyWrite(r) == 1) {
				req.setAttribute("r", "댓글 쓰기 성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "댓글 쓰기 실패");
			e.printStackTrace();
		}
	}
	
	// 댓글 삭제
	public void replyDelete(MemoReply r, HttpServletRequest req, HttpServletResponse res) {
		try {
			if(ss.getMapper(Jscbpm2MemoReplyMapper.class).replyDelete(r) == 1) {
				req.setAttribute("r", "댓글 삭제 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글 삭제 실패");
		}
	}
	

}
