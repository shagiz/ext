package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "SuspTabl")
public class SuspTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Температура, K", fieldLength = 17)
    @Column(name = "Temper")
    private BigDecimal temper;

    @ColumnProperty(name = "Растворитель", fieldLength = 50)
    @Column(name = "SuspName")
    private String suspName;

    @ColumnProperty(name = "Растворимость, г/100 г раствора", fieldLength = 21)
    @Column(name = "Suspense", nullable = false)
    private BigDecimal suspense;

    @ColumnProperty(name = "Погрешность, г/100 г", fieldLength = 21)
    @Column(name = "ErrSusp")
    private BigDecimal errSusp;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodS")
    private String methodS;

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
}
