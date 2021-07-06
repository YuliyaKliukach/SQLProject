import java.sql.*;

public class SQLDemo1 {
    public static void main(String[] args) {
        String dbURL="jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        String userName="syntax_hrm";
        String password="syntaxhrm123";

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            connection=DriverManager.getConnection(dbURL,userName,password);
            statement= connection.createStatement();
            resultSet=statement.executeQuery("select * from employee;");
            ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
            for (int i = 1; i <=resultSetMetaData.getColumnCount(); i++) {

                System.out.print( resultSetMetaData.getColumnName(i)+" ");
            }
            System.out.println(" ");
            while(resultSet.next()){
                System.out.print(resultSet.getString("empId")+" ");
                System.out.print(resultSet.getString("salary")+" ");
                System.out.print(resultSet.getString("grade")+" ");
                System.out.print(resultSet.getString("department"));
                System.out.println(" ");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
