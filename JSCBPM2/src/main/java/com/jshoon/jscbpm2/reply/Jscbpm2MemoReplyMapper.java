package com.jshoon.jscbpm2.reply;

import java.util.List;

public interface Jscbpm2MemoReplyMapper {
	public abstract List<MemoReply> getAllMemoReply();
	public abstract int replyWrite(MemoReply r);
	public abstract int replyDelete(MemoReply r);
}
