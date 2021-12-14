package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.member.MemberDTO;
import com.itbank.service.MemberService;

@Controller
public class MemberController {

	@Autowired private MemberService ms;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public ModelAndView login(MemberDTO dto, HttpSession session, String url) {
		ModelAndView mav = new ModelAndView();
		
		MemberDTO login = ms.selectMember(dto); 
		session.setAttribute("login", login);
		
		if(url == null) {
			mav.setViewName("redirect:/");
		}
		else {
			mav.setViewName("redirect:" + url);
		
		}
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:/");
		return mav;
	}
}
