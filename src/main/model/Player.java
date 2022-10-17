package model;

import java.util.ArrayList;
import java.util.List;



public class Player {
    String name;
    int age;
    String position;
    List<Player> players = new ArrayList<>();
    Player player;




    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
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

//    public ArrayList addPlayerAndDisplay() {
//        for (Player p: this.players) {
//            if (!players.contains(p)) {
//                players.add(p);
//            } else {
//                System.out.println("Contains Duplicate");
//            }
//        }
//        return (ArrayList) players;
//    }

    public boolean checkEligibility() {

        if (age > 18) {
            System.out.println("Eligible");;
            return true;
        } else {
            return false;
        }

    }

}



