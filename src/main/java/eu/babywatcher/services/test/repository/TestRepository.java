package eu.babywatcher.services.test.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eu.babywatcher.services.test.model.Test;

public interface TestRepository extends MongoRepository<Test, String> {

    public Test add(Test test);
	public Test findById(Long id);
    public boolean deleteById(Long id);
    public List<Test> findAll();
    

} 