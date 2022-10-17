package ui;


import model.Player;
import model.Team;


import java.util.ArrayList;
import java.util.Scanner;

public class StatApp {
    private Player player;
    private Team team;
    private Scanner sc;

    //EFFECTS: constructs new scanner ,player and team to be used later in program
    public StatApp() {
        startAndDisplay();
        Scanner sc = new Scanner(System.in);
        Player player1 = new Player("Hardit",19,"CB");
        Team  team1 = new Team("Barca",20,1);
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
        System.out.println("Added Team!");

        addTeamStats();
    }

    //EFFECTS: quits the application and prints out an exit statement ("Bye!")
    public void quit() {

        System.out.println("Bye!");

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


    }

    //EFFECTS: adds team name, points and displays them
    public void addTeamStats() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter team details now!");

        System.out.println("Team name:");
        String tmName = sc.next();

        System.out.println("Points");
        int points = sc.nextInt();

        System.out.println("Details recorded!");

        System.out.println("Team name: " + tmName);
        System.out.println("points: " + points);

    }

    //MODIFIES: this
    //EFFECTS: Starts taking input for league format, runs a loop with the given number of teams
    // to keep adding
    public void addLeague() {
        ArrayList<String> teams = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter league details now!");

        System.out.println("Enter number of teams:");
        int numTeams = sc.nextInt();

        for (int i = 0; i < numTeams; i++) {

            System.out.println("Enter team " + i);
            String tmNames = sc.next();
            teams.add(tmNames);


        }
        System.out.println(teams);

    }
}