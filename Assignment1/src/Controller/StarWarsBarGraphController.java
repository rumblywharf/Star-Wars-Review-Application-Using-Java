package Controller;
import Model.StarWarsModel;
import Utility.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StarWarsBarGraphController {
    @FXML
    private BarChart<?, ?> starWarsBarChart;

    @FXML
    private Button tableButton;

    //populate the bargraph
    public void initialize() throws SQLException{
        ArrayList<StarWarsModel> starWarsModels = DataBaseConnection.getAll();
        XYChart.Series series = new XYChart.Series();
//        for(int i = 0; i < starWarsModels.size(); i++){
//            series.getAll().add(new XYChart.Data(starWarsModels.get(i).getTitle(), starWarsModels.get(i).getRevenue()));
//        }
//        starWarsBarChart.getAll().add(series);
    }

    //when you click the button it takes you back to the tableview fxml
    public void onClick(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getClassLoader().getResource("./View/StarWarsTableView.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Star Wars Graph");
        stage.getIcons().add(new Image("./Icon/icon.jpg"));
        stage.setScene(scene);
        stage.show();
    }
}
