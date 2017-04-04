package dao;


import dao.interfaces.*;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AllDaoImpl implements AllDao {
    @Inject
    private AcopDao acopDao;
    @Inject
    private DensityDao densityDao;
    @Inject
    private SistDao sistDao;
    @Inject
    private HeatDao heatDao;
    @Inject
    private BiblioDao biblioDao;
    @Inject
    private ElementDao elementDao;

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

    @Override
    public ElementDao getElementDao() {
        return elementDao;
    }
}
