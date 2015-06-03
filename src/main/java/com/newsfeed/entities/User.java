package com.newsfeed.entities;

import java.sql.SQLException;
import java.util.ArrayList;

import com.newsfeed.dao.NewsDal;

public class User {
	private int userId;
	private String name;
	private String userName;
	private String password;
	private int role;
	private String address;
	private int gender;
	private int dept;
	
	
	
	/**
	 * @param name
	 * @param userName
	 * @param password
	 * @param role
	 * @param address
	 * @param age
	 */
	
	
	public User(String name, String userName, String password,
			String address, int gender, int dept) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.gender = gender;
		this.dept = dept;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the age
	 */
	public int getGender() {
		return gender;
	}
	/**
	 * @param age the age to set
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}
	/**
	 * @return the dept
	 */
	public int getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(int dept) {
		this.dept = dept;
	}
	
	public User getUser(String uname, String pwd){
		NewsDal ndal = new NewsDal();
		try {
			User u = ndal.getUser(uname, pwd);
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<User> getAllEditors(){
		NewsDal ndal = new NewsDal();
		try {
			return ndal.getAllEditors();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void registerUser(User u, int roleId){
		NewsDal ndal = new NewsDal();
		try {
			ndal.insertUser(u, roleId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int uid){
		NewsDal ndal = new NewsDal();
		try {
			ndal.deleteUser(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
