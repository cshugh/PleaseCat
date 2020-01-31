package com.ssafy.model.dto;

public class following_user {
	private int followed_no;
	private int follower_no;
	
	public following_user() {
		super();
	}
	public following_user(int followed_no, int follower_no) {
		super();
		this.followed_no = followed_no;
		this.follower_no = follower_no;
	}
	public int getFollowed_no() {
		return followed_no;
	}
	public void setFollowed_no(int followed_no) {
		this.followed_no = followed_no;
	}
	public int getFollower_no() {
		return follower_no;
	}
	public void setFollower_no(int follower_no) {
		this.follower_no = follower_no;
	}
	@Override
	public String toString() {
		return "following_user [followed_no=" + followed_no + ", follower_no=" + follower_no + "]";
	}
	
	
}
