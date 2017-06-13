package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SingTabl")
public class SingTabl {

    @Id
    @Column(name = "SingClue")
    private int singClue;

    @Column(name = "HeadClue")
    private int headClue;

    @Column(name = "SingType")
    private String singType;

    public int getSingClue() {
        return singClue;
    }

    public void setSingClue(int singClue) {
        this.singClue = singClue;
    }

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public String getSingType() {
        return singType;
    }

    public void setSingType(String singType) {
        this.singType = singType;
    }
}
