package ui;

import model.League;
import model.Team;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static ui.StatApp.JSON_STORE;

public class AddTeamPage {

    ArrayList<Team> teams = new ArrayList<>();
    Team team;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel leagueName = new JLabel("League Name:");
    JTextField leagueNameField = new JTextField(10);
    JLabel label = new JLabel("Add Team details");
    JLabel label2 = new JLabel("Name:");
    JLabel label3 = new JLabel("Points:");
    JLabel label4 = new JLabel("Standing");
    JLabel text1 = new JLabel("Teams added");
    JTextField f1 = new JTextField(10);
    JTextField f2 = new JTextField(5);
    JTextField f3 = new JTextField(5);
    JButton createLeague = new JButton("Save league");
    JButton show = new JButton("Add and save team to league");
    JButton showTeam = new JButton("Show Teams added.");
    JButton loadLeague = new JButton("Load league");
    JSONObject json;
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);
    League league;


    public AddTeamPage() {
//        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
//        panel.setLayout(new GridLayout(0, 1));
//        frame.add(panel, BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("FootyStat");
//        show.setActionCommand("add");
//        show.addActionListener(this::actionPerformed);
//        createLeague.setActionCommand("addTeam");
//        createLeague.addActionListener(this::actionPerformed);
//        showTeam.setActionCommand("show");
//        showTeam.addActionListener(this::actionPerformed);
//        loadLeague.setActionCommand("load");
//        loadLeague.addActionListener(this::actionPerformed);
//        show.setPreferredSize(new Dimension(100, 100));

        panelOps();
        panel.add(loadLeague);
        panel.add(leagueName);
        panel.add(leagueNameField);
        panel.add(createLeague);
        panel.add(label);
        panel.add(label2);
        panel.add(f1);
        panel.add(label3);
        panel.add(f2);
        panel.add(label4);
        panel.add(f3);
        panel.add(show);
        panel.add(showTeam);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void panelOps() {

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("FootyStat");
        show.setActionCommand("add");
        show.addActionListener(this::actionPerformed);
        createLeague.setActionCommand("addTeam");
        createLeague.addActionListener(this::actionPerformed);
        showTeam.setActionCommand("show");
        showTeam.addActionListener(this::actionPerformed);
        loadLeague.setActionCommand("load");
        loadLeague.addActionListener(this::actionPerformed);
        show.setPreferredSize(new Dimension(100, 100));

    }

    //EFFECTS: listens to actions , takes to next page according to button pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {
            System.out.println(f1.getText());
            System.out.println(f2.getText());
            System.out.println(f3.getText());

            int points = Integer.parseInt(String.valueOf(f2.getText()));
            int standing = Integer.parseInt(String.valueOf(f3.getText()));


            league.addTeamToLeague(new Team(f1.getText(), points, standing));
            saveLeague();


        } else if (e.getActionCommand().equals("show")) {

            JLabel text2 = new JLabel(String.valueOf(toJson()));
            panel.add(text2);
            System.out.println(text2);

        } else if (e.getActionCommand().equals("addTeam")) {
            league = new League(leagueNameField.getText());
            JLabel msg = new JLabel("Created League, please add team details now! ");
            panel.add(msg);
            saveLeague();
        } else if (e.getActionCommand().equals("load")) {
            loadLeague();
        }


    }

    //  EFFECTS: converts team details to json object.
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", f1.getText());
        json.put("points", f2.getText());
        json.put("standing", f3.getText());
        //json.put("teams", teamsToJson());
        return json;
    }

    // EFFECTS: returns teams in the league as a JSON array
    private JSONArray teamsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Team t : teams) {
            jsonArray.put(t.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: saves the league to file
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

    public JSONObject toJsonLeague() {
        JSONObject json = new JSONObject();
        json.put("name", leagueNameField.getText());
        //json.put("numTeams", teams);
        json.put("teams", teamsToJson());
        return json;
    }

  // MODIFIES: this
  // EFFECTS: loads league from file
    private void loadLeague() {
        try {
            league = jsonReader.read();
            System.out.println("Loaded " + league.getLname() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
