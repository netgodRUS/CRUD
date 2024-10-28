package org.example.crud.controller;



import org.example.crud.entity.MyEntity;
import org.example.crud.service.MyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class MyEntityController {

    @Autowired
    private MyEntityService service;

    @PostMapping
    public ResponseEntity<MyEntity> create(@RequestBody MyEntity entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MyEntity> getById(@PathVariable Long id) {
        MyEntity entity = service.getById(id);
        return entity != null ? ResponseEntity.ok(entity) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public List<MyEntity> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MyEntity> update(@PathVariable Long id, @RequestBody MyEntity entityDetails) {
        MyEntity updatedEntity = service.update(id, entityDetails);
        return updatedEntity != null ? ResponseEntity.ok(updatedEntity) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

