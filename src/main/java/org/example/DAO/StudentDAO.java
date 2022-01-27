package org.example.DAO;


import org.example.Objects.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public StudentDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public StudentDAO(Connection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    protected void connect() throws SQLException, ClassNotFoundException {
        if(jdbcConnection == null || jdbcConnection.isClosed()){
            try{
                Class.forName("org.postgresql.Driver");
            }catch (ClassNotFoundException e){
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException{
        if(jdbcConnection!= null &&!jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }
    public boolean insertStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Student(name, course, age) VALUES(?,?,?) ";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1,student.getName());
        statement.setString(2,student.getCourse());
        statement.setInt(3,student.getAge());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }
    public List<Student> listAllStudents() throws SQLException, ClassNotFoundException {
        List<Student> listStudents = new ArrayList<>();

        String sql = "SELECT * FROM student";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String course = resultSet.getString("course");
            int age = resultSet.getInt("age");

            Student student = new Student(id,name,course,age);
            listStudents.add(student);
        }
        resultSet.close();
        statement.close();
        disconnect();

        return listStudents;
    }
    public boolean deleteStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM student WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1,student.getId());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }


    public boolean updateStudent(Student student) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE student SET name = ?, course = ?, age = ?";
        sql += " WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getCourse());
        statement.setInt(3, student.getAge());
        statement.setInt(4, student.getId());

        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;

    }
    public Student getStudent(int id) throws SQLException, ClassNotFoundException {
        Student student = null;
        String sql = "SELECT * FROM student WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String name = resultSet.getString("name");
            String course = resultSet.getString("course");
            int age = resultSet.getInt("age");

           student = new Student(id,name,course,age);
        }

        resultSet.close();
        statement.close();

        return student;
    }



}
