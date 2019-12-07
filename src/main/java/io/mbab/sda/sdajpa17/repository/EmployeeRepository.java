package io.mbab.sda.sdajpa17.repository;

import io.mbab.sda.sdajpa17.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class EmployeeRepository extends AbstractCustomCrudRepository<Employee, Long> {
    public EmployeeRepository(EntityManager em) {
        super(em, Employee.class);
    }
}
