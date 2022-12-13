package ftn.uns.ac.rs.bloodBank.model;

import javax.persistence.*;

@Entity
public class Upitnik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private boolean dobrovoljan;
    private boolean odbijen;
    private boolean lekovi;
    private boolean nahranjen;
    private boolean tetoviran;

    @OneToOne
    private Korisnik korisnik;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Upitnik() {
    }

    public Upitnik(Long id, boolean dobrovoljan, boolean odbijen, boolean lekovi, boolean nahranjen, boolean tetoviran, Korisnik korisnik) {
        this.id = id;
        this.dobrovoljan = dobrovoljan;
        this.odbijen = odbijen;
        this.lekovi = lekovi;
        this.nahranjen = nahranjen;
        this.tetoviran = tetoviran;
        this.korisnik = korisnik;
    }

    public Upitnik(boolean dobrovoljan, boolean odbijen, boolean lekovi, boolean nahranjen, boolean tetoviran, Korisnik korisnik) {
        this.dobrovoljan = dobrovoljan;
        this.odbijen = odbijen;
        this.lekovi = lekovi;
        this.nahranjen = nahranjen;
        this.tetoviran = tetoviran;
        this.korisnik = korisnik;
    }

    public boolean isDobrovoljan() {
        return dobrovoljan;
    }

    public void setDobrovoljan(boolean dobrovoljan) {
        this.dobrovoljan = dobrovoljan;
    }

    public boolean isOdbijen() {
        return odbijen;
    }

    public void setOdbijen(boolean odbijen) {
        this.odbijen = odbijen;
    }

    public boolean isLekovi() {
        return lekovi;
    }

    public void setLekovi(boolean lekovi) {
        this.lekovi = lekovi;
    }

    public boolean isNahranjen() {
        return nahranjen;
    }

    public void setNahranjen(boolean nahranjen) {
        this.nahranjen = nahranjen;
    }

    public boolean isTetoviran() {
        return tetoviran;
    }

    public void setTetoviran(boolean tetoviran) {
        this.tetoviran = tetoviran;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
