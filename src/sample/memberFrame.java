package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class memberFrame extends connect{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea output_txt;

    @FXML
    private MenuButton valueBD;

    @FXML
    private Button createBD;

    @FXML
    private Button editBD;

    @FXML
    private TextField newBD_txt;

    @FXML
    private Button openLog;

    @FXML
    private Button swipeRole;

    @FXML
    void initialize() {
        System.gc();

        swipeRole.setOnAction(actionEvent -> {

            openNewFrame("connect.fxml",swipeRole);
        });
    }
}
