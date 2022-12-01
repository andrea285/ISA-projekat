package ftn.uns.ac.rs.bloodBank.service;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;

import java.util.List;

public interface SlobodanTerminService {
    SlobodanTermin save(SlobodanTermin slobodanTermin);
    List<SlobodanTermin> findAll();

}
