package com.healthtory.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.healthtory.dao.ShopDAO;
import com.healthtory.domain.CommentListVO;
import com.healthtory.domain.CommentVO;
import com.healthtory.domain.GoodsVO;

@Service
public class ShopServiceImpl implements ShopService{

	@Inject
	private ShopDAO dao;

	//상품 목록
	@Override
	public List<GoodsVO> list(String goodsPart) throws Exception {
		
		return dao.list(goodsPart);
	}

	//상품 조회
	@Override
	public GoodsVO goodsView(int goodsNum) throws Exception {
		return dao.goodsView(goodsNum);
	}
	
	//댓글 등록
	@Override
	public void commentregist(CommentVO comment) throws Exception {
		dao.commentregist(comment);
	}

	//댓글 목록
	@Override
	public List<CommentListVO> commentList(int goodsNum) throws Exception {
		return dao.commentList(goodsNum);
	}
}
