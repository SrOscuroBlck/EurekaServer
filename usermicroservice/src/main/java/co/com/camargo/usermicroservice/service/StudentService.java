package co.com.camargo.usermicroservice.service;

import co.com.camargo.entitycommon.models.entity.Student;
import co.com.camargo.libr.service.CommonService;
import org.springframework.stereotype.Service;

public interface StudentService extends CommonService<Student> {
    public Student save(Student student);
    public void deleteById(Long id);
}
