package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Плотность
@Entity
@Table(name = "DensTabl")
public class Density extends BaseHeadClueEntity {
    @ColumnProperty(name = "Плотность, г/см3")
    @Column(name = "Density")
    private Float density;

    @ColumnProperty(name = "Погрешность, г/см3")
    @Column(name = "ErrDens")
    private Float errDens;

    @ColumnProperty(name = "Примечания")
    @Column(name = "MethodD")
    private String methodD;

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
}
