package ftn.uns.ac.rs.bloodBank.service;

public interface SendEmailService {

    boolean sendEmail(String from, String subject, String message);
}
