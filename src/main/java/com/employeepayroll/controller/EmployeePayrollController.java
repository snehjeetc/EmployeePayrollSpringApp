package com.employeepayroll.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.dto.ResponseDTO;
import com.employeepayroll.service.IEmployeePayrollService;

import io.swagger.annotations.ApiOperation;

/**
 * Rest Controller to handle rest api request from the server
 * @author snehjeetc12
 *
 */

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	/**
	 * API to retrieves employee from the database
	 * @return ResponseEntity<ResponseDTO(List<Employee>, message)>
	 */
	@GetMapping
	@ApiOperation("Get all the employee payroll data")
	public ResponseEntity<ResponseDTO> getEmployees(){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.getEmployee(), 
				"Fetched data successfully"), HttpStatus.OK);
	}
	
	/**
	 * API to retrieve Employee for the required id
	 * @throws EmployeePayrollException if the id is not found
	 * @param id
	 * @return ResponseEntity<ResponseDTO(Employee, message)>
	 */
	@GetMapping("/{id}")
	@ApiOperation("Get employee payroll of certain id")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int id){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.getEmployee(id), 
				"Details Fetched Successfully"), HttpStatus.OK);
	}
	
	/**
	 * API to fetch list of employees who have the given department
	 * @param department
	 * @return ResponseEntity<ResponseDTO(List<Employee>, message)>
	 */
	@GetMapping("/department")
	@ApiOperation("Get all the employee payroll data of a particular department")
	public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@RequestParam String department){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.getEmployeeByDepartment(department),
				"Fetched employee data by department successfully"),
				HttpStatus.OK);
	}
	
	/**
	 * API to handle http post request, creates a new employee after validating the 
	 * input, and adds it to the database 
	 * @throws MethodArgumentNotValidException, HttpMessageNotReadableException
	 * @param employeeDto
	 * @return ResponseEntity<ResponseDTO(Employee, message)>
	 */
	@PostMapping
	@ApiOperation("Add a new Employee payroll data to the DB")
	public ResponseEntity<ResponseDTO> postEmployee(@Valid @RequestBody EmployeeDTO employeeDto){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.postEmployee(employeeDto), 
				"Accepted"), HttpStatus.ACCEPTED);
	}
	
	/**
	 * API to handle update request from the client to update employee at the given id
	 * Validation is performed before update
	 * @throws MethodArgumentNotValidExceptions, HttpMessageNotReadableException
	 * @param id
	 * @param employeeDto
	 * @return ResponseEntity<ResponseDTO(Employee, message)>
	 */
	@PutMapping("/{id}")
	@ApiOperation("Update an existing employee payroll data by id")
	public ResponseEntity<ResponseDTO> putEmployee(@PathVariable int id,@Valid @RequestBody EmployeeDTO employeeDto){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.putEmployee(id, employeeDto), 
				"Successfully Updated"), HttpStatus.ACCEPTED);
	}
	
	/**
	 * API to delete an existing employee payroll data record of a given id
	 * @throws EmployeePayrollException
	 * @param id
	 * @return ResponseEntity<ResponseDTO(Employee, message)>
	 */
	@DeleteMapping("/{id}")
	@ApiOperation("Delete an employee payroll data by id")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.deleteEmployee(id), 
				"Removed employee data successfully"), HttpStatus.ACCEPTED);
	}

}
