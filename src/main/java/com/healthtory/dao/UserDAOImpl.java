package com.healthtory.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.healthtory.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Inject
	private SqlSession sql;
	
	//매퍼
	private static String namespace = "com.healthtory.mappers.userMapper";
	
	//회원 가입
	@Override
	public void join(UserVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
	}

	//로그인
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return sql.selectOne(namespace + ".login", vo);
	}

}
