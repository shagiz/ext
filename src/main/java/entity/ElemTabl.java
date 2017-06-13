package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ElemTabl")
public class ElemTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония", fieldLength = 2)
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Название линейного параметра", fieldLength = 2)
    @Column(name = "Nazbparam")
    private String nazbparam;

    @ColumnProperty(name = "Значение линейного параметра, A", fieldLength = 20)
    @Column(name = "Znparam")
    private BigDecimal znparam;

    @ColumnProperty(name = "Погрешность, A", fieldLength = 20)
    @Column(name = "Errparam")
    private BigDecimal errparam;

    @ColumnProperty(name = "Название угла", fieldLength = 20)
    @Column(name = "NazvAngl")
    private String nazvAngl;

    @ColumnProperty(name = "Значение угла, град.", fieldLength = 20)
    @Column(name = "ZnAngle")
    private BigDecimal znAngle;

    @ColumnProperty(name = "Погрешность, град.", fieldLength = 20)
    @Column(name = "ErrAngl")
    private BigDecimal errAngl;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodP")
    private String methodP;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public String getNazbparam() {
        return nazbparam;
    }

    public void setNazbparam(String nazbparam) {
        this.nazbparam = nazbparam;
    }

    public BigDecimal getZnparam() {
        return znparam;
    }

    public void setZnparam(BigDecimal znparam) {
        this.znparam = znparam;
    }

    public BigDecimal getErrparam() {
        return errparam;
    }

    public void setErrparam(BigDecimal errparam) {
        this.errparam = errparam;
    }

    public String getNazvAngl() {
        return nazvAngl;
    }

    public void setNazvAngl(String nazvAngl) {
        this.nazvAngl = nazvAngl;
    }

    public BigDecimal getZnAngle() {
        return znAngle;
    }

    public void setZnAngle(BigDecimal znAngle) {
        this.znAngle = znAngle;
    }

    public BigDecimal getErrAngl() {
        return errAngl;
    }

    public void setErrAngl(BigDecimal errAngl) {
        this.errAngl = errAngl;
    }

    public String getMethodP() {
        return methodP;
    }

    public void setMethodP(String methodP) {
        this.methodP = methodP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ElemTabl elemTabl = (ElemTabl) o;

        if (singCode != null ? !singCode.equals(elemTabl.singCode) : elemTabl.singCode != null) return false;
        if (nazbparam != null ? !nazbparam.equals(elemTabl.nazbparam) : elemTabl.nazbparam != null) return false;
        if (znparam != null ? !znparam.equals(elemTabl.znparam) : elemTabl.znparam != null) return false;
        if (errparam != null ? !errparam.equals(elemTabl.errparam) : elemTabl.errparam != null) return false;
        if (nazvAngl != null ? !nazvAngl.equals(elemTabl.nazvAngl) : elemTabl.nazvAngl != null) return false;
        if (znAngle != null ? !znAngle.equals(elemTabl.znAngle) : elemTabl.znAngle != null) return false;
        if (errAngl != null ? !errAngl.equals(elemTabl.errAngl) : elemTabl.errAngl != null) return false;
        return methodP != null ? methodP.equals(elemTabl.methodP) : elemTabl.methodP == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (nazbparam != null ? nazbparam.hashCode() : 0);
        result = 31 * result + (znparam != null ? znparam.hashCode() : 0);
        result = 31 * result + (errparam != null ? errparam.hashCode() : 0);
        result = 31 * result + (nazvAngl != null ? nazvAngl.hashCode() : 0);
        result = 31 * result + (znAngle != null ? znAngle.hashCode() : 0);
        result = 31 * result + (errAngl != null ? errAngl.hashCode() : 0);
        result = 31 * result + (methodP != null ? methodP.hashCode() : 0);
        return result;
    }
}
