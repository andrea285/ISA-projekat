package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.OsnovneInformacije;
import ftn.uns.ac.rs.bloodBank.service.impl.OsnovneInformacijeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/osnovneinformacije")
public class OsnovneInformacijeController {

    private final OsnovneInformacijeServiceImpl osnovneInformacijeService;

    public OsnovneInformacijeController(OsnovneInformacijeServiceImpl osnovneInformacijeService) {
        this.osnovneInformacijeService = osnovneInformacijeService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<OsnovneInformacije> findOsnovneInfo(@PathVariable Long id){
        return new ResponseEntity<>(osnovneInformacijeService.findInfoByUserId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody OsnovneInformacije osnovneInformacije){
        osnovneInformacijeService.save(osnovneInformacije);
        return new ResponseEntity<>("Uspesno ste sacuvali", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody OsnovneInformacije osnovneInformacije){
        osnovneInformacijeService.edit(osnovneInformacije);
        return new ResponseEntity<>("Uspesno ste izmenili", HttpStatus.OK);
    }
}
