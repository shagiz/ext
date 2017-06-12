package dao;

import dao.interfaces.ConstSelDao;
import entity.ConstSel;

import javax.ejb.Stateless;

@Stateless
public class ConstSelDaoImpl extends GenericDaoImpl<ConstSel> implements ConstSelDao {
}
