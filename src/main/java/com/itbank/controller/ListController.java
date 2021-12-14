package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.file.FileDTO;
import com.itbank.service.FileService;

@Controller
public class ListController {

	@Autowired private FileService fs;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		List<FileDTO> list = fs.selectList();
		
		mav.setViewName("list");
		mav.addObject("list", list);
		return mav;
	}
}
