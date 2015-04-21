package Java.GUI;


import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;



/**
 * Created by seraphiana on 31/07/14.
 */
public class GUI extends Application {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Secretary Algorithm Simulator");


    }

    private void createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        addBoxes(grid);
        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
    }



    private void addBoxes(GridPane grid) {
        Label randomiserTitle = new Label("Argument");
        ChoiceBox randomiserType = new ChoiceBox();
        randomiserType.getItems().addAll("Integer");

        Label OracleTitle = new Label("Matroid");
        ChoiceBox oracleType = new ChoiceBox();
        oracleType.getItems().addAll("Single Candidate");

        Label algorithmTitle = new Label("Algorithm");
        ChoiceBox algorithmType = new ChoiceBox();
        algorithmType.getItems().addAll("Conventional");

        Text boxesTitle = new Text("Settings");
        boxesTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        grid.add(boxesTitle, 0, 0, 2, 1);


        grid.add(randomiserTitle,0,1);
        grid.add(randomiserType, 0, 2);
        grid.add(OracleTitle,0,3);
        grid.add(oracleType,0,4);
        grid.add(algorithmTitle,0,5);
        grid.add(algorithmType,0,6);

        Button btn = new Button("Run");

        grid.add(btn, 1, 8);
    }

}
