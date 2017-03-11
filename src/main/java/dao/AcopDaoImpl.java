package dao;

import dao.interfaces.AcopDao;
import entity.Acop;

import javax.ejb.Stateless;

@Stateless
public class AcopDaoImpl extends GenericDaoImpl<Acop> implements AcopDao{
}
