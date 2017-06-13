package dao;


import dao.interfaces.*;
import entity.HeatExpn;

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
    @Inject
    private PzElDao pzElDao;
    @Inject
    private ConstSelDao constSelDao;
    @Inject
    private CuryTablDao curyTablDao;
    @Inject
    private DielectrDao dielectrDao;
    @Inject
    private HardTablDao hardTablDao;
    @Inject
    private SuspDao suspDao;
    @Inject
    private HeatExpnDao heatExpnDao;
    @Inject
    private PlavTablDao plavTablDao;
    @Inject
    private ElemTablDao elemTablDao;
    @Inject
    private RefrcIndDao refrcIndDao;
    @Inject
    private DielDissDao dielDissDao;
    @Inject
    private Elastic1Dao elastic1Dao;
    @Inject
    private ElOpTablDao elOpTablDao;
    @Inject
    private EsOpTablDao esOpTablDao;
    @Inject
    private MechTablDao mechTablDao;
    @Inject
    private MNOpTablDao mNOpTablDao;
    @Inject
    private NlOpTablDao nlOpTablDao;
    @Inject
    private WavepureDao wavepureDao;
    @Inject
    private DecrTablDao decrTablDao;
    @Inject
    private SingTablDao singTablDao;

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

    @Override
    public PzElDao getPzElDao() {
        return pzElDao;
    }

    @Override
    public ConstSelDao getConstSelDao() {
        return constSelDao;
    }

    @Override
    public CuryTablDao getCuryTablDao() {
        return curyTablDao;
    }

    @Override
    public DielectrDao getDielectrDao() {
        return dielectrDao;
    }

    @Override
    public HardTablDao getHardTablDao() {
        return hardTablDao;
    }

    @Override
    public HeatExpnDao getHeatExpnDao() {
        return heatExpnDao;
    }

    @Override
    public PlavTablDao getPlavTablDao() {
        return plavTablDao;
    }

    @Override
    public SuspDao getSuspDao() {
        return suspDao;
    }

    @Override
    public ElemTablDao getElemTablDao() {
        return elemTablDao;
    }

    @Override
    public RefrcIndDao getRefrcIndDao() {
        return refrcIndDao;
    }

    @Override
    public DielDissDao getDielDissDao() {
        return dielDissDao;
    }

    @Override
    public Elastic1Dao getElastic1Dao() {
        return elastic1Dao;
    }

    @Override
    public ElOpTablDao getElOpTablDao() {
        return elOpTablDao;
    }

    @Override
    public EsOpTablDao getEsOpTablDao() {
        return esOpTablDao;
    }

    @Override
    public MechTablDao getMechTablDao() {
        return mechTablDao;
    }

    @Override
    public MNOpTablDao getMNOpTablDao() {
        return mNOpTablDao;
    }

    @Override
    public NlOpTablDao getNlOpTablDao() {
        return nlOpTablDao;
    }

    @Override
    public WavepureDao getWavepureDao() {
        return wavepureDao;
    }

    @Override
    public SingTablDao getSingTablDao() {
        return singTablDao;
    }

    @Override
    public DecrTablDao getDecrTablDao() {
        return decrTablDao;
    }
}
