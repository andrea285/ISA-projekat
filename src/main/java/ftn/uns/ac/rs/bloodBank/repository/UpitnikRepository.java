package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.Upitnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpitnikRepository extends JpaRepository<Upitnik, Long> {

    Upitnik findByKorisnik_Id(Long id);
}
