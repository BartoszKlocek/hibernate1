package io.mbab.sda.sdajpa17.repository;

import io.mbab.sda.sdajpa17.entity.Position;
import io.mbab.sda.sdajpa17.entity.Project;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProjectRepository implements CustomCrudRepository<Project, Long> {

    private EntityManager em;

    public ProjectRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Project> findAll() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Project> query = criteriaBuilder.createQuery(Project.class);
        Root<Project> from = query.from(Project.class);
        return em.createQuery(query.select(from))
                .getResultList();
    }

    @Override
    public Project findById(Long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Project> query = criteriaBuilder.createQuery(Project.class);
        Root<Project> from = query.from(Project.class);

        return em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get("id"), id))).getSingleResult();
    }

    public List<String> findAllNames(){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Path<String> from = query.from(Project.class).get("name");

        return em.createQuery(query.select(from)).getResultList();
    }

    public List<Project> findByName(String value) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Project> query = criteriaBuilder.createQuery(Project.class);
        Root<Project> from = query.from(Project.class);

        return em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.like(from.get("name"), "%" + value + "%")))
                .getResultList();
    }

    @Override
    @Transactional
    public Project create(Project obj) {
        em.persist(obj);
        return obj;
    }

    @Override
    @Transactional
    public Project update(Project obj) {
        return em.merge(obj);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        em.createQuery("DELETE FROM Project WHERE id= :id")
                .setParameter("id", id)
                .executeUpdate();

    }
}
