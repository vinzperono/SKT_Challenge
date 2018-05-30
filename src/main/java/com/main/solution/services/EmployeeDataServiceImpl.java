package com.main.solution.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.solution.domain.Employee;
import com.main.solution.repositories.EmployeeDataRepository;

/**
 * Employee Data Service implementation class
 */
@Service
public class EmployeeDataServiceImpl implements EmployeeDataService{
	
	private EmployeeDataRepository employeeDataRepository;
	 
	@Autowired
	public void setTradeDataRepository(EmployeeDataRepository employeeDataRepository) {
	    this.employeeDataRepository = employeeDataRepository;
	}

	/**
	 * {@inheritDoc}
	*/
	@Override
	public Iterable<Employee> listAllEmployees() {
		return employeeDataRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	*/
	@Override
	public Employee getEmployeeById(Integer id) {
		return employeeDataRepository.findOne(id);
	}

	/**
	 * {@inheritDoc}
	*/
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDataRepository.save(employee);
	}

	/**
	 * {@inheritDoc}
	*/
	@Override
	public void deleteEmployee(Integer id) {
		employeeDataRepository.delete(id);
	}
	
}
