package com.main.solution.bootstrap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.main.solution.domain.Employee;
import com.main.solution.repositories.EmployeeDataRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Data Loader class
 *
 */
@Slf4j
@Component
public class EmployeeDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private EmployeeDataRepository employeeDataRepository;

    @Autowired
    public void setEmployeeDataRepository(EmployeeDataRepository employeeDataRepository) {
        this.employeeDataRepository = employeeDataRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
    	
    	JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("employee.json"));
            
            // loop array
            JSONArray info = (JSONArray) obj;
            Iterator<Object> iterator1 = info.iterator();
            while (iterator1.hasNext()) {
            	Employee employee = new Employee();
                JSONObject jsonObject = (JSONObject) iterator1.next();

                String name = (String) jsonObject.get("name");
                employee.setName(name);
                String joindate = (String) jsonObject.get("joindate");
                employee.setJoinDate(joindate);
                Long age = (Long) jsonObject.get("age");
                employee.setAge(age);
                String company = (String) jsonObject.get("company");
                employee.setCompany(company);
                String email = (String) jsonObject.get("email");
                employee.setEmail(email);
                String phone = (String) jsonObject.get("phone");
                employee.setPhone(phone);
                Long salary = (Long) jsonObject.get("salary");
                employee.setSalary(salary);
                
                JSONObject address = (JSONObject) jsonObject.get("address");
                
                if (address != null){
                	String street = (String) address.get("street");
                    String city = (String) address.get("city");
                    String zipcode = (String) address.get("zipcode");
                    employee.setAddress(street + " " + city + ", " + zipcode);
                }
                
                employeeDataRepository.save(employee);
                log.info("Saved employee data - id: {}", employee.getId());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
