package com.endava.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class gsonExample {

    private static final Logger LOGGER = LogManager.getLogger(gsonExample.class);

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setAmount(100);
        payment.setCurrency("RON");
        payment.setCardNumber("45263655565");
        payment.setCustomerName("Johnny Bravo");


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        gson.toJson();//serializare
//        gson.toJson();//deserializare

        String json = gson.toJson(payment);
        LOGGER.info("\n{}",json);


        Payment deserializedPayment = gson.fromJson(json, Payment.class);
        LOGGER.info(payment.equals(deserializedPayment));
        LOGGER.info(deserializedPayment.getCardNumber());
    }
}
