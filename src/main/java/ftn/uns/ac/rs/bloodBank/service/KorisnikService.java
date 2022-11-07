package ftn.uns.ac.rs.bloodBank.service;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;

public interface KorisnikService {
    Korisnik save(Korisnik korisnik);
    Korisnik findById(Long Id);
}
