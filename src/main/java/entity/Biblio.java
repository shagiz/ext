package entity;

import javax.persistence.*;

@Entity
@Table(name = "Bibliogr")
public class Biblio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Bknumber", nullable = false)
    private int bknumber;

    @Column(name = "Authors")
    private String authors;

    @Column(name = "Source")
    private String source;

    @Column(name = "Title")
    private String title;

    public int getBknumber() {
        return bknumber;
    }

    public void setBknumber(int bknumber) {
        this.bknumber = bknumber;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
