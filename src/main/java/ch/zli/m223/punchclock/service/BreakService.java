package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Break;
import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BreakService {
    @Inject
    private EntityManager entityManager;

    public BreakService(){

    }

    @Transactional
    public Break createBreak(Break brake){
        entityManager.persist(brake);
        return brake;
    }

    @Transactional
    public void delBreakObj(Break brek){
        entityManager.remove(brek);
    }

    @Transactional
    public void delBreakId(Long id) {
        Break brek = entityManager.find(Break.class, id);
        entityManager.remove(brek);
    }

    @SuppressWarnings("unchecked")
    public List<Break> findAll() {
        var query = entityManager.createQuery("FROM Break");
        return query.getResultList();
    }

    public Break getBreak(Long id){
        return entityManager.find(Break.class, id);
    }

    @Transactional
    public Break updateBreak(Break brek) {
        return entityManager.merge(brek);
    }
}
