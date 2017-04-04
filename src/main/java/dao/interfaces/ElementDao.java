package dao.interfaces;

import entity.Element;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by shagi on 04.04.2017.
 */
@Local
public interface ElementDao extends GenericDao<Element> {
}
