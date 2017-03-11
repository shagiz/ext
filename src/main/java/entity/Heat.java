package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HeatTabl")
public class Heat extends BaseEntity {

    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @Column(name = "Temperat")
    private Double temperat;

    @Column(name = "ZnC")
    private String znc;

    @Column(name = "C")
    private Double c;

    @Column(name = "ErrC")
    private Double errc;

    @Column(name = "MethodC")
    private String methodC;

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
