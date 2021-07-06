import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String dbURL="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";
        try {
            Connection connection= DriverManager.getConnection(dbURL, userName, password);
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select firstname, lastname from person;");
            while (resultSet.next()){
                String firstname=resultSet.getString("firstname");
                String lastname=resultSet.getString("lastname");
                System.out.println(firstname+" "+lastname);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
