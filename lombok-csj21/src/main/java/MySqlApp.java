import java.sql.*;

public class MySqlApp {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/cyber_success";
        String username = "root";
        String password = "root@1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from product");
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2));
        }
        connection.close();
    }
}
