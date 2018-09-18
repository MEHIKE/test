package eu.babywatcher.services.test.model.repo;

import java.util.List;

//import org.springframework.data.mongodb.repository.MongoRepository;

import eu.babywatcher.services.test.mongo.domain.MyTest;

public interface MyTestRepository {// extends MongoRepository<MyTest, String> {

    public MyTest add(MyTest myTest);
	public MyTest findById(Long id);
    public boolean deleteById(Long id);
    public List<MyTest> findAll();
    

} 