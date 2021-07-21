/**
 * 
 */
package com.pineda.app.models.services;

import java.util.List;

import com.pineda.app.exceptions.BusinessException;
import com.pineda.app.models.entities.EmployeeDto;

/**
 * @author leanys
 *
 */
public interface IEmployeeService {
	
	/**
	 * Metodfo para listar todos los empleados en la base de datos,
	 * si no se cuenta con unformacion retornara una excepcion controlada
	 * @return Retorna la lista de los empleados
	 * @throws BusinessException
	 */
	public List<EmployeeDto> findAll() throws BusinessException;
	
	/**
	 * Metodo para buscar un empleado dentro de la bd por medio
	 * de su identificacion
	 * @param identification
	 * @return retorna true o false si encuentra o no el empleado
	 * @throws BusinessException
	 */
	public Boolean findByIdentification(String identification) throws BusinessException;
	
	/**
	 * Metodo para guardar un empleado en la base de datos
	 * @param employee Objeto dto con la informacion a guardar
	 * @return
	 * @throws BusinessException
	 */
	public EmployeeDto save(EmployeeDto employee) throws BusinessException;
	
	

}
