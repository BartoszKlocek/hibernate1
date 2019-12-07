package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Position;
import io.mbab.sda.sdajpa17.repository.CustomCrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T, ID> {

    private CustomCrudRepository<T, ID> crudRepository;

    public AbstractController(CustomCrudRepository<T, ID> crudRepository) {
        this.crudRepository = crudRepository;
    }

    @GetMapping
    List<T> findAll() {
        return crudRepository.findAll();
    }

    @GetMapping("/{id}")
    public T findById(@PathVariable ID id) {

        return crudRepository.findById(id);
    }

    @PostMapping
    public T create(@RequestBody T obj) {
        return crudRepository.create(obj);
    }

    @PutMapping
    public T update(@RequestBody T obj) {

        return crudRepository.update(obj);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {

        crudRepository.deleteById(id);
    }

}
