package ui;

import jdk.swing.interop.SwingInterOpUtils;
import model.Player;
import model.Team;
import model.League;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatApp {
    private Player player;
    private Team team;
    private Scanner sc;

    public StatApp() {
        startAndDisplay();
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player("Hardit",19,"CB");
        Team  team1 = new Team("Barca",20,1);
    }






    public void startAndDisplay() {
        System.out.println("Welcome to FootyStat!");
        System.out.println("What would you like to do today?");
        boolean status = true;

        while (status = true) {
            displayMenu();
        }


    }





    public void displayMenu() {

        System.out.println("To add player Press P/p");
        System.out.println("To create league press L/l");
        System.out.println("To add team press T/t");
        System.out.println("To quit press q");

        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        if (input.equals("p")) {
            addPlayer();
        } else if (input.equals("l")) {
            createLeague();
        } else if (input.equals("t")) {
            addTeam();
        } else if (input.equals("q")) {
            quit();

        } else {
            System.out.println("Please Enter a Valid input");
        }


    }

    //EFFECTS: adds player to arraylist if not already present
    public void addPlayer() {
//        for (Player allPlayers : this.players) {
//            if (!players.contains(Player)) {
//                players.add(Player);
//            }
//        }
        addPlayerStats();


    }

    //EFFECTS : creates a new league
    public void createLeague() {
        System.out.println("Created League");
        addLeague();


    }

    //EFFECTS: adds team to arraylist if not already present
    public void addTeam() {
        System.out.println("Added Team!");

        addTeamStats();


    }

    //EFFECTS: quits the application and prints out an exit statement ("Bye!")
    public void quit() {

        System.out.println("Bye!");

        System.exit(0);


    }

    public void addPlayerStats() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Stats now");



        System.out.println("Goals scored:");
        int goals = sc.nextInt();

        System.out.println("Assists");
        int assists = sc.nextInt();

        System.out.println("Minutes Played");
        int minutesPlayed = sc.nextInt();

        System.out.println("Stats recorded!");


    }

    public void addTeamStats() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter team details now!");



        System.out.println("Team name:");
        String tname = sc.next();

        System.out.println("Points");
        int points = sc.nextInt();

        System.out.println("Details recorded!");

    }

    public void addLeague() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter league details now!");

        System.out.println("Enter number of teams:");
        int numTeams = sc.nextInt();

        for (int i = 0; i < numTeams; i++) {

            System.out.println("Enter team " + i);
            String tmNames = sc.next();


        }

    }

}