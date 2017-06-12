package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "HardTabl")
public class HardTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Min")
    @Column(name = "Hard1")
    private BigDecimal hard1;

    @ColumnProperty(name = "Max")
    @Column(name = "Hard2")
    private BigDecimal hard2;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrHard")
    private BigDecimal errHard;

    @ColumnProperty(name = "Моос")
    @Column(name = "Mohs")
    private BigDecimal mohs;

    @ColumnProperty(name = "Погрешность Моос")
    @Column(name = "ErrMohs")
    private BigDecimal errMohs;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodH")
    private String methodH;

    public BigDecimal getHard1() {
        return hard1;
    }

    public void setHard1(BigDecimal hard1) {
        this.hard1 = hard1;
    }

    public BigDecimal getHard2() {
        return hard2;
    }

    public void setHard2(BigDecimal hard2) {
        this.hard2 = hard2;
    }

    public BigDecimal getErrHard() {
        return errHard;
    }

    public void setErrHard(BigDecimal errHard) {
        this.errHard = errHard;
    }

    public BigDecimal getMohs() {
        return mohs;
    }

    public void setMohs(BigDecimal mohs) {
        this.mohs = mohs;
    }

    public BigDecimal getErrMohs() {
        return errMohs;
    }

    public void setErrMohs(BigDecimal errMohs) {
        this.errMohs = errMohs;
    }

    public String getMethodH() {
        return methodH;
    }

    public void setMethodH(String methodH) {
        this.methodH = methodH;
    }
}
