import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Inventory {
    public static int beer = 4;
    public static int steak = 2;
    public static int soda = 5;
    public static int pills = 2;
    
public static void settingsFile() throws IOException {
    File file = new File("kitchenlog.bin");

        
    if ((!file.createNewFile()) && (!file.exists())) {
        Player.created.setText("Error creating settings file.");
        Main.main(null);
        Player.frame.dispose();
    } else {
        FileWriter writer = new FileWriter("kitchenlog.bin");
        writer.write(String.valueOf(beer));
        writer.write("\n");
        writer.write(String.valueOf(steak));
        writer.write("\n");
        writer.write(String.valueOf(soda));
        writer.write("\n");
        writer.write(String.valueOf(Player.beers));
        writer.write("\n");
        Player.created.setText("Settings file created.");
        writer.close();
    }

    File file2 = new File("bathroomlog.bin");

        
    if ((!file2.createNewFile()) && (!file2.exists())) {
        Player.created.setText("Error creating settings file.");
        Main.main(null);
        Player.frame.dispose();
    } else {
        FileWriter writer = new FileWriter("bathroomlog.bin");
        writer.write(String.valueOf(pills));
        writer.write("\n");
        Player.created.setText("Settings file created.");
        writer.close();
    
}
    
}

}
