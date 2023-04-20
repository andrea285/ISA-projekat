package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.OsnovneInformacije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OsnovneInformacijeRepository extends JpaRepository<OsnovneInformacije, Long> {
    @Query("select o from OsnovneInformacije o where o.korisnikId.id = ?1")

    OsnovneInformacije findByKorisnikId_Id(Long id);

    OsnovneInformacije findByKorisnikId(Long id);


}
