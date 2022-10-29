package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;



public class Player {
    String name;
    int age;
    String position;
    int goals;
    int assists;
    int minutes;

    List<Player> players = new ArrayList<>();
    Player player;


    public Player(String name, int age, String position, int goals, int assists, int minutes) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.goals = goals;
        this.assists = assists;
        this.minutes = minutes;
    }


    public String getName() {
        return name;
    }

//    public void setName(String playerName) {
//        this.name = playerName;
//    }

    public int getAge() {
        return age;
    }

//    public void setAge(int playerAge) {
//
//        this.age = playerAge;
//    }

    public String getPosition() {
        return position;
    }

    //EFFECTS: checks eligibility of players , can only register if they are 18+
    public boolean checkEligibility() {

        if (age > 18) {
            return true;
        } else {
            return false;
        }

    }

}