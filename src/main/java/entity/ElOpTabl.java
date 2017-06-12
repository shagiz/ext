package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ElOpTabl")
public class ElOpTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Длина волны, мкм")
    @Column(name = "WvLeng")
    private BigDecimal wvLeng;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "ZnN1")
    private String znN1;

    @ColumnProperty(name = "Значение коэффициента")
    @Column(name = "R")
    private BigDecimal R;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrR")
    private BigDecimal errR;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodR")
    private String methodR;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getWvLeng() {
        return wvLeng;
    }

    public void setWvLeng(BigDecimal wvLeng) {
        this.wvLeng = wvLeng;
    }

    public String getZnN1() {
        return znN1;
    }

    public void setZnN1(String znN1) {
        this.znN1 = znN1;
    }

    public BigDecimal getR() {
        return R;
    }

    public void setR(BigDecimal r) {
        R = r;
    }

    public BigDecimal getErrR() {
        return errR;
    }

    public void setErrR(BigDecimal errR) {
        this.errR = errR;
    }

    public String getMethodR() {
        return methodR;
    }

    public void setMethodR(String methodR) {
        this.methodR = methodR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ElOpTabl elOpTabl = (ElOpTabl) o;

        if (singCode != null ? !singCode.equals(elOpTabl.singCode) : elOpTabl.singCode != null) return false;
        if (wvLeng != null ? !wvLeng.equals(elOpTabl.wvLeng) : elOpTabl.wvLeng != null) return false;
        if (znN1 != null ? !znN1.equals(elOpTabl.znN1) : elOpTabl.znN1 != null) return false;
        if (R != null ? !R.equals(elOpTabl.R) : elOpTabl.R != null) return false;
        if (errR != null ? !errR.equals(elOpTabl.errR) : elOpTabl.errR != null) return false;
        return methodR != null ? methodR.equals(elOpTabl.methodR) : elOpTabl.methodR == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (wvLeng != null ? wvLeng.hashCode() : 0);
        result = 31 * result + (znN1 != null ? znN1.hashCode() : 0);
        result = 31 * result + (R != null ? R.hashCode() : 0);
        result = 31 * result + (errR != null ? errR.hashCode() : 0);
        result = 31 * result + (methodR != null ? methodR.hashCode() : 0);
        return result;
    }
}
