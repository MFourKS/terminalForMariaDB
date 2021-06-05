package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
    private Button back;

    @FXML
    private TextField login_txt;

    @FXML
    private PasswordField passvd_txt;

    PrintWriter pw= new PrintWriter(System.out, true);
    public static Connection cont;

    public static void alert(String s) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning alert");

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(s);

        alert.showAndWait();
    }
    @FXML
    void initialize() throws SQLException {
        System.gc();

        valueRole.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                if ( valueRole.getValue().equals("Администратор")) value = 1;
                else if( valueRole.getValue().equals("Пользователь")) value = 2;
            }
        });

        input.setOnAction(actionEvent -> {
            if ( value == 0 ){
                alert("Выберите роль");
            }
            if ( value == 1 ) {
                    // openNewFrame("adminFrame.fxml",input);
                    String url = "jdbc:mysql://localhost:3306/mysql";
                    String name_user = login_txt.getText();
                    String pass_user = passvd_txt.getText();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                    } catch (Exception e) {
                        alert("ОШИБКА подключения драйвера!");
                    }
                    try {
                        cont = DriverManager.getConnection(url, name_user, pass_user);
                        openNewFrame("adminFrame1.fxml", input);
                    } catch (Exception e) {
                        alert("Неверный логин или пароль");
                    }

            }
            if ( value == 2 ) {

                openNewFrame("memberFrame.fxml",input);

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