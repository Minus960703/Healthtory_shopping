package com.healthtory.dao;

import java.util.List;

import com.healthtory.domain.GoodsVO;

public interface ShopDAO {

	// 파트별 상품 리스트
	public List<GoodsVO> list(String goodsPart) throws Exception;
}
