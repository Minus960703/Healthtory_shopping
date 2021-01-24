package com.healthtory.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthtory.domain.GoodsVO;
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
}
