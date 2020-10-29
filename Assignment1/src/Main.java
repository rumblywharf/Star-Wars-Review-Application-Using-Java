import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    //loads the tableview fxml when the application launches
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./View/StarWarsTableView.fxml"));
        primaryStage.setTitle("Star Wars Table");
        primaryStage.getIcons().add(new Image("./Icon/icon.jpg"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    //launches the application
    public static void main(String[] args) {
        launch(args);
    }
}
