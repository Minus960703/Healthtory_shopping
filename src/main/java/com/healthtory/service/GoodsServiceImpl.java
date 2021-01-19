package com.healthtory.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.healthtory.dao.GoodsDAO;
import com.healthtory.domain.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Inject
	private GoodsDAO dao;
	
	// 상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		
		dao.register(vo);
	}

	// 상품 목록
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		
		return dao.goodslist();
	}

	//상품 조회
	@Override
	public GoodsVO goodsView(int goodsNum) throws Exception {
		return dao.goodsView(goodsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}

	//상품 삭제
	@Override
	public void goodsDelete(int goodsNum) throws Exception {
		dao.goodsDelete(goodsNum);
	}

}
