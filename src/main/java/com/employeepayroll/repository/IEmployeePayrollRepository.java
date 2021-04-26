package com.employeepayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeepayroll.model.Employee;

@Repository
public interface IEmployeePayrollRepository extends JpaRepository<Employee, Integer> {
}
