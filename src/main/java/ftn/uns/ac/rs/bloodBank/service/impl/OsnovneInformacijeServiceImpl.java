package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.OsnovneInformacije;
import ftn.uns.ac.rs.bloodBank.repository.OsnovneInformacijeRepository;
import ftn.uns.ac.rs.bloodBank.service.OsnovneInformacijeService;
import org.springframework.stereotype.Service;

@Service
public class OsnovneInformacijeServiceImpl implements OsnovneInformacijeService {

    private final OsnovneInformacijeRepository osnovneInformacijeRepository;

    public OsnovneInformacijeServiceImpl(OsnovneInformacijeRepository osnovneInformacijeRepository) {
        this.osnovneInformacijeRepository = osnovneInformacijeRepository;
    }

    @Override
    public void save(OsnovneInformacije osnovneInformacije) {
        osnovneInformacijeRepository.save(osnovneInformacije);
    }

    @Override
    public void edit(OsnovneInformacije osnovneInformacije) {
        osnovneInformacijeRepository.saveAndFlush(osnovneInformacije);
    }

    @Override
    public OsnovneInformacije findInfoByUserId(Long id) {
        return osnovneInformacijeRepository.findByKorisnikId_Id(id);
    }
}
