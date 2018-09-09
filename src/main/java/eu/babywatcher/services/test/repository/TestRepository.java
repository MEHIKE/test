package eu.babywatcher.services.test.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import eu.babywatcher.services.test.model.Test;

public class TestRepository {

	private List<Test> employees = new ArrayList<>();
	
	public Test add(Test employee) {
		employee.setId((long) (employees.size()+1));
		employees.add(employee);
		return employee;
	}
	
	public Test findById(Long id) {
		Optional<Test> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}
	
	public boolean deleteById(Long id) {
		Optional<Test> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employees.remove(employee.get());
		else
			return false;
	}
	
	public List<Test> findAll() {
		return employees;
	}
	
	public List<Test> findByDepartment(Long departmentId) {
		return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
	}
	
	public List<Test> findByOrganization(Long organizationId) {
		return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
	}
	
}
