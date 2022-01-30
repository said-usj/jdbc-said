import java.sql.*;

/**
Class that connects to MySQL database
 */

public class Main {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Constants info = new Constants();
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + info.getDatabaseName() +
                "?characterEncoding=latin1&useConfigs=maxPerformance",
                info.getUsername(),
                info.getPassword()
            );
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while(resultSet.next()) {
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                User user = new User(username, email);
                System.out.println(user.greet());
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}