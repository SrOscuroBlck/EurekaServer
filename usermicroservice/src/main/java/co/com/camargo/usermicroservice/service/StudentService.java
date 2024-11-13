package co.com.camargo.usermicroservice.service;

import co.com.camargo.libr.service.CommonService;
import co.com.camargo.usermicroservice.models.entity.Student;

import java.util.Optional;

public interface StudentService extends CommonService<Student> {
    public Student save(Student student);
    public void deleteById(Long id);
}
