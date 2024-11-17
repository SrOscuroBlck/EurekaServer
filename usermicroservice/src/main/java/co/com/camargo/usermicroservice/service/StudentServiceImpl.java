package co.com.camargo.usermicroservice.service;

import co.com.camargo.entitycommon.models.entity.Student;
import co.com.camargo.libr.service.CommonServiceImpl;
import co.com.camargo.usermicroservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student,StudentRepository> implements StudentService {

    public StudentServiceImpl(StudentRepository studentRepository) {
        super(studentRepository);
    }

}
