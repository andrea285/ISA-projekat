package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import ftn.uns.ac.rs.bloodBank.service.impl.SlobodanTerminImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j //
@RequestMapping("api/v1/termin")
public class SlobodanTerminController {

    private final SlobodanTerminImpl slobodanTerminImpl;

    public SlobodanTerminController(SlobodanTerminImpl slobodanTerminImpl) {
        this.slobodanTerminImpl = slobodanTerminImpl;
    }

    @GetMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_WORKER')")
    public ResponseEntity<List<SlobodanTermin>> findAll(){
        return new ResponseEntity<>(slobodanTerminImpl.findAll(), HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> save(@RequestBody SlobodanTermin slobodanTermin){
        log.error("does exist {}", slobodanTerminImpl.isAvailable(slobodanTermin.getDate(), slobodanTermin.getTime(), slobodanTermin.getDuration()));
        if(!slobodanTerminImpl.isAvailable(slobodanTermin.getDate(), slobodanTermin.getTime(), slobodanTermin.getDuration())){

            return new ResponseEntity<>(slobodanTerminImpl.save(slobodanTermin), HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
        }
    }



}
