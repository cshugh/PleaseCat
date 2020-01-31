package com.ssafy.model.dto;

public class following_cat {
	private int follwer_no;
	private int cat_no;
	
	public following_cat(int follwer_no, int cat_no) {
		super();
		this.follwer_no = follwer_no;
		this.cat_no = cat_no;
	}

	public following_cat() {
		super();
	}

	public int getFollwer_no() {
		return follwer_no;
	}

	public void setFollwer_no(int follwer_no) {
		this.follwer_no = follwer_no;
	}

	public int getCat_no() {
		return cat_no;
	}

	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}

	@Override
	public String toString() {
		return "following_cat [follwer_no=" + follwer_no + ", cat_no=" + cat_no + "]";
	}
	
	
}
