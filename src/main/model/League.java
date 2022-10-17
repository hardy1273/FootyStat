package model;

import java.util.ArrayList;

public class League {
    String lname;
    int teams;

    public League(String lname, int teams) {
        this.lname = lname;
        this.teams = teams;

    }

    public int getTeams() {
        return teams;
    }

//    public void setTeams(ArrayList<Team> teams) {
//        this.teams = teams;
//    }

    public String getLname() {
        return lname;
    }

//    public void setLname(String lname) {
//        this.lname = lname;

}




