package com.mk.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.department.entity.Department;

public interface DepartmentRepository  extends JpaRepository<Department,Long>{

}
