package com.main.solution.services;

import com.main.solution.domain.Employee;

/**
 * Employee Data Service
 *
 */
public interface EmployeeDataService {
	
	/**
	 * Get all the employee data
	 * @return Iterable list of employees
	 */
	Iterable<Employee> listAllEmployees();
	
	/**
	 * Get the specific employee data using id
	 * @param id
	 * @return Specific employee
	 */
    Employee getEmployeeById(Integer id);
 
    /**
     * Save new created employee
     * @param employee
     * @return Employee data
     */
    Employee saveEmployee(Employee employee);
    
    /**
     * Delete specific employee data using id
     * @param id
     */
    void deleteEmployee(Integer id);

}
