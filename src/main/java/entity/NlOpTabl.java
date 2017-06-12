package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "NlOpTabl")
public class NlOpTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Длина волны, мкм")
    @Column(name = "Lyambda")
    private BigDecimal Lyambda;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "ZnR")
    private String ZnR;

    @ColumnProperty(name = "Значение коэффициента")
    @Column(name = "Rij")
    private BigDecimal Rij;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrRij")
    private BigDecimal ErrRij;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodR")
    private String MethodR;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getLyambda() {
        return Lyambda;
    }

    public void setLyambda(BigDecimal lyambda) {
        Lyambda = lyambda;
    }

    public String getZnR() {
        return ZnR;
    }

    public void setZnR(String znR) {
        ZnR = znR;
    }

    public BigDecimal getRij() {
        return Rij;
    }

    public void setRij(BigDecimal rij) {
        Rij = rij;
    }

    public BigDecimal getErrRij() {
        return ErrRij;
    }

    public void setErrRij(BigDecimal errRij) {
        ErrRij = errRij;
    }

    public String getMethodR() {
        return MethodR;
    }

    public void setMethodR(String methodR) {
        MethodR = methodR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        NlOpTabl nlOpTabl = (NlOpTabl) o;

        if (singCode != null ? !singCode.equals(nlOpTabl.singCode) : nlOpTabl.singCode != null) return false;
        if (Lyambda != null ? !Lyambda.equals(nlOpTabl.Lyambda) : nlOpTabl.Lyambda != null) return false;
        if (ZnR != null ? !ZnR.equals(nlOpTabl.ZnR) : nlOpTabl.ZnR != null) return false;
        if (Rij != null ? !Rij.equals(nlOpTabl.Rij) : nlOpTabl.Rij != null) return false;
        if (ErrRij != null ? !ErrRij.equals(nlOpTabl.ErrRij) : nlOpTabl.ErrRij != null) return false;
        return MethodR != null ? MethodR.equals(nlOpTabl.MethodR) : nlOpTabl.MethodR == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (Lyambda != null ? Lyambda.hashCode() : 0);
        result = 31 * result + (ZnR != null ? ZnR.hashCode() : 0);
        result = 31 * result + (Rij != null ? Rij.hashCode() : 0);
        result = 31 * result + (ErrRij != null ? ErrRij.hashCode() : 0);
        result = 31 * result + (MethodR != null ? MethodR.hashCode() : 0);
        return result;
    }
}
