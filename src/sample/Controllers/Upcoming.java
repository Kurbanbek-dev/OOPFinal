package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;

public class Upcoming implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void handleAdd(MouseEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("sample/view/add_upcoming.fxml")), resources);
            Stage stage = new Stage();
            stage.setTitle("Add to Upcoming");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void handleDisable(MouseEvent event) {

    }

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
    private TableView<ModelTable> tableUpc;

    @FXML
    private TableColumn<ModelTable, String> timeUpc;

    @FXML
    private TableColumn<ModelTable, String> nameUpc;

    @FXML
    private TableColumn<ModelTable, String> surnameUpc;

    @FXML
    private TableColumn<ModelTable, String> facultyUpc;

    @FXML
    private TableColumn<ModelTable, String> numberUpc;

    @FXML
    private TableColumn<ModelTable, String> diseaseUpc;

    @FXML
    private ImageView addBtn;

    @FXML
    private ImageView disableBtn;

    ObservableList<ModelTable> observableList = FXCollections.observableArrayList();

    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            Connection con = databaseHandler.getDbConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from upcoming");

            while (rs.next()){
                observableList.add(new ModelTable(rs.getString("name"), rs.getString("surname"), rs.getString("faculty"),
                        rs.getString("number"), rs.getString("disease"), rs.getString("time")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        timeUpc.setCellValueFactory(new PropertyValueFactory<>("time"));
        nameUpc.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameUpc.setCellValueFactory(new PropertyValueFactory<>("surname"));
        facultyUpc.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        numberUpc.setCellValueFactory(new PropertyValueFactory<>("number"));
        diseaseUpc.setCellValueFactory(new PropertyValueFactory<>("disease"));

        tableUpc.setItems(observableList);
    }
}
