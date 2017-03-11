package dao;

import dao.interfaces.SistDao;
import entity.Sist;

import javax.ejb.Stateless;

@Stateless
public class SistDaoImpl extends GenericDaoImpl<Sist> implements SistDao {
}
