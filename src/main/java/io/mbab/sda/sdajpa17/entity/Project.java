package io.mbab.sda.sdajpa17.entity;


import io.mbab.sda.sdajpa17.AbstractEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Project extends AbstractEntity<Long> {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 31)
    private String type;

    @Column
    private String client;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", client='" + client + '\'' +
                '}';
    }
}
