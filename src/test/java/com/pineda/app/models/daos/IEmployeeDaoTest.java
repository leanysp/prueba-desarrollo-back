package com.pineda.app.models.daos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pineda.app.models.entities.Employee;


@ExtendWith(MockitoExtension.class)
class IEmployeeDaoTest {


	@Mock
	private IEmployeeDao dao;
	
	private Employee employee;
	
	@BeforeEach
    public void setup() {
		employee = new Employee(1, "prueba nombre", "cargo prueba", "11111", null);
    }

	
	@Test
	void testFindByIdentification() {
		Mockito.when(dao.findByIdentification("11111")).thenReturn(employee);
		Employee empl = dao.findByIdentification("11111");
		assertNotNull(empl);
	}

}
