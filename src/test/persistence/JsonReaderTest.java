package persistence;

import model.Team;
import model.League;
import model.Player;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            League lg = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyLeague() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyLeague.json");
        try {
            League lg = reader.read();
            assertEquals("La Liga", lg.getLname());
            assertEquals(0, lg.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderLeague() {
        JsonReader reader = new JsonReader("./data/testReaderLeague.json");
        try {
            League lg = reader.read();
            assertEquals("La Liga", lg.getLname());
            List<Team> teamsInLeague = lg.getTeamsInLeague();
            assertEquals(0, teamsInLeague.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

