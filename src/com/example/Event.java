package com.example;

import java.time.LocalDateTime;

/**
 * Created by MattyG on 4/18/17.
 */
public class Event {
    private String name;
    private String action;
    private LocalDateTime at;

    //Methods --
    //Constructor

    //GetnSet
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDateTime getAt() {
        return at;
    }

    public void setAt(LocalDateTime at) {
        this.at = at;
    }


    //toString
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", action='" + action + '\'' +
                ", at=" + at +
                '}';
    }
}
