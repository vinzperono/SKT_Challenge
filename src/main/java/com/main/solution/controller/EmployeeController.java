package com.main.solution.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.main.solution.domain.Employee;
import com.main.solution.services.EmployeeDataService;

@Controller
public class EmployeeController {

    private EmployeeDataService employeeDataService;

    @Autowired
    public void setEmployeeDataService(EmployeeDataService employeeDataService) {
        this.employeeDataService = employeeDataService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("employees", employeeDataService.listAllEmployees());
        return "employees";
    }
    
    @RequestMapping(value = "/get/employees/sorted/salary", method = RequestMethod.GET)
    public String listBySalary(Model model){
    	List<Employee> listOfEmployee = new ArrayList<Employee>();
    	
    	Iterator<Employee> iterator1 = employeeDataService.listAllEmployees().iterator();
        while (iterator1.hasNext()) {
        	listOfEmployee.add(iterator1.next());
        }
        
        listOfEmployee.sort((o1, o2)->(int) (o1.getSalary() - o2.getSalary()));
    	
        model.addAttribute("employees", listOfEmployee);
        return "employees";
    }
    
    @RequestMapping(value = "/get/employees/younger/than/25", method = RequestMethod.GET)
    public String listByAge(Model model){
    	List<Employee> listOfEmployee = new ArrayList<Employee>();
    	
    	Iterator<Employee> iterator1 = employeeDataService.listAllEmployees().iterator();
        while (iterator1.hasNext()) {
        	listOfEmployee.add(iterator1.next());
        }
        
        List<Employee> result = listOfEmployee.stream()                
                .filter(o -> o.getAge() < 25)     
                .collect(Collectors.toList());
    	
        model.addAttribute("employees", result);
        return "employees";
    }

    @RequestMapping("employee/{id}")
    public String showEmployee(@PathVariable Integer id, Model model){
        model.addAttribute("employee", employeeDataService.getEmployeeById(id));
        return "employeeshow";
    }

    @RequestMapping("employee/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("employee", employeeDataService.getEmployeeById(id));
        return "employeeform";
    }

    @RequestMapping("employee/new")
    public String newEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "employeeform";
    }

    @RequestMapping(value = "employee", method = RequestMethod.POST)
    public String saveEmployee(Employee employee){
    	employeeDataService.saveEmployee(employee);
        return "redirect:/employee/" + employee.getId();
    }

    @RequestMapping("employee/delete/{id}")
    public String delete(@PathVariable Integer id){
    	employeeDataService.deleteEmployee(id);
        return "redirect:/employees";
    }

}
