package dao;

import dao.interfaces.HeatDao;
import entity.Heat;

import javax.ejb.Stateless;

@Stateless
public class HeatDaoImpl extends GenericDaoImpl<Heat> implements HeatDao {
}
