import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Prologue {

    public static void main (String[] args) throws InterruptedException, IOException {


        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        JPanel panel = new JPanel();
        frame.add(panel);
        frame.setTitle("unInjured");

        panel.setLayout(null);




        JLabel title = new JLabel("Prologue");
        title.setBounds(300, 30, 150, 25);

        JLabel l1 = new JLabel("You're lucky to be sitting in your own couch.\n ");
        l1.setBounds(100, 50, 300, 25);

        
        JLabel l2 = new JLabel("And not in the laid-back sense of being lucky to afford a roof over your head.\n");
        l2.setBounds(100, 100, 500, 25);

       
        JLabel l3 = new JLabel("After the day you've had, you're also lucky to have made it home.\n");
        l3.setBounds(100, 150, 450, 25);

        
        JLabel l4 = new JLabel("The detour you'd taken through an unfamiliar part of town \n");
        l4.setBounds(100, 200, 650, 25);

        JLabel l5 = new JLabel("took more out of your evening than just a couple of hours. \n");
        l5.setBounds(100, 250, 650, 25);
       
        JLabel l6 = new JLabel("You're lucky to even be alive,");
        l6.setBounds(100, 300, 300, 25);

        
        JLabel l7 = new JLabel("the searing pain in the left side of your gut,");
        l7.setBounds(100, 350, 350, 25);

        JLabel l8 = new JLabel("a god-sent remark that you'd won the lottery today and should cash it in soon,");
        l8.setBounds(100, 400, 500, 25);

        JLabel l9 = new JLabel("before you succumb to whatever put you in that agony.\n");
        l9.setBounds(100, 450, 400, 25);


        


         panel.add(l1);
         
         panel.add(l2);
        
         panel.add(l3);
         
         panel.add(l4);

         panel.add(l5);
        
         panel.add(l6);
        
         panel.add(l7);
        
         panel.add(l8);

         panel.add(l9);

        

         JLabel confirm = new JLabel("Go back to main screen");
         confirm.setBounds(50, 500, 150, 25);
         panel.add(confirm);
 
         JButton confirmButton = new JButton("Main");
         confirmButton.setBounds(200, 500, 120, 25);
         ActionListener Confirm = new ActionListener() {
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
         confirmButton.addActionListener(Confirm);
         panel.add(confirmButton);






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
