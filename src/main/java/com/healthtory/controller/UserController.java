package com.healthtory.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.healthtory.domain.UserVO;
import com.healthtory.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	
	@Inject
	UserService service;
	
	// 회원 가입 get
	@RequestMapping("/join")
	public void getJoin() throws Exception{
		System.out.println("get join");
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(UserVO vo) throws Exception{
		System.out.println("post join");
		
		vo.setUserPass(vo.getUserPass());
		
		service.join(vo);
		
		return "redirect:/";
	}
	
	// 로그인 get
	@RequestMapping("/login")
	public void getLogin() throws Exception{
		System.out.println("get Login");
	}
	
	// 로그인 post
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		System.out.println("post Login");
		
		UserVO login = service.login(vo);
		HttpSession session = req.getSession();
		
		if(login != null) {
			session.setAttribute("user", login);
		}
		else {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/user/login";
		}
		return "redirect:/";
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String signout(HttpSession session) throws Exception {
		System.out.println("logout");
		service.logout(session);
	   
		return "redirect:/";
	}

}
