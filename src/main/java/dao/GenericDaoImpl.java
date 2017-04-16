package dao;

import dao.interfaces.GenericDao;
import dto.Sort;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDaoImpl<E> implements GenericDao<E> {

    protected EntityManager em = Persistence.createEntityManagerFactory("MyPersist").createEntityManager();

    protected Class<E> type;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public E create(E e) {
        em.getTransaction().begin();
        this.em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    @Override
    public void delete(int id) {
        em.getTransaction().begin();
        this.em.remove(this.em.getReference(type, id));
        em.getTransaction().commit();
    }

    @Override
    public E find(int id) {
        return (E) this.em.find(type, id);
    }

    @Override
    public List<E> findAll() {
        final StringBuffer queryString = new StringBuffer(
                "SELECT o from ");

        queryString.append(type.getSimpleName()).append(" o ");
        queryString.append("order by o.id");

        final Query query = this.em.createQuery(queryString.toString());

        return (List<E>) query.getResultList();
    }

    @Override
    public List<E> findAll(int page, int start, int limit, Sort sort, Integer headClue) {
        final StringBuffer queryString = new StringBuffer(
                "SELECT o from ");

        queryString.append(type.getSimpleName()).append(" o ");

        if (headClue != null) {
            queryString
                    .append("WHERE o.headClue=")
                    .append(headClue)
                    .append(" ");
        }

        if (sort != null) {
            queryString
                    .append("order by o.")
                    .append(sort.getProperty())
                    .append(" ")
                    .append(sort.getDirection());
        } else {
            queryString.append("order by o.id");
        }

        final Query query = this.em.createQuery(queryString.toString());
//        query.setParameter(0, headClue);
        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);

        return (List<E>) query.getResultList();
    }

    @Override
    public E update(E e) {
        em.getTransaction().begin();
        E res = this.em.merge(e);
        em.getTransaction().commit();
        return res;
    }
}
