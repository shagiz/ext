package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "RefrcInd")
public class RefrcInd extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Температура, K")
    @Column(name = "Temper")
    private BigDecimal temper;

    @ColumnProperty(name = "Длина волны, мкм")
    @Column(name = "WaveLeng")
    private BigDecimal waveLeng;

    @ColumnProperty(name = "Обозначение показателя")
    @Column(name = "NazbIndx")
    private String nazbIndx;

    @ColumnProperty(name = "Значение показателя")
    @Column(name = "ZnachInd")
    private BigDecimal znachInd;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrIndex")
    private BigDecimal errIndex;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodIn")
    private String methodIn;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getTemper() {
        return temper;
    }

    public void setTemper(BigDecimal temper) {
        this.temper = temper;
    }

    public BigDecimal getWaveLeng() {
        return waveLeng;
    }

    public void setWaveLeng(BigDecimal waveLeng) {
        this.waveLeng = waveLeng;
    }

    public String getNazbIndx() {
        return nazbIndx;
    }

    public void setNazbIndx(String nazbIndx) {
        this.nazbIndx = nazbIndx;
    }

    public BigDecimal getZnachInd() {
        return znachInd;
    }

    public void setZnachInd(BigDecimal znachInd) {
        this.znachInd = znachInd;
    }

    public BigDecimal getErrIndex() {
        return errIndex;
    }

    public void setErrIndex(BigDecimal errIndex) {
        this.errIndex = errIndex;
    }

    public String getMethodIn() {
        return methodIn;
    }

    public void setMethodIn(String methodIn) {
        this.methodIn = methodIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RefrcInd refrcInd = (RefrcInd) o;

        if (singCode != null ? !singCode.equals(refrcInd.singCode) : refrcInd.singCode != null) return false;
        if (temper != null ? !temper.equals(refrcInd.temper) : refrcInd.temper != null) return false;
        if (waveLeng != null ? !waveLeng.equals(refrcInd.waveLeng) : refrcInd.waveLeng != null) return false;
        if (nazbIndx != null ? !nazbIndx.equals(refrcInd.nazbIndx) : refrcInd.nazbIndx != null) return false;
        if (znachInd != null ? !znachInd.equals(refrcInd.znachInd) : refrcInd.znachInd != null) return false;
        if (errIndex != null ? !errIndex.equals(refrcInd.errIndex) : refrcInd.errIndex != null) return false;
        return methodIn != null ? methodIn.equals(refrcInd.methodIn) : refrcInd.methodIn == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (temper != null ? temper.hashCode() : 0);
        result = 31 * result + (waveLeng != null ? waveLeng.hashCode() : 0);
        result = 31 * result + (nazbIndx != null ? nazbIndx.hashCode() : 0);
        result = 31 * result + (znachInd != null ? znachInd.hashCode() : 0);
        result = 31 * result + (errIndex != null ? errIndex.hashCode() : 0);
        result = 31 * result + (methodIn != null ? methodIn.hashCode() : 0);
        return result;
    }
}
