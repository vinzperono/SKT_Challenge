package com.main.solution.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

/**
 * Employee domain class
 *
 */
@Data
@Entity
public class Employee {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
 
    @Version
    private Integer version;
 
    private String name;
    private String joinDate;
    private Long age;
    private String company;
    private String email;
    private String phone;
    private Long salary;
    private String address;
    
}
