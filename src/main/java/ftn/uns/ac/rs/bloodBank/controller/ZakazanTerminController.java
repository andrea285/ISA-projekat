package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.ZakazanTermin;
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

    public ZakazanTerminController(ZakazanTerminImpl zakazanTermin) {
        this.zakazanTermin = zakazanTermin;
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
        LocalDate trenutni = LocalDate.now();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(zt.getSlobodanTermin().getDate()+" "+zt.getSlobodanTermin().getTime());
        LocalDate lastTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate beforeSix = trenutni.minusMonths(6);

        if(lastTime.isAfter(beforeSix)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
