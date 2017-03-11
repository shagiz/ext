package dao;

import dao.interfaces.DensityDao;
import entity.Density;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class DensityDaoImpl extends GenericDaoImpl<Density> implements DensityDao {
}
