package ftn.uns.ac.rs.bloodBank.service;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import ftn.uns.ac.rs.bloodBank.model.ZakazanTermin;
import lombok.SneakyThrows;

import java.util.List;

public interface ZakazanTerminService {

    void save(ZakazanTermin zakazanTermin);

    @SneakyThrows
    List<SlobodanTermin> getAllFreeTermins(String date, String startTime, String endTime);

    List<ZakazanTermin> getAllZakazaniTermini(Long id);
}
