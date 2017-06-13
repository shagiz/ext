package dao.interfaces;

import dto.Sort;

import java.util.List;

public interface GenericDao<E> {
    E create(E t);

    void delete(int id);

    E find(int id);

    List<E> findAll();

    List<E> findAll(int page, int start, int limit, Sort sort, Integer headClue);

    Long count(Integer headClue);

    E update(E t);
}
