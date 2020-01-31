package com.ssafy.model.service;


public interface ReportService {
	public String searchReport(int user_no, int post_no);
	public void insertReport(int user_no, int post_no);
	public void deleteReport(int user_no, int post_no);
}
