package co.com.camargo.usermicroservice.controller;

import co.com.camargo.entitycommon.models.entity.Student;
import co.com.camargo.libr.controller.CommonController;
import co.com.camargo.usermicroservice.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController extends CommonController<Student, StudentService> {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }

    @Value("config.balancer.test")
    private String testBalancer;


    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Student student) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Student ID must not be null");
        }

        Optional<Student> ob = studentService.findById(id);
        if (ob.isPresent()) {
            Student dbStudent = ob.get();

            // Actualiza los campos necesarios
            if (student.getName() != null) {
                dbStudent.setName(student.getName());
            }
            if (student.getLastName() != null) {
                dbStudent.setLastName(student.getLastName());
            }
            if (student.getEmail() != null) {
                dbStudent.setEmail(student.getEmail());
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(dbStudent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //    Balancer test
    @GetMapping("/balancer-test")
    public ResponseEntity<?> testBalancer() {
        Map<String, Object> response = new HashMap<String, Object> ();
        response.put("testBalancer", testBalancer);
        response.put("student", studentService.findAll());
        return ResponseEntity.ok(response);
    }

}
