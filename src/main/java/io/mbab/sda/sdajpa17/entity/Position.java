package io.mbab.sda.sdajpa17.entity;

import io.mbab.sda.sdajpa17.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Position extends AbstractEntity<Long> {


    @Column(unique = true,nullable = false, length = 64)
    private String name;

    //Jezeli dodajemy konsturktory wlasny to musimy tez dodac


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public void setVersion(Long version) { usuwamy, bo nie zmieniamy tej wersji recznie!
    //    this.version = version;
    //}



    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }



}
