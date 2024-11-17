package co.com.camargo.coursesmicroservice.repository;

import co.com.camargo.coursesmicroservice.models.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
