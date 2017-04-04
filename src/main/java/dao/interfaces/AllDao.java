package dao.interfaces;

import javax.ejb.Local;

@Local
public interface AllDao {
    AcopDao getAcopDao();

    DensityDao getDensityDao();

    SistDao getSistDao();

    HeatDao getHeatDao();

    BiblioDao getBiblioDao();

    ElementDao getElementDao();
}
