package com.healthtory.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthtory.domain.GoodsVO;
import com.healthtory.service.GoodsService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Inject
	private GoodsService service;
	
	//관리자 화면
	@RequestMapping("/index")
	public void getIndex() throws Exception{
		System.out.println("get index");
	}
	
	//상품 등록
	@RequestMapping("/goods/register")
	public void getGoodsRegister() throws Exception{
		System.out.println("get goods register");
	}
	
	//상품 등록
	@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo) throws Exception{
		service.register(vo);
		
		return "redirect:/admin/goods/list";
	}
	
	//상품 목록
	@RequestMapping("/goods/list")
	public void getGoodsList(Model model) throws Exception{
		System.out.println("get goods list");
		
		List<GoodsVO> goodslist = service.goodslist();
		
		model.addAttribute("goodslist", goodslist);
	}
	
	//상품 조회
	@RequestMapping("/goods/view")
	public void getGoodsView(@RequestParam("goodsNum") int goodsNum, Model model) throws Exception{
		System.out.println("get goods view");
		
		GoodsVO goodsView = service.goodsView(goodsNum);
		
		model.addAttribute("goodsView", goodsView);
	}
	
	//상품 수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("goodsNum") int goodsNum, Model model) throws Exception{
		System.out.println("get goods modify");
		
		GoodsVO goods = service.goodsView(goodsNum);
		model.addAttribute("goods", goods);
	}
	
	//상품 수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoodsModify(GoodsVO vo) throws Exception{
		System.out.println("post goods modify");
		
		service.goodsModify(vo);
		
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("goodsNum") int goodsNum, Model model) throws Exception{
		System.out.println("post goods delete");
		
		service.goodsDelete(goodsNum);
		
		return "redirect:/admin/index";
	}
}
