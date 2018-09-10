package eu.babywatcher.services.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.babywatcher.services.test.model.MyTest;
import eu.babywatcher.services.test.repository.MyTestRepository;

@RestController
@RequestMapping("/test")
public class MyTestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyTestController.class);
	
	@Autowired
	MyTestRepository repository;
	
	@PostMapping("/")
	public MyTest add(@RequestBody MyTest myTest) {
		LOGGER.info("MyTest add: {}", myTest);
		MyTest test=repository.add(myTest);
		LOGGER.info("lisatud: "+test);
		return test;
	}
	
	@GetMapping("/{id}")
	public MyTest findById(@PathVariable("id") Long id) {
		LOGGER.info("MyTest find: id={}", id);
		return repository.findById(id);
	}

	@GetMapping("/del/{id}")
	public boolean deleteById(@PathVariable("id") Long id) {
		LOGGER.info("MyTest find: id={}", id);
		return repository.deleteById(id);
	}

	@GetMapping("/")
	public List<MyTest> findAll() {
		LOGGER.info("MyTest find");
		LOGGER.info("kokku: "+repository.findAll().size());
		return repository.findAll();
	}
	
	/*@GetMapping("/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
		LOGGER.info("Employee find: departmentId={}", departmentId);
		return repository.findByDepartment(departmentId);
	}*/
	
	/*@GetMapping("/organization/{organizationId}")
	public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Employee find: organizationId={}", organizationId);
		return repository.findByOrganization(organizationId);
	}*/
	
}
