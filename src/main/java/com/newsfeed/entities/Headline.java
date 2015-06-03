package com.newsfeed.entities;

public class Headline {
	private int headlineId;
	private String name;
	private String description;
	private int deptId;
	
	
	
	/**
	 * @param description
	 * @param deptId
	 */
	public Headline(String description, int deptId) {
		super();
		this.description = description;
		this.deptId = deptId;
	}
	public Headline() {
		// TODO Auto-generated constructor stub
	}
	public int getHeadlineId() {
		return headlineId;
	}
	public void setHeadlineId(int headlineId) {
		this.headlineId = headlineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	
}
