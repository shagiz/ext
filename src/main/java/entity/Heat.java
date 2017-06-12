package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Удельная теплоемкость
@Entity
@Table(name = "HeatTabl")
public class Heat extends BaseEntity {

    @ColumnName(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnName(name = "Температура, K")
    @Column(name = "Temperat")
    private Double temperat;

    @ColumnName(name = "Обозначение коэффициента")
    @Column(name = "ZnC")
    private String znc;

    @ColumnName(name = "Теплоемко-сть, Дж/кг*K")
    @Column(name = "C")
    private Double c;

    @ColumnName(name = "Погреш-ность, Дж/кг*K")
    @Column(name = "ErrC")
    private Double errc;

    @ColumnName(name = "Примечания")
    @Column(name = "MethodC")
    private String methodC;

    @ColumnName(name = "Ссылка")
    @Column(name = "Bknumber")
    private Integer bknumber;

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

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

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
