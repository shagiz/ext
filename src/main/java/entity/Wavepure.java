package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Wavepure")
public class Wavepure extends BaseHeadClueEntity {

    @ColumnName(name = "Нижняя граница")
    @Column(name = "Leftwave")
    private BigDecimal leftwave;

    @ColumnName(name = "Верхняя граница")
    @Column(name = "Rightwave")
    private BigDecimal rightwave;

    public BigDecimal getLeftwave() {
        return leftwave;
    }

    public void setLeftwave(BigDecimal leftwave) {
        this.leftwave = leftwave;
    }

    public BigDecimal getRightwave() {
        return rightwave;
    }

    public void setRightwave(BigDecimal rightwave) {
        this.rightwave = rightwave;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Wavepure wavepure = (Wavepure) o;

        if (leftwave != null ? !leftwave.equals(wavepure.leftwave) : wavepure.leftwave != null) return false;
        return rightwave != null ? rightwave.equals(wavepure.rightwave) : wavepure.rightwave == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (leftwave != null ? leftwave.hashCode() : 0);
        result = 31 * result + (rightwave != null ? rightwave.hashCode() : 0);
        return result;
    }
}
