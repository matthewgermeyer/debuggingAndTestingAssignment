package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestAnalytics {

    AnalyticsImpl analyticsImpl;

    @Before
    public void setUp() throws Exception {
        analyticsImpl = new AnalyticsImpl();
    }

    @Test
    public void testAddEvent() throws Exception {
        // Exception test
        try {
            analyticsImpl.addEvent(null);
            Assert.fail("Adding a null event should throw an exception ... ");
        } catch (IllegalArgumentException e) {
            // All's well
        }
        Event event = new Event();

        try {
            analyticsImpl.addEvent(event);
            Assert.fail("All 3 paramaters are null .. ");
        } catch (IllegalArgumentException e) {
            // All's well
        }

        event.setAction("Face2Face");
        event.setAt(LocalDateTime.now());
        event.setName("Marty");

        boolean flag = analyticsImpl.addEvent(event);
        Assert.assertTrue(flag);

//
//        // Boundary test
//        assertEquals(analyticsImpl.addEvent(""), 0);
//
//        // Random test
//        String randomText = RandomStringUtils.random(random.nextInt(1000));
//        System.out.printf("length=%d for %s%n", randomText.length(), randomText);
//        assertEquals(foo.getStringLength(randomText), randomText.length());
    }

    // new copy of above:
    /*
    The requirements have changed. Action can only be one of the following values:
Face2Face
PhoneCall
TextMessaging
Unknown

The action variable in Event has to stay a String for backward compatibility.
Add a check in the addEvent method to validate the String value. If not valid throw an IllegalArgumentException.

Refactor the test case before making the changes to the addEvent method.
     */

    @Test
    public void testAction() throws Exception {
        // Exception test

        Event event = new Event();

        event.setAction("blah");
        event.setAt(LocalDateTime.now());
        event.setName("Marty");

        try {
            analyticsImpl.addEvent(event);
            Assert.fail("Action was not an allowed value ..  ");
        } catch (IllegalArgumentException e) {
            // All's well
        }
    }
}
