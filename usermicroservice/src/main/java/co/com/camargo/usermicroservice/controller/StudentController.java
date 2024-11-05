package co.com.camargo.usermicroservice.controller;

import co.com.camargo.usermicroservice.models.entity.Student;
import co.com.camargo.usermicroservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Student student) {
        if (student.getName() == null || student.getLastName() == null || student.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }
        Student dbStudent = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(dbStudent);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(Student student) {
        Optional<Student> ob = studentService.findById(student.getId());
        if (ob.isPresent()) {
            Student dbStudent = ob.get();

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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
