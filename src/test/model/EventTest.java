package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
        private Event e;
        private Date d;

        @BeforeEach
        public void runBefore() {
            e = new Event("Team added to league");
            d = Calendar.getInstance().getTime();
        }

        @Test
        public void testEvent() {
            assertEquals("Team added to league", e.getDescription());
        }

        @Test
        public void testToString() {
            assertEquals(d.toString() + "\n" + "Team added to league", e.toString());
        }
}

