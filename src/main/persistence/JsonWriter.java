package persistence;

import model.League;
import model.Player;
import model.Team;
import org.json.JSONObject;


import java.io.*;

// Represents a writer that writes JSON representation of league to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of League to file
    // EFFECTS: writes JSON representation of League to file
    public void write(League league) {
        JSONObject json = league.toJson();
        saveToFile(json.toString(TAB));
    }

//    public void write(Player p) {
//        JSONObject json = p.toJson();
//        saveToFile(json.toString(TAB));
//    }
//
//    public void write(Team t) {
//        JSONObject json = t.toJson();
//        saveToFile(json.toString(TAB));
//    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
