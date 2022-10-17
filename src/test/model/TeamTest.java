package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamTest {
    Team teamTest;



    @BeforeEach
    public void runBefore() {
        Team teamTest = new Team("Barca",20,1);
        ArrayList<Team> teams = new ArrayList<>();

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
        Team teamTest = new Team("Barca",20,1);
        ArrayList<Team> teamsTest = new ArrayList<>();
        teamTest.addTeam(teamTest);
        assertEquals(1,teamTest.getSize());


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


