package entity;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

@Entity
@Table(name = "RefrTabl")
public class Referat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HeadClue", nullable = false)
    private int headClue;

    @Expose
    @OneToOne
    @JoinColumn(name = "HeadClue")
    private Element element;

    @Column(name = "Referat")
    private String value;

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
