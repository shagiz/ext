package dao;

import dao.interfaces.HardTablDao;
import entity.HardTabl;

import javax.ejb.Stateless;

@Stateless
public class HardTablDaoImpl extends GenericDaoImpl<HardTabl> implements HardTablDao {
}
