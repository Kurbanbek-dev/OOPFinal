package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Database.DatabaseHandler;
import sample.Student;

public class AddUpcoming {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField upcomingID;

    @FXML
    private TextField upcomingDisease;

    @FXML
    private TextField upcomingTime;

    @FXML
    private Label lableCaught;

    @FXML
    private Button upcomingBtn;

    @FXML
    void initialize() {
        upcomingBtn.setOnAction(actionEvent -> {
            ArrayList<String> student_id = new ArrayList<>();
            student_id.add("18010100069");
            student_id.add("18010100018");

            List<Student> data = new ArrayList<>();
            data.add(new Student("18010100069", "Askhat", "Shailoobekov", "19.03.2000", "com-18", "0777860987", "", ""));
            data.add(new Student("18010100018", "Maksatbek", "Kanybekuulu", "06.06.2000", "com-18", "0777776688", "", ""));
            String id = upcomingID.getText().trim();
            if(student_id.contains(id)) {
                int pos = student_id.indexOf(id);
                Student student = new Student(data.get(pos).getId(), data.get(pos).getName(), data.get(pos).getSurname(),
                        data.get(pos).getBirthDate(), data.get(pos).getFaculty(), data.get(pos).getNumber(), upcomingDisease.getText(), upcomingTime.getText());
                DatabaseHandler databaseHandler = new DatabaseHandler();
                databaseHandler.addUpcoming(student);
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

            }else {
                lableCaught.setText("Student ID doesn't exist!");
            }
        });
    }
}
