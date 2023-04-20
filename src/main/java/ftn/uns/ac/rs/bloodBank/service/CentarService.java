package ftn.uns.ac.rs.bloodBank.service;

import ftn.uns.ac.rs.bloodBank.model.Centar;

import java.util.List;

public interface CentarService{
    Centar save(Centar centar);
    List<Centar> findAll();
    List<Centar> findByAddress(String city);
    List<Centar> findByName(String name);
    List<Centar> findByReview(String sort);
    List<Centar> findByAppointmentReady();
}
