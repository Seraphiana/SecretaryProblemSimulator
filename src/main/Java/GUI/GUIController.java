package Java.GUI;

import Java.Algorithm.SecretaryAlgorithm;
import Java.Controller.ModuleController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.HashMap;
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
    @FXML
    private GridPane choiceGrid;
    @FXML
    private ChoiceBox<SecretaryAlgorithm> algorithmChoice;
    @FXML
    private GridPane topGrid;
    @FXML
    private Button stopButton;
    @FXML
    private Button runButton;
    @FXML
    private AnchorPane basePane;
    @FXML
    private Pane solutionPane;
    @FXML
    private Pane inPane;
    @FXML
    private ChoiceBox<?> matroidChoice;
    private ModuleController moduleController;


    public GUIController(ModuleController moduleController) {
        moduleController = this.moduleController;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        algorithmChoice = new ChoiceBox<>(moduleController.getAlgChoice());
        basePane = new AnchorPane();
        choiceGrid = new GridPane();
        topGrid = new GridPane();
        stopButton = new Button();
        runButton = new Button();
        solutionPane = new Pane();
        inPane = new Pane();
        matroidChoice = new ChoiceBox<>();

        stopButton.setOnAction(actionEvent -> {

        });

        runButton.setOnAction(actionEvent -> {

        });

        algorithmChoice.setConverter(new StringConverter<SecretaryAlgorithm>() {
            @Override
            public String toString(SecretaryAlgorithm secretaryAlgorithm) {
                return secretaryAlgorithm.toString();
            }

            @Override
            public SecretaryAlgorithm fromString(String s) {
                return moduleController.getAlgorithmName(s);
            }
        });




    }
}
