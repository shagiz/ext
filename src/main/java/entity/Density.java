package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DensTabl")
public class Density extends BaseEntity {

    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @Column(name = "Density")
    private Double density;

    @Column(name = "ErrDens")
    private Double errDens;

    @Column(name = "MethodD")
    private String methodD;

    @Column(name = "Bknumber")
    private Integer bknumber;

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Double getErrDens() {
        return errDens;
    }

    public void setErrDens(Double errDens) {
        this.errDens = errDens;
    }

    public String getMethodD() {
        return methodD;
    }

    public void setMethodD(String methodD) {
        this.methodD = methodD;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
