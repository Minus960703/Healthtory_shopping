package com.healthtory.dao;

import java.util.List;

import com.healthtory.domain.GoodsVO;

public interface GoodsDAO {
	
	// 상품 등록
	public void register(GoodsVO vo) throws Exception;
	
	//상품 목록
	public List<GoodsVO> goodslist() throws Exception;
	
	//상품 조회
	public GoodsVO goodsView(int goodsNum) throws Exception;
	
	//상품 수정
	public void goodsModify(GoodsVO vo) throws Exception;
	
	//상품 삭제
	public void goodsDelete(int goodsNum) throws Exception;
}
