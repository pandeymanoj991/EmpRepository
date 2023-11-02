package com.mk.department.dto;

public class DepartmentDTO {

	private Long id;
	private String departmentName;
	private String departmentDesc;
	private String departmentCode;

	public DepartmentDTO() {
		super();
	}

	public DepartmentDTO(Long id, String departmentName, String departmentDesc, String departmentCode) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.departmentDesc = departmentDesc;
		this.departmentCode = departmentCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDesc() {
		return departmentDesc;
	}

	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

}
