package ui;

import model.League;
import model.Team;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import static ui.StatApp.JSON_STORE;



public class LeaguePage {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Create a league", SwingConstants.CENTER);
    JLabel label3 = new JLabel("Enter League name:");
    JTextField f2 = new JTextField(10);
    JSONObject json;
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);
    League league;
    int teams;
    Team team;
    ArrayList<Team> teamsInLeague = new ArrayList<>();


    public LeaguePage() {
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("FootyStat");

        JButton addLeague = new JButton("Save this league! (After saving , add teams)");
        JButton addTeam = new JButton("Add Teams to this league");
        addLeague.setActionCommand("add");
        addLeague.addActionListener(this::actionPerformed);
        addTeam.setActionCommand("addTeam");
        addTeam.addActionListener(this::actionPerformed);
        addLeague.setPreferredSize(new Dimension(100, 100));

        panel.add(label3);
        panel.add(f2);
        panel.add(addLeague);
        panel.add(addTeam);
        frame.setPreferredSize(new Dimension(800, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {
            league = new League(f2.getText());
            saveLeague();


        } else if (e.getActionCommand().equals("addTeam")) {
            new AddTeamPage();
            // run add Team frame
        }
    }


    public JSONObject toJson() {
        json = new JSONObject();
        json.put("name", f2.getText());
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

    private void saveLeague() {
        try {
            jsonWriter.open();
            jsonWriter.write(league);
            jsonWriter.close();
            System.out.println("Saved " + league.getLname() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}






