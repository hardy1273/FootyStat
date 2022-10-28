package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Team;
import model.League;

public class LeagueTest {
    private League leagueTest;
    private Team team;




    @BeforeEach
    public void runBefore() {
        League leagueTest = new League("La liga");
        ArrayList<Team> TeamsInleagueTestList = new ArrayList<>();

    }
    @Test
    public void testConstructor() {
        League leagueTest = new League("La liga");
        assertEquals("La liga",leagueTest.getLname());
//        assertEquals(20,leagueTest.getTeams());

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
    public void testAddLeagueMultiple() {
        ArrayList<League> leagueTestList = new ArrayList<>();
        League leagueTest2 = new League("PL");

        leagueTestList.add(leagueTest);
        leagueTestList.add(leagueTest2);
        assertEquals(2,leagueTestList.size());

    }
    @Test
    public void testAddTeamToLeague() {
        League leagueTest = new League("La liga");
        Team t = new Team("Barca",20,1);
        leagueTest.addTeamToLeague(t);
        assertEquals(1,leagueTest.getSize());

    }

}



