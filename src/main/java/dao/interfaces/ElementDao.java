package dao.interfaces;

import dto.Filter;
import dto.Sort;
import entity.Element;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by shagi on 04.04.2017.
 */
@Local
public interface ElementDao extends GenericDao<Element> {
    List<Element> findAll(int page, int start, int limit, Sort sorts, Filter filter);
}
