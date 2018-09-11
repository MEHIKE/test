package eu.babywatcher.services.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import eu.babywatcher.services.test.model.repo.MyTestRepository;
import eu.babywatcher.services.test.mongo.domain.MyTest;
import eu.babywatcher.services.test.postgres.domain.TestPostgres;
import eu.babywatcher.services.test.postgres.repo.PostgresRepository;
import eu.babywatcher.services.test.postgres2.domain.TestPostgres2;
import eu.babywatcher.services.test.postgres2.repo.Postgres2Repository;
//import eu.babywatcher.services.test.repository.EmployeeRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableMongoRepositories
@EnableSwagger2
public class MyTestApplication {

	@Autowired
	MyTestRepository repository;

	@Autowired
	PostgresRepository posrepository;

	@Autowired
	Postgres2Repository pos2repository;

	private static final Logger LOGGER = LoggerFactory.getLogger(MyTestApplication.class);

	
	public static void main(String[] args) {
		String kubeSvcHost, kubeSvcPort;
		if ((kubeSvcHost = System.getenv("KUBERNETES_SERVICE_HOST")) != null &&
		(kubeSvcPort = System.getenv("KUBERNETES_SERVICE_PORT_HTTPS")) != null) {
		System.setProperty("kubernetes.master", kubeSvcHost + ":" + kubeSvcPort);
		}
		SpringApplication.run(MyTestApplication.class, args);
	}

/*	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("eu.babywatcher.services.test.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("MyTest API").description("Documentation MyTest API v1.0").build());
	}
	*/

	@Bean
	public Docket swaggerPersonApi10() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("eu.babywatcher.services.test.controller"))
					.paths(PathSelectors.any())
				.build()
				.apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").description("Documentation Employee API v1.0").build());
	}
	
	@Bean
	MyTestRepository repository() {
		//MyTestRepositoryImpl repository = new MyTestRepositoryImpl();
		repository.add(new MyTest(1L, 1L, "John Smith", 34, "Analyst"));
		repository.add(new MyTest(1L, 1L, "Darren Hamilton", 37, "Manager"));
		repository.add(new MyTest(1L, 1L, "Tom Scott", 26, "Developer"));
		repository.add(new MyTest(1L, 2L, "Anna London", 39, "Analyst"));		
		repository.add(new MyTest(2L, 2L, "Patrick Dempsey", 27, "Developer"));
		repository.add(new MyTest(2L, 3L, "Kevin Price", 38, "Developer"));		
		repository.add(new MyTest(2L, 3L, "Ian Scott", 34, "Developer"));
		repository.add(new MyTest(2L, 3L, "Andrew Campton", 30, "Manager"));
		repository.add(new MyTest(2L, 4L, "Steve Franklin", 25, "Developer"));
		repository.add(new MyTest(2L, 4L, "Elisabeth Smith", 30, "Developer"));
		LOGGER.info("lisatud: mongo 10tk");
		return repository;
	}
	
	@Bean
	PostgresRepository posrepository() {
		//MyTestRepositoryImpl repository = new MyTestRepositoryImpl();
		posrepository.add(new TestPostgres("John Smith"));
		posrepository.add(new TestPostgres("Darren Hamilton"));
		posrepository.add(new TestPostgres("Tom Scott"));
		posrepository.add(new TestPostgres("Anna London"));		
		posrepository.add(new TestPostgres("Patrick Dempsey"));
		posrepository.add(new TestPostgres("Kevin Price"));		
		posrepository.add(new TestPostgres("Ian Scott"));
		posrepository.add(new TestPostgres("Andrew Campton"));
		posrepository.add(new TestPostgres("Steve Franklin"));
		posrepository.add(new TestPostgres("Elisabeth Smith"));
		LOGGER.info("lisatud: postgres 10tk");
		return posrepository;
	}

	@Bean
	Postgres2Repository pos2repository() {
		//MyTestRepositoryImpl repository = new MyTestRepositoryImpl();
		pos2repository.add(new TestPostgres2("John Smith"));
		pos2repository.add(new TestPostgres2("Darren Hamilton"));
		pos2repository.add(new TestPostgres2("Tom Scott"));
		pos2repository.add(new TestPostgres2("Anna London"));		
		pos2repository.add(new TestPostgres2("Patrick Dempsey"));
		pos2repository.add(new TestPostgres2("Kevin Price"));		
		pos2repository.add(new TestPostgres2("Ian Scott"));
		pos2repository.add(new TestPostgres2("Andrew Campton"));
		pos2repository.add(new TestPostgres2("Steve Franklin"));
		pos2repository.add(new TestPostgres2("Elisabeth Smith"));
		LOGGER.info("lisatud: postgres2 10tk");
		return pos2repository;
	}

}
