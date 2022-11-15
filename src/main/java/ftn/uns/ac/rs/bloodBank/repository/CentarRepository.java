package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.Centar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentarRepository extends JpaRepository<Centar, Long> {

    List<Centar> findAllByAddress(String address);
    List<Centar> findAllByName(String name);
    List<Centar> findByOrderByReviewAsc();
    List<Centar> findByOrderByReviewDesc();
    List<Centar> findAllByReservation(Boolean free);


}
