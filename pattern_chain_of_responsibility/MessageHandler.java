package pattern_chain_of_responsibility;

public abstract class MessageHandler {
    public MessageHandler successor;
    public abstract void handle(Sender sender, String name, String message);
}
