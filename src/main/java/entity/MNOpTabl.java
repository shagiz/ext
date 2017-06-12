package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "MNOpTabl")
public class MNOpTabl extends BaseHeadClueEntity {

    @ColumnName(name = "Сингония")
    @Column(name = "SingCode")
    private String singCode;

    @ColumnName(name = "Длина волны, мкм")
    @Column(name = "Lyambda")
    private BigDecimal Lyambda;

    @ColumnName(name = "n^w")
    @Column(name = "Nw")
    private BigDecimal Nw;

    @ColumnName(name = "n^2w")
    @Column(name = "N2w")
    private BigDecimal N2w;

    @ColumnName(name = "Обозначение коэффициента")
    @Column(name = "Znakcon")
    private String Znakcon;

    @ColumnName(name = "Значение коэффициента")
    @Column(name = "K")
    private BigDecimal K;

    @ColumnName(name = "Погрешность")
    @Column(name = "ErrKj")
    private BigDecimal ErrKj;

    @ColumnName(name = "СингПримечанияония")
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
