package com.clozet.model.dto;

import java.sql.Timestamp;

public class CommentDto {

	private String userId;
	private Long commentNo;
	private String commentContent;
	private String password;
	private Timestamp regDate;
	private Long recommend;
	private Long prodNo;

	public CommentDto() {

	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public Long getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(Long commentNo) {
		System.out.println("인트 들어옴");
		this.commentNo = commentNo;
	}


	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Timestamp getRegDate() {
		return regDate;
	}



	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}



	public Long getRecommend() {
		return recommend;
	}

	public void setRecommend(Long recommend) {
		this.recommend = recommend;
	}

	public Long getProdNo() {
		return prodNo;
	}

	public void setProdNo(Long prodNo) {
		this.prodNo = prodNo;
	}



	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", commentNo=" + commentNo + ", commentContent=" + commentContent
				+ ", password=" + password + ", regDate=" + regDate + ", recommend=" + recommend + ", prodNo=" + prodNo
				+ "]";
	}







}
