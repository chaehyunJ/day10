package com.itbank.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.file.FileDTO;
import com.itbank.service.FileService;

@Controller
public class HomeController{
	
	@Autowired private FileService fs;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String home(MultipartFile file) throws IllegalStateException, IOException {
		
		boolean f = fs.upload(file);
		System.out.println(f == true ? "성공" : "실패");
		return "redirect:/";
	}
	
	@GetMapping("/upload2")
	public void upload2() {}
	
	@PostMapping("/upload2")
	public ModelAndView upload2(FileDTO dto) throws IllegalStateException, IOException {
		ModelAndView mav = new ModelAndView("upload2");
		
		int row = fs.upload2(dto);
		if(row == 1) {
			mav.setViewName("redirect:/list");
			System.out.println("성공");
		}
		else {
			mav.setViewName("alert");
			mav.addObject("msg", "추가 실패");
			mav.addObject("url", "upload2");
			System.out.println("실패");
		}
		
		return mav;
	}

}