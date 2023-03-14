package helpdesk.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost/helpdesk";
    private static final String[] prisijungimas = new String[]{"root", ""} ;

    public static void create(User user) throws SQLException {
            Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, pswd, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Vartotojas sėkmingai pridėtas");
    }
}
