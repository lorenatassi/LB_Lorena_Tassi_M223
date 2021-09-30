package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.JiraStat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class JiraStatService {
    @Inject
    private EntityManager entityManager;

    public JiraStatService(){

    }

    @Transactional
    public JiraStat createJiraStat(JiraStat jiraStat){
        entityManager.persist(jiraStat);
        return jiraStat;
    }

    @Transactional
    public void delJiraStatObj(JiraStat jiraStat){
        entityManager.remove(jiraStat);
    }

    @Transactional
    public void delJiraStatId(Long id){
        JiraStat jiraStat = entityManager.find(JiraStat.class, id);
        entityManager.remove(jiraStat);
    }

    public List<JiraStat> findAll(){
        var query = entityManager.createQuery("FROM jirastat");
        return query.getResultList();
    }

    public JiraStat getJira(Long id){
        return entityManager.find(JiraStat.class,id);
    }

    @Transactional
    public JiraStat updateJira(JiraStat jiraStat) {
        return entityManager.merge(jiraStat);
    }
}
