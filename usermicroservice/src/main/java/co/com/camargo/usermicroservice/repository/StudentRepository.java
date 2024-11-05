package co.com.camargo.usermicroservice.repository;

import co.com.camargo.usermicroservice.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
