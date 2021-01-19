package com.healthtory.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.healthtory.domain.GoodsVO;

@Repository
public class GoodsDAOImpl implements GoodsDAO{

	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.healthtory.mappers.goodsMapper";
	
	// 상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		
		sql.insert(namespace + ".register", vo);
	}

	// 상품 목록
	@Override
	public List<GoodsVO> goodslist() throws Exception {
		return sql.selectList(namespace + ".goodslist");
	}
	
	//상품 조회
	@Override
	public GoodsVO goodsView(int goodsNum) throws Exception {
		
		return sql.selectOne(namespace + ".goodsView", goodsNum);
	}
	
	//상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		sql.update(namespace + ".goodsModify", vo);
	}
	
	// 상품 삭제
	@Override
	public void goodsDelete(int goodsNum) throws Exception {
		sql.delete(namespace + ".goodsDelete", goodsNum);
		
	}

}
