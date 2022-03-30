package com.simple.basic.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.MemoVO;
import com.simple.basic.memo.MemoService;

@Controller
@RequestMapping("/memo")
public class MemoController {
	
	@Autowired
	@Qualifier("memoService")
	private MemoService memoService;
	
	//예제코드 (컨트롤러-서비스-매퍼 연결)
	@GetMapping("/ex")
	public void ex(Model model) {
		
		String time = memoService.getTime();
		
		model.addAttribute("time", time);
		
	}
	
	
	//화면처리 memoWrite
	@GetMapping("/memoWrite")
	public void memoWrite() {
		
	}
	
	//화면처리 memoList
	@GetMapping("/memoList")
	public String memoList(MemoVO vo, Model model) {
		
		//select
		ArrayList<MemoVO> list = memoService.getList();
		model.addAttribute("list", list);
		
		return "memo/memoList";
	}
	
	//요청폼(등록)
	
	@PostMapping("/memoForm") 
	public String memoForm(@Valid MemoVO vo, Errors errors, Model model) {
		
		//유효성검사
		if(errors.hasErrors()) { //유효성 검사 실패시 true
			
			List<FieldError> list = errors.getFieldErrors(); //유효성 검사
			
			for(FieldError err : list) {		
				model.addAttribute("valid_" + err.getField(), err.getDefaultMessage());
			}
			
			model.addAttribute("vo", vo); //화면에 처리할 데이터
			return "memo/memoWrite";
		}
		
		//등록
		memoService.memoInsert(vo);
		
		return "redirect:/memo/memoList"; //리스트화면으로 
	}
	
}
