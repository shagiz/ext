package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//пьезоэлектрические коэффициенты
@Entity
@Table(name = "PzElTabl")
public class PzEl extends BaseEntity {

    @ColumnProperty(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Частота, МГц")
    @Column(name = "FreqPzEl")
    private Double freqPzEl;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "ConstD")
    private String constD;

    @ColumnProperty(name = "Значение коэффициента")
    @Column(name = "D")
    private Double d;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrD")
    private Double errD;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodPz")
    private String methodPz;

    @ColumnProperty(name = "Номер ссылки")
    @Column(name = "bknumber")
    private Integer bknumber;

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

    public Double getFreqPzEl() {
        return freqPzEl;
    }

    public void setFreqPzEl(Double freqPzEl) {
        this.freqPzEl = freqPzEl;
    }

    public String getConstD() {
        return constD;
    }

    public void setConstD(String constD) {
        this.constD = constD;
    }

    public Double getD() {
        return d;
    }

    public void setD(Double d) {
        this.d = d;
    }

    public Double getErrD() {
        return errD;
    }

    public void setErrD(Double errD) {
        this.errD = errD;
    }

    public String getMethodPz() {
        return methodPz;
    }

    public void setMethodPz(String methodPz) {
        this.methodPz = methodPz;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
