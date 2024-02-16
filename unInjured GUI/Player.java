import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player {
    
    static String name;
    static int health = 23;
    static int beers = 0;
    static JLabel created;
    static JFrame frame;

    public static JProgressBar healthBar;

    public static void settingsFile() throws IOException
 {
    File file = new File("log.bin");


        if ((!file.createNewFile()) && (!file.exists())) {
            created.setText("Error creating settings file.");
            Main.main(null);
            frame.dispose();
        } else {
            FileWriter writer = new FileWriter("log.bin");
            writer.write(name);
            writer.write("\n");
            writer.write(String.valueOf(health));
            writer.write("\n");
            created.setText("Settings file updated.");
            writer.close();
        }
    
 }

    public static void main (String[] args) throws IOException {
         

        healthBar = new JProgressBar();
        healthBar.setValue(health);
        healthBar.setBounds(300, 250, 150, 25);
        healthBar.setStringPainted(true);
        healthBar.setForeground(Color.red);
        healthBar.setBackground(Color.black);

        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setTitle("unInjured");

        panel.setLayout(null);

        JLabel stats = new JLabel("");
        stats.setBounds(300, 200, 150, 25);
        panel.add(stats);


        JLabel namePrompt = new JLabel("Enter player name: ");
        namePrompt.setBounds(50, 50, 150, 25);
        panel.add(namePrompt);

        JTextField nameBox = new JTextField();
        nameBox.setBounds(300, 50, 150, 25);
        panel.add(nameBox);

        JButton submitName = new JButton("Enter");
        submitName.setBounds(300, 100, 120, 25);
        ActionListener Name = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameBox.getText();
                stats.setText(name+" : "+health+"%");
                panel.add(healthBar);

                try {
                    settingsFile();
                    Inventory.settingsFile();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        };
        submitName.addActionListener(Name);
        panel.add(submitName);

        created = new JLabel("");
        created.setBounds(300, 140, 150, 25);
        panel.add(created);

        JLabel main = new JLabel("Go back to main screen");
        main.setBounds(150, 400, 150, 25);
        panel.add(main);

        JButton mainButton = new JButton("Main");
        mainButton.setBounds(300, 400, 120, 25);
        ActionListener mainScreen = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.main(args);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                frame.dispose();
            }     
        };
        mainButton.addActionListener(mainScreen);
        panel.add(mainButton);


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
