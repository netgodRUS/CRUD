package org.example.crud.service;



import org.example.crud.entity.MyEntity;
import org.example.crud.repository.MyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntityService {

    @Autowired
    private MyEntityRepository repository;

    public MyEntity create(MyEntity entity) {
        return repository.save(entity);
    }

    public MyEntity getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<MyEntity> getAll() {
        return repository.findAll();
    }

    public MyEntity update(Long id, MyEntity entityDetails) {
        MyEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setName(entityDetails.getName());
            entity.setDescription(entityDetails.getDescription());
            return repository.save(entity);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

