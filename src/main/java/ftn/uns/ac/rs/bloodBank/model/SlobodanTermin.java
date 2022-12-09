package ftn.uns.ac.rs.bloodBank.model;

import javax.persistence.*;

@Entity
public class SlobodanTermin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String date;
    private String time;
    private Integer duration; //min

    public SlobodanTermin(Long id, String date, String time, Integer duration) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public SlobodanTermin(String date, String time, Integer duration) {
        this.date = date;
        this.time = time;
        this.duration = duration;
    }

    public SlobodanTermin() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SlobodanTermin{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", duration=" + duration +
                '}';
    }
}
