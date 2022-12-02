package ui;


import com.oracle.tools.packager.Log;
import javafx.scene.layout.Pane;
import model.Event;
import model.EventLog;
import model.Player;
import model.Team;
import model.League;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import persistence.JsonReader;
import persistence.JsonWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import org.json.*;

import javax.swing.*;


public class StatApp {
    private Player player;
    private Team team;
    private League league;
    private Scanner sc;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    static final String JSON_STORE = "./data/statapp.json";
    EventLog el;


    //EFFECTS: constructs new scanner ,player and team to be used later in program
    public StatApp() throws IOException {

        Scanner sc = new Scanner(System.in);
//        Player player1 = new Player("Hardit", 19, "CB");
//        Team team1 = new Team("Barca", 20, 1);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        new Gui();
        startAndDisplay();
    }

    //EFFECTS: initializes menu of the app and print a welcome message.
    public void startAndDisplay() {
        System.out.println("Welcome to FootyStat!");
        System.out.println("What would you like to do today?");
        boolean status = true;

        while (status = true) {
            displayMenu();
        }


    }


    //EFFECTS: displays menu of the app and can be operated on
    public void displayMenu() {
        System.out.println("To add player Press P/p");
        System.out.println("To create league press L/l");
        System.out.println("To add team press T/t");
        System.out.println("To Load stats press ls/LS");
        System.out.println("To Save stats press s/S");
        System.out.println("To quit press q");
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toLowerCase();

        if (input.equals("p")) {
            addPlayerStats();
        } else if (input.equals("l")) {
            createLeague();
        } else if (input.equals("t")) {
            addTeam();
        } else if (input.equals("q")) {
            quit();
        } else if (input.equals("s")) {
            saveLeague();
        } else if (input.equals("ls")) {
            loadLeague();
        } else {
            System.out.println("Please Enter a Valid input");
        }

    }

    //EFFECTS : creates a new league
    public void createLeague() {
        System.out.println("Created League");
        addLeague();


    }

    //EFFECTS: adds team to arraylist if not already present
    public void addTeam() {

        addTeamStats();
    }

    //EFFECTS: quits the application and prints out an exit statement ("Bye!")
    public void quit() {

        System.out.println("Bye!");
        for (Event next : el) {
            System.out.println(next.toString());
        }

        System.exit(0);




    }

    //EFFECTS: adds player stats and displays them
    public void addPlayerStats() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String playerName = sc.next();

        System.out.println("Enter age");
        int playerAge = sc.nextInt();

        System.out.println("Enter position");
        String playerPosition = sc.next();

        System.out.println("Please enter Stats now");


        System.out.println("Goals scored:");
        int goals = sc.nextInt();

        System.out.println("Assists");
        int assists = sc.nextInt();

        System.out.println("Minutes Played");
        int minutesPlayed = sc.nextInt();

        System.out.println("Stats recorded!");

        System.out.println("Your Stats recorded as of now are the following:");
        System.out.println(playerName + " " + "Age: " + playerAge + " " + "Position: " + playerPosition);
        System.out.println("Goals: " + goals);
        System.out.println("Assists: " + assists);
        System.out.println("Minutes Played: " + minutesPlayed);

        player = new Player(playerName, playerAge, playerPosition, goals, assists, minutesPlayed);


    }

    //EFFECTS: adds team name, points and displays them
    public void addTeamStats() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter team details now!");

        System.out.println("Team name:");
        String tmName = sc.next();

        System.out.println("Points");
        int points = sc.nextInt();

        System.out.println("Standing");
        int standing = sc.nextInt();

        System.out.println("Details recorded!");

        System.out.println("Team name: " + tmName);
        System.out.println("points: " + points);

        league.addTeamToLeague(new Team(tmName, points, standing));

        System.out.println(league.getTeamsInLeague());
    }

    //MODIFIES: this
    //EFFECTS: Starts taking input for league format, runs a loop with the given number of teams
    // to keep adding
    public void addLeague() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter league details now!");

        System.out.println("Enter number of teams:");
        int numTeams = sc.nextInt();
        System.out.println("Enter League Name ");
        String lname = sc.next();
        league = new League(lname);

        System.out.println(league.getLname());

    }




    // EFFECTS: saves the league to file
    private void saveLeague() {
        try {
            jsonWriter.open();
            jsonWriter.write(league);
            jsonWriter.close();
            System.out.println("Saved " + league.getLname() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
//
//    // MODIFIES: this
//    // EFFECTS: loads league from file

    private void loadLeague() {
        try {
            league = jsonReader.read();
            System.out.println("Loaded " + league.getLname() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
