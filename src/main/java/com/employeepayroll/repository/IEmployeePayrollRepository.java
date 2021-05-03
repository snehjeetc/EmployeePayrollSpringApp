package com.employeepayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employeepayroll.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "SELECT * FROM employee_payroll, employee_department where employee_id = id AND department = :department", nativeQuery = true)
	List<Employee> findEmployeeByDepartment(String department);
}
