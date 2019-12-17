package pattern_chain_of_responsibility;

import java.sql.SQLException;

public class DatabaseHandler extends MessageHandler {
    @Override
    public void handle(Sender sender, String name, String message) {
        if (sender.databaseTransfer) {
            try {
                DatabaseAPI.insertRecord(name, message);
                System.out.println("Сообщение успешно отправлено в базу данных");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if (successor != null) {
            successor.handle(sender, name, message);
        }
    }
}
