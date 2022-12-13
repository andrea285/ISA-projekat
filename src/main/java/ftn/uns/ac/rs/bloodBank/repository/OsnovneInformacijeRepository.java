package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.OsnovneInformacije;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OsnovneInformacijeRepository extends JpaRepository<OsnovneInformacije, Long> {

    OsnovneInformacije findByKorisnik_Id(Long id);

}
