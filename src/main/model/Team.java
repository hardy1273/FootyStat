package model;

import java.util.ArrayList;

public class Team {
    String tname;
    int points;
    int standing;

    ArrayList<Team> teams = new ArrayList<>();
    Team team;

    public Team(String tname, int points, int standing) {
        this.tname = tname;
        this.points = points;
        this.standing = standing;

    }


    public String getTname() {
        return tname;
    }

//    public void setName(String teamName) {
//        this.tname = teamName;
//    }

    public int getPoints() {
        return points;
    }

//    public void setPoints(int teamPoints) {
//
//        this.points = teamPoints;
//    }

    public int getStanding() {
        return standing;
    }

//    public void setStanding(int teamStanding) {
//        this.standing = teamStanding;
//    }

    public void addTeam(Team team) {
        if (!teams.contains(team)) {
            teams.add(team);
        }
    }

    public int getSize() {
        return teams.size();
    }

}




