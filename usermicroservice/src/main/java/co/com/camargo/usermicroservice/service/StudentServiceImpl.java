package co.com.camargo.usermicroservice.service;

import co.com.camargo.usermicroservice.models.entity.Student;
import co.com.camargo.usermicroservice.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository dao;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.dao = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return dao.save(student);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
