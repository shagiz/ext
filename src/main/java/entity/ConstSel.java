package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ConstSel")
public class ConstSel extends BaseHeadClueEntity {

    @ColumnName(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnName(name = "Уравнение")
    @Column(name = "Equation")
    private String equation;

    @ColumnName(name = "Название коэффициента")
    @Column(name = "NazvSel")
    private String nazvSel;

    @ColumnName(name = "Значение коэффициента")
    @Column(name = "ZnachSel")
    private BigDecimal znachSel;

    @ColumnName(name = "Размерность")
    @Column(name = "Measure")
    private String measure;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ConstSel constSel = (ConstSel) o;

        if (singCode != null ? !singCode.equals(constSel.singCode) : constSel.singCode != null) return false;
        if (equation != null ? !equation.equals(constSel.equation) : constSel.equation != null) return false;
        if (nazvSel != null ? !nazvSel.equals(constSel.nazvSel) : constSel.nazvSel != null) return false;
        if (znachSel != null ? !znachSel.equals(constSel.znachSel) : constSel.znachSel != null) return false;
        return measure != null ? measure.equals(constSel.measure) : constSel.measure == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (equation != null ? equation.hashCode() : 0);
        result = 31 * result + (nazvSel != null ? nazvSel.hashCode() : 0);
        result = 31 * result + (znachSel != null ? znachSel.hashCode() : 0);
        result = 31 * result + (measure != null ? measure.hashCode() : 0);
        return result;
    }

    public String getSingCode() {

        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public String getNazvSel() {
        return nazvSel;
    }

    public void setNazvSel(String nazvSel) {
        this.nazvSel = nazvSel;
    }

    public BigDecimal getZnachSel() {
        return znachSel;
    }

    public void setZnachSel(BigDecimal znachSel) {
        this.znachSel = znachSel;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
