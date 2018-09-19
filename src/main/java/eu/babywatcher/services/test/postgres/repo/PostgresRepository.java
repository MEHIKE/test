package eu.babywatcher.services.test.postgres.repo;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.babywatcher.services.test.postgres.domain.TestPostgres;


@Repository
public interface PostgresRepository extends JpaRepository<TestPostgres, Long> {

  @Autowired
  public EntityManager em;

  public TestPostgres saveAndFlush(TestPostgres testPostgres);
  public List<TestPostgres> findAll();
  public Optional<TestPostgres> findById(Long id);
  public void delete(TestPostgres testPostgres);
  //public Optional<TestPostgres> save(TestPostgres testPostgres);

/*  public TestPostgres saveOrUpdate(TestPostgres testPostgres) {
	    
	    if (testPostgres.getId() == null) {
	      em.persist(TestPostgres);
	    } else {
	      em.merge(testPostgres);
	    }
	    
	    return testPosgres;
	  }
  */
} 