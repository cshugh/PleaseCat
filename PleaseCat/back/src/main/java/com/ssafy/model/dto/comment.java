package com.ssafy.model.dto;

public class comment {
	private int comment_no;
	private int post_no;
	private int user_no;
	private String comment_time;
	private String comment_content;
	private int comment_like;
	private int comment_unlike;
	private int comment_report;
	
	
	public comment() {}
	
	
	public comment(int comment_no, int post_no, int user_no, String comment_time, String comment_content,
			int comment_like, int comment_unlike, int comment_report) {
		super();
		this.comment_no = comment_no;
		this.post_no = post_no;
		this.user_no = user_no;
		this.comment_time = comment_time;
		this.comment_content = comment_content;
		this.comment_like = comment_like;
		this.comment_unlike = comment_unlike;
		this.comment_report = comment_report;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getPost_no() {
		return post_no;
	}
	public void setPost_no(int post_no) {
		this.post_no = post_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getComment_like() {
		return comment_like;
	}
	public void setComment_like(int comment_like) {
		this.comment_like = comment_like;
	}
	public int getComment_unlike() {
		return comment_unlike;
	}
	public void setComment_unlike(int comment_unlike) {
		this.comment_unlike = comment_unlike;
	}
	public int getComment_report() {
		return comment_report;
	}
	public void setComment_report(int comment_report) {
		this.comment_report = comment_report;
	}
	@Override
	public String toString() {
		return "comment [comment_no=" + comment_no + ", post_no=" + post_no + ", user_no=" + user_no + ", comment_time="
				+ comment_time + ", comment_content=" + comment_content + ", comment_like=" + comment_like
				+ ", comment_unlike=" + comment_unlike + ", comment_report=" + comment_report + "]";
	}
	
	
}
