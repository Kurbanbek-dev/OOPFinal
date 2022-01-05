package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;
import sample.Student;

public class AddPatient {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField studentID;

    @FXML
    private TextField DiseaseTxt;

    @FXML
    private Button addPatientBtn;

    @FXML
    private URL location;

    @FXML
    void handlerHistory(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/history.fxml")), resources);
            Stage stage = new Stage();
            stage.setTitle("History");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void handlerHome(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/home.fxml")), resources);
            Stage stage = new Stage();
            stage.setTitle("Home");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void handlerPatient(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/add_Patient.fxml")), resources);
            Stage stage = new Stage();
            stage.setTitle("Add Patient");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void handlerUpcoming(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/upcoming.fxml")), resources);
            Stage stage = new Stage();
            stage.setTitle("Upcoming");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void initialize() {
        addPatientBtn.setOnAction(actionEvent -> {
            addPatent();
        });

    }
    private void addPatent() {
        ArrayList<String> student_id = new ArrayList<>();
        student_id.add("18010100069");
        student_id.add("18010100018");

        List<Student> data = new ArrayList<>();
        data.add(new Student("18010100069", "Askhat", "Shailoobekov", "12.01.2000", "com-18", "0777860987", "", ""));
        data.add(new Student("18010100018", "Maksatbek", "Kanybekuulu", "06.06.2000", "com-18", "0777776688", "", ""));
        String id = studentID.getText().trim();
        if(student_id.contains(id)) {
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            int pos = student_id.indexOf(id);
            Student student = new Student(data.get(pos).getId(), data.get(pos).getName(), data.get(pos).getSurname(),
                    data.get(pos).getBirthDate(), data.get(pos).getFaculty(), data.get(pos).getNumber(), DiseaseTxt.getText(), timeStamp);
            DatabaseHandler databaseHandler = new DatabaseHandler();
            databaseHandler.addPatient(student);
            studentID.setText("");
            DiseaseTxt.setText("");
        }

    }
}
