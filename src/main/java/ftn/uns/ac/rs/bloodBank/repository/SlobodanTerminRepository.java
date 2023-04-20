package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlobodanTerminRepository extends JpaRepository<SlobodanTermin, Long> {

   List<SlobodanTermin> findAllByReservated(boolean isReservated);
}
