package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "EsOpTabl")
public class EsOpTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония", fieldLength = 2)
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Длина волны, мкм", fieldLength = 25)
    @Column(name = "LengWave")
    private BigDecimal LengWave;

    @ColumnProperty(name = "Обозначение коэффициента", fieldLength = 50)
    @Column(name = "ZnP")
    private String ZnP;

    @ColumnProperty(name = "Значение коэффициента", fieldLength = 16)
    @Column(name = "P")
    private BigDecimal P;

    @ColumnProperty(name = "Погрешность", fieldLength = 18)
    @Column(name = "ErrP")
    private BigDecimal ErrP;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodP")
    private String MethodP;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getLengWave() {
        return LengWave;
    }

    public void setLengWave(BigDecimal lengWave) {
        LengWave = lengWave;
    }

    public String getZnP() {
        return ZnP;
    }

    public void setZnP(String znP) {
        ZnP = znP;
    }

    public BigDecimal getP() {
        return P;
    }

    public void setP(BigDecimal p) {
        P = p;
    }

    public BigDecimal getErrP() {
        return ErrP;
    }

    public void setErrP(BigDecimal errP) {
        ErrP = errP;
    }

    public String getMethodP() {
        return MethodP;
    }

    public void setMethodP(String methodP) {
        MethodP = methodP;
    }
}
