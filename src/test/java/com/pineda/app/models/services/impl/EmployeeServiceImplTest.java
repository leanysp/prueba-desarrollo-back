package com.pineda.app.models.services.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pineda.app.exceptions.BusinessException;
import com.pineda.app.models.daos.IEmployeeDao;
import com.pineda.app.models.entities.EmployeeDto;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

	@Mock
	private IEmployeeDao dao;

	@Mock
	private EmployeeServiceImpl service;
	
	private EmployeeDto employeeDto;
	
	@BeforeEach
    public void setup() {
		employeeDto = new EmployeeDto(1, "prueba nombre", "cargo prueba", "11111", null);
    }

	@Test
	void testListEmployee() throws BusinessException {
		List<EmployeeDto> listEmployeeDto = new ArrayList<>();
		listEmployeeDto.add(employeeDto);
		Mockito.when(service.findAll()).thenReturn(listEmployeeDto);
		List<EmployeeDto> list = service.findAll();
		System.out.println("la cantidad es: "+list.size());
		assertNotNull(list);
	}

	@Test
	void testFindEmployee() throws BusinessException {
		Mockito.when(service.findByIdentification(employeeDto.getIdentification())).thenReturn(true);
		Boolean response = service.findByIdentification(employeeDto.getIdentification());
		assertTrue(response);
	}

	@Test
    public void testAddEmployee() throws BusinessException {
		Mockito.when(service.save(employeeDto)).thenReturn(employeeDto);
		EmployeeDto dto = service.save(employeeDto);
		assertNotNull(dto);
		verify(service).save(employeeDto);
    }

}
