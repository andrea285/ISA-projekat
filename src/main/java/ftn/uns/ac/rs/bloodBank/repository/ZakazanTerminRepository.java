package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.ZakazanTermin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZakazanTerminRepository extends JpaRepository<ZakazanTermin, Long> {

    List<ZakazanTermin> getAllByKorisnik_Id(Long id);
}
