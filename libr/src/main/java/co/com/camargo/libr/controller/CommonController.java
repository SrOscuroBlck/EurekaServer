package co.com.camargo.libr.controller;

import co.com.camargo.libr.service.CommonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonController<E, S extends CommonService<E>> {
    private final S service;

    public CommonController(S service) {
        this.service = service;
    }

    @Value("config.balancer.test")
    private String testBalancer;

    //    Balancer test
    @GetMapping("/balancer-test")
    public ResponseEntity<?> testBalancer() {
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("testBalancer", testBalancer);
        response.put("student", service.findAll());
        return ResponseEntity.ok(response);
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
