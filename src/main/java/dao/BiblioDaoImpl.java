package dao;

import dao.interfaces.BiblioDao;
import dto.Sort;
import entity.Biblio;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class BiblioDaoImpl extends GenericDaoImpl<Biblio> implements BiblioDao {

    @Override
    public List<Biblio> findAllByBk(int page, int start, int limit, int bkNumber) {
        String queryString = "select b from Biblio b where b.bknumber= :bkNumber";
        final Query query = this.em.createQuery(queryString);

        query.setParameter("bkNumber", bkNumber);
        query.setFirstResult((page - 1) * limit);
        query.setMaxResults(limit);

        return (List<Biblio>) query.getResultList();
    }
}
