package com.healthtory.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.healthtory.domain.GoodsVO;

@Repository
public class ShopDAOImpl implements ShopDAO{

	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.healthtory.mappers.shopMapper";
	
	@Override
	public List<GoodsVO> list(String goodsPart) throws Exception {
	
		return sql.selectList(namespace + ".list", goodsPart);
	}

}
