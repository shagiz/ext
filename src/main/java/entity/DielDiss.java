package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "DielDiss")
public class DielDiss extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония", fieldLength = 2)
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Частота, МГц", fieldLength = 24)
    @Column(name = "FreqDiss")
    private BigDecimal freqDiss;

    @ColumnProperty(name = "Температура, K", fieldLength = 16)
    @Column(name = "Temper_3")
    private BigDecimal temper3;

    @ColumnProperty(name = "Обозначение тангенса угла потерь", fieldLength = 25)
    @Column(name = "TangName")
    private String tangName;

    @ColumnProperty(name = "Значение тангенса угла", fieldLength = 20)
    @Column(name = "TangentD")
    private BigDecimal tangentD;

    @ColumnProperty(name = "Погрешность", fieldLength = 20)
    @Column(name = "ErrDiss")
    private BigDecimal errDiss;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodY")
    private String methodY;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getFreqDiss() {
        return freqDiss;
    }

    public void setFreqDiss(BigDecimal freqDiss) {
        this.freqDiss = freqDiss;
    }

    public BigDecimal getTemper3() {
        return temper3;
    }

    public void setTemper3(BigDecimal temper3) {
        this.temper3 = temper3;
    }

    public String getTangName() {
        return tangName;
    }

    public void setTangName(String tangName) {
        this.tangName = tangName;
    }

    public BigDecimal getTangentD() {
        return tangentD;
    }

    public void setTangentD(BigDecimal tangentD) {
        this.tangentD = tangentD;
    }

    public BigDecimal getErrDiss() {
        return errDiss;
    }

    public void setErrDiss(BigDecimal errDiss) {
        this.errDiss = errDiss;
    }

    public String getMethodY() {
        return methodY;
    }

    public void setMethodY(String methodY) {
        this.methodY = methodY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DielDiss dielDiss = (DielDiss) o;

        if (singCode != null ? !singCode.equals(dielDiss.singCode) : dielDiss.singCode != null) return false;
        if (freqDiss != null ? !freqDiss.equals(dielDiss.freqDiss) : dielDiss.freqDiss != null) return false;
        if (temper3 != null ? !temper3.equals(dielDiss.temper3) : dielDiss.temper3 != null) return false;
        if (tangName != null ? !tangName.equals(dielDiss.tangName) : dielDiss.tangName != null) return false;
        if (tangentD != null ? !tangentD.equals(dielDiss.tangentD) : dielDiss.tangentD != null) return false;
        if (errDiss != null ? !errDiss.equals(dielDiss.errDiss) : dielDiss.errDiss != null) return false;
        return methodY != null ? methodY.equals(dielDiss.methodY) : dielDiss.methodY == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (freqDiss != null ? freqDiss.hashCode() : 0);
        result = 31 * result + (temper3 != null ? temper3.hashCode() : 0);
        result = 31 * result + (tangName != null ? tangName.hashCode() : 0);
        result = 31 * result + (tangentD != null ? tangentD.hashCode() : 0);
        result = 31 * result + (errDiss != null ? errDiss.hashCode() : 0);
        result = 31 * result + (methodY != null ? methodY.hashCode() : 0);
        return result;
    }
}
