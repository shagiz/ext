package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AcOpTabl")
public class Acop extends BaseEntity {

    @Column(name = "HeadClue")
    private Integer headClue;

    @Column(name = "WaveLeng")
    private Double waveLeng;

    @Column(name = "Nzv")
    private String nzv;

    @Column(name = "Uzv")
    private String uzv;

    @Column(name = "Nsv")
    private String nsv;

    @Column(name = "E")
    private String e;

    @Column(name = "M1")
    private Double m1;

    @Column(name = "M2")
    private Double m2;

    @Column(name = "M3")
    private Double m3;

    @Column(name = "Bknumber")
    private Integer bknumber;

    public Integer getHeadClue() {
        return headClue;
    }

    public void setHeadClue(Integer headClue) {
        this.headClue = headClue;
    }

    public Double getWaveLeng() {
        return waveLeng;
    }

    public void setWaveLeng(Double waveLeng) {
        this.waveLeng = waveLeng;
    }

    public String getNzv() {
        return nzv;
    }

    public void setNzv(String nzv) {
        this.nzv = nzv;
    }

    public String getUzv() {
        return uzv;
    }

    public void setUzv(String uzv) {
        this.uzv = uzv;
    }

    public String getNsv() {
        return nsv;
    }

    public void setNsv(String nsv) {
        this.nsv = nsv;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public Double getM1() {
        return m1;
    }

    public void setM1(Double m1) {
        this.m1 = m1;
    }

    public Double getM2() {
        return m2;
    }

    public void setM2(Double m2) {
        this.m2 = m2;
    }

    public Double getM3() {
        return m3;
    }

    public void setM3(Double m3) {
        this.m3 = m3;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bkNumber) {
        this.bknumber = bkNumber;
    }
}
