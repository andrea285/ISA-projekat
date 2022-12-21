package ftn.uns.ac.rs.bloodBank.service.impl;
import ftn.uns.ac.rs.bloodBank.service.SendEmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements SendEmailService {

    private JavaMailSender emailSender;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public boolean sendEmail(String from, String subject, String message1) {

        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(from);
            message.setSubject(subject);
            message.setText(message1);
            emailSender.send(message);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
