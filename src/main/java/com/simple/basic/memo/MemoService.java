package com.simple.basic.memo;

import java.util.ArrayList;

import com.simple.basic.command.MemoVO;

public interface MemoService {
	
	public String getTime(); //예제코드
	public void memoInsert(MemoVO vo); //등록
	public ArrayList<MemoVO> getList(); //목록
}
