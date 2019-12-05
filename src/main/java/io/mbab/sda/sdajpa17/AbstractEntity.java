package io.mbab.sda.sdajpa17;

import io.mbab.sda.sdajpa17.entity.Position;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class AbstractEntity<ID> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoinkrementacja - identity
    protected ID id;

    @Version
    protected Long version =0L;

    @Transient // pole ktore istnieje tylko w obiekcie, nie istnieje w bazie danych
    private UUID uuid = UUID.randomUUID(); //na tym opierany jest id, bo id jest tworzony w bazie wiec nie mozemy uzyc id. A uuid jest generowany


    public ID getId() {
        return id;
    }

    //public void setId(ID id) {
    //    this.id = id;
    //}

    public Long getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
