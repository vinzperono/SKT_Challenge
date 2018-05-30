# Employee Data Management
## Developed by Vinz Perono

# Steps to check and run the App
1. Unzip the file and import in your fav IDE as maven project
2. Run: "mvn clean install" to check for issues
2. Run: "mvn spring-boot:run" to bootup your App
3. Access the WebApp: "http://localhost:8080/"
4. List of available REST API: "http://localhost:8080/swagger-ui.html"
5. Play around the webapp

# Technology used
springboot
h2 Memory Db
thymeleaf
bootstrap
jquery
swagger
lombok - make sure lombok is configured properly.
json-simple

# Requirements
1. List all Employees by clicking the "Employee" header menu.
2. Retrieve all employees sorted by salary in ascending order:
	** Either you click the column header Salary or
	** Enter directly in the URL http://localhost:8080/get/employees/sorted/salary
	
3. Retrieve employees younger than 25:
	** Either you click the "Filter" in the Header menu or
	** Enter directly in the URL http://localhost:8080/get/employees/younger/than/25

