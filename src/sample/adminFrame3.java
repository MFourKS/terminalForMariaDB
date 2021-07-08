package sample;
import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.CheckBox;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.RadioButton;
        import javafx.scene.control.TextField;

import java.sql.SQLException;

public class adminFrame3 {

    @FXML
    private PasswordField passwd_text;

    @FXML
    private CheckBox Update;

    @FXML
    private CheckBox Select;

    @FXML
    private CheckBox Delete;

    @FXML
    private CheckBox Superuser;

    @FXML
    private CheckBox Usage;

    @FXML
    private RadioButton User_radio;

    @FXML
    private RadioButton Superuser_radio;

    @FXML
    private RadioButton Usage_radio;

    @FXML
    private TextField log_text;

    @FXML
    private PasswordField re_passwd_text_;

    @FXML
    private Button create_user;

    @FXML
    private Button delete_user;

    @FXML
    void initialize() throws SQLException {
    }

}
