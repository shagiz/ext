package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PzElTabl")
public class PzEl extends BaseEntity {

    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @Column(name = "SingCode")
    private String singCode;

    @Column(name = "FreqPzEl")
    private Double freqPzEl;

    @Column(name = "ConstD")
    private String constD;

    @Column(name = "D")
    private Double d;

    @Column(name = "ErrD")
    private Double errD;

    @Column(name = "MethodPz")
    private String methodPz;

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
