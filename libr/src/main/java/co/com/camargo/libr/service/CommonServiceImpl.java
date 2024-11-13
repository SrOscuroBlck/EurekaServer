package co.com.camargo.libr.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class CommonServiceImpl<E, R extends CrudRepository<E,Long>> implements CommonService<E> {

    private final R dao;

    public CommonServiceImpl(R studentRepository) {
        this.dao = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return dao.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        dao.deleteById(id);
    }

}
