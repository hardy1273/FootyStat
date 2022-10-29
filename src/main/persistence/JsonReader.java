package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.League;
import model.Team;
import model.Player;
import org.json.*;

// Represents a reader that reads league from JSON data stored in file
public class JsonReader {
    private final String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads league from file and returns it;
    // throws IOException if an error occurs reading data from file
    public League read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseLeague(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses league from JSON object and returns it
    // EFFECTS: parses league from JSON object and returns it
    private League parseLeague(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
//        int numTeams = jsonObject.getInt("numTeams");
        League lg = new League(name);
        addTeamToLeague(lg, jsonObject);
        return lg;

    }

    // MODIFIES: league
    // EFFECTS: parses teams from JSON object and adds them to league
    private void addTeamToLeague(League lg, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("teams");
        for (Object json : jsonArray) {
            JSONObject nextTeam = (JSONObject) json;
            addTeamToLeague(lg, nextTeam);
        }
    }

//    // MODIFIES: league
//    // EFFECTS: parses team from JSON object and adds it to league
//    private void addTeam(League league, JSONObject jsonObject) {
//        String name = jsonObject.getString("name");
//        int points = jsonObject.getInt("points");
//        int standing = jsonObject.getInt("standings");
//        Team team = new Team(name, points, standing);
//        league.addTeamToLeague(team);
//    }

}