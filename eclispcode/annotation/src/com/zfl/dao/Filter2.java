package com.zfl.dao;

@Table("user1")
public class Filter2 {
	
	@Column("id")
	private int id;
	
	@Column("userName")
	private String userName;
	
	@Column("nickName")
	private String nickName;
	
	@Column("count")
	private int count;
	
	@Column("age")
	private int age;
	
	@Column("email")
	private String email;
	
	@Column("mobile")
	private String mobile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
}
