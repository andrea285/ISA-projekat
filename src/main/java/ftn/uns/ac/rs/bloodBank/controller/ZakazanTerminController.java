package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;
import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import ftn.uns.ac.rs.bloodBank.model.ZakazanTermin;
import ftn.uns.ac.rs.bloodBank.model.ZakazaniTerminHttpRequst;
import ftn.uns.ac.rs.bloodBank.service.impl.EmailServiceImpl;
import ftn.uns.ac.rs.bloodBank.service.impl.KorisnikServiceImpl;
import ftn.uns.ac.rs.bloodBank.service.impl.SlobodanTerminImpl;
import ftn.uns.ac.rs.bloodBank.service.impl.ZakazanTerminImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/appointments")
@Slf4j
public class ZakazanTerminController {

    private final ZakazanTerminImpl zakazanTermin;
    private final KorisnikServiceImpl korisnikService;
    private final SlobodanTerminImpl slobodanTermin;
    private final EmailServiceImpl emailService;

    public ZakazanTerminController(ZakazanTerminImpl zakazanTermin, KorisnikServiceImpl korisnikService, SlobodanTerminImpl slobodanTermin, EmailServiceImpl emailService) {
        this.zakazanTermin = zakazanTermin;
        this.korisnikService = korisnikService;
        this.slobodanTermin = slobodanTermin;
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCenters(@RequestParam("date")String date, @RequestParam("startTime")String startTime, @RequestParam("endTime")String endTime){
        log.error(date);
        log.error(startTime);
        log.error(endTime);

        return new ResponseEntity<>(zakazanTermin.getAllFreeTermins(date, startTime, endTime), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllZakazaniTerminiByKorisnik(@PathVariable Long id){
        return new ResponseEntity<>(zakazanTermin.getAllZakazaniTermini(id), HttpStatus.OK);
    }
    @SneakyThrows
    @GetMapping("/six")
    public ResponseEntity<Boolean> sixMonthsDonations(){
        ArrayList<ZakazanTermin> zakazanTermins = (ArrayList<ZakazanTermin>) zakazanTermin.getAllZakazaniTermini(5l);
        int size = zakazanTermins.size();
        if(size == 0){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        ZakazanTermin zt = zakazanTermins.get(size-1);
        log.error("test {}", zt.toString());
        LocalDate trenutni = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(zt.getSlobodanTermin().getDate()+" "+zt.getSlobodanTermin().getTime());
        LocalDate lastTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate beforeSix = trenutni.minusMonths(6);

        if(lastTime.isBefore(beforeSix)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(false, HttpStatus.OK);   //todo vratiti u false
        }
    }
    @PostMapping
    public ResponseEntity<ZakazanTermin> saveZakazanTermin(@RequestBody ZakazaniTerminHttpRequst zakazaniTerminHttpRequst){

        Korisnik k= korisnikService.findById(zakazaniTerminHttpRequst.getKorisnikId());
        SlobodanTermin st = slobodanTermin.findById(zakazaniTerminHttpRequst.getSlobodanTerminId());
        ZakazanTermin zt = new ZakazanTermin();
        zt.setKorisnik(k);
        zt.setSlobodanTermin(st);

        slobodanTermin.setReservation(st);

        zakazanTermin.save(zt);


        emailService.sendEmail(k.getEmail(), "Zakazan termin", "Uspesno ste zakazali termin za donaciju krvi. Datum: "+st.getDate()+" Vreme: "+st.getTime());
        return new ResponseEntity<>(zt, HttpStatus.OK);


    }
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findZakazanTermin(@PathVariable Long id){
        return new ResponseEntity<>(zakazanTermin.getAllZakazaniTermini(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id){

        ZakazanTermin zt = zakazanTermin.findById(id);
        //SlobodanTermin slobodanTermin1 = slobodanTermin.findById(zt.getSlobodanTermin());

        slobodanTermin.setReservation(zt.getSlobodanTermin());

        return  new ResponseEntity<>(zakazanTermin.delete(id), HttpStatus.OK);

    }
}
