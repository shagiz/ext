package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Elastic1")
public class Elastic1 extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония", fieldLength = 2)
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Частота, МГц", fieldLength = 16)
    @Column(name = "TemperEl")
    private BigDecimal temperEl;

    @ColumnProperty(name = "Температура, K", fieldLength = 6)
    @Column(name = "CondClu1")
    private String condClu1;

    @ColumnProperty(name = "Условия измерения", fieldLength = 20)
    @Column(name = "ZnE")
    private String ZnE;

    @ColumnProperty(name = "Обозначение коэффициента", fieldLength = 26)
    @Column(name = "E1")
    private BigDecimal E1;

    @ColumnProperty(name = "Погрешность", fieldLength = 20)
    @Column(name = "ErrE")
    private BigDecimal errE;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodE")
    private String methodE;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getTemperEl() {
        return temperEl;
    }

    public void setTemperEl(BigDecimal temperEl) {
        this.temperEl = temperEl;
    }

    public String getCondClu1() {
        return condClu1;
    }

    public void setCondClu1(String condClu1) {
        this.condClu1 = condClu1;
    }

    public String getZnE() {
        return ZnE;
    }

    public void setZnE(String znE) {
        ZnE = znE;
    }

    public BigDecimal getE1() {
        return E1;
    }

    public void setE1(BigDecimal e1) {
        E1 = e1;
    }

    public BigDecimal getErrE() {
        return errE;
    }

    public void setErrE(BigDecimal errE) {
        this.errE = errE;
    }

    public String getMethodE() {
        return methodE;
    }

    public void setMethodE(String methodE) {
        this.methodE = methodE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Elastic1 elastic1 = (Elastic1) o;

        if (singCode != null ? !singCode.equals(elastic1.singCode) : elastic1.singCode != null) return false;
        if (temperEl != null ? !temperEl.equals(elastic1.temperEl) : elastic1.temperEl != null) return false;
        if (condClu1 != null ? !condClu1.equals(elastic1.condClu1) : elastic1.condClu1 != null) return false;
        if (ZnE != null ? !ZnE.equals(elastic1.ZnE) : elastic1.ZnE != null) return false;
        if (E1 != null ? !E1.equals(elastic1.E1) : elastic1.E1 != null) return false;
        if (errE != null ? !errE.equals(elastic1.errE) : elastic1.errE != null) return false;
        return methodE != null ? methodE.equals(elastic1.methodE) : elastic1.methodE == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (temperEl != null ? temperEl.hashCode() : 0);
        result = 31 * result + (condClu1 != null ? condClu1.hashCode() : 0);
        result = 31 * result + (ZnE != null ? ZnE.hashCode() : 0);
        result = 31 * result + (E1 != null ? E1.hashCode() : 0);
        result = 31 * result + (errE != null ? errE.hashCode() : 0);
        result = 31 * result + (methodE != null ? methodE.hashCode() : 0);
        return result;
    }
}
