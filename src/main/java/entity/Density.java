package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "DensTabl")
public class Density extends BaseEntity {

    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @Column(name = "Density")
    private Float density;

    @Column(name = "ErrDens")
    private Float errDens;

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

    public Float getDensity() {
        return density;
    }

    public void setDensity(Float density) {
        this.density = density;
    }

    public Float getErrDens() {
        return errDens;
    }

    public void setErrDens(Float errDens) {
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
