package com.ssafy.model.dto;

public class user {
	private int user_no; 
	private String user_email; 
	private String user_pw; 
	private String user_id; 
	private String user_image; 
	private String user_desc;
	
	
	public user() {}
	
	public user(int user_no, String user_email, String user_pw, String user_id) {
		super();
		this.user_no = user_no;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.user_id = user_id;
	}
	
	public user(int user_no, String user_email, String user_pw, String user_id, String user_image, String user_desc) {
		super();
		this.user_no = user_no;
		this.user_email = user_email;
		this.user_pw = user_pw;
		this.user_id = user_id;
		this.user_image = user_image;
		this.user_desc = user_desc;
	}
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_image() {
		return user_image;
	}
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	public String getUser_desc() {
		return user_desc;
	}
	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}

	@Override
	public String toString() {
		return "user [user_no=" + user_no + ", user_email=" + user_email + ", user_pw=" + user_pw + ", user_id="
				+ user_id + ", user_image=" + user_image + ", user_desc=" + user_desc + "]";
	} 
	
}
