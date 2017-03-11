package dao;


import dao.interfaces.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AllDaoImpl implements AllDao {
    @Inject
    AcopDao acopDao;
    @Inject
    DensityDao densityDao;
    @Inject
    SistDao sistDao;
    @Inject
    HeatDao heatDao;
    @Inject
    BiblioDao biblioDao;

    @Override
    public AcopDao getAcopDao() {
        return acopDao;
    }

    @Override
    public DensityDao getDensityDao() {
        return densityDao;
    }

    @Override
    public SistDao getSistDao() {
        return sistDao;
    }

    @Override
    public HeatDao getHeatDao() {
        return heatDao;
    }

    @Override
    public BiblioDao getBiblioDao() {
        return biblioDao;
    }
}
