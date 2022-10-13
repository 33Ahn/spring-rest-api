# spring-rest-api

Project’s title: Employee Management Application

My project is a Spring Boot project that performs getting all employees information, adding new employees, updating and deleting the existing employees. I chose this project because I wanted to understand how applications talk to each other and learn how to design the architecture and thought this would be a good project to operate CRUD operations.
	
What I learned

	Through building this project, I have a better understanding of how applications talk to each other and how clients’ requests are 	processed. It was complex and quite challenging, but I want to know how this magical communication works between clients and     servers.
	
	Also I learned that I need to start something even if it’s small. The hardest part of the project was I didn’t know what to 	build, thinking 	I have to build something project-worthy. That halted me for some time and as a very beginner in Java, I think 	it’s OK to start something 	very small. And there are so many dependencies to inject and the folder structure was overwhelming in the beginning.

	Lastly, I faced the  issues with my computer, intelliJ, and my wireless mouse erasing everything on its own. And the applications release 	updated versions frequently, so I had to  search for the changes in the updated version. There are almost always unexpected surprises on the 	way and I learned that I accept those and be ready for them. 
  
Technologies used

	For the frontend side, I used VS code, React, JavaScript, Bootstrap 4.0, Axios HTTP library, NodeJS and npm, Create React App CLI.
	For the server side, I used IntelliJ initially, Eclipse, Spring Boot, SpringData JPA(Hibernate), Maven, JDK, Embedded Tomcat,  MySQL 	database.

How I built it

	1.Create spring project 	spring initializr https://start.spring.io/ and add 4 dependencies
		1.Spring boot Dev Tools
		2.Spring Web
		3.Spring Data JPA
		4.MySQL Driver
	Then generate a project. Extract the ZIP file, and open IntelliJ and open the project.
	
	2.  Create packaging structure
	From the source folder, create packages, such as controller, repository, model, and exception.
	
	3. Configure MySQL Database
	Open MySQL Workbench, create database employee management application;
	Then configure the database to the project in the application.properties file.
	
	4. Create Employee JPA Entity
	From the model package, create an Employee class and create instance fields, constructor, and getters and setters. Use JPA annotations to
	 map this class to the database such as @Entity @Table(name=” “) @Id @GeneratedValue(strategy = Generationtype.IDENTITY) @Column(name=” “)
	
	5. Create EmployeeREpository Interface
	From the repository, create an  EmployeeRepository Interface. 
	Add @Repository annotation.
	
	6.Create ResourceNotFoundException class within the ResourceNotFoundException package and add @ResponseStatus(value=HttpStatus.NOT_FOUND)
	
	7. Create an EmployeeController class within the model package and add @RestController, @RequestMapping(“/api/v1/employees”) @GetMapping for  	getting all employees.
	
	8. Run the application and check if it’s connected to the database. Try to insert a few records in a table, then check the 	localhost:8080/api/v1/employees or Postman.
	
	9. Create get employee by id REST API
	Use @GetMapping(“{id})  @PathVariable(“id “)
	
	10. Create add employee REST API
	Use @PostMapping  @RequestBody  
	
	11. Create update employee by id REST API
	Use @PutMapping  @PathVariable(“id”)  @RequestBody
	
	12. Create delete employee REST API
	Use @DeleteMapping(“{id}”)  @PathVariable(“id”)
	Every API, check if it’s working on Postman.
		
	https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#data
	https://www.baeldung.com/spring-tutorial

