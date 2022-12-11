package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.service.impl.ZakazanTerminImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
