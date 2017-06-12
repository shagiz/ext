package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "EsOpTabl")
public class EsOpTabl extends BaseHeadClueEntity {

    @ColumnName(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnName(name = "Длина волны, мкм")
    @Column(name = "LengWave")
    private BigDecimal LengWave;

    @ColumnName(name = "Обозначение коэффициента")
    @Column(name = "ZnP")
    private String ZnP;

    @ColumnName(name = "Значение коэффициента")
    @Column(name = "P")
    private BigDecimal P;

    @ColumnName(name = "Погрешность")
    @Column(name = "ErrP")
    private BigDecimal ErrP;

    @ColumnName(name = "Примечания")
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