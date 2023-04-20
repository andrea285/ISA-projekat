package ftn.uns.ac.rs.bloodBank.repository;

import ftn.uns.ac.rs.bloodBank.model.Centar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CentarRepository extends JpaRepository<Centar, Long> {

    List<Centar> findAllByAddressContainingIgnoreCase(String address);
    List<Centar> findAllByNameContainingIgnoreCase(String name);
    List<Centar> findByOrderByReviewAsc();
    List<Centar> findByOrderByReviewDesc();
    List<Centar> findAllByReservation(Boolean free);


}
