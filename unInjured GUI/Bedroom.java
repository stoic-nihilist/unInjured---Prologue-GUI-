import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Bedroom {

    public static String name;
    public static int health;
    public static JProgressBar healthBar;
    public static int pills;
    public static int beers;
    
    public static JLabel l4;
    public static JLabel stats;
    public static JLabel updates;
    public static JLabel title, title2, title3;
    public static void main (String[] args) throws IOException {


        name = Files.readAllLines(Paths.get("log.bin")).get(0);
        pills = Integer.parseInt(Files.readAllLines(Paths.get("bathroomlog.bin")).get(0));
        beers = Integer.parseInt(Files.readAllLines(Paths.get("kitchenlog.bin")).get(3));
        health = Integer.parseInt(Files.readAllLines(Paths.get("log.bin")).get(1));

        healthBar = new JProgressBar();
        healthBar.setValue(health);
        healthBar.setBounds(300, 490, 150, 25);
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

        JLabel l1 = new JLabel(name+" had already made the most of his already bad evening, \n \n\n");
        l1.setBounds(100, 50, 500, 25);

        JLabel l2 = new JLabel("recuperating from the mess he'd found himself in,");
        l2.setBounds(100, 100, 400, 25);

        JLabel l3 = new JLabel("using whatever he'd found the time to buy that week.");
        l3.setBounds(100, 150, 500, 25);

        l4 = new JLabel("");
        if ((pills < 2) && (beers < 1)) {
       l4.setText(" 'Those painkillers were a life-saver.' \n");
        } else if (beers > 2) {
            l4.setText(" 'Shouldn't have taken too many cold ones.' \n");
        } else if ((beers > 1) && (pills < 2)) {
            l4.setText(" 'Healthy combination, chasing them down like that.' \n");
        }
        l4.setBounds(100, 200, 500, 25);
        
        JLabel l5 = new JLabel(name+" would have enough time to find out if someone put a hit out on him in the morning.");
        l5.setBounds(100, 250, 700, 25);
       
       JLabel l6 = new JLabel("Provided they didn't know where he lived, broke in and killed him in his sleep.");
       l6.setBounds(100, 300, 600, 25);
       
        JLabel l7 = new JLabel("For now, he would lay in bed and let a good night's rest do it's job.\n");
        l7.setBounds(100, 350, 600, 25);
       
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(l7);

        stats = new JLabel(name+" : "+health+"%");
        stats.setBounds(300, 400, 350, 25);
        panel.add(stats);

        updates = new JLabel("");
        updates.setBounds(300, 420, 300, 25);
        panel.add(updates);


        title2 = new JLabel("\n\n\n ------- ");
        title = new JLabel("unInjured.");
        title3 = new JLabel(" ------- \n\n\n");

        title.setBounds(290, 450, 100, 25);
        title2.setBounds(300, 440, 100, 25);
        title3.setBounds(300, 460, 100, 25);

        panel.add(title);
        panel.add(title2);
        panel.add(title3);
        
        File file = new File("unInjured-Prologue.bin");

        if ((file.createNewFile()) || (file.exists())) {
                updates.setText("Save file created.");
                updates.setText("Saving progress.");
                
        }

        FileWriter writer = new FileWriter("unInjured-Prologue.bin");
        writer.write(name);
        writer.write("\n");
        writer.write(String.valueOf(health));
        writer.close();
        updates.setText("Save successful.");



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
 