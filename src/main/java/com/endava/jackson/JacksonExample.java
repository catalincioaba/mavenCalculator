package com.endava.jackson;

import com.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {

    private static final Logger LOGGER = LogManager.getLogger(JacksonExample.class);
    public static void main(String[] args) throws JsonProcessingException {

        Payment payment = new Payment();
        payment.setAmount(200.5);
        payment.setCurrency("EUR");
        payment.setCardNumber("3255698489");
        payment.setCustomerName("Johnny Walker");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payment);

        LOGGER.info(json);

        Payment deserializedPayment = objectMapper.readValue(json, Payment.class);
        LOGGER.info(deserializedPayment.equals(payment));

    }
}
