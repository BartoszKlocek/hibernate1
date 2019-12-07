package io.mbab.sda.sdajpa17.entity;

import io.mbab.sda.sdajpa17.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Employee extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    private Integer age;

    //mapowanie
    @ManyToOne()
    //cascade typow lepiej nie uzywac
    //fetch tyoe eager jest domyslny
    private Position position;

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", position=" + position +
                ", id=" + id +
                ", version=" + version +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
