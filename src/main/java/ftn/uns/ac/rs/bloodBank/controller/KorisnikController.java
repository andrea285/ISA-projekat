package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.Korisnik;
import ftn.uns.ac.rs.bloodBank.service.impl.KorisnikServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/korisnik")
public class KorisnikController {

    private final KorisnikServiceImpl korisnikService;

    public KorisnikController(KorisnikServiceImpl korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<Korisnik> findById(@RequestParam("id") Long id){
        return ResponseEntity.ok(korisnikService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Korisnik> save(@RequestBody Korisnik korisnik){
        return ResponseEntity.ok(korisnikService.update(korisnik));
    }


}
