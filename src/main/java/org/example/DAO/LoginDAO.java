package org.example.DAO;

import org.example.Objects.LoginBean;

import java.sql.*;


public class LoginDAO {

    public static LoginBean validate(String username, String password) throws ClassNotFoundException, SQLException {
        boolean status = false;
        String jdbcURL = "jdbc:postgresql://localhost:5432/student_management";
        String jdbcUsername = "postgres";
        String jdbcPassword = "root";

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet result = preparedStatement.executeQuery();

        LoginBean loginBean  = null;

        if(result.next()){
            loginBean = new LoginBean();
            loginBean.setUsername(result.getString("username"));
            loginBean.setPassword(result.getString("password"));
        }
        connection.close();
        return loginBean;

    }

    private void printSQLException(SQLException ex){
        for(Throwable e : ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
            }

    }
}
