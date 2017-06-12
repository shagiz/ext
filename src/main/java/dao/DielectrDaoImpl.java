package dao;

import dao.interfaces.DielectrDao;
import entity.Dielectr;

import javax.ejb.Stateless;

@Stateless
public class DielectrDaoImpl extends GenericDaoImpl<Dielectr> implements DielectrDao {
}
