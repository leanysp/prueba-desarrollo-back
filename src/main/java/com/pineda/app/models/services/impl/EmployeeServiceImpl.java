/**
 * 
 */
package com.pineda.app.models.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.pineda.app.constanst.ErrorConstants;
import com.pineda.app.exceptions.BusinessException;
import com.pineda.app.models.daos.IEmployeeDao;
import com.pineda.app.models.entities.Employee;
import com.pineda.app.models.entities.EmployeeDto;
import com.pineda.app.models.services.IEmployeeService;

/**
 * @author leanys
 * @since 18-07-2021
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public List<EmployeeDto> findAll() throws BusinessException {
		try {
			List<Employee> employees = (List<Employee>) employeeDao.findAll();
			if (employees.isEmpty()) {
				throw new BusinessException(ErrorConstants.NOT_DATA, HttpStatus.NO_CONTENT.value());
			}
			return employees.stream().map(this::convertToDto).collect(Collectors.toList());
		} catch (Exception e) {
			throw new BusinessException(ErrorConstants.ERROR_LIST_EMPLOYEE, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

	}
	
	@Override
	public Boolean findByIdentification(String identification) throws BusinessException {
		Employee employee = employeeDao.findByIdentification(identification);
		return employee != null;
	}

	@Override
	public EmployeeDto save(EmployeeDto employeeDto) throws BusinessException {
		try {
			Employee employee = convertToEntity(employeeDto);
			return this.convertToDto(employeeDao.save(employee));
		} catch (Exception e) {
			throw new BusinessException(ErrorConstants.ERROR_SAVE_EMPLOYEE, HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
	}

	/**
	 * Method that convert dto to entity
	 * 
	 * @param dto
	 * @return
	 */
	private Employee convertToEntity(EmployeeDto dto) {
		return modelMapper.map(dto, Employee.class);
	}

	private EmployeeDto convertToDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}

}
