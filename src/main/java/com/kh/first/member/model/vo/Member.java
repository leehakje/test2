package com.kh.first.member.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

//servlet context 한테 자동으로 등록을 해주기 위해 annotation을 달아준다.
@Component
public class Member implements java.io.Serializable{
	public final static long SerialVersionUID = 1L;
	
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enroll_date;
	
	public String getMember_id() {
		return member_id;
	}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	public String getMember_pwd() {
		return member_pwd;
	}
	
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	
	public String getMember_name() {
		return member_name;
	}
	
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public Date getEnroll_date() {
		return enroll_date;
	}
	
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	@Override
	public String toString() {
		return "member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", gender=" + gender + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", hobby=" + hobby + ", enroll_date=" + enroll_date;
	}
	
	
}
