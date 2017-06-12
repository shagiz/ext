package entity;

import javax.persistence.*;
import java.math.BigDecimal;

//Температура Кюри
@Entity
@Table(name = "CuryTabl")
public class CuryTabl extends BaseEntity {

    @ColumnProperty(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnProperty(name = "Температура, K")
    @Column(name = "CuryTemp")
    private BigDecimal curyTemp;

    @ColumnProperty(name = "Погрешность, K")
    @Column(name = "ErrCury")
    private BigDecimal errCury;

    @ColumnProperty(name = "Тип фазового перехода")
    @Column(name = "Oboztran")
    private String oboztran;

    @ColumnProperty(name = "Ссылка")
    @Column(name = "Bknumber")
    private Integer bknumber;

    public BigDecimal getCuryTemp() {
        return curyTemp;
    }

    public void setCuryTemp(BigDecimal curyTemp) {
        this.curyTemp = curyTemp;
    }

    public BigDecimal getErrCury() {
        return errCury;
    }

    public void setErrCury(BigDecimal errCury) {
        this.errCury = errCury;
    }

    public String getOboztran() {
        return oboztran;
    }

    public void setOboztran(String oboztran) {
        this.oboztran = oboztran;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CuryTabl curyTabl = (CuryTabl) o;

        if (curyTemp != null ? !curyTemp.equals(curyTabl.curyTemp) : curyTabl.curyTemp != null) return false;
        if (errCury != null ? !errCury.equals(curyTabl.errCury) : curyTabl.errCury != null) return false;
        if (oboztran != null ? !oboztran.equals(curyTabl.oboztran) : curyTabl.oboztran != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = curyTemp != null ? curyTemp.hashCode() : 0;
        result = 31 * result + (errCury != null ? errCury.hashCode() : 0);
        result = 31 * result + (oboztran != null ? oboztran.hashCode() : 0);
        return result;
    }

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
