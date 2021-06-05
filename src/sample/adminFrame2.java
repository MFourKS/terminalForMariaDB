package sample;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;


public class adminFrame2 extends connect{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea output_txt;

    @FXML
    private Button deleteBD;

    @FXML
    private Button editBD;

    @FXML
    private Button openLog;

    @FXML
    private Button clearLog;

    @FXML
    private Button back;

    @FXML
    void initialize() throws SQLException {

        Statement statement = cont.createStatement();;
        String name = "";
        try {

            ResultSet resultSet = statement.executeQuery("SHOW TABLES");
            int i = 0;
            while(resultSet.next()){
                name += i + " - "+ resultSet.getString(1) + "\n";
                i++;
            }
            output_txt.setText(name);
        }
        catch (Exception e){
            output_txt.setText("Базы данных не найдены");
        }
        back.setOnAction(actionEvent -> {
            openNewFrame("adminFrame1.fxml",back);
        });
    }
}
