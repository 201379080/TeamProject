package com.jshoon.jscbpm2.textmemo;

import java.util.List;

public interface Jscbpm2MemoMapper {
	// 리턴 타입:
	//		insert, update, delete => int
	//		select => resultType과 같게
	//		메소드명 : id
	//		파라메터 : parameterType
	public abstract List<TextMemo> getAllTextMemoList();
	public abstract int memoWrite(TextMemo tm);
	public abstract int memoDelete(TextMemo tm);
}
