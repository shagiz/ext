package dao;

import dao.interfaces.GenericDao;
import entity.BaseEntity;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDaoImpl<E> implements GenericDao<E> {

    protected EntityManager em = Persistence.createEntityManagerFactory("MyPersist").createEntityManager();

    private Class<E> type;

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
    public List<E> findAll(int page, int start, int limit) {
        final StringBuffer queryString = new StringBuffer(
                "SELECT o from ");

        queryString.append(type.getSimpleName()).append(" o ");
        queryString.append("order by o.id");

        final Query query = this.em.createQuery(queryString.toString());

        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);

        return (List<E>) query.getResultList();
    }

    @Override
    public <T extends BaseEntity> List<T> findAll(String table) {
        return null;
    }

    @Override
    public E update(E e) {
        em.getTransaction().begin();
        E res = this.em.merge(e);
        em.getTransaction().commit();
        return res;
    }
}
