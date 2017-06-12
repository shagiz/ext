package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Плотность
@Entity
@Table(name = "DensTabl")
public class Density extends BaseEntity {

    @ColumnProperty(name = "Номер соединения")
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnProperty(name = "Плотность, г/см3")
    @Column(name = "Density")
    private Float density;

    @ColumnProperty(name = "Погрешность, г/см3")
    @Column(name = "ErrDens")
    private Float errDens;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodD")
    private String methodD;

    @ColumnProperty(name = "Ссылка")
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
