package pattern_chain_of_responsibility;

public class ConsoleHandler extends MessageHandler {
    @Override
    public void handle(Sender sender, String name, String message) {
        if (sender.consoleTransfer) {
            System.out.println(name + ":" + message);
            System.out.println("Сообщение выведено в консоль");
        }
        if (successor != null) {
            successor.handle(sender, name, message);
        }
    }
}
