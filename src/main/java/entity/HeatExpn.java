package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "HeatExpn")
public class HeatExpn extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония", fieldLength = 2)
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Тип данных", allowBlank = false)
    @Column(name = "DataType", nullable = false)
    private Integer dataType;

    @ColumnProperty(name = "Температура, K (Min)", fieldLength = 16)
    @Column(name = "Temper_1")
    private BigDecimal temper1;

    @ColumnProperty(name = "Температура, K (Max)", fieldLength = 16)
    @Column(name = "Temper_2")
    private BigDecimal temper2;

    @ColumnProperty(name = "Обозначение коэффициента", fieldLength = 30)
    @Column(name = "Znak1")
    private String znak1;

    @ColumnProperty(name = "Значение коэффициента", fieldLength = 22)
    @Column(name = "S11")
    private BigDecimal S11;

    @ColumnProperty(name = "Погрешность", fieldLength = 18)
    @Column(name = "ErrHExp")
    private BigDecimal errHExp;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodEx")
    private String methodEx;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public BigDecimal getTemper1() {
        return temper1;
    }

    public void setTemper1(BigDecimal temper1) {
        this.temper1 = temper1;
    }

    public BigDecimal getTemper2() {
        return temper2;
    }

    public void setTemper2(BigDecimal temper2) {
        this.temper2 = temper2;
    }

    public String getZnak1() {
        return znak1;
    }

    public void setZnak1(String znak1) {
        this.znak1 = znak1;
    }

    public BigDecimal getS11() {
        return S11;
    }

    public void setS11(BigDecimal s11) {
        S11 = s11;
    }

    public BigDecimal getErrHExp() {
        return errHExp;
    }

    public void setErrHExp(BigDecimal errHExp) {
        this.errHExp = errHExp;
    }

    public String getMethodEx() {
        return methodEx;
    }

    public void setMethodEx(String methodEx) {
        this.methodEx = methodEx;
    }
}
