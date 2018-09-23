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

import eu.babywatcher.services.test.postgres.domain.TestPostgres;
import eu.babywatcher.services.test.postgres.repo.PostgresRepository;

@RestController
//@RequestMapping("/pos")
public class PostgresController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostgresController.class);
	

	@Autowired
	PostgresRepository posrepository;

	@PostMapping("/")
	public TestPostgres add(@RequestBody TestPostgres myTest) {
		LOGGER.info("Postgres add: {}", myTest);
		TestPostgres test=posrepository.save(myTest);
		LOGGER.info("lisatud: "+test);
		return test;
	}
	
	@GetMapping("/{id}")
	public Optional<TestPostgres> findById(@PathVariable("id") Long id) {
		LOGGER.info("Postgres find: id={}", id);
		return posrepository.findById(id);
	}

/*	@GetMapping("/del/{id}")
	public boolean deleteById(@PathVariable("id") Long id) {
		LOGGER.info("Postgres find: id={}", id);
		return posrepository.deleteById(id);
	}
*/
	@GetMapping("/")
	public List<TestPostgres> findAll() {
		LOGGER.info("Postgres find");
		LOGGER.info("kokku: "+posrepository.findAll().size());
		return posrepository.findAll();
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
