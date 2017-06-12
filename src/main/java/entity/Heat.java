package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Удельная теплоемкость
@Entity
@Table(name = "HeatTabl")
public class Heat extends BaseHeadClueEntity {

    @ColumnProperty(name = "Температура, K")
    @Column(name = "Temperat")
    private Double temperat;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "ZnC")
    private String znc;

    @ColumnProperty(name = "Теплоемко-сть, Дж/кг*K")
    @Column(name = "C")
    private Double c;

    @ColumnProperty(name = "Погреш-ность, Дж/кг*K")
    @Column(name = "ErrC")
    private Double errc;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodC")
    private String methodC;
    public Double getTemperat() {
        return temperat;
    }

    public void setTemperat(Double temperat) {
        this.temperat = temperat;
    }

    public String getZnc() {
        return znc;
    }

    public void setZnc(String znc) {
        this.znc = znc;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Double getErrc() {
        return errc;
    }

    public void setErrc(Double errc) {
        this.errc = errc;
    }

    public String getMethodC() {
        return methodC;
    }

    public void setMethodC(String methodC) {
        this.methodC = methodC;
    }
}
