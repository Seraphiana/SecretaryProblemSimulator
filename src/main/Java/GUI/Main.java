package Java.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by seraphiana on 23/04/15.
 */
public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[])null);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            StackPane page = (StackPane) FXMLLoader.load(Main.class.getResource("GUI.fxml"));
            Scene scene = new Scene(page);
            stage.setScene(scene);
            stage.setTitle("AlgSim2015");
            stage.show();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stop() {

    }
}
