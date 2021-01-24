package com.healthtory.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;
import com.healthtory.domain.GoodsVO;
import com.healthtory.service.GoodsService;
import com.healthtory.utils.UploadFileUtils;

import net.sf.json.JSONObject;

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
	public String postGoodsRegister(GoodsVO vo, MultipartFile file, @RequestParam("goodsThumbnail") String goodsThumbnail) throws Exception{
		
		if(goodsThumbnail.equals("null")) {
			vo.setGoodsThumbnail("/resources/imgUpload/none.png");
		}
		/*String imaUploadPath = uploadPath + File.separator + "imgUpload";	//파일이 저장될 기본이 되는 폴더 . imgUpload라는 폴더에 저장됨.
		String ymdPath = UploadFileUtils.calcPath(imaUploadPath);	//위의 폴더를 기준으로 연월일 폴더 생성
		String fileName = null;	//기본 경로와 별개로 작성되는 경로 + 파일이름
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			//파일 인풋박스에 첨부된 파일이 없다면 ( = 첨부된 파일 이름 없다면 )
			fileName = UploadFileUtils.fileUpload(imaUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		}else {	//첨부된 파일 없으면
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";	//미리 준비된 none.png파일 대신 출력
		}
		//goodsImage에 원본 파일 경로 + 파일명
		vo.setGoodsImage(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		//goodsThumbnail에 썸네일 파일 경로 + 파일명
		vo.setGoodsThumbnail(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		*/
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
		
		/*// 새로운 파일이 등록되었는지 확인
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
		  
		 }*/
		
		service.goodsModify(vo);
		
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("goodsNum") int goodsNum, Model model) throws Exception{
		System.out.println("post goods delete");
		
		service.goodsDelete(goodsNum);
		
		return "redirect:/admin/index";
	}
	
	@RequestMapping(value="/goods/imgUpload", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		
		// 외부경로로 저장을 희망할때.
		//String fileRoot = "C:\\Users\\you\\Desktop\\My_Space\\GitHub\\practice_spring\\practice_spring\\src\\main\\webapp\\resources\\image\\";
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot = contextRoot+"resources/imgUpload/";
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/resources/imgUpload/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
			//jsonObject.addProperty("url", fileRoot+savedFileName); 
			System.out.println(fileRoot+savedFileName);//경로 및 파일명 출력
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
	
}
