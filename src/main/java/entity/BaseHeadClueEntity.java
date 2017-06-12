package entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseHeadClueEntity extends BaseEntity {

    @ColumnProperty(name = "Номер соединения", allowBlank = false, readOnly = true)
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @ColumnProperty(name = "Ссылка", allowBlank = false)
    @Column(name = "Bknumber")
    private Integer bknumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseHeadClueEntity that = (BaseHeadClueEntity) o;

        if (headClue != that.headClue) return false;
        return bknumber != null ? bknumber.equals(that.bknumber) : that.bknumber == null;

    }

    @Override
    public int hashCode() {
        int result = headClue;
        result = 31 * result + (bknumber != null ? bknumber.hashCode() : 0);
        return result;
    }

    public int getHeadClue() {

        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public Integer getBknumber() {
        return bknumber;
    }

    public void setBknumber(Integer bknumber) {
        this.bknumber = bknumber;
    }
}
