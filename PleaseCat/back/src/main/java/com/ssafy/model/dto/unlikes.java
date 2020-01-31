package com.ssafy.model.dto;

public class unlikes {

		private int user_no;
		private int post_no;
		
		public unlikes() {}
		
		
		public unlikes(int user_no, int post_no) {
			super();
			this.user_no = user_no;
			this.post_no = post_no;
		}
		public int getUser_no() {
			return user_no;
		}
		public void setUser_no(int user_no) {
			this.user_no = user_no;
		}
		public int getPost_no() {
			return post_no;
		}
		public void setPost_no(int post_no) {
			this.post_no = post_no;
		}
		@Override
		public String toString() {
			return "report [user_no=" + user_no + ", post_no=" + post_no + "]";
		}

}
