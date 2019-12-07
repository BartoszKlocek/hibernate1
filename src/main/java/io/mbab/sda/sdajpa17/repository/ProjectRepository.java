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
//public class ProjectRepository implements CustomCrudRepository<Project, Long> {
public class ProjectRepository extends AbstractCustomCrudRepository<Project, Long> {

    private EntityManager em;

    public ProjectRepository(EntityManager em) {
        super(em, Project.class);
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

}
