package dao;

import dao.interfaces.MechTablDao;
import entity.MechTabl;

import javax.ejb.Stateless;

@Stateless
public class MechTablDaoImpl extends GenericDaoImpl<MechTabl> implements MechTablDao {
}
