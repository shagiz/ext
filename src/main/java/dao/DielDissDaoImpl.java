package dao;

import dao.interfaces.DielDissDao;
import entity.DielDiss;

import javax.ejb.Stateless;

@Stateless
public class DielDissDaoImpl extends GenericDaoImpl<DielDiss> implements DielDissDao {
}
