package pattern_chain_of_responsibility;

public class FileHandler extends MessageHandler {
    @Override
    public void handle(Sender sender, String name, String message) {
        if (sender.fileTransfer) {
            WriteToFileAPI.writeToFile(name, message);
            System.out.println("Сообщение успешно записано в файл");
        }
        if (successor != null) {
            successor.handle(sender, name, message);
        }
    }
}
