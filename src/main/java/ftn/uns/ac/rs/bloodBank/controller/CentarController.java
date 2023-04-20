package ftn.uns.ac.rs.bloodBank.controller;

import ftn.uns.ac.rs.bloodBank.model.Centar;
import ftn.uns.ac.rs.bloodBank.service.impl.CentarServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/v1/centar")
public class CentarController {

    private final CentarServiceImpl centarService;

    public CentarController(final CentarServiceImpl centarService) {
        this.centarService = centarService;
    }

    @PostMapping
    public ResponseEntity<Centar> save(@RequestBody Centar centar){
        return new ResponseEntity<>(centarService.save(centar), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Centar>> findAll(@RequestParam("city") String city,
                                                @RequestParam("name") String name,
                                                @RequestParam("sort") String sort,
                                                @RequestParam("free") Boolean free){
        if(!city.equalsIgnoreCase("null")){
            return new ResponseEntity<>(centarService.findByAddress(city), HttpStatus.OK);
        }else if (!name.equalsIgnoreCase("null")) {
            return new ResponseEntity<>(centarService.findByName(name), HttpStatus.OK);
        }else if (sort.equalsIgnoreCase("asc")) {
            return new ResponseEntity<>(centarService.findByReview(sort), HttpStatus.OK);
        }else if (sort.equalsIgnoreCase("desc")) {
            return new ResponseEntity<>(centarService.findByReview(sort), HttpStatus.OK);
        } else if (free) {
            return new ResponseEntity<>(centarService.findByAppointmentReady(), HttpStatus.OK);
        }else
            return new ResponseEntity<>(centarService.findAll(), HttpStatus.OK);
    }


}
