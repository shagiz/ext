package dao.interfaces;

import dto.Sort;
import entity.Biblio;

import javax.ejb.Local;
import java.util.List;

@Local
public interface BiblioDao extends GenericDao<Biblio> {
    List<Biblio> findAllByBk(int page, int start, int limit, int bkNumber);
}
