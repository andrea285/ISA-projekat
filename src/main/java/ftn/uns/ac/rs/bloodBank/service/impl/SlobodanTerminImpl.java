package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import ftn.uns.ac.rs.bloodBank.repository.SlobodanTerminRepository;
import ftn.uns.ac.rs.bloodBank.service.SlobodanTerminService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SlobodanTerminImpl implements SlobodanTerminService {

    private final SlobodanTerminRepository slobodanTerminRepository;

    public SlobodanTerminImpl(SlobodanTerminRepository slobodanTerminRepository) {
        this.slobodanTerminRepository = slobodanTerminRepository;
    }

    @Override
    public SlobodanTermin save(SlobodanTermin slobodanTermin) {
        return slobodanTerminRepository.save(slobodanTermin);
    }

    @Override
    public List<SlobodanTermin> findAll() {
        return slobodanTerminRepository.findAll();
    }
}
