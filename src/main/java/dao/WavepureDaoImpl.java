package dao;

import dao.interfaces.WavepureDao;
import entity.Wavepure;

import javax.ejb.Stateless;

@Stateless
public class WavepureDaoImpl extends GenericDaoImpl<Wavepure> implements WavepureDao {
}
