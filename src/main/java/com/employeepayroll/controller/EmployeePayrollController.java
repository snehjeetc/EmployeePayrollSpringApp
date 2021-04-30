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
import org.springframework.web.bind.annotation.RestController;

import com.employeepayroll.dto.EmployeeDTO;
import com.employeepayroll.dto.ResponseDTO;
import com.employeepayroll.service.IEmployeePayrollService;

@RestController
@RequestMapping("/employeepayroll")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getEmployees(){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.getEmployee(), 
				"Fetched data successfully"), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getEmployee(@PathVariable int id){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.getEmployee(id), 
				"Details Fetched Successfully"), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ResponseDTO> postEmployee(@Valid @RequestBody EmployeeDTO employeeDto){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.postEmployee(employeeDto), 
				"Accepted"), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponseDTO> putEmployee(@PathVariable int id,@Valid @RequestBody EmployeeDTO employeeDto){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.putEmployee(id, employeeDto), 
				"Successfully Updated"), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id){
		return new ResponseEntity<>(new ResponseDTO(
				employeePayrollService.deleteEmployee(id), 
				"Removed employee data successfully"), HttpStatus.ACCEPTED);
	}

}
