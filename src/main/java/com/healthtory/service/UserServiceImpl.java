package com.healthtory.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.healthtory.dao.UserDAO;
import com.healthtory.domain.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Inject UserDAO dao;
	
	//회원 가입
	@Override
	public void join(UserVO vo) throws Exception {
		dao.join(vo);
	}

	//로그인
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return dao.login(vo);
	}

	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}

}
