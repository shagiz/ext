package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Акустооптические свойства
@Entity
@Table(name = "AcOpTabl")
public class Acop extends BaseHeadClueEntity {

    @ColumnProperty(name = "Длина волны, мкм")
    @Column(name = "WaveLeng")
    private Double waveLeng;

    @ColumnProperty(name = "Nзв")
    @Column(name = "Nzv")
    private String nzv;

    @ColumnProperty(name = "Uзв")
    @Column(name = "Uzv")
    private String uzv;

    @ColumnProperty(name = "Nсв")
    @Column(name = "Nsv")
    private String nsv;

    @Column(name = "E")
    private String e;

    @ColumnProperty(name = "M1, 10-7 см2*cек/г")
    @Column(name = "M1")
    private Double m1;

    @ColumnProperty(name = "M2, 10-18 сек3/г")
    @Column(name = "M2")
    private Double m2;

    @ColumnProperty(name = "M3, 10-12 см*сек2/г")
    @Column(name = "M3")
    private Double m3;

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
}
