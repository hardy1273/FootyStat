package persistence;

import model.League;
import model.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkTeam(League lg) {
       assertEquals(lg, lg.getLname());

        //Stub
    }
}
