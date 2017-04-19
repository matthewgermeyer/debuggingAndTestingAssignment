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

            Assert.fail(" if event is null we should get illegal argument exc.. ");
        } catch (IllegalArgumentException e) {
            // All's well
        }
        Event event = new Event();

        try {
            analyticsImpl.addEvent(event);
            Assert.fail("This is bad ... ");
        } catch (IllegalArgumentException e) {
            // All's well
        }

        event.setAction("Face2Face");
        event.setAt(LocalDateTime.now());
        event.setName("Marty");

        //flag represents the bool that addEvent returns..
        boolean flag = analyticsImpl.addEvent(event);
        //Assert that flag is true (it should be.. unless..)
        Assert.assertTrue(flag);

    }

    @Test
    public void testAction() throws Exception {
        // Exception test

        Event event = new Event();

        // setting action to bad value.
        event.setAction("blah");
        event.setAt(LocalDateTime.now());
        event.setName("Marty");

        //test for accepted actions.... 'blah' is not one we want for Action.
        try {
            analyticsImpl.addEvent(event);
            Assert.fail("should not get here..illegal argument should be thrown for action -> 'blah'  ");
        } catch (IllegalArgumentException e) {
            // All's well
        }
    }
}
