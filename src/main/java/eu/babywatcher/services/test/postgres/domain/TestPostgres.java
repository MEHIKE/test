package eu.babywatcher.services.test.postgres.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name = "Post")
@Table(name = "uus")
@EqualsAndHashCode
@ToString
@Data
public class TestPostgres {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)//, generator="bar_id_seq")
	  //@SequenceGenerator(name="bar_id_seq", sequenceName="bar_id_seq", allocationSize=1)
	  @Column(name = "ID")
	  private Long id;

	  @NotNull
	  @Column(name = "postgres")
	  private String postgres;

	  public TestPostgres(String postgres) {
	    this.postgres = postgres;
	  }

	  TestPostgres() {
	    // Default constructor needed by JPA
	  }

	  public String getPostgres() {
	    return postgres;
	  } 
}
