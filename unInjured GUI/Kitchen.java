import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Kitchen {

    public static JLabel stats;
    
    public static JLabel updates;

    public static String name;
    public static int health;
    public static JProgressBar healthBar;
    public static int beer;
    public static int steak;
    public static int soda;
    public static int beers; 

    public static JButton beerButton;
    public static JButton steakButton;
    public static JButton sodaButton;

    public static void updateKitchen() throws IOException {

    File file = new File("log.bin");

    if (!file.exists()) {
        updates.setText("Error updating settings.");
    } else {

        FileWriter writer = new FileWriter("log.bin");

        writer.write(name);
        writer.write("\n");
        writer.write(String.valueOf(health));
        writer.close();
    }

    File file2 = new File("kitchenlog.bin");
    if (!file2.exists()) {
        Kitchen.updates.setText("Error updating settings.");
    } else {
    FileWriter writer = new FileWriter("kitchenlog.bin");
        writer.write(String.valueOf(beer));
        writer.write("\n");
        writer.write(String.valueOf(steak));
        writer.write("\n");
        writer.write(String.valueOf(soda));
        writer.write("\n");
        writer.write(String.valueOf(beers));
        writer.write("\n");
        writer.close();
    }


 }


    public static void main (String[] args) throws IOException {

        name = Files.readAllLines(Paths.get("log.bin")).get(0);
        health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));

        beer = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(0));
        steak = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(1));
        soda = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(2));
        beers = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(3));

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

        stats = new JLabel(name+" : "+health+"%");
        stats.setBounds(300, 140, 350, 25);
        panel.add(stats);
        panel.add(healthBar);

        JLabel inventory = new JLabel("");
        inventory.setBounds(300, 160, 300, 25);
        panel.add(inventory);

        updates = new JLabel("");
        updates.setBounds(300, 180, 300, 25);
        panel.add(updates);


                 

        inventory.setText("Beer: "+beer+", Steak: "+steak+", Soda: "+soda);

        JLabel Beer = new JLabel("Beer: "+beer);
        Beer.setBounds(50, 250, 150, 25);
        panel.add(Beer);       

        JButton beerButton = new JButton("Take");
        beerButton.setBounds(200, 250, 150, 25);  
        ActionListener takeBeer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                     if (beer == 0) {
                    Beer.setText("None left.");
                    panel.remove(beerButton);
                } else  if (health >= 100) {
                    updates.setText("Health full.");
                    panel.remove(beerButton);
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
                        beer -= 1;
                        beers += 1;
                        Beer.setText("Beer: "+beer);
                
                        
                if (beers <= 2) {
                        health += 10;
                        healthBar.setValue(health);

                        updates.setText("Health +10. Beer -1.");

                        stats.setText(name+" : "+health+"%");
                        inventory.setText("Beer: "+beer+", Steak: "+steak+", Soda: "+soda);  
                        
                        try {
                            updateKitchen();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                       
                    } else if (beers > 2) {
                        health -= 8;
                        healthBar.setValue(health);
                                               
                        updates.setText("Health -8. You've had too many beers.");
                        stats.setText(name+" : "+health+"%");
                        inventory.setText("Beer: "+beer+", Steak: "+steak+", Soda: "+soda);
                        

                        try {
                            updateKitchen();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                      
                }
            }
            }

        
            }
                
                };
        beerButton.addActionListener(takeBeer);  
            
    
        
            panel.add(beerButton);
               

        JLabel Steak = new JLabel("Steak: "+steak);
        Steak.setBounds(50, 300, 150, 25);
        panel.add(Steak);

        JButton steakButton = new JButton("Take");
        steakButton.setBounds(200, 300, 150, 25);
        ActionListener takeSteak = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     
                if (steak == 0) {
                    Steak.setText("None left.");
                    panel.remove(steakButton);
                } else  if (health >= 100) {
                    updates.setText("Health full.");
                    panel.remove(steakButton);
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
                        steak -= 1;
                        Steak.setText("Steak: "+steak);

                        health += 10;
                        healthBar.setValue(health);
                        updates.setText("Health +10. Steak -1.");
                        stats.setText(name+" : "+health+"%");
                        inventory.setText("Beer: "+beer+", Steak: "+steak+", Soda: "+soda);  
                        
                        try {
                            updateKitchen();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                        if (health >= 100) {
                            updates.setText("Health full.");
                            panel.remove(steakButton);
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
        steakButton.addActionListener(takeSteak);


            panel.add(steakButton);
           
    
        JLabel Soda = new JLabel("Soda: "+soda);
        Soda.setBounds(50, 350, 150, 25);
        panel.add(Soda);

        JButton sodaButton = new JButton("Take");
        sodaButton.setBounds(200, 350, 150, 25);
        ActionListener takeSoda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                if (soda == 0) {
                    Soda.setText("None left.");
                    panel.remove(sodaButton);
                } else  if (health >= 100) {
                    updates.setText("Health full.");
                    panel.remove(sodaButton);
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
                        soda -= 1;
                        Soda.setText("Soda: "+soda);

                        health += 2;
                        healthBar.setValue(health);
                        updates.setText("Health +2. Soda -1.");
                        stats.setText(name+" : "+health+"%");
                        inventory.setText("Beer: "+beer+", Steak: "+steak+", Soda: "+soda);  
                        
                        try {
                            updateKitchen();
                        } catch (IOException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }

                    }
                }
                }
            };
        sodaButton.addActionListener(takeSoda);

       panel.add(sodaButton);
          


        JLabel main = new JLabel("Go back to main screen");
        main.setBounds(150, 500, 150, 25);
        panel.add(main);

        JButton mainButton = new JButton("Main");
        mainButton.setBounds(300, 500, 120, 25);
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
