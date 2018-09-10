package eu.babywatcher.services.test.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import eu.babywatcher.services.test.model.MyTest;

public class MyTestRepositoryImpl {

	private List<MyTest> employees = new ArrayList<>();
	
	public MyTest add(MyTest employee) {
		employee.setId((long) (employees.size()+1));
		employees.add(employee);
		return employee;
	}
	
	public MyTest findById(Long id) {
		Optional<MyTest> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employee.get();
		else
			return null;
	}
	
	public boolean deleteById(Long id) {
		Optional<MyTest> employee = employees.stream().filter(a -> a.getId().equals(id)).findFirst();
		if (employee.isPresent())
			return employees.remove(employee.get());
		else
			return false;
	}
	
	public List<MyTest> findAll() {
		return employees;
	}


	/*public List<MyTest> findByDepartment(Long departmentId) {
		return employees.stream().filter(a -> a.getDepartmentId().equals(departmentId)).collect(Collectors.toList());
	}
	
	public List<MyTest> findByOrganization(Long organizationId) {
		return employees.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
	}*/
	
}
