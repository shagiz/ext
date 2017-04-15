package dao;

import dao.interfaces.ElementDao;
import dto.Filter;
import dto.Sort;
import entity.Element;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by shagi on 04.04.2017.
 */
@Stateless
public class ElementDaoImpl extends GenericDaoImpl<Element> implements ElementDao {
    @Override
    public List<Element> findAll(int page, int start, int limit, Sort sorts, Filter filter) {
        final StringBuffer queryString = new StringBuffer(
                "SELECT o from ");

        queryString.append(type.getSimpleName()).append(" o ");

        if (filter != null) {
            queryString
                    .append("WHERE o.")
                    .append(filter.getProperty())
                    .append(" ")
                    .append(filter.getOperator())
                    .append(" '%")
                    .append(filter.getValue())
                    .append("%' ");
        }
        if (sorts != null) {
            queryString
                    .append("order by o.")
                    .append(sorts.getProperty())
                    .append(" ")
                    .append(sorts.getDirection());
        } else {
            queryString.append("order by o.id");
        }

        final Query query = this.em.createQuery(queryString.toString());

        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);

        return (List<Element>) query.getResultList();
    }
}
