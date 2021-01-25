package com.healthtory.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthtory.domain.CommentListVO;
import com.healthtory.domain.CommentVO;
import com.healthtory.domain.GoodsVO;
import com.healthtory.domain.UserVO;
import com.healthtory.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {

	@Inject
	ShopService service;
	
	// 상품 리스트
	@RequestMapping("/list")
	public void getList(@RequestParam("c") String goodsPart, Model model) throws Exception{
		System.out.println("get part list");
		
		List<GoodsVO> list = null;
		list = service.list(goodsPart);
		
		model.addAttribute("list", list);
	} 
	
	// 상품 조회
	@RequestMapping("/view")
	public void getView(@RequestParam("n") int goodsNum, Model model) throws Exception{
		System.out.println("get view");
		
		GoodsVO view = service.goodsView(goodsNum);
		model.addAttribute("view", view);
		/*
		//댓글 목록
		List<CommentListVO> comment = service.commentList(goodsNum);
		model.addAttribute("comment", comment);
		*/
	}
	/*
	//댓글 등록
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String commentregist(CommentVO comment, HttpSession session) throws Exception{
		System.out.println("comment regist");
		
		UserVO user = (UserVO)session.getAttribute("user");
		comment.setUserId(user.getUserId());
		
		service.commentregist(comment);
		
		return "redirect:/shop/view?n=" + comment.getGoodsNum();
	}*/
	
	//댓글 등록
	@ResponseBody
	@RequestMapping(value = "/view/commentregist", method = RequestMethod.POST)
	public void commentregist(CommentVO comment, HttpSession session) throws Exception{
		System.out.println("regist comment");
		
		UserVO user = (UserVO)session.getAttribute("user");
		comment.setUserId(user.getUserId());
		
		service.commentregist(comment);
	}
	
	//댓글 목록
	@ResponseBody
	@RequestMapping("/view/commentList")
	public List<CommentListVO> getCommentList(@RequestParam("n") int goodsNum) throws Exception{
		System.out.println("get comment list");
		
		List<CommentListVO> comment = service.commentList(goodsNum);
		
		return comment;
	}
}
