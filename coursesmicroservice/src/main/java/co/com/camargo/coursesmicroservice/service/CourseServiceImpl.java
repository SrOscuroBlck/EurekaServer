package co.com.camargo.coursesmicroservice.service;

import co.com.camargo.coursesmicroservice.models.entity.Course;
import co.com.camargo.coursesmicroservice.repository.CourseRepository;
import co.com.camargo.libr.service.CommonServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CourseService {

    public CourseServiceImpl(CourseRepository courseRepository) {
        super(courseRepository);
    }

}
