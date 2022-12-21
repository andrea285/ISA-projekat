package ftn.uns.ac.rs.bloodBank.service.impl;

import ftn.uns.ac.rs.bloodBank.model.SlobodanTermin;
import ftn.uns.ac.rs.bloodBank.repository.SlobodanTerminRepository;
import ftn.uns.ac.rs.bloodBank.service.SlobodanTerminService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
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

    @SneakyThrows
    @Override
    public Boolean isAvailable(String date, String time, Integer duration) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Boolean exist = false;
        List<SlobodanTermin> allTerm = findAll();
        for (SlobodanTermin st : allTerm) {
            Date term = sdf.parse(st.getDate() + " " + st.getTime());
            //log.error("test1 {}", term);
            Date newTerm = sdf.parse(date + " " + time);
            Date termWithDuration = sdf.parse(st.getDate() + " " + st.getTime());
            termWithDuration.setTime(termWithDuration.getTime()+st.getDuration()*60*1000);
            if (date.equals(st.getDate())) {


                //if (!term.equals(newTerm)) {
                if((term.after(newTerm) || term.before(newTerm) && (termWithDuration.before(newTerm)))){
                    log.error("test {}", newTerm);
                    exist = false;
                } else {
                    //log.error("test2 {}", term);
                    exist = true;
                }
            }

        }
        return exist;
    }



    @Override
    public SlobodanTermin findById(Long id) {
        return slobodanTerminRepository.findById(id).orElse(null);
    }
}
