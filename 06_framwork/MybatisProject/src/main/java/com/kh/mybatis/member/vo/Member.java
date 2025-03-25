package com.kh.mybatis.member.vo;

import java.sql.Date;

/**
 * @author user1
 *
 */
public class Member {
	// MEMBER 테이블 기준 컬럼 --> 필드(변수)
	
	private int    userNo;
	private String userId;
	private String userPwd;
	private String name;
	private String email;
	private String birthday;
	private String gender;
	private String phone;
	private String address;
	private Date enroll_date;
	private Date modify_date;
	private String status;
	
	public Member() {
		super();
	}

	
	
	
	public Member(String userId, String userPwd, String name, String email, String birthday, String gender,
			String phone, String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}




	public Member(int userNo, String userId, String userPwd, String name, String email, String birthday, String gender,
			String phone, String address, Date enroll_date, Date modify_date, String status) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.name = name;
		this.email = email;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.enroll_date = enroll_date;
		this.modify_date = modify_date;
		this.status = status;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", name=" + name
				+ ", email=" + email + ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone
				+ ", address=" + address + ", enroll_date=" + enroll_date + ", modify_date=" + modify_date + ", status="
				+ status + "]";
	}
	
	
	
	
	
	
	
}
