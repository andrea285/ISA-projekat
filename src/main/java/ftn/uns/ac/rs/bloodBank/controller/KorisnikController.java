package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;
import ftn.uns.ac.rs.bloodBank.service.impl.KorisnikServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/korisnik")
public class KorisnikController {

    private final KorisnikServiceImpl korisnikService;

    public KorisnikController(KorisnikServiceImpl korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Korisnik> findById(@PathVariable Long id){
        return ResponseEntity.ok(korisnikService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Korisnik> save(@RequestBody Korisnik korisnik){
        return ResponseEntity.ok(korisnikService.save(korisnik));
    }
}
