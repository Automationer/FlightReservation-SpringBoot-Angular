package com.cyramsolutions.flight_reservation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {

    private final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendItinerary(String address, String filePath) {
        LOGGER.info("Inside sendItinerary()");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(address);
            helper.setSubject("Itinerary for your flight");
            helper.setText("Please find your Itinerary attached.");
            helper.addAttachment("Itinerary", new File(filePath));
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Exception inside sendItinerary: " + e);
        }
    }

}
