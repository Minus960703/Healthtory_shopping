package com.healthtory.service;

import java.util.List;

import com.healthtory.domain.GoodsVO;

public interface ShopService {
	
	// 상품 리스트
	public List<GoodsVO> list(String goodsPart) throws Exception;

}
