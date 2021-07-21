/**
 * 
 */
package com.pineda.app.models.daos;

import org.springframework.data.repository.CrudRepository;

import com.pineda.app.models.entities.Employee;

/**
 * @author leanys
 *
 */
public interface IEmployeeDao extends CrudRepository <Employee, Integer>{
	
	/**
	 * Metodo que busca un empleado, este metodo se ha realizado 
	 * por medio del standar de JPA
	 * @param identification
	 * @return devuelve un empleado por medio de su identificacion
	 */
	public Employee findByIdentification(String identification);

}
