package dao;

import dao.interfaces.DecrTablDao;
import entity.DecrTabl;

import javax.ejb.Stateless;

@Stateless
public class DecrTablDaoImpl extends GenericDaoImpl<DecrTabl> implements DecrTablDao {
}
