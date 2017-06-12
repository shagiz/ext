package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

//Диэлектрическая проницаемость
@Entity
@Table(name = "Dielectr")
public class Dielectr extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Частота, МГц")
    @Column(name = "FreqDiel")
    private BigDecimal freqDiel;

    @ColumnProperty(name = "Температура, ")
    @Column(name = "Temper_2")
    private BigDecimal temper2;

    @ColumnProperty(name = "Условия измерения")
    @Column(name = "Constant")
    private String constant;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "Znak")
    private String znak;

    @ColumnProperty(name = "Значение коэффициента")
    @Column(name = "Diel")
    private BigDecimal diel;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrY")
    private BigDecimal errY;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodY")
    private String methodY;

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
}
