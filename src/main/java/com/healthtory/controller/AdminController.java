package com.healthtory.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.healthtory.domain.GoodsVO;
import com.healthtory.service.GoodsService;
import com.healthtory.utils.UploadFileUtils;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Inject
	private GoodsService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
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
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception{
		
		String imaUploadPath = uploadPath + File.separator + "imgUpload";	//파일이 저장될 기본이 되는 폴더 . imgUpload라는 폴더에 저장됨.
		String ymdPath = UploadFileUtils.calcPath(imaUploadPath);
		String fileName = null;
		
		if(file != null) {
			fileName = UploadFileUtils.fileUpload(imaUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		}else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setGoodsImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGoodsThumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
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
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception{
		System.out.println("post goods modify");
		
		// 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		  // 기존 파일을 삭제
		  new File(uploadPath + req.getParameter("gdsImg")).delete();
		  new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
		  
		  // 새로 첨부한 파일을 등록
		  String imgUploadPath = uploadPath + File.separator + "imgUpload";
		  String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		  String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
		  vo.setGoodsImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		  vo.setGoodsThumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
		  vo.setGoodsImage(req.getParameter("gdsImg"));
		  vo.setGoodsThumbnail(req.getParameter("gdsThumbImg"));
		  
		 }
		
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
