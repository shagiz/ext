package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "HardTabl")
public class HardTabl extends BaseEntity {

    @ColumnName(name = "Номер соединения")
    @Column(name = "HeadClue")
    private Integer headClue;

    @ColumnName(name = "Min")
    @Column(name = "Hard1")
    private BigDecimal hard1;

    @ColumnName(name = "Max")
    @Column(name = "Hard2")
    private BigDecimal hard2;

    @ColumnName(name = "Погрешность")
    @Column(name = "ErrHard")
    private BigDecimal errHard;

    @ColumnName(name = "Моос")
    @Column(name = "Mohs")
    private BigDecimal mohs;

    @ColumnName(name = "Погрешность Моос")
    @Column(name = "ErrMohs")
    private BigDecimal errMohs;

    @ColumnName(name = "Примечания")
    @Column(name = "MethodH")
    private String methodH;

    @ColumnName(name = "Ссылка")
    @Column(name = "Bknumber")
    private Integer bknumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HardTabl hardTabl = (HardTabl) o;

        if (headClue != null ? !headClue.equals(hardTabl.headClue) : hardTabl.headClue != null) return false;
        if (hard1 != null ? !hard1.equals(hardTabl.hard1) : hardTabl.hard1 != null) return false;
        if (hard2 != null ? !hard2.equals(hardTabl.hard2) : hardTabl.hard2 != null) return false;
        if (errHard != null ? !errHard.equals(hardTabl.errHard) : hardTabl.errHard != null) return false;
        if (mohs != null ? !mohs.equals(hardTabl.mohs) : hardTabl.mohs != null) return false;
        if (errMohs != null ? !errMohs.equals(hardTabl.errMohs) : hardTabl.errMohs != null) return false;
        if (methodH != null ? !methodH.equals(hardTabl.methodH) : hardTabl.methodH != null) return false;
        return bknumber != null ? bknumber.equals(hardTabl.bknumber) : hardTabl.bknumber == null;

    }

    @Override
    public int hashCode() {
        int result = headClue != null ? headClue.hashCode() : 0;
        result = 31 * result + (hard1 != null ? hard1.hashCode() : 0);
        result = 31 * result + (hard2 != null ? hard2.hashCode() : 0);
        result = 31 * result + (errHard != null ? errHard.hashCode() : 0);
        result = 31 * result + (mohs != null ? mohs.hashCode() : 0);
        result = 31 * result + (errMohs != null ? errMohs.hashCode() : 0);
        result = 31 * result + (methodH != null ? methodH.hashCode() : 0);
        result = 31 * result + (bknumber != null ? bknumber.hashCode() : 0);
        return result;
    }

    public Integer getHeadClue() {

        return headClue;
    }

    public void setHeadClue(Integer headClue) {
        this.headClue = headClue;
    }

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

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
