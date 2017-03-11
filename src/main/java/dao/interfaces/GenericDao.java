package dao.interfaces;

import entity.BaseEntity;

import java.util.List;

public interface GenericDao<E> {
    E create(E t);

    void delete(int id);

    E find(int id);

    List<E> findAll();

    List<E> findAll(int page, int start, int limit);

    <T extends BaseEntity> List<T> findAll(String table);

    E update(E t);
}
