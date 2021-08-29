package com.sample.hr.dto;

public class DepartmentDto {
	private int id;
	private String name;
	private int managerId;
	private String managerName;
	private	int locationId;
	private	String city;
	private int empCount;
	
	public DepartmentDto() {}

	
	public DepartmentDto(int id, String name, int managerId, String managerName, int locationId, String city,
			int empCount) {
		super();
		this.id = id;
		this.name = name;
		this.managerId = managerId;
		this.managerName = managerName;
		this.locationId = locationId;
		this.city = city;
		this.empCount = empCount;
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

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	
}
