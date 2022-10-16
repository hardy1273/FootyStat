package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class PlayerTest {
    private Player playerTest;

    @BeforeEach
    public void runBefore() {
        Player playerTest = new Player("Hardit", 19, "Centre Back");


    }

    @Test
    public void testConstructor() {
        Player playerTest = new Player("Hardit", 19, "Centre Back");
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

        Player playerTest2 = new Player("Leo Messi", 35, "RW");
        playersTest.add(playerTest2);
        assertEquals(2, playersTest.size());


    }

    @Test
    public void checkDuplicateTest() {
        ArrayList<Player> playersTest = new ArrayList<>();
        playersTest.add(playerTest);
        assertEquals(1, playersTest.size());

        playersTest.add(playerTest);
        playersTest.checkDuplicate();
        assertEquals(1, playersTest.size());

    }
}