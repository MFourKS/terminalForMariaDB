package sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseDragEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class adminFrame1 extends connect{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea output_txt;

    @FXML
    private ComboBox valueBD;

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
    private Button reload;

    @FXML
    private Button clearLog;

    @FXML
    private Button swipeRole;

    @FXML
    void initialize() throws SQLException {
        Statement statement = cont.createStatement();;
        String name = "";
        try {

            ResultSet resultSet = statement.executeQuery("SHOW DATABASES");
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
//---------------------------------------------------------------------------------
        System.gc();

        swipeRole.setOnAction(actionEvent -> {
            openNewFrame("connect.fxml", swipeRole);
        });

        editBD.setOnAction(actionEvent -> {

            openNewFrame("adminFrame2.fxml", editBD);

            String str = "USE " + newBD_txt.getText();
            try {
                funtionBD(cont, str);
                alert("Выбрана база данных '" + newBD_txt.getText() + "'");
            } catch (Exception e) {
                alert("База данных не найдена");
            }
        });

//        valueBD.isSelected
//        valueBD.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                valueBD.setText( actionEvent.toString());
//                System.out.printf("+");
//            }
//        });


           // funtionBD(cont,base) ;
//            try {
//                String table = "";
//                ResultSet resultSet = statement.executeQuery("SHOW tables");
//                int i = 0;
//                while(resultSet.next()){
//                    i++;
//                    final MenuItem menuItem = new MenuItem(resultSet.getString(1));
//                    valueBD.getItems().add(menuItem);
//                    table += i + " - "+ resultSet.getString(1) + "\n";
//
//                }
//                output_txt.setText(table);
                //output_txt.setText("name");
                // ResultSet resultSet = executeQuery("SHOW DATABASES");
//        while (resultSet.next()) {
//
//
//        }
                // ("SHOW DATABASES;");
//            }
//            catch (Exception e){
//                output_txt.setText("Базы данных не найдены");
//            }
        reload.setOnAction(actionEvent -> {
            openNewFrame("adminFrame1.fxml", reload);
        });
        deleteBD.setOnAction(actionEvent -> {
//            Object e = null;
            if(newBD_txt.getText().equals("test"))
                alert("Вы хотите удалить системную базу данных!\n");
            else {
                String str = "DROP DATABASE " + newBD_txt.getText();
                try {
                    funtionBD(cont, str);
                    alert("Удалена база данных '" + newBD_txt.getText() + "'");
                } catch (Exception e) {
                    alert("База данных не существует");
                }
            }
        });

        createBD.setOnAction(actionEvent -> {

            String str = "CREATE DATABASE " + newBD_txt.getText();
            try {
                funtionBD(cont, str);
                alert("Создана база данных '" + newBD_txt.getText() + "'");
            } catch (Exception e) {
                alert("База данных не создана");
            }

        });
    }


    private void clickShow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(
                adminFrame1.class.getResource("YourClass.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("My modal window");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }

private static void funtionBD(Connection cont, String str) {
        Statement statm=null;
        try {

            statm = cont.createStatement();

        }
        catch (Exception e) {
            alert("Ошибка #1 в функции 'funtionBD'");
        }
        try{
            statm.execute(str);

        }
        catch (Exception e){
            alert("Ошибка #2 в функции 'funtionBD'");
        }

    }

}



