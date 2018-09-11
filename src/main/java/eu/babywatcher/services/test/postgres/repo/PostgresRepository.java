package eu.babywatcher.services.test.postgres.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.babywatcher.services.test.postgres.domain.TestPostgres;


@Repository
public interface PostgresRepository extends JpaRepository<TestPostgres, Long> {

  TestPostgres add(TestPostgres testPostgres);
  List<TestPostgres> findAll();
  Optional<TestPostgres> findById(Long id);

} 