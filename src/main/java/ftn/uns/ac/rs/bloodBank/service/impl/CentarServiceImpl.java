package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.Centar;
import ftn.uns.ac.rs.bloodBank.repository.CentarRepository;
import ftn.uns.ac.rs.bloodBank.service.CentarService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CentarServiceImpl implements CentarService {

    private final CentarRepository centarRepository;

    public CentarServiceImpl(final CentarRepository centarRepository) {
        this.centarRepository = centarRepository;
    }

    @Override
    public Centar save(Centar centar) {
        return centarRepository.save(centar);
    }

    @Override
    public List<Centar> findAll() {
        return centarRepository.findAll();
    }

    @Override
    public List<Centar> findByAddress(String city) {
        return centarRepository.findAllByAddress(city);
    }

    @Override
    public List<Centar> findByName(String name) {
        return centarRepository.findAllByName(name);
    }

    @Override
    public List<Centar> findByReview(String sort) {
        if (sort.equalsIgnoreCase("asc")) {
            return centarRepository.findByOrderByReviewAsc();

        } else {
            return centarRepository.findByOrderByReviewDesc();
        }
    }

    @Override
    public List<Centar> findByAppointmentReady() {
        return centarRepository.findAllByReservation(true);
    }
}
