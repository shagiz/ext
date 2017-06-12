package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

//Диэлектрическая проницаемость
@Entity
@Table(name = "Dielectr")
public class Dielectr extends BaseEntity {

    @ColumnName(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnName(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnName(name = "Частота, МГц")
    @Column(name = "FreqDiel")
    private BigDecimal freqDiel;

    @ColumnName(name = "Температура, ")
    @Column(name = "Temper_2")
    private BigDecimal temper2;

    @ColumnName(name = "Условия измерения")
    @Column(name = "Constant")
    private String constant;

    @ColumnName(name = "Обозначение коэффициента")
    @Column(name = "Znak")
    private String znak;

    @ColumnName(name = "Значение коэффициента")
    @Column(name = "Diel")
    private BigDecimal diel;

    @ColumnName(name = "Погрешность")
    @Column(name = "ErrY")
    private BigDecimal errY;

    @ColumnName(name = "Примечания")
    @Column(name = "MethodY")
    private String methodY;

    @ColumnName(name = "Ссылка")
    @Column(name = "Bknumber")
    private Integer bknumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dielectr dielectr = (Dielectr) o;

        if (headClue != dielectr.headClue) return false;
        if (singCode != null ? !singCode.equals(dielectr.singCode) : dielectr.singCode != null) return false;
        if (freqDiel != null ? !freqDiel.equals(dielectr.freqDiel) : dielectr.freqDiel != null) return false;
        if (temper2 != null ? !temper2.equals(dielectr.temper2) : dielectr.temper2 != null) return false;
        if (constant != null ? !constant.equals(dielectr.constant) : dielectr.constant != null) return false;
        if (znak != null ? !znak.equals(dielectr.znak) : dielectr.znak != null) return false;
        if (diel != null ? !diel.equals(dielectr.diel) : dielectr.diel != null) return false;
        if (errY != null ? !errY.equals(dielectr.errY) : dielectr.errY != null) return false;
        if (methodY != null ? !methodY.equals(dielectr.methodY) : dielectr.methodY != null) return false;
        return bknumber != null ? bknumber.equals(dielectr.bknumber) : dielectr.bknumber == null;

    }

    @Override
    public int hashCode() {
        int result = headClue;
        result = 31 * result + (singCode != null ? singCode.hashCode() : 0);
        result = 31 * result + (freqDiel != null ? freqDiel.hashCode() : 0);
        result = 31 * result + (temper2 != null ? temper2.hashCode() : 0);
        result = 31 * result + (constant != null ? constant.hashCode() : 0);
        result = 31 * result + (znak != null ? znak.hashCode() : 0);
        result = 31 * result + (diel != null ? diel.hashCode() : 0);
        result = 31 * result + (errY != null ? errY.hashCode() : 0);
        result = 31 * result + (methodY != null ? methodY.hashCode() : 0);
        result = 31 * result + (bknumber != null ? bknumber.hashCode() : 0);
        return result;
    }

    public int getHeadClue() {

        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getFreqDiel() {
        return freqDiel;
    }

    public void setFreqDiel(BigDecimal freqDiel) {
        this.freqDiel = freqDiel;
    }

    public BigDecimal getTemper2() {
        return temper2;
    }

    public void setTemper2(BigDecimal temper2) {
        this.temper2 = temper2;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public String getZnak() {
        return znak;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public BigDecimal getDiel() {
        return diel;
    }

    public void setDiel(BigDecimal diel) {
        this.diel = diel;
    }

    public BigDecimal getErrY() {
        return errY;
    }

    public void setErrY(BigDecimal errY) {
        this.errY = errY;
    }

    public String getMethodY() {
        return methodY;
    }

    public void setMethodY(String methodY) {
        this.methodY = methodY;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
