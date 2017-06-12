package dao;

import dao.interfaces.PlavTablDao;
import entity.PlavTabl;

import javax.ejb.Stateless;

@Stateless
public class PlavTablDaoImpl extends GenericDaoImpl<PlavTabl> implements PlavTablDao {
}
