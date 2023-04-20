package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository <Korisnik, Long> {
}
