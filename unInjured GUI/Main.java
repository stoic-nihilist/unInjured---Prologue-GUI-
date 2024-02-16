import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
 
    public static int i;
    public static int j;
    public static int k;
    public static JLabel livingroom;
    public static JLabel livingroom2;

    public static JLabel caveat;

    public static String name;

    public static int health;

    public static JProgressBar healthBar;


    public static void main (String[] args) throws IOException {

        i = 1;
        j = 0;
        k = 0;





        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setTitle("unInjured");

        panel.setLayout(null);



        JLabel prologueLabel = new JLabel("Play prologue.");
        prologueLabel.setBounds(50, 20, 300, 25);
        panel.add(prologueLabel);

        JButton prologueButton = new JButton("Prologue");
        prologueButton.setBounds(450, 20, 150, 25);
        ActionListener prologue = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Prologue.main(null);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                frame.dispose();
            }     
        };
        prologueButton.addActionListener(prologue);
        panel.add(prologueButton);

        JLabel createLabel = new JLabel("Create new character. (Warning: resets stats if re-entered.)");
        createLabel.setBounds(50, 60, 400, 25);
        panel.add(createLabel);

        JButton createButton = new JButton("Create");
        createButton.setBounds(450, 60, 150, 25);
        ActionListener create = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Player.main(args);
                    frame.dispose();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                frame.dispose();
            }     
        };
        createButton.addActionListener(create);
        panel.add(createButton);

        JLabel stats = new JLabel("");
        stats.setBounds(300, 140, 350, 25);
        panel.add(stats);

        JLabel oneliner = new JLabel("");
        oneliner.setBounds(300, 160, 300, 25);
        panel.add(oneliner);

        if (Player.name == null) {
            stats.setText("No character created.");
        } else {

            name = Files.readAllLines(Paths.get("log.bin")).get(0);
            health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));

            healthBar = new JProgressBar();
            healthBar.setValue(health);
            healthBar.setBounds(300, 100, 150, 25);
            healthBar.setStringPainted(true);
            healthBar.setForeground(Color.red);
            healthBar.setBackground(Color.black);


            panel.add(healthBar);

            stats.setText(name+" : "+health+"%");
            if (health < 86) {
            oneliner.setText("'Time to patch myself up.'");
        
            }
            else if (health >= 86) {
                oneliner.setText("'Much better.'");
            }

        JLabel screenLabel = new JLabel("Choose a room to enter.");
        screenLabel.setBounds(300, 200, 150, 25);
        panel.add(screenLabel);

        JLabel livingRoom = new JLabel("Living room.");
        livingRoom.setBounds(50, 250, 150, 25);
        panel.add(livingRoom);

        JButton livingroomButton = new JButton("Enter");
        livingroomButton.setBounds(200, 250, 150, 25);
        ActionListener enterLivingRoom = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (i == 1) {
                    caveat.setText("");
                    livingroom2.setText("");
                    livingroom.setText("The sound from your T.V. would blur out the noise in your aching head.");
                    i++;
                } else if (i == 2) {
                    caveat.setText("");
                    livingroom.setText("The radio your girlfriend bought you was probably playing a good song.");
                    livingroom2.setText("Wouldn't hurt to check.");

                    i++;
                } else if (i == 3) {
                    caveat.setText("");
                    livingroom.setText("The couch you and your girlfriend spent your evenings together on was expectedly cold,");
                    livingroom2.setText("after a long day away from home.");

                    i = 1;
                }
            }
        };
        livingroomButton.addActionListener(enterLivingRoom);
        panel.add(livingroomButton);

        JLabel kitchen = new JLabel("Kitchen.");
        kitchen.setBounds(50, 290, 150, 25);
        panel.add(kitchen);

        JButton kitchenButton = new JButton("Enter");
        kitchenButton.setBounds(200, 290, 150, 25);
        ActionListener enterKitchen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Kitchen.main(args);
                    frame.dispose();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                frame.dispose();
            }     
        };
        kitchenButton.addActionListener(enterKitchen);
        panel.add(kitchenButton);

        JLabel bathroom = new JLabel("Bathroom.");
        bathroom.setBounds(50, 330, 150, 25);
        panel.add(bathroom);

        JButton bathroomButton = new JButton("Enter");
        bathroomButton.setBounds(200, 330, 150, 25);
        ActionListener enterBathroom = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Bathroom.main(args);
                    frame.dispose();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                frame.dispose();
            }     
        };
        bathroomButton.addActionListener(enterBathroom);
        panel.add(bathroomButton);

        caveat = new JLabel("");
        caveat.setBounds(450, 370, 200, 25);
        panel.add(caveat);


        JLabel bedroom = new JLabel("Bedroom.");
        bedroom.setBounds(50, 370, 150, 25);
        panel.add(bedroom);

        JButton bedroomButton = new JButton("Enter");
        bedroomButton.setBounds(200, 370, 150, 25);
        ActionListener enterBedroom = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (health < 86) {
                    livingroom.setText("");
                    livingroom2.setText("");
                    caveat.setText("Not much to do here yet.");
                }
                else if (health >= 86) {
                    caveat.setText("");
                    try {
                        Bedroom.main(args);
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    frame.dispose();
                }
            }     
        };
        bedroomButton.addActionListener(enterBedroom);
        panel.add(bedroomButton);

        livingroom = new JLabel("");
        livingroom.setBounds(100, 450, 600, 25);
        panel.add(livingroom);

        livingroom2 = new JLabel("");
        livingroom2.setBounds(100, 480, 600, 25);
        panel.add(livingroom2);
    }
        JButton exit = new JButton("Exit");
        exit.setBounds(600, 500, 120, 25);
        ActionListener Exit = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                frame.dispose();
            }     
        };
        exit.addActionListener(Exit);
        panel.add(exit);

    }
    }