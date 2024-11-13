package co.com.camargo.libr.controller;

import co.com.camargo.libr.service.CommonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

public class CommonController<E, S extends CommonService<E>> {
    private final S service;

    public CommonController(S service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<E> entity = service.findById(id);
        if (entity.isPresent()) {
            return ResponseEntity.ok(entity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody E entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entity));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
