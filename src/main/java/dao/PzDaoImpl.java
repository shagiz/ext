package dao;

import dao.interfaces.PzElDao;
import entity.PzEl;

import javax.ejb.Stateless;

@Stateless
public class PzDaoImpl extends GenericDaoImpl<PzEl> implements PzElDao {
}
