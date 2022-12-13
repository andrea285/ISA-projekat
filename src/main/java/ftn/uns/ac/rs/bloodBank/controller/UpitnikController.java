package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.Upitnik;
import ftn.uns.ac.rs.bloodBank.service.impl.UpitnikServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/upitnik")
public class UpitnikController {

    private final UpitnikServiceImpl upitnikService;

    public UpitnikController(UpitnikServiceImpl upitnikService) {
        this.upitnikService = upitnikService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<Upitnik> findOsnovneInfo(@PathVariable Long id){
        return new ResponseEntity<>(upitnikService.findByKorisnikId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Upitnik upitnik){
        upitnikService.save(upitnik);
        return new ResponseEntity<>("Uspesno ste sacuvali", HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Upitnik upitnik){
        upitnikService.edit(upitnik);
        return new ResponseEntity<>("Uspesno ste izmenili", HttpStatus.OK);
    }

}
