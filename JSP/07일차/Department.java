package com.sample.hr.vo;

public class Department {
	private int id;
	private String name;
	private int managerId;
	private int locationId;
	public Department(int id, String name, int managerId, int locationId) {
		super();
		this.id = id;
		this.name = name;
		this.managerId = managerId;
		this.locationId = locationId;
	}
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

}
