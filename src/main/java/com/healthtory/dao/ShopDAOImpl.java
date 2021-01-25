package com.healthtory.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.healthtory.domain.CommentListVO;
import com.healthtory.domain.CommentVO;
import com.healthtory.domain.GoodsVO;

@Repository
public class ShopDAOImpl implements ShopDAO{

	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.healthtory.mappers.shopMapper";
	
	//상품 목록
	@Override
	public List<GoodsVO> list(String goodsPart) throws Exception {
	
		return sql.selectList(namespace + ".list", goodsPart);
	}

	//상품 조회
	@Override
	public GoodsVO goodsView(int goodsNum) throws Exception {
		return sql.selectOne(namespace + ".view", goodsNum);
		//return sql.selectOne("com.healthtory.mappers.adminMapper + ".goodsView', goodsNum); <- 사용시 ShopMapper에 추가안해도 조회 가능. ( 같은 sql 문이기 때문에 굳이 복사 X)
	}
	
	//댓글 등록
	@Override
	public void commentregist(CommentVO comment) throws Exception {
		sql.insert(namespace + ".commentregist", comment);
	}
	
	//댓글 목록
	@Override
	public List<CommentListVO> commentList(int goodsNum) throws Exception {
		return sql.selectList(namespace + ".commentList", goodsNum);
	}

}
