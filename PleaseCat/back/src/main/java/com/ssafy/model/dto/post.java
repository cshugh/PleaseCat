package com.ssafy.model.dto;

public class post {
	
	private int post_no;
	private int user_no;
	private int cat_no;
	private String post_image;
	private String post_time;
	private String post_content;
	private int post_like;
	private int post_unlike;
	private int post_report;
	private String post_location;
	
	
	public post() {}
	
	
	public post(int post_no, int user_no, int cat_no, String post_image, String post_time, String post_content,
			int post_like, int post_unlike, int post_report, String post_location) {
		super();
		this.post_no = post_no;
		this.user_no = user_no;
		this.cat_no = cat_no;
		this.post_image = post_image;
		this.post_time = post_time;
		this.post_content = post_content;
		this.post_like = post_like;
		this.post_unlike = post_unlike;
		this.post_report = post_report;
		this.post_location = post_location;
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
	public int getCat_no() {
		return cat_no;
	}
	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}
	public String getPost_image() {
		return post_image;
	}
	public void setPost_image(String post_image) {
		this.post_image = post_image;
	}
	public String getPost_time() {
		return post_time;
	}
	public void setPost_time(String post_time) {
		this.post_time = post_time;
	}
	public String getPost_content() {
		return post_content;
	}
	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}
	public int getPost_like() {
		return post_like;
	}
	public void setPost_like(int post_like) {
		this.post_like = post_like;
	}
	public int getPost_unlike() {
		return post_unlike;
	}
	public void setPost_unlike(int post_unlike) {
		this.post_unlike = post_unlike;
	}
	public int getPost_report() {
		return post_report;
	}
	public void setPost_report(int post_report) {
		this.post_report = post_report;
	}
	public String getPost_location() {
		return post_location;
	}
	public void setPost_location(String post_location) {
		this.post_location = post_location;
	}


	@Override
	public String toString() {
		return "post [post_no=" + post_no + ", user_no=" + user_no + ", cat_no=" + cat_no + ", post_image=" + post_image
				+ ", post_time=" + post_time + ", post_content=" + post_content + ", post_like=" + post_like
				+ ", post_unlike=" + post_unlike + ", post_report=" + post_report + ", post_location=" + post_location
				+ "]";
	}

	
	
}
