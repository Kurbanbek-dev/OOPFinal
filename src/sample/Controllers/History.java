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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.Database.DatabaseHandler;

public class History implements Initializable {

    @FXML
    private ResourceBundle resources;

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
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, String> colName;

    @FXML
    private TableColumn<ModelTable, String> colSurname;

    @FXML
    private TableColumn<ModelTable, String> colFaculty;

    @FXML
    private TableColumn<ModelTable, String> colNumber;

    @FXML
    private TableColumn<ModelTable, String> colDiseas;

    @FXML
    private TableColumn<ModelTable, String> colTime;


    ObservableList<ModelTable> observableList = FXCollections.observableArrayList();


    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(table.getSelectionModel());
        DatabaseHandler databaseHandler = new DatabaseHandler();
        try {
            Connection con = databaseHandler.getDbConnection();
            ResultSet rs = con.createStatement().executeQuery("select * from patients");

            while (rs.next()){
                observableList.add(new ModelTable(rs.getString("name"), rs.getString("surname"), rs.getString("faculty"),
                        rs.getString("number"), rs.getString("disease"), rs.getString("time")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        colFaculty.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colDiseas.setCellValueFactory(new PropertyValueFactory<>("disease"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));

        table.setItems(observableList);
    }
}
