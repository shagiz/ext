package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "MNOpTabl")
public class MNOpTabl extends BaseHeadClueEntity {

    @ColumnProperty(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnProperty(name = "Длина волны, мкм")
    @Column(name = "Lyambda")
    private BigDecimal Lyambda;

    @ColumnProperty(name = "n^w")
    @Column(name = "Nw")
    private BigDecimal Nw;

    @ColumnProperty(name = "n^2w")
    @Column(name = "N2w")
    private BigDecimal N2w;

    @ColumnProperty(name = "Обозначение коэффициента")
    @Column(name = "Znakcon")
    private String Znakcon;

    @ColumnProperty(name = "Значение коэффициента")
    @Column(name = "K")
    private BigDecimal K;

    @ColumnProperty(name = "Погрешность")
    @Column(name = "ErrKj")
    private BigDecimal ErrKj;

    @ColumnProperty(name = "СингПримечанияония")
    @Column(name = "MethodK")
    private String MethodK;

    public String getSingCode() {
        return singCode;
    }

    public void setSingCode(String singCode) {
        this.singCode = singCode;
    }

    public BigDecimal getLyambda() {
        return Lyambda;
    }

    public void setLyambda(BigDecimal lyambda) {
        Lyambda = lyambda;
    }

    public BigDecimal getNw() {
        return Nw;
    }

    public void setNw(BigDecimal nw) {
        Nw = nw;
    }

    public BigDecimal getN2w() {
        return N2w;
    }

    public void setN2w(BigDecimal n2w) {
        N2w = n2w;
    }

    public String getZnakcon() {
        return Znakcon;
    }

    public void setZnakcon(String znakcon) {
        Znakcon = znakcon;
    }

    public BigDecimal getK() {
        return K;
    }

    public void setK(BigDecimal k) {
        K = k;
    }

    public BigDecimal getErrKj() {
        return ErrKj;
    }

    public void setErrKj(BigDecimal errKj) {
        ErrKj = errKj;
    }

    public String getMethodK() {
        return MethodK;
    }

    public void setMethodK(String methodK) {
        MethodK = methodK;
    }
}
