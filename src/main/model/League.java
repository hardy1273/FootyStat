package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class League {
    String lname;
    ArrayList<Team> teams;

    public League(String lname, ArrayList teams) {
        this.lname = lname;
        this.teams = new ArrayList<Team>();

    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}




