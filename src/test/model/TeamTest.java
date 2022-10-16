package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {
    private Team teamTest;

    @BeforeEach
    public void runBefore() {
        Team teamTest = new Team("Barca",20,1);

    }
    @Test
    public void testConstructor() {
        Team teamTest = new Team("Barca",20,1);
        assertEquals("Barca",teamTest.getTname());
        assertEquals(20,teamTest.getPoints());
        assertEquals(1,teamTest.getStanding());

    }

    @Test
    public void testAddTeamEmpty() {
        ArrayList<Team> teamsTest = new ArrayList<>();

        assertEquals(0,teamsTest.size());

    }

    @Test
    public void testAddTeamOnce() {
        ArrayList<Team> teamsTest = new ArrayList<>();
        teamsTest.add(teamTest);

        assertEquals(1,teamsTest.size());

    }

    @Test
    public void testAddTeamMultiple() {
        ArrayList<Team> teamsTest = new ArrayList<>();
        Team teamTest2 = new Team("Madrid",17,2);

        teamsTest.add(teamTest);
        assertEquals(1,teamsTest.size());

        teamsTest.add(teamTest2);
        assertEquals(2,teamsTest.size());

    }
}


