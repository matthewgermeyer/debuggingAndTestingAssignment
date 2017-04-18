package com.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Log how long the method took to execute (i.e. log before returning from the method).
 */

public class AnalyticsImpl implements Analytics {
    Random rando = new Random();
    private static final Logger LOGGER = Logger.getLogger("com.example");


    @Override
    public boolean addEvent(Event event) throws InterruptedException {
        //Timestamp1
        Instant firstInstant = Instant.now();
        if (event == null) {
            throw new IllegalArgumentException("Parameter cannot be null");
        }

        if (event.getAction() == null || event.getAt() == null || event.getName() == null) {
            throw new IllegalArgumentException("Please set all 3 parameters .. ");
        }

        boolean isActionOk = event.getAction().equals ("Face2Face") || event.getAction().equals ("PhoneCall") || event.getAction().equals ("TextMessaging") || event.getAction().equals ("Unknown");

        if (!isActionOk) {
            throw new IllegalArgumentException("Not a valid action .. ");
        }

        System.out.println(event);


        Thread.sleep(rando.nextInt(3000));

        Instant secondInstant = Instant.now();
        Duration duration = Duration.between(firstInstant, secondInstant);
        System.out.println("Duration: " + duration);

        //Log the logDuration
        LOGGER.info(duration.toString());
        if (rando.nextInt(10) == 1) {
            return false;
        }
        return true;

    }


}
