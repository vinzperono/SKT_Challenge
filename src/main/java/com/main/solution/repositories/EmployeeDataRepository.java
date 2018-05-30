package com.main.solution.repositories;


import org.springframework.data.repository.CrudRepository;
import com.main.solution.domain.Employee;

//The Spring Data JPA CRUD Repository is my favorite feature of Spring Data JPA. 
//Similar to coding with a Spring Integration Gateway, you can just define an interface. 
//Spring Data JPA uses generics and reflection to generate the concrete implementation of the interface we define.

//Defining a repository for our Product domain class is as simple as defining a interface 
//and extending the CrudRepository interface. You need to declare two classes in the generics for this interface. 
//They are used for the domain class the repository is supporting, and the type of the id declared of the domain class.

public interface EmployeeDataRepository extends CrudRepository<Employee, Integer>{
}
