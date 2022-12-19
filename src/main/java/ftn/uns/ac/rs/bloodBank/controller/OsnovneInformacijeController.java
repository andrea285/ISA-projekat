package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;
import ftn.uns.ac.rs.bloodBank.model.Kviz;
import ftn.uns.ac.rs.bloodBank.model.OsnovneInformacije;
import ftn.uns.ac.rs.bloodBank.service.impl.KorisnikServiceImpl;
import ftn.uns.ac.rs.bloodBank.service.impl.OsnovneInformacijeServiceImpl;
import ftn.uns.ac.rs.bloodBank.service.impl.UpitnikServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@Slf4j
@RequestMapping("api/v1/osnovneinformacije")
public class OsnovneInformacijeController {

    private final OsnovneInformacijeServiceImpl osnovneInformacijeService;
    private final KorisnikServiceImpl korisnikService;
    private final UpitnikServiceImpl upitnikService;
    public OsnovneInformacijeController(OsnovneInformacijeServiceImpl osnovneInformacijeService, KorisnikServiceImpl korisnikService, UpitnikServiceImpl upitnikService) {
        this.osnovneInformacijeService = osnovneInformacijeService;
        this.korisnikService = korisnikService;
        this.upitnikService = upitnikService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<OsnovneInformacije> findOsnovneInfo(@PathVariable Long userId){
        return new ResponseEntity<>(osnovneInformacijeService.findInfoByUserId(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Kviz kviz){
        log.error("pi {}", kviz.getP().getKorisnik());
        Korisnik k = korisnikService.findById(kviz.getP().getKorisnik());
        kviz.getP().setKorisnikId(k);
        osnovneInformacijeService.save(kviz.getP());
        upitnikService.save(kviz.getU());
        return new ResponseEntity<>("Uspesno ste sacuvali", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody OsnovneInformacije osnovneInformacije){
        osnovneInformacijeService.edit(osnovneInformacije);
        return new ResponseEntity<>("Uspesno ste izmenili", HttpStatus.OK);
    }
}
