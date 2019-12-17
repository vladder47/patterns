package pattern_chain_of_responsibility;

public class Sender {
    public boolean fileTransfer;
    public boolean consoleTransfer;
    public boolean databaseTransfer;

    public Sender(boolean ft, boolean ct, boolean dt) {
        this.fileTransfer = ft;
        this.consoleTransfer = ct;
        this.databaseTransfer = dt;
    }
}
