package sample.Database;

import sample.LoginUser;
import sample.Student;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String connectionString = "jdbc:mysql://"+dbHost+":"
                +dbPort+"/"+dbName;
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void addPatient(Student student){
        String insert = "INSERT INTO "+Const.PATIENT_TABLE+"("+Const.PATIENT_ID+","+Const.PATIENT_NAME+","+Const.PATIENT_SURNAME
                +","+Const.PATIENT_BIRTHDATE+","+Const.PATIENT_FACULTY+","+Const.PATIENT_NUMBER+","+Const.PATIENT_DISEASE+","+Const.PATIENT_TIME+")"
                +"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());
            preparedStatement.setString(4, student.getBirthDate());
            preparedStatement.setString(5, student.getFaculty());
            preparedStatement.setString(6, student.getNumber());
            preparedStatement.setString(7, student.getDisease());
            preparedStatement.setString(8, student.getTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addUpcoming(Student student){
        String insert = "INSERT INTO "+Const.UPCOMING_TABLE+"("+Const.UPCOMING_TIME+","+Const.UPCOMING_ID+","+Const.UPCOMING_NAME
                +","+Const.UPCOMING_SURNAME+","+Const.UPCOMING_BIRTHDATE+","+Const.UPCOMING_FACULTY+","+Const.UPCOMING_NUMBER+","+Const.UPCOMING_DISEASE+")"
                +"VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, student.getTime());
            preparedStatement.setString(2, student.getId());
            preparedStatement.setString(3, student.getName());
            preparedStatement.setString(4, student.getSurname());
            preparedStatement.setString(5, student.getBirthDate());
            preparedStatement.setString(6, student.getFaculty());
            preparedStatement.setString(7, student.getNumber());
            preparedStatement.setString(8, student.getDisease());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public ResultSet getUser(LoginUser loginUser){
        ResultSet resultSet = null;
        if(!loginUser.getUsername().equals("") && !loginUser.getPassword().equals("")){
            String query = "SELECT * FROM " + Const.USERS_TABLE+" WHERE "+Const.USERS_USERNAME+"=?"
                    +" AND "+Const.USERS_PASSWORD+"=?";
            try {
                PreparedStatement preparedStatement = getDbConnection().prepareStatement(query);
                preparedStatement.setString(1, loginUser.getUsername());
                preparedStatement.setString(2, loginUser.getPassword());
                resultSet = preparedStatement.executeQuery();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("Wrong username or password!");
        }
        return resultSet;
    }
    public String countPatient(){
        Statement stmt = null;
        int count = 0;
        try {
            stmt = getDbConnection().createStatement();
            String query = "select count(*) from patients";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Integer.toString(count);
    }
    public String coUpcoming(){
        Statement stmt = null;
        int count = 0;
        try {
            stmt = getDbConnection().createStatement();
            String query = "select count(*) from upcoming";
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Integer.toString(count);
    }
}
