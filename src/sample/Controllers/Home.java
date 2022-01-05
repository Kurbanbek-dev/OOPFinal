package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;

public class Home {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView homeImg;

    @FXML
    private ImageView historyImg;

    @FXML
    private ImageView patientImg;

    @FXML
    private ImageView upcomingImg;

    @FXML
    private ImageView history;

    @FXML
    private Button historyBtn;

    @FXML
    private ImageView addPatient;

    @FXML
    private Button addPatientBtn;

    @FXML
    private ImageView upcoming;

    @FXML
    private Button upcomingBtn;

    @FXML
    private Label countHistory;

    @FXML
    private Label countUpcoming;

    @FXML
    void handleHistory(MouseEvent event) {
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
    void handleHome(MouseEvent event) {

    }

    @FXML
    void handlePatient(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/add_patient.fxml")), resources);
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
    void handleUpcoming(MouseEvent event) {
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
       DatabaseHandler databaseHandler = new DatabaseHandler();
       countHistory.setText(databaseHandler.countPatient());
       countUpcoming.setText(databaseHandler.coUpcoming());

        historyBtn.setOnAction(actionEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/history.fxml")), resources);
                Stage stage = new Stage();
                stage.setTitle("History");
                stage.setScene(new Scene(root));
                stage.show();
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        addPatientBtn.setOnAction(actionEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/add_patient.fxml")), resources);
                Stage stage = new Stage();
                stage.setTitle("Add Patient");
                stage.setScene(new Scene(root));
                stage.show();
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        upcomingBtn.setOnAction(actionEvent -> {
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/upcoming.fxml")), resources);
                Stage stage = new Stage();
                stage.setTitle("Upcoming");
                stage.setScene(new Scene(root));
                stage.show();
                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
