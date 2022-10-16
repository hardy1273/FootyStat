package model;

public class Team {
    String tname;
    int points;
    int standing;

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
}



