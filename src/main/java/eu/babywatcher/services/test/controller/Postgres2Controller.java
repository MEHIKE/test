package eu.babywatcher.services.test.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eu.babywatcher.services.test.postgres2.domain.TestPostgres2;
import eu.babywatcher.services.test.postgres2.repo.Postgres2Repository;

@RestController
@RequestMapping("/pos")
public class Postgres2Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(Postgres2Controller.class);
	

	@Autowired
	Postgres2Repository pos2repository;

	@PostMapping("/")
	public TestPostgres2 add(@RequestBody TestPostgres2 myTest) {
		LOGGER.info("Postgres2 add: {}", myTest);
		TestPostgres2 test=pos2repository.add(myTest);
		LOGGER.info("lisatud: "+test);
		return test;
	}
	
	@GetMapping("/{id}")
	public Optional<TestPostgres2> findById(@PathVariable("id") Long id) {
		LOGGER.info("Postgres2 find: id={}", id);
		return pos2repository.findById(id);
	}

/*	@GetMapping("/del/{id}")
	public boolean deleteById(@PathVariable("id") Long id) {
		LOGGER.info("Postgres find: id={}", id);
		return posrepository.deleteById(id);
	}
*/
	@GetMapping("/")
	public List<TestPostgres2> findAll() {
		LOGGER.info("Postgres2 find");
		LOGGER.info("kokku: "+pos2repository.findAll().size());
		return pos2repository.findAll();
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
