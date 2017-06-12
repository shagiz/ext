package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//области гомогенности соединения
@Entity
@Table(name = "SistTabl")
public class Sist extends BaseEntity {

    @ColumnProperty(name = "Номер соединения", allowBlank = false, readOnly = true)
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnProperty(name = "Обозначение хим. элемента")
    @Column(name = "ElemNumb", length = 2)
    private String elemNumb;

    @ColumnProperty(name = "Нижняя граница области гомогенности")
    @Column(name = "MinValue")
    private Double minValue;

    @ColumnProperty(name = "Верхняя граница области гомогенности")
    @Column(name = "MaxValue")
    private Double maxValue;

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public String getElemNumb() {
        return elemNumb;
    }

    public void setElemNumb(String elemNumb) {
        this.elemNumb = elemNumb;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }
}
