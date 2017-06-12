package entity;

import javax.persistence.*;
import java.math.BigDecimal;

//Температура плавления
@Entity
@Table(name = "PlavTabl")
public class PlavTabl extends BaseEntity {

    @ColumnName(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnName(name = "Тип плавления")
    @Column(name = "PlavType")
    private String plavType;

    @ColumnName(name = "Температура, K")
    @Column(name = "PlavTemp")
    private BigDecimal plavTemp;

    @ColumnName(name = "Погрешность, K")
    @Column(name = "ErrPlav")
    private BigDecimal errPlav;

    @ColumnName(name = "Ссылка")
    @Column(name = "Bknumber")
    private Integer bknumber;

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

    public String getPlavType() {
        return plavType;
    }

    public void setPlavType(String plavType) {
        this.plavType = plavType;
    }

    public BigDecimal getPlavTemp() {
        return plavTemp;
    }

    public void setPlavTemp(BigDecimal plavTemp) {
        this.plavTemp = plavTemp;
    }

    public BigDecimal getErrPlav() {
        return errPlav;
    }

    public void setErrPlav(BigDecimal errPlav) {
        this.errPlav = errPlav;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlavTabl plavTabl = (PlavTabl) o;

        if (plavType != null ? !plavType.equals(plavTabl.plavType) : plavTabl.plavType != null) return false;
        if (plavTemp != null ? !plavTemp.equals(plavTabl.plavTemp) : plavTabl.plavTemp != null) return false;
        if (errPlav != null ? !errPlav.equals(plavTabl.errPlav) : plavTabl.errPlav != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = plavType != null ? plavType.hashCode() : 0;
        result = 31 * result + (plavTemp != null ? plavTemp.hashCode() : 0);
        result = 31 * result + (errPlav != null ? errPlav.hashCode() : 0);
        return result;
    }
}
