package com.healthtory.domain;

public class UserVO {

	/*
	 * CREATE TABLE healthtory_user (
	userId VARCHAR(50) NOT NULL,
	userPass VARCHAR(100) NOT NULL,
	userName VARCHAR(30) NOT NULL,
	userPhone VARCHAR(20) NOT NULL,
	userEmail VARCHAR(50) NOT NULL,
	userAddr1 VARCHAR(50) NOT NULL,
	userAddr2 VARCHAR(50) NOT NULL,
	userAddr3 VARCHAR(50) NOT NULL,
	userPost int NOT NULL,
	PRIMARY KEY(userId)
);
	 */
	
	private String userId;
	private String userPass;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private int userPost;
	private String grade;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddr1() {
		return userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	public String getUserAddr2() {
		return userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public String getUserAddr3() {
		return userAddr3;
	}
	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}
	public int getUserPost() {
		return userPost;
	}
	public void setUserPost(int userPost) {
		this.userPost = userPost;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
