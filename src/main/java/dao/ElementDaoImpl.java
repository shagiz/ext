package dao;

import dao.interfaces.ElementDao;
import entity.Element;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by shagi on 04.04.2017.
 */
@Stateless
public class ElementDaoImpl extends GenericDaoImpl<Element> implements ElementDao {
}
