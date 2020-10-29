package Controller;
import Model.StarWarsModel;
import Utility.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StarWarsTableViewController implements Initializable {
    @FXML
    private TableView<StarWarsModel> starWarsTableView;

    @FXML
    private TableColumn<StarWarsModel, String> titleTableColumn;

    @FXML
    private TableColumn<StarWarsModel, Integer> revenueTableColumn;

    @FXML
    private TableColumn<StarWarsModel, Integer> ratingTableColumn;

    @FXML
    private Button graphButton;

    //populate the tableview
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        titleTableColumn.setCellValueFactory(new PropertyValueFactory<StarWarsModel, String>("title"));
        revenueTableColumn.setCellValueFactory(new PropertyValueFactory<StarWarsModel, Integer>("revenue"));
        ratingTableColumn.setCellValueFactory(new PropertyValueFactory<StarWarsModel, Integer>("rating"));
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try {
            starWarsTableView.getItems().addAll(DataBaseConnection.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //when you click the button go to the bar graph fxml file
    public void onClick(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getClassLoader().getResource("./View/StarWarsBarGraph.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Star Wars Graph");
        stage.getIcons().add(new Image("./Icon/icon.jpg"));
        stage.setScene(scene);
        stage.show();
    }
}
