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

    PzElDao getPzElDao();

    DecrTablDao getDecrTablDao();

    ConstSelDao getConstSelDao();

    CuryTablDao getCuryTablDao();

    DielectrDao getDielectrDao();

    HardTablDao getHardTablDao();

    HeatExpnDao getHeatExpnDao();

    PlavTablDao getPlavTablDao();

    SuspDao getSuspDao();

    ElemTablDao getElemTablDao();

    RefrcIndDao getRefrcIndDao();

    DielDissDao getDielDissDao();

    Elastic1Dao getElastic1Dao();

    ElOpTablDao getElOpTablDao();

    EsOpTablDao getEsOpTablDao();

    MechTablDao getMechTablDao();

    MNOpTablDao getMNOpTablDao();

    NlOpTablDao getNlOpTablDao();

    WavepureDao getWavepureDao();

    SingTablDao getSingTablDao();
}
