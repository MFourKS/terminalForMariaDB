package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class connect {

    public int count = 0;
    FXMLLoader loader = new FXMLLoader();
    Stage stage = new Stage();
    int value = 0;


    @FXML
    private Button input;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox valueRole;

    @FXML
    private MenuItem admin_but;

    @FXML
    private MenuItem members_but;

    @FXML
    private TextField login_txt;

    @FXML
    private PasswordField passvd_txt;

    @FXML
    void initialize() {
        System.gc();

        valueRole.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if ( valueRole.getValue().equals("Администратор")) value = 1;
                else if( valueRole.getValue().equals("Пользователь")) value = 2;
            }
        });

        input.setOnAction(actionEvent -> {
            if ( value == 1 ) {

                openNewFrame("adminFrame.fxml",input);

                value = 0;
            }
            if ( value == 2 ) {

                openNewFrame("memberFrame.fxml",input);

                value = 0;
            }
        });

    }

    protected void openNewFrame (String window, Node button){

        button.getScene().getWindow().hide();

        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        stage.setScene(new Scene(root));
        count++;
        stage.show();
    }
}