package io.mbab.sda.sdajpa17.repository;

// metody do odczytu zapisu danych

import io.mbab.sda.sdajpa17.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import java.util.List;


@Repository //oznaczamy te klasy ktore odpowiadaj za dostep do bazy danych (mozna tez @Component)

//public class PositionRepository implements CustomCrudRepository<Position, Long> {

public class PositionRepository extends AbstractCustomCrudRepository<Position, Long> {

    //@Autowired
    //private EntityManager em; // obiekt zarzadzany przez springa


    //public PositionRepository(EntityManager em) { // wstrzykiwanie zaleznosci
    //    this.em = em;


    public PositionRepository(EntityManager em){
        super(em,Position.class);
    }




    public List<String> findAllNames() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Path<String> from = query.from(Position.class).get("name");

        return em.createQuery(query.select(from))
                .getResultList();
    }


    public List<Position> findByName(String value) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Position> query = criteriaBuilder.createQuery(Position.class);
        Root<Position> from = query.from(Position.class);

        return em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.like(from.get("name"), "%" + value + "%")))
                .getResultList();
    }




/*
    @Override // wazne roznice pomiedzzy persist() i merge()
    @Transactional// rolbacki etc. Wazne
    public Position create(Position obj) {
        //Position updated = em.merge(obj); // gdy aktualizujemy
        //updated.setName("test"); //zarzadzalny przez  context hibernate
        //obj.setName("test"); // nie zarzadzany przez context hibernate


        em.persist(obj); // gdy chcemy dodac nowy obiekt, obiekt jest zarzadzny przez hibernate
        //obj.setName("test");
        return obj;
    }

    @Override
    @Transactional// rolbacki etc. Wazne
    public Position update(Position obj) {

        return em.merge(obj);
    }

 */
// ta metoda nie dziala z frontu
    // @Override
    //@Transactional
    //public void delete(Position obj) {
    //    em.remove(obj);
    //}

}
