package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeagueTest {
    private League leagueTest;

    @BeforeEach
    public void runBefore() {
        League leagueTest = new League("La liga",20);

    }
    @Test
    public void testConstructor() {
        League leagueTest = new League("La liga",20);
        assertEquals("La liga",leagueTest.getLname());
        assertEquals(20,leagueTest.getTeams());

    }

    @Test
    public void testAddLeagueEmpty() {
        ArrayList<League> leagueTestList = new ArrayList<>();
        assertEquals(0,leagueTestList.size());

    }

    @Test
    public void testAddLeagueOnce() {
        ArrayList<League> leagueTestlist = new ArrayList<>();
        leagueTestlist.add(leagueTest);

        assertEquals(1,leagueTestlist.size());

    }

    @Test
    public void testAddTeamMultiple() {
        ArrayList<League> leagueTestList = new ArrayList<>();
        League leagueTest2 = new League("PL",20);

        leagueTestList.add(leagueTest);
        leagueTestList.add(leagueTest2);
        assertEquals(2,leagueTestList.size());

    }
}



