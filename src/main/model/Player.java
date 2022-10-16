package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int age;
    String position;

    List<Player> players = new ArrayList<>();




    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }


    public String getName() {
        return name;
    }

    public void setName(String playerName) {
        this.name = playerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int playerAge) {

        this.age = playerAge;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String playerPosition) {
        this.position = playerPosition;
    }

}



