package com.simple.basic.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.simple.basic.memo.MemoMapper;

@SpringBootTest
public class TestCode02 {
	
	@Autowired
	private MemoMapper memoMapper;
	
	@Test
	public void test01() {
		
		String time = memoMapper.getTime();
		System.out.println(time);
		
	}
	
}
