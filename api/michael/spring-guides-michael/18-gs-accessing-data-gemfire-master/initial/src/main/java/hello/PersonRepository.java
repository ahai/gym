package hello;

import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Peron, String> {

  @Trace
  Peron findByName(String name);

  @Trace
  Iterable<Peron> findByAgeGreaterThan(int age);

  @Trace
  Iterable<Peron> findByAgeLessThan(int age);

  @Trace
  Iterable<Peron> findByAgeGreaterThanAndAgeLessThan(int greaterThanAge, int lessThanAge);

}