package entity;

import javax.persistence.*;

@Entity
@Table(name = "HeadTabl")
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HeadClue", nullable = false, unique = true)
    private int headClue;

    @Column(name = "System")
    private String system;

    @Column(name = "Expert")
    private String expert;

    @Column(name = "Class")
    private int eClass;

    @Column(name = "Help")
    private String help;

    @OneToOne(mappedBy = "element", fetch = FetchType.LAZY)
    private Referat referat;

    public int getHeadClue() {
        return headClue;
    }

    public void setHeadClue(int headClue) {
        this.headClue = headClue;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public int geteClass() {
        return eClass;
    }

    public void seteClass(int eClass) {
        this.eClass = eClass;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public Referat getReferat() {
        return referat;
    }

    public void setReferat(Referat referat) {
        this.referat = referat;
    }
}
