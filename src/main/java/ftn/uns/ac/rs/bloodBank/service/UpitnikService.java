package ftn.uns.ac.rs.bloodBank.service;

import ftn.uns.ac.rs.bloodBank.model.Upitnik;


public interface UpitnikService {

    void save(Upitnik upitnik);
    void edit(Upitnik upitnik);

    Upitnik findByKorisnikId(Long id);
}
