package ftn.uns.ac.rs.bloodBank.service;

import ftn.uns.ac.rs.bloodBank.model.OsnovneInformacije;


public interface OsnovneInformacijeService {

    void save(OsnovneInformacije osnovneInformacije);
    void edit(OsnovneInformacije osnovneInformacije);

    OsnovneInformacije findInfoByUserId(Long Id);
}
