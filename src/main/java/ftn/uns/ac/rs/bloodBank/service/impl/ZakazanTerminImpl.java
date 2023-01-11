package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import ftn.uns.ac.rs.bloodBank.model.ZakazanTermin;
import ftn.uns.ac.rs.bloodBank.repository.ZakazanTerminRepository;
import ftn.uns.ac.rs.bloodBank.service.ZakazanTerminService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ZakazanTerminImpl implements ZakazanTerminService {
    private final ZakazanTerminRepository zakazanTerminRepository;
    private final SlobodanTerminImpl slobodanTermin;


    public ZakazanTerminImpl(ZakazanTerminRepository zakazanTerminRepository, SlobodanTerminImpl slobodanTermin) {
        this.zakazanTerminRepository = zakazanTerminRepository;
        this.slobodanTermin = slobodanTermin;
    }

    @Override
    public void save(ZakazanTermin zakazanTermin) {
        zakazanTerminRepository.save(zakazanTermin);

    }

    @SneakyThrows
    @Override
    public List<SlobodanTermin> getAllFreeTermins(String date, String startTime, String endTime){
        List<SlobodanTermin> allFreeTermin = slobodanTermin.findAll();
        List<SlobodanTermin> specificFreeTermin = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startApp = sdf.parse(date + " " + startTime);
        Date endApp = sdf.parse(date + " " + endTime);
        for (SlobodanTermin st:allFreeTermin
        ) {
            Date term = sdf.parse(st.getDate() + " " + st.getTime());

            if (term.after(startApp) && term.before(endApp) && !st.getReservated()){

                specificFreeTermin.add(st);
            }
        }
        return specificFreeTermin;
    }

    @Override
    public List<ZakazanTermin> getAllZakazaniTermini(Long id) {
        return zakazanTerminRepository.getAllByKorisnik_Id(id);
    }

    @Override
    public ZakazanTermin findById(Long id) {
        return zakazanTerminRepository.findById(id).get();
    }

    @Override
    public ZakazanTermin delete(Long id) {
        ZakazanTermin zt = findById(id);
        zakazanTerminRepository.delete(zt);
        return zt;
    }

}
