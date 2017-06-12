package dao;

import dao.interfaces.HeatExpnDao;
import entity.HeatExpn;

import javax.ejb.Stateless;

@Stateless
public class HeatExpnDaoImpl extends GenericDaoImpl<HeatExpn> implements HeatExpnDao {
}
