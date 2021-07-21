/**
 * 
 */
package com.pineda.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pineda.app.exceptions.BusinessException;
import com.pineda.app.models.entities.EmployeeDto;
import com.pineda.app.models.services.IEmployeeService;

/**
 * @author leanys
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(employeeService.findAll());
		} catch (BusinessException be) {
			return ResponseEntity.status(be.getStatus()).body(be.getMessage());
		}

	}
	
	@GetMapping("{identification}")
	public ResponseEntity<?> findByIdentification(@PathVariable String identification) {
		try {
			return ResponseEntity.ok(employeeService.findByIdentification(identification));
		} catch (BusinessException be) {
			return ResponseEntity.status(be.getStatus()).body(be.getMessage());
		}

	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody EmployeeDto employee) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
		} catch (BusinessException be) {
			return ResponseEntity.status(be.getStatus()).body(be.getMessage());
		}
	}

}
