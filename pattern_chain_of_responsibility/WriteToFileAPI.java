package pattern_chain_of_responsibility;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileAPI {
    public static void writeToFile(String login, String message) {
        String filename = "user_records.txt";
        try(FileWriter writer = new FileWriter(filename, true)) {
            writer.write(login + ":" + message + "\n");
            writer.flush();
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
