package dao;

import dao.interfaces.SuspDao;
import entity.SuspTabl;

import javax.ejb.Stateless;

@Stateless
public class SuspDaoImpl extends GenericDaoImpl<SuspTabl> implements SuspDao {
}
