package pattern_chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        String name = "User_one";
        String message = "Connected to server";
        Sender sender = new Sender(true, true, true);

        MessageHandler fileHandler = new FileHandler();
        MessageHandler consoleHandler = new ConsoleHandler();
        MessageHandler databaseHandler = new DatabaseHandler();
        consoleHandler.successor = fileHandler;
        fileHandler.successor = databaseHandler;

        consoleHandler.handle(sender, name, message);
    }
}