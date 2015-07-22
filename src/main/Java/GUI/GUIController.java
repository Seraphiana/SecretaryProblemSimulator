package Java.GUI;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {
    @FXML
    public TextField d;
    @FXML
    public TextField c;
    @FXML
    public TextField b;
    @FXML
    public TextField a;
    public javafx.scene.text.Text solution;
    public ChoiceBox oracleChoice;
    public GridPane bottomeGrid;
    public TextField max;
    public TextField freq;
    @FXML
    public javafx.scene.text.Text matroidContents;


    @FXML
    private TextField algorithmChoice;
    @FXML
    private GridPane topGrid;
    @FXML
    private Button stopButton;
    @FXML
    private Button runButton;
    @FXML
    private AnchorPane basePane;
    @FXML
    private GridPane solutionGrid;
    @FXML
    private Pane inPane;
    @FXML
    private ChoiceBox matroidChoice;


    private Controller controller;


    public GUIController() {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new Controller();
        matroidChoice.setItems(FXCollections.observableArrayList(controller.getMatroids()));
        oracleChoice.setItems(FXCollections.observableArrayList(controller.getOracles()));
        System.out.println(algorithmChoice.getCharacters().toString());


        stopButton.setOnAction(actionEvent -> {
            controller.stop();
        });

        runButton.setOnAction(actionEvent -> {
            String[] buildData = new String[]{max.getCharacters().toString(), a.getCharacters().toString(), b.getCharacters().toString(),
                    c.getCharacters().toString(), d.getCharacters().toString(), freq.getCharacters().toString()};
            String result = controller.run(buildData, algorithmChoice.getCharacters().toString(), (String) matroidChoice.getValue(), (String) oracleChoice.getValue());
            System.out.println("====>" +result);
            solution.setText(result);
            matroidContents.setText(controller.getMatroid().toString());
        });





    }
}
