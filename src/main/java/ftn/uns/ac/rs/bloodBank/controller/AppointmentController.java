package ftn.uns.ac.rs.bloodBank.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/appointments")
@Slf4j
public class AppointmentController {

    @GetMapping
    public ResponseEntity<?> getAllCenters(@RequestParam("date")String date){
        log.error(date);
        return new ResponseEntity(date, HttpStatus.OK);
    }
}
