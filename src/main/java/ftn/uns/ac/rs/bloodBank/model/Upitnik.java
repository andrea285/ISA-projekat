package ftn.uns.ac.rs.bloodBank.model;

import javax.persistence.*;

@Entity
public class Upitnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean dobrovoljan;
    private boolean odbijen;
    private boolean lekovi;
    private boolean nahranjen;
    private boolean tetoviran;

    @OneToOne
    private Korisnik korisnik;

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

    public Long id() {
        return id;
    }

    public Upitnik setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean dobrovoljan() {
        return dobrovoljan;
    }

    public Upitnik setDobrovoljan(boolean dobrovoljan) {
        this.dobrovoljan = dobrovoljan;
        return this;
    }

    public boolean odbijen() {
        return odbijen;
    }

    public Upitnik setOdbijen(boolean odbijen) {
        this.odbijen = odbijen;
        return this;
    }

    public boolean lekovi() {
        return lekovi;
    }

    public Upitnik setLekovi(boolean lekovi) {
        this.lekovi = lekovi;
        return this;
    }

    public boolean nahranjen() {
        return nahranjen;
    }

    public Upitnik setNahranjen(boolean nahranjen) {
        this.nahranjen = nahranjen;
        return this;
    }

    public boolean tetoviran() {
        return tetoviran;
    }

    public Upitnik setTetoviran(boolean tetoviran) {
        this.tetoviran = tetoviran;
        return this;
    }

    public Korisnik korisnik() {
        return korisnik;
    }

    public Upitnik setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
        return this;
    }
}
