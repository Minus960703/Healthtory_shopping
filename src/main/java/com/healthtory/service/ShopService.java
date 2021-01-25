package com.healthtory.service;

import java.util.List;

import com.healthtory.domain.CommentListVO;
import com.healthtory.domain.CommentVO;
import com.healthtory.domain.GoodsVO;

public interface ShopService {
	
	// 상품 리스트
	public List<GoodsVO> list(String goodsPart) throws Exception;
	
	//상품 조회
	public GoodsVO goodsView(int goodsNum) throws Exception;
	
	//댓글 등록
	public void commentregist(CommentVO comment) throws Exception;
	
	//댓글 목록
	public List<CommentListVO> commentList(int goodsNum) throws Exception;

}
