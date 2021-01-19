package com.healthtory.dao;

import com.healthtory.domain.UserVO;

public interface UserDAO {

	//회원 가입
	public void join(UserVO vo) throws Exception;
	
	//로그인
	public UserVO login(UserVO vo) throws Exception;
	
}
