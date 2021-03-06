package sample;

import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class adminFrame extends connect {

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
    private Button deleteBD;

    @FXML
    private Button editBD;

    @FXML
    private TextField newBD_txt;

    @FXML
    private Button openLog;

    @FXML
    private Button clearLog;

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
