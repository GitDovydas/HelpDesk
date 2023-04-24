package helpdesk.model;

import java.sql.*;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost/helpdesk";
    private static final String[] prisijungimas = new String[]{"root", ""} ;

    public static void create(User user) throws SQLException {
            Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, email) VALUES (?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();

            connection.close();
            System.out.println("Vartotojas sėkmingai pridėtas");
    }

    public static int findUserIdByUsername(String username) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
        // TODO: Jeigu title yra tusčias, suformuoti select kuris grąžins visus duomenis esančius lentelėje. (Nereikia where)
        // tačiau jeigu title nėra tusčias vykdyti select kuris aprašytas eilute žemiau
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("SELECT user_id FROM users WHERE username = ?");
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
//        preparedStatement.close();
//        connection.close();
        return resultSet.getInt(1);
    }

    public static User userLogin(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, prisijungimas[0], prisijungimas[1]);
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        User vartotojas = null;
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            vartotojas = new User(resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(2));
        }
        return vartotojas;
    }



}
