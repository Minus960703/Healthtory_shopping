package com.healthtory.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.healthtory.dao.ShopDAO;
import com.healthtory.domain.GoodsVO;

@Service
public class ShopServiceImpl implements ShopService{

	@Inject
	private ShopDAO dao;

	@Override
	public List<GoodsVO> list(String goodsPart) throws Exception {
		
		return dao.list(goodsPart);
	}
}
