package persistence;

import model.League;
import model.Team;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            League lg = new League("La Liga");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyLeague() {
        try {
            League lg = new League("La Liga");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyLeague.json");
            writer.open();
            writer.write(lg);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyLeague.json");
            lg = reader.read();
            assertEquals("La Liga", lg.getLname());
            assertEquals(0, lg.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterLeague() {
        try {
            League lg = new League("La Liga");
            lg.addTeamToLeague(new Team("Barca",20,1));
            lg.addTeamToLeague(new Team("Madrid",19,2));
            JsonWriter writer = new JsonWriter("./data/testWriterLeague.json");
            writer.open();
            writer.write(lg);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterLeague.json");
            lg = reader.read();
            assertEquals("La Liga", lg.getLname());
            List<Team> teams = lg.getTeamsInLeague();
            assertEquals(0, teams.size());


        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}