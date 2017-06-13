package entity;

import javax.persistence.*;
import java.math.BigDecimal;

//Температура Кюри
@Entity
@Table(name = "CuryTabl")
public class CuryTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Температура, K", fieldLength = 16)
    @Column(name = "CuryTemp")
    private BigDecimal curyTemp;

    @ColumnProperty(name = "Погрешность, K", fieldLength = 16)
    @Column(name = "ErrCury")
    private BigDecimal errCury;

    @ColumnProperty(name = "Тип фазового перехода", fieldLength = 50)
    @Column(name = "Oboztran")
    private String oboztran;

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
}
