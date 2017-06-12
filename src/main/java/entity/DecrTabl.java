package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "DecrTabl")
public class DecrTabl extends BaseHeadClueEntity {

    @ColumnName(name = "Направление распространения")
    @Column(name = "Nzv")
    private String Nzv;

    @ColumnName(name = "Направление смещения")
    @Column(name = "Uzv")
    private String Uzv;

    @ColumnName(name = "Тип волны")
    @Column(name = "WaveType")
    private String WaveType;

    @ColumnName(name = "Скорость волны, 10^5 см/сек")
    @Column(name = "WaveSpeed")
    private BigDecimal WaveSpeed;

    @ColumnName(name = "Коэффициент затухания, дБ/см")
    @Column(name = "Decrement")
    private BigDecimal Decrement;

    @ColumnName(name = "Частота электрического поля, МГц")
    @Column(name = "DecrFreq")
    private BigDecimal DecrFreq;

    public String getNzv() {
        return Nzv;
    }

    public void setNzv(String nzv) {
        Nzv = nzv;
    }

    public String getUzv() {
        return Uzv;
    }

    public void setUzv(String uzv) {
        Uzv = uzv;
    }

    public String getWaveType() {
        return WaveType;
    }

    public void setWaveType(String waveType) {
        WaveType = waveType;
    }

    public BigDecimal getWaveSpeed() {
        return WaveSpeed;
    }

    public void setWaveSpeed(BigDecimal waveSpeed) {
        WaveSpeed = waveSpeed;
    }

    public BigDecimal getDecrement() {
        return Decrement;
    }

    public void setDecrement(BigDecimal decrement) {
        Decrement = decrement;
    }

    public BigDecimal getDecrFreq() {
        return DecrFreq;
    }

    public void setDecrFreq(BigDecimal decrFreq) {
        DecrFreq = decrFreq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DecrTabl decrTabl = (DecrTabl) o;

        if (Nzv != null ? !Nzv.equals(decrTabl.Nzv) : decrTabl.Nzv != null) return false;
        if (Uzv != null ? !Uzv.equals(decrTabl.Uzv) : decrTabl.Uzv != null) return false;
        if (WaveType != null ? !WaveType.equals(decrTabl.WaveType) : decrTabl.WaveType != null) return false;
        if (WaveSpeed != null ? !WaveSpeed.equals(decrTabl.WaveSpeed) : decrTabl.WaveSpeed != null) return false;
        if (Decrement != null ? !Decrement.equals(decrTabl.Decrement) : decrTabl.Decrement != null) return false;
        return DecrFreq != null ? DecrFreq.equals(decrTabl.DecrFreq) : decrTabl.DecrFreq == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Nzv != null ? Nzv.hashCode() : 0);
        result = 31 * result + (Uzv != null ? Uzv.hashCode() : 0);
        result = 31 * result + (WaveType != null ? WaveType.hashCode() : 0);
        result = 31 * result + (WaveSpeed != null ? WaveSpeed.hashCode() : 0);
        result = 31 * result + (Decrement != null ? Decrement.hashCode() : 0);
        result = 31 * result + (DecrFreq != null ? DecrFreq.hashCode() : 0);
        return result;
    }
}
