package co.com.camargo.usermicroservice.repository;

import co.com.camargo.entitycommon.models.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
