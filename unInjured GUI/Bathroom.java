import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Bathroom {
    
    public static JLabel updates;
    public static int pills;
    public static int health;
    public static JProgressBar healthBar;
    public static String name;
    public static JLabel stats;

    public static void updateBathroom() throws IOException {

        File file = new File("bathroomlog.bin");

    if (!file.exists()) {
        Bathroom.updates.setText("Error updating settings.");
    } else{
    FileWriter writer = new FileWriter("bathroomlog.bin");
        writer.write(String.valueOf(pills));
        writer.write("\n");
        writer.close();
    }

    File file2 = new File("log.bin");

    if (!file2.exists()) {
        Bathroom.updates.setText("Error updating settings.");
    } else {

        FileWriter writer = new FileWriter("log.bin");

        writer.write(name);
        writer.write("\n");
        writer.write(String.valueOf(health));
        writer.close();
    }
    }
    public static void main (String[] args) throws IOException {

        name = Files.readAllLines(Paths.get("log.bin")).get(0);
        health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));

        pills = Integer.parseInt(Files.readAllLines(Paths.get("bathroomlog.bin")).get(0));

        healthBar = new JProgressBar();
        healthBar.setValue(health);
        healthBar.setBounds(300, 100, 150, 25);
        healthBar.setStringPainted(true);
        healthBar.setForeground(Color.red);
        healthBar.setBackground(Color.black);

        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setTitle("unInjured");

        panel.setLayout(null);
        panel.add(healthBar);

        stats = new JLabel(name+" : "+health+"%");
        stats.setBounds(300, 140, 350, 25);
        panel.add(stats);

        JLabel inventory = new JLabel("");
        inventory.setBounds(300, 160, 300, 25);
        panel.add(inventory);

        updates = new JLabel("");
        updates.setBounds(300, 180, 300, 25);
        panel.add(updates);

        inventory.setText("Pills: "+pills);

        JLabel Pills = new JLabel("Pills: "+pills);
        Pills.setBounds(50, 250, 150, 25);
        panel.add(Pills);       

        JButton pillButton = new JButton("Take");
        pillButton.setBounds(200, 250, 150, 25); 
        ActionListener takePills = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pills == 0) {
                    Pills.setText("None left.");
                    panel.remove(pillButton);
                } else  if (health >= 100) {
                    updates.setText("Health full.");
                    panel.remove(pillButton);
                    healthBar.setValue(100);

                    FileWriter writer;
                    try {
                        writer = new FileWriter("log.bin");

                        writer.write(name);
                        writer.write("\n");
                        writer.write(String.valueOf(100));
                        writer.close();

                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                    if (health <= 99) {
                        pills -= 1;
                        Pills.setText("Pills: "+pills);

                        health += 20;
                        updates.setText("Health +20. Pills -1.");
                        stats.setText(name+" : "+health+"%");
                        healthBar.setValue(health);
                        inventory.setText("Pills: "+pills);  
                        
                        try {
                            updateBathroom();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }


                        if (health >= 100) {
                            updates.setText("Health full.");
                            panel.remove(pillButton);
                            healthBar.setValue(100);
        
                            FileWriter writer;
                            try {
                                writer = new FileWriter("log.bin");
        
                                writer.write(name);
                                writer.write("\n");
                                writer.write(String.valueOf(100));

                                writer.close();
                                
                            } catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                        
                    }
                }
                
                }
            }; 
        pillButton.addActionListener(takePills);


            panel.add(pillButton);


        JLabel main = new JLabel("Go back to main screen");
        main.setBounds(150, 400, 150, 25);
        panel.add(main);

        JButton mainButton = new JButton("Main");
        mainButton.setBounds(300, 400, 120, 25);
        ActionListener mainMenu = new ActionListener() {
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
        mainButton.addActionListener(mainMenu);
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
