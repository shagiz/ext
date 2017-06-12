package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "SuspTabl")
public class SuspTabl extends BaseEntity {

    @ColumnName(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnName(name = "Температура, K")
    @Column(name = "Temper")
    private BigDecimal temper;

    @ColumnName(name = "Растворитель")
    @Column(name = "SuspName")
    private String suspName;

    @ColumnName(name = "Растворимость, г/100 г раствора")
    @Column(name = "Suspense", nullable = false)
    private BigDecimal suspense;

    @ColumnName(name = "Погрешность, г/100 г")
    @Column(name = "ErrSusp")
    private BigDecimal errSusp;

    @ColumnName(name = "Примечания")
    @Column(name = "MethodS")
    private String methodS;

    @ColumnName(name = "Ссылка")
    @Column(name = "Bknumber")
    private Integer bknumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SuspTabl susp = (SuspTabl) o;

        if (headClue != susp.headClue) return false;
        if (temper != null ? !temper.equals(susp.temper) : susp.temper != null) return false;
        if (suspName != null ? !suspName.equals(susp.suspName) : susp.suspName != null) return false;
        if (suspense != null ? !suspense.equals(susp.suspense) : susp.suspense != null) return false;
        if (errSusp != null ? !errSusp.equals(susp.errSusp) : susp.errSusp != null) return false;
        if (methodS != null ? !methodS.equals(susp.methodS) : susp.methodS != null) return false;
        return bknumber != null ? bknumber.equals(susp.bknumber) : susp.bknumber == null;

    }

    @Override
    public int hashCode() {
        int result = headClue;
        result = 31 * result + (temper != null ? temper.hashCode() : 0);
        result = 31 * result + (suspName != null ? suspName.hashCode() : 0);
        result = 31 * result + (suspense != null ? suspense.hashCode() : 0);
        result = 31 * result + (errSusp != null ? errSusp.hashCode() : 0);
        result = 31 * result + (methodS != null ? methodS.hashCode() : 0);
        result = 31 * result + (bknumber != null ? bknumber.hashCode() : 0);
        return result;
    }

    public int getHeadClue() {

        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public BigDecimal getTemper() {
        return temper;
    }

    public void setTemper(BigDecimal temper) {
        this.temper = temper;
    }

    public String getSuspName() {
        return suspName;
    }

    public void setSuspName(String suspName) {
        this.suspName = suspName;
    }

    public BigDecimal getSuspense() {
        return suspense;
    }

    public void setSuspense(BigDecimal suspense) {
        this.suspense = suspense;
    }

    public BigDecimal getErrSusp() {
        return errSusp;
    }

    public void setErrSusp(BigDecimal errSusp) {
        this.errSusp = errSusp;
    }

    public String getMethodS() {
        return methodS;
    }

    public void setMethodS(String methodS) {
        this.methodS = methodS;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
