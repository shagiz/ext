package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "MechTabl")
public class MechTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Частота, МГц")
    @Column(name = "FreqCons")
    private BigDecimal freqCons;

    @ColumnProperty(name = "Температура, K")
    @Column(name = "Temper")
    private BigDecimal temper;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "ZnK")
    private String ZnK;

    @ColumnProperty(name = "Значение коэффицента")
    @Column(name = "K")
    private BigDecimal K;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrK")
    private BigDecimal errK;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodK")
    private String methodK;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getFreqCons() {
        return freqCons;
    }

    public void setFreqCons(BigDecimal freqCons) {
        this.freqCons = freqCons;
    }

    public BigDecimal getTemper() {
        return temper;
    }

    public void setTemper(BigDecimal temper) {
        this.temper = temper;
    }

    public String getZnK() {
        return ZnK;
    }

    public void setZnK(String znK) {
        ZnK = znK;
    }

    public BigDecimal getK() {
        return K;
    }

    public void setK(BigDecimal k) {
        K = k;
    }

    public BigDecimal getErrK() {
        return errK;
    }

    public void setErrK(BigDecimal errK) {
        this.errK = errK;
    }

    public String getMethodK() {
        return methodK;
    }

    public void setMethodK(String methodK) {
        this.methodK = methodK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MechTabl mechTabl = (MechTabl) o;

        if (singCode != null ? !singCode.equals(mechTabl.singCode) : mechTabl.singCode != null) return false;
        if (freqCons != null ? !freqCons.equals(mechTabl.freqCons) : mechTabl.freqCons != null) return false;
        if (temper != null ? !temper.equals(mechTabl.temper) : mechTabl.temper != null) return false;
        if (ZnK != null ? !ZnK.equals(mechTabl.ZnK) : mechTabl.ZnK != null) return false;
        if (K != null ? !K.equals(mechTabl.K) : mechTabl.K != null) return false;
        if (errK != null ? !errK.equals(mechTabl.errK) : mechTabl.errK != null) return false;
        return methodK != null ? methodK.equals(mechTabl.methodK) : mechTabl.methodK == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (freqCons != null ? freqCons.hashCode() : 0);
        result = 31 * result + (temper != null ? temper.hashCode() : 0);
        result = 31 * result + (ZnK != null ? ZnK.hashCode() : 0);
        result = 31 * result + (K != null ? K.hashCode() : 0);
        result = 31 * result + (errK != null ? errK.hashCode() : 0);
        result = 31 * result + (methodK != null ? methodK.hashCode() : 0);
        return result;
    }
}
