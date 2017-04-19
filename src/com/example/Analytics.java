package com.example;

/**
 * Created by MattyG on 4/18/17.
 */
public interface Analytics {

    /**
     * if event is null -> illegal arg exc
     * if any instance vars of event are null throw ill arg exc
     *
     * if action variable of event is not one of the 4 acceptable ones .. --> throw illegal arg exc.
     *
     * This method should always return true.
     *
     *
     * @param event
     * @return
     */
    boolean addEvent(Event event);
}
