package ftn.uns.ac.rs.bloodBank.model;

import javax.persistence.*;

@Entity
public class ZakazanTermin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private SlobodanTermin slobodanTermin;  //jedan slobodan termin moze da rezervise jedan korisnik

    @ManyToOne
    private Korisnik korisnik;  //jedan korisnik moze vise termina

    public ZakazanTermin(Long id, SlobodanTermin slobodanTermin, Korisnik korisnik) {
        this.id = id;
        this.slobodanTermin = slobodanTermin;
        this.korisnik = korisnik;
    }

    public ZakazanTermin(SlobodanTermin slobodanTermin, Korisnik korisnik) {
        this.slobodanTermin = slobodanTermin;
        this.korisnik = korisnik;
    }

    public ZakazanTermin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SlobodanTermin getSlobodanTermin() {
        return slobodanTermin;
    }

    public void setSlobodanTermin(SlobodanTermin slobodanTermin) {
        this.slobodanTermin = slobodanTermin;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
