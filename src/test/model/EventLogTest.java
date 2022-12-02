package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventLogTest {
    private Event e1;
    private Event e2;

    @BeforeEach
    public void loadEvents() {
        e1 = new Event("Team added to league");
        e2 = new Event("Team added to league");
        EventLog el = EventLog.getInstance();
        el.logEvent(e1);
        el.logEvent(e2);
    }

    @Test
    public void testLogEvent() {
        List<Event> listOfEvent = new ArrayList<Event>();

        EventLog el = EventLog.getInstance();
        for (Event next : el) {
            listOfEvent.add(next);
        }

        assertTrue(listOfEvent.contains(e1));
        assertTrue(listOfEvent.contains(e1));
    }

}
