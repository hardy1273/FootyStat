package model;

import model.Team;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League implements Writable {
    String lname;
    int teams;
    Team team;
    ArrayList<Team> teamsInLeague;


    public League(String lname) {
        this.lname = lname;
//        this.teams = teams;
        teamsInLeague = new ArrayList<>();

    }



//
////    public void setTeams(ArrayList<Team> teams) {
////        this.teams = teams;
////    }
//

    public String getLname() {
        return lname;
    }

//    public void setLname(String lname) {
//        this.lname = lname;

    public int getSize() {
        return teamsInLeague.size();
    }

    public void addTeamToLeague(Team team) {
        EventLog.getInstance().logEvent(new Event("Team added to league"));
        teamsInLeague.add(team);

    }

    public List<Team> getTeamsInLeague() {
        return Collections.unmodifiableList(teamsInLeague);

    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", lname);
        //json.put("numTeams", teams);
        json.put("teams", teamsToJson());
        return json;
    }

    // EFFECTS: returns teams in this league as a JSON array
    private JSONArray teamsToJson() {
        JSONArray jsonArray = new JSONArray();
        for (Team t : teamsInLeague) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;


    }




}



