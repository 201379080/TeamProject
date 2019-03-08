package com.jshoon.jscbpm2.member;

public interface Jscbpm2MemberMapper {
	public abstract int register(Member m);
	public abstract Member getMemberById(Member m);
	public abstract int updateByMemberInfo(Member m);
	public abstract int deleteByMemberId(Member m);
}
