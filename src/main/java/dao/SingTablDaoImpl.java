package dao;

import dao.interfaces.SingTablDao;
import entity.SingTabl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SingTablDaoImpl implements SingTablDao {
    protected EntityManager em = Persistence.createEntityManagerFactory("MyPersist").createEntityManager();

    @Override
    public List<SingTabl> findForHeadClue(int headClue) {
        final String queryString = "select s from SingTabl s where s.headClue = :headClue";
        Query query = em.createQuery(queryString);
        query.setParameter("headClue", headClue);
        return (List<SingTabl>) query.getResultList();
    }
}
