package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.Upitnik;
import ftn.uns.ac.rs.bloodBank.repository.UpitnikRepository;
import ftn.uns.ac.rs.bloodBank.service.UpitnikService;
import org.springframework.stereotype.Service;

@Service
public class UpitnikServiceImpl implements UpitnikService {

    private final UpitnikRepository upitnikRepository;

    public UpitnikServiceImpl(UpitnikRepository upitnikRepository) {
        this.upitnikRepository = upitnikRepository;
    }

    @Override
    public void save(Upitnik upitnik) {
        Upitnik u = new Upitnik(upitnik.dobrovoljan(),upitnik.odbijen(), upitnik.lekovi(), upitnik.nahranjen(), upitnik.tetoviran(), upitnik.korisnik());

        upitnikRepository.save(u);
    }

    @Override
    public void edit(Upitnik upitnik) {
        upitnikRepository.saveAndFlush(upitnik);
    }

    @Override
    public Upitnik findByKorisnikId(Long id) {
        return upitnikRepository.findByKorisnik_Id(id);
    }
}
