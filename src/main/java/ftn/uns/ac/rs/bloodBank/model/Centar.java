package ftn.uns.ac.rs.bloodBank.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Centar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String address;
    private String description;
    private Double review;
    private Boolean reservation;
    private String admins;
    private String medWorkers;
    private Date dateAndTime;
    private Double duration;
    private String start;
    private String end;



    public Centar() {
    }

    public Centar(Long id, String name, String address, String description, Double review, Boolean reservation, String admins, String medWorkers, Date dateAndTime, Double duration, String start, String end) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.review = review;
        this.reservation = reservation;
        this.admins = admins;
        this.medWorkers = medWorkers;
        this.dateAndTime = dateAndTime;
        this.duration = duration;
        this.start = start;
        this.end = end;
    }

    public Centar(String name, String address, String description, Double review, Boolean reservation, String admins, String medWorkers, Date dateAndTime, Double duration, String start, String end) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.review = review;
        this.reservation = reservation;
        this.admins = admins;
        this.medWorkers = medWorkers;
        this.dateAndTime = dateAndTime;
        this.duration = duration;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getReview() {
        return review;
    }

    public void setReview(Double review) {
        this.review = review;
    }

    public Boolean getReservation() {
        return reservation;
    }

    public void setReservation(Boolean reservation) {
        this.reservation = reservation;
    }

    public String getAdmins() {
        return admins;
    }

    public void setAdmins(String admins) {
        this.admins = admins;
    }

    public String getMedWorkers() {
        return medWorkers;
    }

    public void setMedWorkers(String medWorkers) {
        this.medWorkers = medWorkers;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
