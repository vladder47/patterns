package pattern_chain_of_responsibility;

import java.sql.*;

public class DatabaseAPI {
    private static final String DB_URL = "jdbc:postgresql://localhost/test";
    private static final String USER = "postgres";
    private static final String PASS = "qwerty123";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (dbConnection != null) {
            System.out.println("You successfully connected to database now");
        }

        return dbConnection;
    }

    public static void insertRecord(String user, String message) throws SQLException {

        String query = "INSERT INTO usermessage(login, message) VALUES(?, ?)";

        try (Connection dbConnection = getDBConnection(); PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setString(1, user);
            statement.setString(2, message);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
