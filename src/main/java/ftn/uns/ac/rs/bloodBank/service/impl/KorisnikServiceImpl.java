package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;
import ftn.uns.ac.rs.bloodBank.repository.KorisnikRepository;
import ftn.uns.ac.rs.bloodBank.service.KorisnikService;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }


    @Override
    public Korisnik save(Korisnik korisnik) {
        return korisnikRepository.save(korisnik);
    }

    @Override
    public Korisnik findById(Long Id) {
        return korisnikRepository.findById(Id).orElse(null);
    }

    @Override
    public Korisnik update(Korisnik korisnik) {
        return korisnikRepository.saveAndFlush(korisnik);
    }


}
