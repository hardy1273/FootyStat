package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PlayerTest {
    private Player playerTest;

    @BeforeEach
    public void runBefore() {
        Player playerTest = new Player("Hardit", 19, "Centre Back",2,7,700);
        ArrayList<Player> playersTest = new ArrayList<>();


    }

    @Test
    public void testConstructor() {
        Player playerTest = new Player("Hardit", 19, "Centre Back",2,2,20);
        assertEquals("Hardit", playerTest.getName());
        assertEquals(19, playerTest.getAge());
        assertEquals("Centre Back", playerTest.getPosition());

    }

    @Test
    public void testAddPlayerEmpty() {
        ArrayList<Player> playersTest = new ArrayList<>();
        assertEquals(0, playersTest.size());

    }

    @Test
    public void testAddPlayerOnce() {
        ArrayList<Player> playersTest = new ArrayList<>();
        playersTest.add(playerTest);
        assertEquals(1, playersTest.size());
    }

    @Test
    public void testAddPlayerMultiple() {
        ArrayList<Player> playersTest = new ArrayList<>();
        playersTest.add(playerTest);
        assertEquals(1, playersTest.size());

        Player playerTest2 = new Player("Leo Messi", 35, "RW",45,20,1900);
        playersTest.add(playerTest2);
        assertEquals(2, playersTest.size());


    }

//    @Test
//    public void addPlayerAndDisplayTest() {
//        Player playerTest = new Player("Hardit", 19, "Centre Back");
//        ArrayList<Player> playersTest = new ArrayList<>();
//        playersTest.add(playerTest);
//        playerTest.addPlayerAndDisplay();
//        assertEquals(1, playersTest.size());
//
//
//    }
    //unit test to checkAgeEligibilty
    @Test
    public void checkEligibilityTest() {
        ArrayList<Player> playersTest = new ArrayList<>();
        Player playertest2 = new Player("Sample",17,"Centre back",2,4,60);
        Player playerTest = new Player("Hardit",19,"Centre back",2,3,90);
        boolean successA = playertest2.checkEligibility();
        boolean successB = playerTest.checkEligibility();
        assertFalse(successA);
        assertTrue(successB);
    }

}