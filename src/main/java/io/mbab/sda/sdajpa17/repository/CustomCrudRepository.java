package io.mbab.sda.sdajpa17.repository;

import com.sun.xml.bind.v2.model.core.ID;

import java.util.List;

public interface CustomCrudRepository<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T create(T obj);
    T update(T obj);
    void deleteById(ID id);
}