package ui;

import model.League;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistence.JsonReader;
import persistence.JsonWriter;

import static ui.StatApp.JSON_STORE;


public class Gui extends JFrame {
    private JLabel label;
    private JTextField field;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel leaguePanel = new JPanel();
    JPanel newTeamPanel = new JPanel();
    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);


    BufferedImage previewImage = ImageIO.read(new File("./data/images/homePage.png"));
    Image imageSized = previewImage.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
    JLabel image = new JLabel(new ImageIcon(imageSized));


    JButton addLeague = new JButton("Create New League");
    JButton loadLeague = new JButton("Add to previous league");
    League league;


    public Gui() throws IOException {
        panel.add(addLeague);
        panel.add(image);
        panel.add(loadLeague);



        //layout
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panel.setLayout(new GridLayout(0, 3));
        JLabel label = new JLabel("Welcome to FootyStat!", SwingConstants.CENTER);
        panel.add(Box.createHorizontalStrut(5));
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("FootyStat");

        //buttons

        panel.add(label);


        //action listeners
        addLeague.setActionCommand("addLeague");
        addLeague.addActionListener(this::actionPerformed);
        loadLeague.setActionCommand("loadLeague");
        loadLeague.addActionListener(this::actionPerformed);

        //sizing
        //addLeague.setPreferredSize(new Dimension(100, 100));
        frame.setPreferredSize(new Dimension(800, 500));

        //assembling
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    //EFFECTS: listens to actions , takes to next page according to button pressed

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("addLeague")) {
            new AddTeamPage();


        } else if (e.getActionCommand().equals("loadLeague")) {
            loadLeague();
            new AddTeamPage();

        }


    }

    // MODIFIES: this
    // EFFECTS: loads league from file
    private void loadLeague() {
        try {
            league = jsonReader.read();
            System.out.println("Loaded " + league.getLname() + " from " + JSON_STORE);
            JLabel loadLabel = new JLabel("Loaded " + league.getLname() + " from " + JSON_STORE);
            panel.add(loadLabel);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }



}
