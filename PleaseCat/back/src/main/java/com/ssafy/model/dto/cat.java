package com.ssafy.model.dto;

public class cat {

	private int cat_no;
	private int age;
	private int cat_manager;
	private String cat_name;
	private String cat_image;
	private String sex;
	private String reg_date;
	private String meal_time;
	private String cat_location;
	private String cat_desc;
	private String hair_color;
	private	String eye_color;
	private int skin_disease;
	private int neuter;
	private int hurt;
	
	
	
	public String getCat_image() {
		return cat_image;
	}
	public void setCat_image(String cat_image) {
		this.cat_image = cat_image;
	}
	public cat() {
		super();
	}
	public cat(int cat_no, int age, int cat_manager, String cat_name, String sex, String reg_date, String meal_time,
			String cat_location, String cat_desc, String hair_color, String eye_color, int skin_disease, int neuter,
			int hurt) {
		super();
		this.cat_no = cat_no;
		this.age = age;
		this.cat_manager = cat_manager;
		this.cat_name = cat_name;
		this.sex = sex;
		this.reg_date = reg_date;
		this.meal_time = meal_time;
		this.cat_location = cat_location;
		this.cat_desc = cat_desc;
		this.hair_color = hair_color;
		this.eye_color = eye_color;
		this.skin_disease = skin_disease;
		this.neuter = neuter;
		this.hurt = hurt;
	}
	public int getCat_no() {
		return cat_no;
	}
	public void setCat_no(int cat_no) {
		this.cat_no = cat_no;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCat_manager() {
		return cat_manager;
	}
	public void setCat_manager(int cat_manager) {
		this.cat_manager = cat_manager;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getMeal_time() {
		return meal_time;
	}
	public void setMeal_time(String meal_time) {
		this.meal_time = meal_time;
	}
	public String getCat_location() {
		return cat_location;
	}
	public void setCat_location(String cat_location) {
		this.cat_location = cat_location;
	}
	public String getCat_desc() {
		return cat_desc;
	}
	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}
	public String getHair_color() {
		return hair_color;
	}
	public void setHair_color(String hair_color) {
		this.hair_color = hair_color;
	}
	public String getEye_color() {
		return eye_color;
	}
	public void setEye_color(String eye_color) {
		this.eye_color = eye_color;
	}
	public int getSkin_disease() {
		return skin_disease;
	}
	public void setSkin_disease(int skin_disease) {
		this.skin_disease = skin_disease;
	}
	public int getNeuter() {
		return neuter;
	}
	public void setNeuter(int neuter) {
		this.neuter = neuter;
	}
	public int getHurt() {
		return hurt;
	}
	public void setHurt(int hurt) {
		this.hurt = hurt;
	}
	@Override
	public String toString() {
		return "cat [cat_no=" + cat_no + ", age=" + age + ", cat_manager=" + cat_manager + ", cat_name=" + cat_name
				+ ", sex=" + sex + ", reg_date=" + reg_date + ", meal_time=" + meal_time + ", cat_location="
				+ cat_location + ", cat_desc=" + cat_desc + ", hair_color=" + hair_color + ", eye_color=" + eye_color
				+ ", skin_disease=" + skin_disease + ", neuter=" + neuter + ", hurt=" + hurt + "]";
	}
	
	
	
}
