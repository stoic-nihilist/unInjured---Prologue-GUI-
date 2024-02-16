import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class SplashScreen {

    public static void displaySplash() {

        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String fileName = "blood-png-4.png";
        ImageIcon splashScreen = new ImageIcon(fileName);
        JLabel splashIcon = new JLabel(splashScreen);

        frame.add(splashIcon);
        try {
            Thread.sleep(7000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
