import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class FilmsDatabase {
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

        //System.out.println("PostgreSQL JDBC Driver successfully connected");

        try {
            dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (dbConnection != null) {
            //System.out.println("You successfully connected to database now");
        }

        return dbConnection;
    }

    public static ArrayList<Film> select() throws SQLException{
        ArrayList<Film> films = new ArrayList<>();
        String query = "SELECT * FROM films ORDER BY id";

        try (Connection dbConnection = getDBConnection(); Statement stmt = dbConnection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                int year = rs.getInt("year");
                int rating = rs.getInt("rating");
                Film film = new Film(title, genre, director, year, rating);
                films.add(film);
                film.setId(id);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return films;
    }

    public static void insert(Film film) throws SQLException {
        String query = "INSERT INTO films(title, genre, director, year, rating) VALUES(?, ?, ?, ?, ?)";

        try (Connection dbConnection = getDBConnection(); PreparedStatement statement = dbConnection.prepareStatement(query)) {
            statement.setString(1, film.getTitle());
            statement.setString(2, film.getGenre());
            statement.setString(3, film.getDirector());
            statement.setInt(4, film.getYear());
            statement.setInt(5, film.getRating());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Film selectOne(int id) {
        String query = "SELECT * FROM films WHERE id = ?";
        Film film = null;

        try (Connection dbConnection = getDBConnection(); PreparedStatement stmt = dbConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                String title = rs.getString("title");
                String genre = rs.getString("genre");
                String director = rs.getString("director");
                int year = rs.getInt("year");
                int rating = rs.getInt("rating");
                film = new Film(title, genre, director, year, rating);
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return film;
    }

    public static void update(Film film) {
        String query = "UPDATE films SET title = ?, genre = ?, director = ?, year = ?, rating = ? WHERE id = ?";

        try (Connection dbConnection = getDBConnection(); PreparedStatement stmt = dbConnection.prepareStatement(query)) {
            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getGenre());
            stmt.setString(3, film.getDirector());
            stmt.setInt(4, film.getYear());
            stmt.setInt(5, film.getRating());
            stmt.setInt(6, film.getId());
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void delete(int id) {
        String query = "DELETE FROM films WHERE id = ?";

        try(Connection dbConnection = getDBConnection(); PreparedStatement stmt = dbConnection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
