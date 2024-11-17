package co.com.camargo.coursesmicroservice.controller;

import co.com.camargo.coursesmicroservice.models.entity.Course;
import co.com.camargo.coursesmicroservice.service.CourseService;
import co.com.camargo.entitycommon.models.entity.Student;
import co.com.camargo.libr.controller.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController extends CommonController<Course, CourseService> {

    private final CourseService courseService;

    public CourseController(CourseService service) {
        super(service);
        this.courseService = service;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Course course) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Course ID must not be null");
        }

        Optional<Course> ob = courseService.findById(id);
        if (ob.isPresent()) {
            Course dbCourse = ob.get();

            // Actualiza los campos necesarios
            if (course.getName() != null) {
                dbCourse.setName(course.getName());
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(dbCourse));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}/add-student")
    public ResponseEntity<?> addStudent(@RequestBody List<Student> students, @PathVariable Long id) {
        Optional<Course> ob = courseService.findById(id);
        if (ob.isPresent()) {
            Course dbCourse = ob.get();
            students.forEach(dbCourse::addStudent);
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(dbCourse));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/remove-student")
    public ResponseEntity<?> removeStudent(@RequestBody Student student, @PathVariable Long id) {
        Optional<Course> ob = courseService.findById(id);
        if (ob.isPresent()) {
            Course dbCourse = ob.get();
            dbCourse.removeStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(dbCourse));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
