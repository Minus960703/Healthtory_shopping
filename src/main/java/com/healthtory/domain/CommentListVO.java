package com.healthtory.domain;

import java.util.Date;

public class CommentListVO {
	
	private int goodsNum;
	private String userId;
	private int comNum;
	private String comCon;
	private Date comDate;
	
	private String userName;

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getComNum() {
		return comNum;
	}

	public void setComNum(int comNum) {
		this.comNum = comNum;
	}

	public String getComCon() {
		return comCon;
	}

	public void setComCon(String comCon) {
		this.comCon = comCon;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
